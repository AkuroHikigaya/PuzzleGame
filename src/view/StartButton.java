package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class StartButton extends JButton{
	private BufferedImage button_start;
	private BufferedImage button_start_light;
	private boolean light;
	public StartButton() {
		light = false;
		try {
			button_start = ImageIO.read(new File("src/resources/images/click_here_to_start.png"));
			button_start_light = ImageIO.read(new File("src/resources/images/click_here_to_start_light.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		setPreferredSize(new Dimension(400,40));
	}

	public void paint(Graphics g) {
		if(light)
			g.drawImage(button_start_light, 0, 0, getPreferredSize().width, getPreferredSize().height, null);
		else
			g.drawImage(button_start, 0, 0, getPreferredSize().width, getPreferredSize().height, null);
	}

	public boolean isState() {
		return light;
	}

	public void setState(boolean state) {
		this.light = state;
	}
	
	
	
}
