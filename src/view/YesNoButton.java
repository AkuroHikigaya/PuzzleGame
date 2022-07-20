package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class YesNoButton extends JButton{
	private BufferedImage yes_button_light;
	private BufferedImage no_button_light;
	private String state;
	public YesNoButton(String state) {
		this.state = state;
		try {
			yes_button_light = ImageIO.read(new File("src/resources/images/yes_button_light.png"));
			no_button_light = ImageIO.read(new File("src/resources/images/no_button_light.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setPreferredSize(new Dimension(100,50));
	}
	
	 public void paint(Graphics g) {
		 if(state.equals("Yes")) {
					g.drawImage(yes_button_light, 0, 0, getPreferredSize().width, getPreferredSize().height, null);	
		}else if(state.equals("No")) {
					g.drawImage(no_button_light, 0, 0, getPreferredSize().width, getPreferredSize().height, null);				
		}
	 }

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
}
