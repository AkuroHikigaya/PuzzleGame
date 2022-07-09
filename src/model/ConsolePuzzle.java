package model;

import java.util.Random;

public class ConsolePuzzle {
	
	private Random rd;
	private int board[][];
	
	public ConsolePuzzle(int w, int h) {
		rd = new Random();
		board = new int[w][h];
		initPuzzle(w, h);
	}
	
	public void initPuzzle(int w, int h) {
		int count = 1;
		for(int i=0; i<w; i++) {
			for(int j=0; j<h; j++) {
				if(count != w*h) {
					board[i][j] = count;
					count++;
				}
				else {
					board[i][j] = 0;
				}
			}
		}
		
		for(int i=0; i<w; i++) {
			for(int j=0; j<h; j++) {
				System.out.format("%2d ", board[i][j]);
			}
			System.out.println();
		}
	}
	
	public int getX(int n) {
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				if(board[i][j] == n) return i;
			}
		}
		return -1;
	}
	
	public int getY(int n) {
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				if(board[i][j] == n) return j;
			}
		}
		return -1;
	}
	
}
