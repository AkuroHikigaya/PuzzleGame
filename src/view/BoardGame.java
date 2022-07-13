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
				block[i][j] = new JBlock("cell_false",count); //IN REDCELL + R1
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



	//Đổi cấu trúc 1 ô
	public void setCell(JButton jb_cell, Color color) {
		
	}
	
	public void getCoor() {
		
	}
	
	
	public int getNumber() {
		return 1;
	}
//Key Listener
	/**Kiểm tra xem có phải block_null hay không*/
	public boolean isBlockNull(JBlock block) {
		if(block.getState().equals("cell_null"))
			return true;
		return false;
	}
	
	/**Lấy Block Null*/
	public JBlock getBlockNull() {
		//cho 2 for chạy khi nào gặp cell_null thì return block chứa tọa độ 
		for(int i=0; i<block.length; i++) {
			for(int j=0; j<block[0].length; j++) {
				if(isBlockNull(block[i][j]))
					return block[i][j];
			}
		}
		System.out.println("Không có Block Null, trả về block đầu");
		return block[0][0];
	}
	
	/**Thay đổi thuộc tính block 
	 * <p>
	 * Block muốn đỗi
	 * <p>
	 * Block đã vào đúng ?  
	 * <p>
	 * Trạng thái của block 
	 * <p>
	 * Số trên block*/
	public void setAttributeBlock(JBlock block,boolean bool, String state, int number) {
		block.setRight(bool);
		block.setState(state);
		block.setNumber(number);
	}
	
	public void up() {
		
	}
	
	public void down(int w, int h) {
		
	}
	
	public void left() {
		
	}
	
	public void right() {
		
	}
//	MouseListener 
	public void swap () {
		
	}
	public boolean isExist (JBlock block, int i, int j) {
		for(int k = i-1; k<=i+1; k++) {
			for(int l = j-1; l<=j+1; l++) {
				if(k>=0 && k<this.block.length && l>=0 && l<this.block[0].length) {
					if(block.getNumber() == this.block.length*this.block[0].length) {
						System.out.println("Đã có 16");
						return true;
				}
				}
			}
		}
		return false;
	}
}
