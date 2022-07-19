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
	private boolean turn_on;
	public SoundButton() {
		light = false;
		turn_on = true;
		try {
			sound_on = ImageIO.read(new File("src/resources/images/sound_button_on.png"));
			sound_light_on = ImageIO.read(new File("src/resources/images/sound_button_on_light.png"));
			sound_off = ImageIO.read(new File("src/resources/images/sound_button_off.png"));
			sound_light_off = ImageIO.read(new File("src/resources/images/sound_button_off_light.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		setPreferredSize(new Dimension(47,47));
	}

	public void paint(Graphics g) {
		if(turn_on) {
			if(light)
				g.drawImage(sound_light_on, 0, 0, getPreferredSize().width, getPreferredSize().height, null);
			else
				g.drawImage(sound_on, 0, 0, getPreferredSize().width, getPreferredSize().height, null);
		}else {
			if(light)
				g.drawImage(sound_light_off, 0, 0, getPreferredSize().width, getPreferredSize().height, null);
			else
				g.drawImage(sound_off, 0, 0, getPreferredSize().width, getPreferredSize().height, null);
		}
	}

	public boolean isLight() {
		return light;
	}

	public void setLight(boolean light) {
		this.light = light;
	}

	public boolean isTurn_on() {
		return turn_on;
	}

	public void setTurn_on(boolean turn_on) {
		this.turn_on = turn_on;
	}
	
	

}
