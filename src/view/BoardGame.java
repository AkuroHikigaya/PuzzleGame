package view;

import java.awt.FlowLayout;

import javax.swing.JPanel;

public class BoardGame extends JPanel{
	private Cell cells;
	
	public BoardGame() {
		cells = new Cell();
		this.setLayout(new FlowLayout());
		this.add(cells);
		
	}
	
	

}
