package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;

import model.Images;

public class Cell extends JButton{
	private JButton jb_cell;
	private JLabel jl_number;
	private boolean check;
	private Images imgs;
	
	public Cell() {
		jb_cell = new JButton();
		jl_number = new JLabel("1");
		check = false;
		this.setPreferredSize(new Dimension(40,40));
		this.add(jl_number);
		imgs = new Images();
	}
	
	public void paint(Graphics g) {
		if(!check) {
			g.drawImage(imgs.getList_imgs().get("img_false"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);			
		}else
			g.drawImage(imgs.getList_imgs().get("img_true"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);			
	}
	
}
