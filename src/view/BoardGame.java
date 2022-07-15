package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.PuzzleListener;

public class BoardGame extends JPanel{
	private JBlock block[][];
	private int rule[][];
	

	public BoardGame(int w, int h) {
		int count = 1;
		rule = new int[w][h];
		block = new JBlock[w][h];
		this.setLayout(new GridLayout(w,h,0,0));
		PuzzleListener pl = new PuzzleListener(this);
		for(int i=0; i<w; i++) {
			for(int j=0; j<h; j++) {
				block[i][j] = new JBlock("cell_true",count); //IN REDCELL + R1
				block[i][j].addMouseListener(pl);
				block[i][j].addKeyListener(pl);
				if(count == w*h) {  // Biến đếm  = 4*4 = 16
					block[i][j] = new JBlock("cell_null",count);
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
		//Mượn chổ test rule
				for(int i=0; i<w; i++) {
					for(int j=0; j<h; j++) {
						System.out.print(getRule()[i][j]+" ");
					}
					System.out.println();
				}
				
				
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
		if(count == w*h)
			JOptionPane.showMessageDialog(null,
					"Message Example",
					"Title Example",
					JOptionPane.INFORMATION_MESSAGE);
			
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

	public void moveDown() {
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
	}
	
	
}
