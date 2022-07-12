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
				String st_count = String.valueOf(count);
				if(count == w*h) {
//					jb_cell[i][j] = new JButton("0");
					block[i][j] = new JBlock();
					this.add(block[i][j]);
				}
				else {
//					this.add(jb_cell[i][j] = new JButton(st_count));
					this.add(block[i][j] = new JBlock());
					count++;
				}
//				jb_cell[i][j].addActionListener(pl);				
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
