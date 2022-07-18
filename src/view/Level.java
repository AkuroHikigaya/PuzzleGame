package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Level extends JPanel {
	private JLabel jl_dif_background;
	private LevelButton jb_easy;
	private LevelButton jb_normal;
	private LevelButton jb_hard;
	private BackButton jb_back;
	
	public Level() {
		setBounds(100, 100, 800, 600);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		jb_easy = new LevelButton("Easy");
		jb_easy.setBounds(50, 250, 200, 200);
		jb_easy.setContentAreaFilled(false);		
		jb_easy.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
				jb_easy.setLight(false);
				jb_easy.repaint();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				jb_easy.setLight(true);
				jb_easy.repaint();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		this.add(jb_easy);
		
		jb_normal = new LevelButton("Normal");
		jb_normal.setBounds(290, 250, 200, 200);
		jb_normal.setContentAreaFilled(false);
		jb_normal.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
				jb_normal.setLight(false);
				jb_normal.repaint();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				jb_normal.setLight(true);
				jb_normal.repaint();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		this.add(jb_normal);
		
		jb_hard = new LevelButton("Hard");
		jb_hard.setBounds(530, 250, 200, 200);
		jb_hard.setContentAreaFilled(false);
		jb_hard.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
				jb_hard.setLight(false);
				jb_hard.repaint();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				jb_hard.setLight(true);
				jb_hard.repaint();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		this.add(jb_hard);
		
		jb_back = new BackButton();
		jb_back.setBounds(650, 500, 100, 40);
		jb_back.setContentAreaFilled(false);
		jb_back.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
				jb_back.setLight(false);
				jb_back.repaint();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				jb_back.setLight(true);
				jb_back.repaint();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		this.add(jb_back);;
		
		jl_dif_background = new JLabel();
		jl_dif_background.setIcon(new ImageIcon("src/resources/images/dif_background.gif"));
		jl_dif_background.setBounds(0, 0, 800, 600);
		this.add(jl_dif_background);

	}

	public JButton getJb_easy() {
		return jb_easy;
	}

	public void setJb_easy(LevelButton jb_easy) {
		this.jb_easy = jb_easy;
	}

	public JButton getJb_normal() {
		return jb_normal;
	}

	public void setJb_normal(LevelButton jb_normal) {
		this.jb_normal = jb_normal;
	}

	public JButton getJb_hard() {
		return jb_hard;
	}

	public void setJb_hard(LevelButton jb_hard) {
		this.jb_hard = jb_hard;
	}

	public BackButton getJb_back() {
		return jb_back;
	}

	public void setJb_back(BackButton jb_back) {
		this.jb_back = jb_back;
	}
	
	
	
}
