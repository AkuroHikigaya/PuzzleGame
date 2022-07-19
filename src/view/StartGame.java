package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class StartGame extends JPanel {
	private JLabel jl_start_background;
	private StartButton jb_start;
	private PowerButton power_button;
	private SoundButton sound_button;
	private SoundEffect se;
	private SoundEffect music_background;
	public StartGame() {
		setBounds(100, 100, 800, 600);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		music_background = new SoundEffect(".//src//resources//sounds//main_soundtrack.wav");
		music_background.play();
		jb_start = new StartButton();
		jb_start.setBounds(200, 433, 400,40);
		jb_start.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
				jb_start.setState(false);
				jb_start.repaint();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				jb_start.setState(true);
				se = new SoundEffect(".//src//resources//sounds//enter_soundtrack.wav");
				se.play();
				jb_start.repaint();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		this.add(jb_start);
		
		power_button = new PowerButton();
		power_button.setBounds(10, 545, 45, 45);
		power_button.setContentAreaFilled(false);
		power_button.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
				power_button.setLight(false);
				power_button.repaint();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				power_button.setLight(true);
				power_button.repaint();
				se = new SoundEffect(".//src//resources//sounds//enter_soundtrack.wav");
				se.play();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		this.add(power_button);
		
		sound_button = new SoundButton();
		sound_button.setBounds(742,542,47,47);
		sound_button.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(sound_button.isTurn_on()) {
					sound_button.setTurn_on(false);
					music_background.pause();
				}
				else {
					sound_button.setTurn_on(true);
					music_background.continues();
				}
				sound_button.repaint();
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
				sound_button.setLight(false);
				sound_button.repaint();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				sound_button.setLight(true);
				sound_button.repaint();
				se = new SoundEffect(".//src//resources//sounds//enter_soundtrack.wav");
				se.play();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		this.add(sound_button);
		
		jl_start_background = new JLabel();
		jl_start_background.setIcon(new ImageIcon("src/resources/images/start_background.gif"));
		jl_start_background.setBounds(0, 0, 800, 600);
		this.add(jl_start_background);
	}
	public StartButton getJb_start() {
		return jb_start;
	}
	public JButton getPower_button() {
		return power_button;
	}
	public void setPower_button(PowerButton quit) {
		this.power_button = quit;
	}
	public SoundEffect getMusic_background() {
		return music_background;
	}
	public void setMusic_background(SoundEffect music_background) {
		this.music_background = music_background;
	}
	
}
