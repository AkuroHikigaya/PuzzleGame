package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.BoardGame;
import view.SoundEffect;

public class PuzzleListener implements MouseListener, KeyListener{
	private BoardGame board_game;
	private SoundEffect se;

	public PuzzleListener(BoardGame board_game) {
		this.board_game = board_game;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		//		System.out.println("Đang đè");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		for(int i=0; i<board_game.getBlock().length; i++) {
			for(int j=0; j<board_game.getBlock()[0].length;j++) {
				if(e.getSource() == board_game.getBlock()[i][j]) {
//					System.out.println("Đã click dô số: " + board_game.getBlock()[i][j].getNumber()+
//							" Tọa độ: " + i + " " + j + " Lenght :" + board_game.getBlock().length);
					boolean exist=false;
					// Dò xem 4 góc có block null không

					/** Trên*/
					if(i-1>=0) {
						if(board_game.getBlock()[i-1][j].getNumber() == (board_game.getBlock().length)*(board_game.getBlock()[0].length)) {
							board_game.moveDown();
							se = new SoundEffect(".//src//resources//sounds//block_soundtrack.wav");
							se.play();
						}
					}
					/** Dưới*/
					if(i+1<board_game.getBlock().length) {
						if(board_game.getBlock()[i+1][j].getNumber() == (board_game.getBlock().length)*(board_game.getBlock()[0].length)) {
							board_game.moveUp();
							se = new SoundEffect(".//src//resources//sounds//block_soundtrack.wav");
							se.play();
						}
					}
					/** Trái*/
					if(j-1>=0) {
						if(board_game.getBlock()[i][j-1].getNumber() == (board_game.getBlock().length)*(board_game.getBlock()[0].length)) {
							board_game.moveRight();
							se = new SoundEffect(".//src//resources//sounds//block_soundtrack.wav");
							se.play();
						}
					}
					/** Phải*/
					if(j+1<board_game.getBlock()[0].length) {
						if(board_game.getBlock()[i][j+1].getNumber() == (board_game.getBlock().length)*(board_game.getBlock()[0].length)) {
							board_game.moveLeft();
							se = new SoundEffect(".//src//resources//sounds//block_soundtrack.wav");
							se.play();
						}
					}
					
					board_game.checkWin(board_game.getBlock().length, board_game.getBlock()[0].length);
				}
			}
		}
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

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			board_game.moveRight();
			se = new SoundEffect(".//src//resources//sounds//block_soundtrack.wav");
			se.play();
		}

		if (key == KeyEvent.VK_RIGHT) {
			board_game.moveLeft();
			se = new SoundEffect(".//src//resources//sounds//block_soundtrack.wav");
			se.play();
		}

		if (key == KeyEvent.VK_UP) {
			board_game.moveDown();
			se = new SoundEffect(".//src//resources//sounds//block_soundtrack.wav");
			se.play();
		}

		if (key == KeyEvent.VK_DOWN) {
			board_game.moveUp();
			se = new SoundEffect(".//src//resources//sounds//block_soundtrack.wav");
			se.play();
		}
		board_game.checkWin(board_game.getBlock().length, board_game.getBlock()[0].length);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
