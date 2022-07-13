package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.BoardGame;

public class PuzzleListener implements MouseListener, KeyListener{
	private BoardGame board_game;

	public PuzzleListener(BoardGame board_game) {
		this.board_game = board_game;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for(int i=0; i<board_game.getBlock().length; i++) {
			for(int j=0; j<board_game.getBlock()[0].length;j++) {
				if(e.getSource() == board_game.getBlock()[i][j]) {
					System.out.println("Đã click dô số: " + board_game.getBlock()[i][j].getNumber()+
							" Tọa độ: " + i + " " + j + " Lenght :" + board_game.getBlock().length);
					boolean exist=false;
					// Dò xem 4 góc có block null không

					/** Trên*/
					if(i-1>=0) {
						if(board_game.getBlock()[i-1][j].getNumber() == (board_game.getBlock().length)*(board_game.getBlock()[0].length)) {
							System.out.println("Có Block Null ở trên");
						}
					}
					/** Dưới*/
					if(i+1<board_game.getBlock().length) {
						if(board_game.getBlock()[i+1][j].getNumber() == (board_game.getBlock().length)*(board_game.getBlock()[0].length)) {
							System.out.println("Có Block Null ở dưới");
							
						}
					}
					/** Trái*/
					if(j-1>=0) {
						if(board_game.getBlock()[i][j-1].getNumber() == (board_game.getBlock().length)*(board_game.getBlock()[0].length)) {
							System.out.println("Có Block Null bên trái");
						}
					}
					/** Phải*/
					if(j+1<board_game.getBlock().length) {
						if(board_game.getBlock()[i][j+1].getNumber() == (board_game.getBlock().length)*(board_game.getBlock()[0].length)) {
							System.out.println("Có Block Null bên phải");
							//Lấy Block Null Đổi thuộc tính thành block vừa click
							//board_game.setAttributeBlock(Block null, lấy thuộc tính right trong block vừa click, lấy thuộc tính state trong block vừa click, lấy thuộc tính number trong block vừa click)
							board_game.setAttributeBlock(board_game.getBlock()[i][j+1], board_game.getBlock()[i][j].isRight(), board_game.getBlock()[i][j].getState(), board_game.getBlock()[i][j].getNumber());
							//Lấy Block vừa click, đổi lại thành null
							//board_game.setAttributeBlock(Block vừa click, phần còn lại y vậy)
							board_game.setAttributeBlock(board_game.getBlock()[i][j], false, "null_cell", (board_game.getBlock().length)*(board_game.getBlock()[0].length));
							board_game.getBlock()[i][j+1].repaint();
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

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			System.out.println("Trái");
		}

		if (key == KeyEvent.VK_RIGHT) {
			System.out.println("Phải");
		}

		if (key == KeyEvent.VK_UP) {
			//	    	if((board_game.getBlock()[board_game.getBlock().length-1][board_game.getBlock()[0].length-1].getNumber() == board_game.getBlock().length*board_game.getBlock()[0].length)) {
			//	    		System.out.println("UP!");
			//	    	}
			board_game.setAttributeBlock(board_game.getBlockNull(), false, null, key);
		}

		if (key == KeyEvent.VK_DOWN) {
			System.out.println("Dưới");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
