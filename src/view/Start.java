package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Start extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Start() {
		contentPane = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 600);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setTitle("Game puzzle");
		contentPane.setLayout(null);
		
		
//		JButton btnNewButton = new JButton("START");
//		btnNewButton.setFont(new Font("Arial", Font.BOLD, 30));
//		btnNewButton.setBounds(155, 134, 146, 53);
////		btnNewButton.setBackground(Color.BLACK);
//		btnNewButton.setForeground(Color.GREEN);
//		btnNewButton.setOpaque(false);
//		btnNewButton.setContentAreaFilled(false);
//		btnNewButton.setBorderPainted(false);
//		contentPane.add(btnNewButton);
		
		JLabel gif_img = new JLabel("");
		gif_img.setLabelFor(contentPane);
		gif_img.setIcon(new ImageIcon("src/resources/images/start_background.gif"));
//		gif_img.setBounds(0, 10, 426, 253);
		gif_img.setBounds(0,0, 1920, 1080);
		contentPane.add(gif_img);
		
	}
}