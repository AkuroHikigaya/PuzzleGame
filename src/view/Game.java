package view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Game extends JPanel{
	private FrameGame jl_frame; //Khung ngoài
	private JLabel jl_game_frame;//Khung trong
	private JButton jb_back;
	private BoardGame board_game;
	private JButton jb_mainmenu;
	private JButton jb_pause;
	private JButton jb_newgame;
	private SoundButton jb_sound;
	public Game(int w, int h) {
		setBounds(100, 100, 800, 600);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		board_game = new BoardGame(w, h);
		board_game.setBounds(60,60,480,480);
		this.add(board_game);
		
		jb_newgame = new JButton("New Game");
		jb_newgame.setBounds(630, 340, 100, 40);
		this.add(jb_newgame);
		
		jb_pause = new JButton("Pause");
		jb_pause.setBounds(630, 390, 100, 40);
		this.add(jb_pause);
		
		jb_back = new JButton("Exit");
		jb_back.setBounds(630, 440, 100, 40);
		this.add(jb_back);
		
		jb_mainmenu = new JButton("Main Menu");
		jb_mainmenu.setBounds(630, 490, 100, 40);
		this.add(jb_mainmenu);
		
		jb_sound = new SoundButton();
		jb_sound.setBounds(730, 30, 40, 40);
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
	public JButton getJb_back() {
		return jb_back;
	}
	public void setJb_back(JButton jb_back) {
		this.jb_back = jb_back;
	}
	
	
	
}
