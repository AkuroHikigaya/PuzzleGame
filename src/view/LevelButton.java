package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class LevelButton extends JButton {
	private BufferedImage easy_button;
	private BufferedImage easy_button_light;
	private BufferedImage normal_button;
	private BufferedImage normal_button_light;
	private BufferedImage hard_button;
	private BufferedImage hard_button_light;
	private String state;
	private boolean light;
	
	public LevelButton(String state) {
		this.light = false;
		this.state = state;
		try {
			easy_button = ImageIO.read(new File("src/resources/images/easy_button.png"));
			easy_button_light = ImageIO.read(new File("src/resources/images/easy_button_enter.png"));
			normal_button = ImageIO.read(new File("src/resources/images/normal_button.png"));
			normal_button_light = ImageIO.read(new File("src/resources/images/normal_button_enter.png"));
			hard_button = ImageIO.read(new File("src/resources/images/hard_button.png"));
			hard_button_light = ImageIO.read(new File("src/resources/images/hard_button_enter.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setPreferredSize(new Dimension(200,200));
	}
	
	public void paint(Graphics g) {
		if(state.equals("Easy")) {
			if(light)
				g.drawImage(easy_button_light, 0, 0, getPreferredSize().width, getPreferredSize().height, null);				
			else
				g.drawImage(easy_button, 0, 0, getPreferredSize().width, getPreferredSize().height, null);
		}
		if(state.equals("Normal")) {
			if(light)
				g.drawImage(normal_button_light, 0, 0, getPreferredSize().width, getPreferredSize().height, null);				
			else
				g.drawImage(normal_button, 0, 0, getPreferredSize().width, getPreferredSize().height, null);
		}
		if(state.equals("Hard")) {
			if(light)
				g.drawImage(hard_button_light, 0, 0, getPreferredSize().width, getPreferredSize().height, null);				
			else
				g.drawImage(hard_button, 0, 0, getPreferredSize().width, getPreferredSize().height, null);
		}
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isLight() {
		return light;
	}

	public void setLight(boolean light) {
		this.light = light;
	}
	
	
	
}
