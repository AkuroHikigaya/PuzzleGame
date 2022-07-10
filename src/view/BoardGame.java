package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.PuzzleListener;

public class BoardGame extends JPanel{
	private JButton jb_cell[][];
	
	public BoardGame(int w, int h) {
		int count = 1;
		jb_cell = new JButton[w][h];
		this.setLayout(new GridLayout(w,h,5,5));
		PuzzleListener pl = new PuzzleListener(this);
		for(int i=0; i<w; i++) {
			for(int j=0; j<h; j++) {
				String st_count = String.valueOf(count);
				if(count == w*h) 
					this.add(jb_cell[i][j] = new JButton("0"));
				else {
					this.add(jb_cell[i][j] = new JButton(st_count));
					count++;
				}
				jb_cell[i][j].addActionListener(pl);				
			}
		}
		
	}
	public void up () {
		
	}
	
	
	
	public JButton[][] getJb_cell() {
		return jb_cell;
	}



	public void setJb_cell(JButton[][] jb_cell) {
		this.jb_cell = jb_cell;
	}
	
	public void getCoor(String n) {
		for(int i=0; i<jb_cell.length; i++) {
			for(int j=0; j<jb_cell[0].length; j++) {
				if(jb_cell[i][j].getText() == n) {
					System.out.println(i + " " + j);
				}
			}
		}
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
}
