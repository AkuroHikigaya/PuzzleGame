package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class BackButton extends JButton{
	private BufferedImage back;
	private BufferedImage back_light;
	private boolean light;
	public BackButton() {
		light = false;
		try {
			back = ImageIO.read(new File("src/resources/images/back.png"));
			back_light = ImageIO.read(new File("src/resources/images/back_light.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		setPreferredSize(new Dimension(100,40));
	}

	public void paint(Graphics g) {
		if(light)
			g.drawImage(back_light, 0, 0, getPreferredSize().width, getPreferredSize().height, null);
		else
			g.drawImage(back, 0, 0, getPreferredSize().width, getPreferredSize().height, null);
	}

	public boolean isLight() {
		return light;
	}

	public void setLight(boolean light) {
		this.light = light;
	}
	
	
}
