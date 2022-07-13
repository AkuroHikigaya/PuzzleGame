package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.BoardGame;

public class PuzzleListener implements MouseListener{
	private BoardGame board_game;
	
	public PuzzleListener(BoardGame board_game) {
		this.board_game = board_game;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for(int i=0; i<board_game.getBlock().length; i++) {
			for(int j=0; j<board_game.getBlock()[0].length;j++) {
				if(e.getSource() == board_game.getBlock()[i][j]) {
					System.out.println("Đã click dô số: " + board_game.getBlock()[i][j].getNumber());
					boolean exist=false;
					for(int k=i-1 ; k<= i+1;k++) {
						for(int l=j-1; l<= j+1; l++)
						{
							if(k>=0 && k<board_game.getBlock().length && l>=0 && l<board_game.getBlock()[0].length) {
								
								if(board_game.getBlock()[k][l].getNumber()==16) {
									System.out.println("Da co so 16");
									board_game.getBlock()[k][l].setState("cell_red");
									board_game.getBlock()[k][l].setNumber(12);
									board_game.getBlock()[k][l].repaint();

									exist = true;
							}
						}
						}
					}
					if(exist == true) {			
//						String temp=board_game.getBlock()[i][j].;
						int temp_i = board_game.getBlock()[i][j].getNumber();
						board_game.getBlock()[i][j].setState("cell_null");
						board_game.getBlock()[i][j].setNumber(16);
						board_game.getBlock()[i][j].repaint();
					}
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("Đang đè");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("Đã thả");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("Đã vào ô");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("Đã ra khỏi ô");
		
	}
	
}
