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
				if(count == w*h) {  // Biến đếm  = 4*4 = 16
					block[i][j].setState("cell_null");
					block[i][j].addMouseListener(pl);
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
	
	public void up () {
		
	}
	
	public int getNumber() {
		return 1;
	}

//	public void up() {
//		
//	}
//	
//	public void down(int w, int h) {
//		
//	}
//	
//	public void left() {
//		
//	}
//	
//	public void right() {
//		
//	}
//	MouseListener 
//	public void swap () {
//		
//	}
//	public boolean isExist (JBlock b) {
//		for()
//	}
}
