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
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Level extends JPanel {
	private JLabel jl_dif_background;
	private JButton jb_easy;
	private JButton jb_normal;
	private JButton jb_hard;
	
	public Level() {
		setBounds(100, 100, 800, 600);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		jb_easy = new JButton("Easy");
		jb_easy.setBounds(22, 122, 85, 33);
		this.add(jb_easy);
		
		jb_normal = new JButton("Normal");
		jb_normal.setBounds(141, 122, 143, 33);
		this.add(jb_normal);
		
		jb_hard = new JButton("Khó");
		jb_hard.setBounds(323, 122, 85, 33);
		this.add(jb_hard);
		
		jl_dif_background = new JLabel();
		jl_dif_background.setIcon(new ImageIcon("src/resources/images/dif_background.gif"));
		jl_dif_background.setBounds(0, 0, 786, 563);
		this.add(jl_dif_background);

	}

	public JButton getJb_easy() {
		return jb_easy;
	}

	public void setJb_easy(JButton jb_easy) {
		this.jb_easy = jb_easy;
	}

	public JButton getJb_normal() {
		return jb_normal;
	}

	public void setJb_normal(JButton jb_normal) {
		this.jb_normal = jb_normal;
	}

	public JButton getJb_hard() {
		return jb_hard;
	}

	public void setJb_hard(JButton jb_hard) {
		this.jb_hard = jb_hard;
	}
	
}
