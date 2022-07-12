package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;

import model.Images;

public class JNumber extends JLabel{
	private int number;
	private Images imgs;
	
	public JNumber() {
		imgs = new Images();
		setPreferredSize(new Dimension(50,50));
	}
	
	public void paint(Graphics g) {
			g.drawImage(imgs.getList_imgs().get("b1"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);
	}
	
}
