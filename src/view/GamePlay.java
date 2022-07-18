package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class GamePlay extends JFrame{
	private StartGame startgame;
	private Level level;
	private Game game;
	public GamePlay() {
		this.setTitle("Game Puzzle");
		startgame = new StartGame();
		this.add(startgame);
		startgame.getJb_start().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				started(startgame);
			}
		});
		this.setBounds(startgame.getBounds());
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		startgame.getQuit().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) {
		new GamePlay();
	}
	
	public void exit(ActionListener actionListener) {
	}
	
	public void started(JPanel rm) {
		level = new Level();
		this.remove(rm);
		this.add(level);
		
		//Khi bấm vào Easy
		level.getJb_easy().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setLevel(1);
			}
		});
		
		//Khi bấm vào Normal
		level.getJb_normal().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setLevel(2);
			}
		});
		
//		Khi bấm vào Hard
		level.getJb_hard().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setLevel(3);
			}
		});
		
		level.getJb_back().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				backToStart();
			}
		});
		
		this.setVisible(true);
	}
	
	public void backToStart() {
		dispose();
		new GamePlay();
	}
	
	public void levelEasy() {
//		System.out.println("In level Easy");
		game = new Game(4, 4);
		this.remove(level);
		this.add(game);
		this.setVisible(true);
	}
	public void levelNormal() {
//		System.out.println("In level Normal");
		game = new Game(6, 6);
		this.remove(level);
		this.add(game);
		this.setVisible(true);
	}
	public void levelHard() {
//		System.out.println("In level Hard");
		game = new Game(8, 8);
		this.remove(level);
		this.add(game);
		this.setVisible(true);
	}
	
	public void setLevel(int level) {
		if(level == 1) 
			levelEasy();
		if(level == 2)
			levelNormal();
		if(level == 3)
			levelHard();
		game.getJb_back().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				started(game);
			}
		});
	}
	
}
