package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;

import model.Images;

public class JCell extends JLabel{
	private boolean right;
	private Images imgs;
	
	public JCell() {
		right = true;
		imgs = new Images();
		setPreferredSize(new Dimension(150,150));
	}
	
	public void paint(Graphics g) {
		if(right) {
			g.drawImage(imgs.getList_imgs().get("imgs_true"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);
		}else {
			g.drawImage(imgs.getList_imgs().get("imgs_false"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);
		}
	}
	
}
