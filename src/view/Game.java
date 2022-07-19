package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class Game extends JPanel{
	private FrameGame jl_frame; //Khung ngoài
	private JLabel jl_game_frame;//Khung trong
	private JButton jb_return;
	private BoardGame board_game;
	private JButton jb_mainmenu;
	private JButton jb_pause;
	private Timer count_time;
	private JLabel time;
	private int clock_count;

	private OnGameButton jb_newgame;
	private SoundButton jb_sound;

	public Game(int w, int h) {
		setBounds(100, 100, 800, 600);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);

		board_game = new BoardGame(w, h);
		board_game.setBounds(60,60,480,480);
		this.add(board_game);

		// Bộ đếm
		time = new JLabel("0");
		clock_count = 0;
		count_time = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clock_count++;
				time.setText(String.valueOf(clock_count));		
			}
		});

		time.setBounds(605, 100, 150, 50);
		this.add(time);

		jb_newgame = new OnGameButton("New Game");
		jb_newgame.setBounds(605, 290, 150, 50);
		this.add(jb_newgame);

		jb_pause = new JButton("Pause");
		jb_pause.setBounds(605, 355, 150, 50);
		this.add(jb_pause);

		jb_return = new JButton("Return");
		jb_return.setBounds(605, 420, 150, 50);
		this.add(jb_return);

		jb_mainmenu = new JButton("Main Menu");
		jb_mainmenu.setBounds(605, 485, 150, 50);
		this.add(jb_mainmenu);

		jb_sound = new SoundButton();
		jb_sound.setBounds(720, 30, 50, 50);
		jb_sound.setContentAreaFilled(false);
		jb_sound.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				jb_sound.setLight(false);
				jb_sound.repaint();
				System.out.println("tắt ");


			}

			@Override
			public void mouseEntered(MouseEvent e) {
				jb_sound.setLight(true);
				jb_sound.repaint();
				System.out.println("sáng");


			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		this.add(jb_sound);



		jl_frame = new FrameGame();
		jl_frame.setBounds(0, 0, 800, 600);
		this.add(jl_frame);
	}
	public JButton getJb_return() {
		return jb_return;
	}
	public void setJb_return(JButton jb_return) {
		this.jb_return = jb_return;
	}
	public JButton getJb_mainmenu() {
		return jb_mainmenu;
	}
	public void setJb_mainmenu(JButton jb_mainmenu) {
		this.jb_mainmenu = jb_mainmenu;
	}
	public JButton getJb_pause() {
		return jb_pause;
	}
	public void setJb_pause(JButton jb_pause) {
		this.jb_pause = jb_pause;
	}
	public JButton getJb_newgame() {
		return jb_newgame;
	}
	public void setJb_newgame(OnGameButton jb_newgame) {
		this.jb_newgame = jb_newgame;
	}
	public JButton getJb_sound() {
		return jb_sound;
	}
	public void setJb_sound(SoundButton jb_sound) {
		this.jb_sound = jb_sound;
	}



}
