package view;

import javax.swing.JFrame;

public class Display extends JFrame{
	private BoardGame boardGame;
	public  Display (int w, int h) {
		this.setTitle("Game Puzzle");
		this.setSize(600,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		boardGame = new BoardGame(w, h);
		this.add(boardGame);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
	}
	
	
}
