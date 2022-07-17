package view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class StartGame extends JPanel {
	private JLabel jl_start_background;
	private JButton jb_start;
	public StartGame() {
		setBounds(100, 100, 800, 600);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		jb_start = new JButton("Start");
		jb_start.setBounds(342, 433, 85, 21);
		this.add(jb_start);
		
		jl_start_background = new JLabel();
		jl_start_background.setIcon(new ImageIcon("src/resources/images/start_background.gif"));
		jl_start_background.setBounds(0, 0, 786, 563);
		this.add(jl_start_background);
	}
	public JButton getJb_start() {
		return jb_start;
	}
	public void setJb_start(JButton jb_start) {
		this.jb_start = jb_start;
	}
	
}
