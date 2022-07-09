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
	
	//Tạo một mảng với số random bất kỳ từ 1 -> 8 ([3x3]=9 - 1 ô trống)
	public void initPuzzle(int w, int h) {
		int count = 0;
		for(int i=0; i<w; i++) {
			for(int j=0; j<h; j++) {
				board[i][j] = count;
				count++;
			}
		}
		
		for(int i=0; i<w; i++) {
			for(int j=0; j<h; j++) {
				System.out.format("%2d ", board[i][j]);
			}
			System.out.println();
		}
	}
	
	
	
}
