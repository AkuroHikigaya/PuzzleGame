package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BoardGame extends JPanel{
	private JButton jb_cell[][];
	
	public BoardGame(int w, int h) {
		int count = 1;
		jb_cell = new JButton[w][h];
		this.setLayout(new GridLayout(w,h,5,5));
		for(int i=0; i<w; i++) {
			for(int j=0; j<h; j++) {
				String st_count = String.valueOf(count);
				if(count == w*h) 
					this.add(jb_cell[i][j] = new JButton("0"));
				else {
					this.add(jb_cell[i][j] = new JButton(st_count));
					count++;
				}
			}
		}
		
	}
	
	

}
