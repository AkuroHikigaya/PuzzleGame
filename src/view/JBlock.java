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
	private JNumber number;
	
	public JBlock() {
		imgs = new Images();
		right = false;
		setPreferredSize(new Dimension(120,121));
		number = new JNumber(); // Đã thêm Number chứa số 1 vào nhưng không hiện
	}
	
	public void paint(Graphics g) {
		if(right) {
			g.drawImage(imgs.getList_imgs().get("red_cell"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);
		}else {
			g.drawImage(imgs.getList_imgs().get("blue_cell"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);
		}
	}
	
}
