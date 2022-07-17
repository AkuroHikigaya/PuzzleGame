package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Game extends JPanel{
	private JLabel jl_frame; //Khung ngoài
	private JLabel jl_game_frame;//Khung trong
	private JButton jb_back;
	private BoardGame board_game;
	public Game(int w, int h) {
		setBounds(100, 100, 800, 600);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		board_game = new BoardGame(w, h);
		board_game.setBounds(100,100,480,480);
		this.add(board_game);
		
		jb_back = new JButton("Level");
		jb_back.setBounds(662, 471, 85, 21);
		this.add(jb_back);
		
		jl_frame = new JLabel();
		jl_frame.setIcon(new ImageIcon("src/resources/images/blue_frames.png"));
		jl_frame.setBounds(0, 0, 786, 563);
		this.add(jl_frame);
	}
	public JButton getJb_back() {
		return jb_back;
	}
	public void setJb_back(JButton jb_back) {
		this.jb_back = jb_back;
	}
	
	
	
}
