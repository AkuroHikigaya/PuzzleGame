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
	private PowerButton quit;
	public StartGame() {
		setBounds(100, 100, 800, 600);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
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
				jb_start.repaint();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		this.add(jb_start);
		
		quit = new PowerButton();
		quit.setBounds(10, 540, 50, 50);
		quit.addMouseListener(new MouseListener() {
			
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
				quit.setLight(false);
				quit.repaint();
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				quit.setLight(true);
				quit.repaint();
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		this.add(quit);
		
		
		jl_start_background = new JLabel();
		jl_start_background.setIcon(new ImageIcon("src/resources/images/start_background.gif"));
		jl_start_background.setBounds(0, 0, 800, 600);
		this.add(jl_start_background);
	}
	public JButton getJb_start() {
		return jb_start;
	}
	public JButton getQuit() {
		return quit;
	}
	public void setQuit(PowerButton quit) {
		this.quit = quit;
	}
	
}
