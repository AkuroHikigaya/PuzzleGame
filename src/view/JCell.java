package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Images;

public class JCell extends JPanel{
	private boolean right;
	private Images imgs;
	private JButton jb_cell;
	
	public JCell() {
		jb_cell = new JButton();
		imgs = new Images();
//		right = true;
		setPreferredSize(new Dimension(120,121));
	}
	
	public void paint(Graphics g) {
//		if(right) {
		g.drawImage(imgs.getList_imgs().get("img_false"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);
//		}else {
//			g.drawImage(imgs.getList_imgs().get("imgs_false"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);
//		}
	}
	
}
