package view;

import javax.swing.JFrame;

import model.Images;

public class Display extends JFrame{
	private BoardGame boardGame;
	public  Display (int w, int h) {
		this.setTitle("Game Puzzle");
		this.setIconImage(new Images().getList_imgs().get("img_icon"));
		boardGame = new BoardGame(w, h);
		this.add(boardGame);
		this.pack();
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
	}
	
	
}
