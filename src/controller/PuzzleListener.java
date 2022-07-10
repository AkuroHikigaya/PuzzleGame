package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
<<<<<<< HEAD
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PuzzleListener implements MouseListener, ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

=======

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
	
>>>>>>> b3f5b5a4dde2a91bb54d10eb49c18b9e5296ff97
}
