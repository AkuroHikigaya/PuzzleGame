package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.ConsolePuzzle;

public class Model_PuzzleListener implements KeyListener{
	private ConsolePuzzle console_puzzle;
	
	
	public Model_PuzzleListener(ConsolePuzzle console_puzzle) {
		this.console_puzzle = console_puzzle;
	}


	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println(e.getKeyCode());
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}	
	
	
}
