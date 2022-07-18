package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class SoundButton extends JButton{
	private BufferedImage sound_light_on;
	private BufferedImage sound_light_off;
	private BufferedImage sound_on;
	private BufferedImage sound_off;
	private boolean light;
	public SoundButton() {
		light = false;
		try {
			sound_on = ImageIO.read(new File("src/resources/images/back.png"));
			sound_light_on = ImageIO.read(new File("src/resources/images/back_light.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		setPreferredSize(new Dimension(100,40));
	}

	public void paint(Graphics g) {
		if(light)
			g.drawImage(sound_light_on, 0, 0, getPreferredSize().width, getPreferredSize().height, null);
		else
			g.drawImage(sound_on, 0, 0, getPreferredSize().width, getPreferredSize().height, null);
	}

	public boolean isLight() {
		return light;
	}

	public void setLight(boolean light) {
		this.light = light;
	}
	
	

}
