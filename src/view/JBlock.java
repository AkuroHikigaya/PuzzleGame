package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Images;

public class JBlock extends JButton{
	private boolean right;
	private Images imgs;
	private String number;
	
	public JBlock() {
		number = "1"; 
		imgs = new Images();
		right = true;
		setPreferredSize(new Dimension(120,121));
		
		
	}
	
	public void paint(Graphics g) {
		if(right) {
			g.drawImage(imgs.getList_imgs().get("red_cell"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);
			g.drawImage(imgs.getList_imgs().get("r1"),  35, 35, 50, 50, null);
		}else {
			g.drawImage(imgs.getList_imgs().get("blue_cell"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);
		}
	}
	
}
