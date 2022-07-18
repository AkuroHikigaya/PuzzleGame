package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class PowerButton extends JButton{
	private BufferedImage power;
	private BufferedImage power_light;
	private boolean light;
	public PowerButton() {
		light = false;
		try {
			power = ImageIO.read(new File("src/resources/images/power_button.png"));
			power_light = ImageIO.read(new File("src/resources/images/power_button_light.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		setPreferredSize(new Dimension(50,50));
	}

	public void paint(Graphics g) {
		if(light)
			g.drawImage(power_light, 0, 0, getPreferredSize().width, getPreferredSize().height, null);
		else
			g.drawImage(power, 0, 0, getPreferredSize().width, getPreferredSize().height, null);
	}

	public boolean isLight() {
		return light;
	}

	public void setLight(boolean light) {
		this.light = light;
	}
	
	
	
	

}
