package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WinFrame extends JPanel{
	private JFrame frame;
	private Win win_background;
	private YesNoButton yes_button;
	private YesNoButton no_button;
	private JLabel moves;
	private JLabel times;
	
	public WinFrame(int move, int time) {
		frame = new JFrame();
		frame.setTitle("YOU WIN");
		frame.setSize(700,300);
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		frame.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		
		moves = new JLabel(String.valueOf(move));
		moves.setForeground(Color.WHITE);
		moves.setFont(new Font("Arial", Font.BOLD, 30));
		moves.setBounds(240,114,150,50);
		frame.add(moves);
		
		times = new JLabel(String.valueOf(time)+ "s");
		times.setForeground(Color.WHITE);
		times.setFont(new Font("Arial", Font.BOLD, 30));
		times.setBounds(508,114,150,50);
		frame.add(times);
		
		yes_button = new YesNoButton("Yes");
		yes_button.setBounds(380,195,100,50);
		yes_button.setContentAreaFilled(true);
		frame.add(yes_button);
		
		no_button = new YesNoButton("No");
		no_button.setBounds(520,195,100,50);
		no_button.setContentAreaFilled(true);
		frame.add(no_button);
		
		win_background = new Win();
		frame.add(win_background);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public YesNoButton getYes_button() {
		return yes_button;
	}
	public void setYes_button(YesNoButton yes_button) {
		this.yes_button = yes_button;
	}
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public YesNoButton getNo_button() {
		return no_button;
	}
	public void setNo_button(YesNoButton no_button) {
		this.no_button = no_button;
	}
	
	
}
