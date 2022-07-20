package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class Win extends JLabel{
	private BufferedImage win_panel;
	
	public Win() {
		try {
			win_panel = ImageIO.read(new File("src/resources/images/you_win.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		setPreferredSize(new Dimension(700,300));
	}
	
	public void paint(Graphics g) {
			g.drawImage(win_panel, 0, 0, getPreferredSize().width, getPreferredSize().height, null);
	}
	
}
