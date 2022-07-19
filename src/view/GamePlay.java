package view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GamePlay{
	private JFrame framegame;
	private StartGame startgame;
	private Level level;
	private Game game;
	private SoundEffect se;
	private SoundEffect music_background;
	public GamePlay() {
		framegame = new JFrame();
		framegame.setTitle("Game Puzzle");
		startgame = new StartGame();
		framegame.add(startgame);
		startgame.getJb_start().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				started(startgame);
				startgame.getJb_start().setState(false);
				se = new SoundEffect(".//src//resources//sounds//select_soundtrack.wav");
				se.play();
			}
		});
		music_background = new SoundEffect(".//src//resources//sounds//main_soundtrack.wav");
		music_background.play();
		framegame.setBounds(startgame.getBounds());
		framegame.setResizable(false);
		framegame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framegame.setUndecorated(true);
		framegame.setLocationRelativeTo(null);
		framegame.setVisible(true);
		startgame.getQuit().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				se = new SoundEffect(".//src//resources//sounds//select_soundtrack.wav");
				se.play();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) {
		new GamePlay();
	}
	
	public void started(JPanel rm) {
		level = new Level();
		framegame.remove(rm);
		framegame.add(level);
		
		//Khi bấm vào Easy
		level.getJb_easy().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				se = new SoundEffect(".//src//resources//sounds//startgame_soundtrack.wav");
				se.play();
				setLevel(1);
			}
		});
		
		//Khi bấm vào Normal
		level.getJb_normal().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				se = new SoundEffect(".//src//resources//sounds//startgame_soundtrack.wav");
				se.play();
				setLevel(2);
			}
		});
		
//		Khi bấm vào Hard
		level.getJb_hard().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				se = new SoundEffect(".//src//resources//sounds//startgame_soundtrack.wav");
				se.play();
				setLevel(3);
			}
		});
		
		level.getJb_back().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				se = new SoundEffect(".//src//resources//sounds//select_soundtrack.wav");
				se.play();
				framegame.remove(level);
				framegame.add(startgame);
				startgame.repaint();
				framegame.setVisible(true);
			}
		});
		
		framegame.setVisible(true);
	}
	
	
	public void levelEasy() {
//		System.out.println("In level Easy");
		game = new Game(4, 4);
		framegame.remove(level);
		framegame.add(game);
		framegame.setVisible(true);
	}
	public void levelNormal() {
//		System.out.println("In level Normal");
		game = new Game(6, 6);
		framegame.remove(level);
		framegame.add(game);
		framegame.setVisible(true);
	}
	public void levelHard() {
//		System.out.println("In level Hard");
		game = new Game(8, 8);
		framegame.remove(level);
		framegame.add(game);
		framegame.setVisible(true);
	}
	
	public void setLevel(int level) {
		music_background.stop();
		music_background = new SoundEffect(".//src//resources//sounds//play_soundtrack_1.wav");
		music_background.play();
		if(level == 1) 
			levelEasy();
		if(level == 2)
			levelNormal();
		if(level == 3)
			levelHard();
		game.getJb_return().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				started(game);
			}
		});
		game.getJb_newgame().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				se = new SoundEffect(".//src//resources//sounds//select_soundtrack.wav");
				se.play();
				
			}
		});
game.getJb_newgame().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				se = new SoundEffect(".//src//resources//sounds//select_soundtrack.wav");
				se.play();
				
			}
		});
game.getJb_pause().addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		se = new SoundEffect(".//src//resources//sounds//select_soundtrack.wav");
		se.play();
		
	}
});
game.getJb_return().addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		se = new SoundEffect(".//src//resources//sounds//select_soundtrack.wav");
		se.play();
		
	}
});
game.getJb_mainmenu().addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		se = new SoundEffect(".//src//resources//sounds//select_soundtrack.wav");
		se.play();
		
	}
});
	}
	
	
}
