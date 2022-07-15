package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.PuzzleListener;

public class BoardGame extends JPanel{
	private JBlock block[][];

	public BoardGame(int w, int h) {
		int count = 1;
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
				}
				this.add(block[i][j]);
				count++;
			}
		}

	}

	public JBlock[][] getBlock() {
		return block;
	}

	public void setBlock(JBlock[][] block) {
		this.block = block;
	}

	//Listener
	/**Hàm cập nhật trạng thái
	 * <br>
	 * Nếu ô vào đúng chổ -> Màu đỏ 
	 * <br>
	 * Ngược lại màu xanh*/
	public void UpdateState() {
		
	}

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
					if (i+1<block.length) { //Nếu ở dưới +1 < chiều dài mảng -> tiếp tục -> Đổi BlockNull xuống dưới
						setAttributeBlock(block[i][j], block[i+1][j].getState(),block[i+1][j].getNumber());
						setAttributeBlock(block[i+1][j], "null_cell", this.block.length*this.block[0].length);
						System.out.println("Đây là hàm Down");
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
						setAttributeBlock(block[i-1][j], "null_cell", this.block.length*this.block[0].length);	
						System.out.println("Đây là hàm UP");
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
}
