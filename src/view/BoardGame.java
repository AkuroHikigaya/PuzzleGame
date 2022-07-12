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
				block[i][j] = new JBlock("cell_true"); //IN REDCELL + R1
//				if(count == w*h) {  // Biến đếm  = 4*4 = 16
//					block[i][j].setState("cell_null");
//				}
				this.add(block[i][j]);
				count++;
			}
		}
		
	}
	
	//Đổi cấu trúc 1 ô
	public void setCell(JButton jb_cell, Color color) {
		
	}
	
	public void up () {
		
	}
	
//	
//	
//	public JButton[][] getJb_cell() {
//		return jb_cell;
//	}


//
//	public void setJb_cell(JButton[][] jb_cell) {
//		this.jb_cell = jb_cell;
//	}
//	
//	public void getCoor(String n) {
//		for(int i=0; i<jb_cell.length; i++) {
//			for(int j=0; j<jb_cell[0].length; j++) {
//				if(jb_cell[i][j].getText() == n) {
//					System.out.println(i + " " + j);
//				}
//			}
//		}
//	}


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
}
