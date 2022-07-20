package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import controller.PuzzleListener;

public class BoardGame extends JPanel{
	private JBlock block[][];
	private int rule[][];
	private Timer count_time;
	private JLabel time;
	private int clock_count;
	private int count_moves;
	private JLabel moves;
	private PuzzleListener pl;
	private WinFrame winner;
	private SoundEffect se;
	
	public BoardGame(int w, int h) {
		// Bộ đếm
		time = new JLabel("0000");
		time.setForeground(Color.WHITE);
		time.setFont(new Font("Arial", Font.BOLD, 30));
		clock_count = 0;
		count_time = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clock_count++;
				if(Integer.valueOf(time.getText())<9)
					time.setText("000" + String.valueOf(clock_count));		
				else if(Integer.valueOf(time.getText())>=9&&Integer.valueOf(time.getText())<99)
					time.setText("00" + String.valueOf(clock_count));
				else if(Integer.valueOf(time.getText())>=99&&Integer.valueOf(time.getText())<999)
					time.setText("0" + String.valueOf(clock_count));
				else
					time.setText(String.valueOf(clock_count));
			}
		});
		
		//Moves
		moves = new JLabel("0");
		moves.setForeground(Color.WHITE);
		moves.setFont(new Font("Arial", Font.BOLD, 30));
		count_moves = 0;
		
		int count = 1;
		rule = new int[w][h];
		block = new JBlock[w][h];
		this.setLayout(new GridLayout(w,h,0,0));
		pl = new PuzzleListener(this);
		for(int i=0; i<w; i++) {
			for(int j=0; j<h; j++) {
				
				if(w == 4)
					block[i][j] = new JBlock("cell_true",count,1); //IN REDCELL + R1
				else if(w==6)
					block[i][j] = new JBlock("cell_true",count,2); //IN REDCELL + R1
				else
					block[i][j] = new JBlock("cell_true",count,3); //IN REDCELL + R1		
				
				block[i][j].addMouseListener(pl);
				block[i][j].addKeyListener(pl);
				if(count == w*h) {  // Biến đếm  = 4*4 = 16
					if(w == 4)
						block[i][j] = new JBlock("cell_null",count,1);
					else if(w==6)
						block[i][j] = new JBlock("cell_null",count,2);
					else
						block[i][j] = new JBlock("cell_null",count,3);
					block[i][j].addMouseListener(pl);
					block[i][j].addKeyListener(pl);
					rule[i][j] = count;
				}
				this.add(block[i][j]);
				rule[i][j] = count;
				count++;
			}
		}
		randomBoard();
	}

	public JBlock[][] getBlock() {
		return block;
	}

	public void setBlock(JBlock[][] block) {
		this.block = block;
	}
	
	

	public int[][] getRule() {
		return rule;
	}

	public void setRule(int[][] rule) {
		this.rule = rule;
	}
	
	public void checkWin(int w, int h) {
		int count = 0;
		for(int i=0; i<w; i++) {
			for(int j=0; j<h; j++) {
				if(block[i][j].getNumber() == rule[i][j])
					count++;
			}
		}
		if(count == w*h) {
			se = new SoundEffect(".//src//resources//sounds//win.wav");
			se.play();
			count_time.stop();
			for(int i=0; i<w; i++) {
				for(int j=0; j<h; j++) {
					block[i][j].removeMouseListener(pl);
					block[i][j].removeKeyListener(pl);
				}
			}
			
			winner = new WinFrame(count_moves, clock_count);
			winner.getYes_button().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					randomBoard();
					for(int i=0; i<w; i++) {
						for(int j=0; j<h; j++) {
							block[i][j].addMouseListener(pl);
							block[i][j].addKeyListener(pl);
						}
					}
					winner.getFrame().dispose();
				}
			});
			winner.getNo_button().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					for(int i=0; i<w; i++) {
						for(int j=0; j<h; j++) {
							block[i][j].addMouseListener(pl);
							block[i][j].addKeyListener(pl);
						}
					}
					winner.getFrame().dispose();
				}
			});
		}
			
	}
	
	/**Hàm cập nhật trạng thái đúng sai*/
	public void UpdateState(JBlock block[][], int i, int j) {
		if(block[i][j].getNumber() == rule[i][j]) {
			block[i][j].setState("cell_true");
		}else {
			block[i][j].setState("cell_false");
		}
	}
	//Listener
	/**Hàm cập nhật trạng thái
	 * <br>
	 * Nếu ô vào đúng chổ -> Màu đỏ 
	 * <br>
	 * Ngược lại màu xanh*/

	/**Thay đổi thuộc tính block 
	 * <p>
	 * Block muốn đỗi
	 * <br>
	 * Block đã vào đúng ?  
	 * <br>
	 * Trạng thái của block 
	 * <br>
	 * Số trên block*/
	public void setAttributeBlock(JBlock block, String state, int number) {
		block.setState(state);
		block.setNumber(number);
	}
	
	public void startCount(Timer t){
		if(!t.isRunning()) {
			t.start();
		}
	}
	
	public void countMoves() {
		count_moves++;
		moves.setText(String.valueOf(count_moves));
	}
	
	public void moveDown() {
		startCount(count_time);
		countMoves();
		for(int i=block.length-1; i>=0; i--) {
			for (int j=0; j<block[0].length; j++) {
				if(block[i][j].getNumber()== this.block.length*this.block[0].length) { //Nếu đã tìm thấy BlockNull
					if(i+1<block.length) { //Nếu ở dưới +1 < chiều dài mảng -> tiếp tục -> Đổi BlockNull xuống dưới
						//Điều kiện kiểm tra đúng sai
						setAttributeBlock(block[i][j], block[i+1][j].getState(),block[i+1][j].getNumber());
						UpdateState(block, i, j);
						setAttributeBlock(block[i+1][j], "null_cell", this.block.length*this.block[0].length);
						block[i][j].repaint();
						block[i+1][j].repaint();
						break;
					}
				}
			}
		}
	}

	public void moveUp() {
		startCount(count_time);
		countMoves();
		for(int i=0; i<block.length; i++) {
			for(int j=0; j<block[0].length; j++) {
				if(block[i][j].getNumber() == this.block.length*this.block[0].length) {
					if(i-1>=0) {
						setAttributeBlock(block[i][j], block[i-1][j].getState(), block[i-1][j].getNumber());	
						UpdateState(block, i, j);
						setAttributeBlock(block[i-1][j], "null_cell", this.block.length*this.block[0].length);	
						block[i][j].repaint();
						block[i-1][j].repaint();
					}
				}
			}
		}
	}
	/**Di chuyển Block Null sang trái*/
	public void moveLeft() {
		startCount(count_time);
		countMoves();
		//		Xác định block null
		for(int i=0; i<block.length; i++) {
			for(int j=0; j<block[0].length; j++) {
				if(block[i][j].getNumber() == this.block.length*this.block[0].length) {// Nếu nó là block null
//					System.out.println("Đã lấy được block null");
					if(j-1>=0) {
//						System.out.println("Đã vào điều kiện");
						//Lấy block null đổi thành block bên trái
						setAttributeBlock(block[i][j], block[i][j-1].getState(), block[i][j-1].getNumber());	
						UpdateState(block, i, j);
						//Lấy block bên trái đổi lại thành block null
						setAttributeBlock(block[i][j-1], "null_cell", this.block.length*this.block[0].length);		
						//Tô lại
						block[i][j].repaint();
						block[i][j-1].repaint();
					}
				}
			}
		}
	}


	public void moveRight() {
		startCount(count_time);
		countMoves();
//		Xác định block null
		for(int i=0; i<block.length; i++) {
			for(int j=block[0].length-1; j>=0; j--) {
				if(block[i][j].getNumber() == this.block.length*this.block[0].length) {// Nếu nó là block null
//					System.out.println("Đã lấy được block null");
					if(j+1<block[0].length) {
//						System.out.println("Đã vào điều kiện");
						//Lấy block null đổi thành block bên trái
						setAttributeBlock(block[i][j], block[i][j+1].getState(), block[i][j+1].getNumber());	
						UpdateState(block, i, j);
						//Lấy block bên trái đổi lại thành block null
						setAttributeBlock(block[i][j+1], "null_cell", this.block.length*this.block[0].length);		
						//Tô lại
						block[i][j].repaint();
						block[i][j+1].repaint();
					}
				}
			}
		}
	}
	public void randomBoard() {
		Random rand = new Random();
		for(int i=0;i<1000;i++) {
			int index = 1 + rand.nextInt(4);
			switch (index) {
			case 1: 
				moveUp();
				break;
			case 2:
				moveDown();
				break;
			case 3:
				moveLeft();
				break;
			case 4:
				moveRight();
				break;
			}
		}
		count_moves = 0;
		moves.setText("0");
		time.setText("0000");
		clock_count = 0;
		count_time.restart();
		count_time.stop();
	}

	public JLabel getTime() {
		return time;
	}

	public void setTime(JLabel time) {
		this.time = time;
	}

	public JLabel getMoves() {
		return moves;
	}

	public void setMoves(JLabel moves) {
		this.moves = moves;
	}

	public Timer getCount_time() {
		return count_time;
	}

	public void setCount_time(Timer count_time) {
		this.count_time = count_time;
	}

	public int getCount_moves() {
		return count_moves;
	}

	public void setCount_moves(int count_moves) {
		this.count_moves = count_moves;
	}

	public PuzzleListener getPl() {
		return pl;
	}

	public void setPl(PuzzleListener pl) {
		this.pl = pl;
	}
	
	
}
