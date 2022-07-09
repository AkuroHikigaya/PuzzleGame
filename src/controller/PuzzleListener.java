package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.BoardGame;

public class PuzzleListener implements ActionListener {
	private BoardGame board_game;
	

	public PuzzleListener(BoardGame board_game) {
		this.board_game = board_game;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		board_game.getCoor(e.getActionCommand());
	}
	
}
