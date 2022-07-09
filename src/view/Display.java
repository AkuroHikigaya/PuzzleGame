package view;

import javax.swing.JFrame;

public class Display extends JFrame{
	private BoardGame boardGame;
	public  Display () {
		this.setTitle("Game Pullze");
		this.setSize(600,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		boardGame = new BoardGame();
		this.add(boardGame);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
	}
	
	
}
