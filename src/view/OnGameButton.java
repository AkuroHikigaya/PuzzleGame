package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class OnGameButton extends JButton {
	private BufferedImage mainmenu_button;
	private BufferedImage mainmenu_button_light;
	private BufferedImage newgame_button;
	private BufferedImage newgame_button_light;
	private BufferedImage pause_button;
	private BufferedImage pause_button_light;
	private BufferedImage return_button;
	private BufferedImage return_button_light;
	private String state;
	private boolean light;
	
	
	public OnGameButton (String s) {
		
		
			this.light = false;
			this.state = state;
			try {
				mainmenu_button = ImageIO.read(new File("src/resources/images/mainmenu_button.png"));
				mainmenu_button_light = ImageIO.read(new File("src/resources/images/mainmenu_button_light.png"));
				newgame_button = ImageIO.read(new File("src/resources/images/newgame_button.png"));
				newgame_button_light = ImageIO.read(new File("src/resources/images/newgame_button_light.png"));
				pause_button = ImageIO.read(new File("src/resources/images/pause_button.png"));
				pause_button_light = ImageIO.read(new File("src/resources/images/pause_button_light.png"));
				return_button = ImageIO.read(new File("src/resources/images/return_button.png"));
				return_button_light = ImageIO.read(new File("src/resources/images/return_button_light.png"));
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			setPreferredSize(new Dimension(100,40));
		}
	
	
	public void paint(Graphics g) {
		OnGameButton new_game = new OnGameButton("New Game");
		if(state.equals("New Game")) {
			if(light)
				g.drawImage(newgame_button_light, 0, 0, getPreferredSize().width, getPreferredSize().height, null);	
			
			else
				g.drawImage(newgame_button, 0, 0, getPreferredSize().width, getPreferredSize().height, null);
			
		}
		if(state.equals("Pause")) {
			if(light)
				g.drawImage(pause_button_light, 0, 0, getPreferredSize().width, getPreferredSize().height, null);				
			else
				g.drawImage(pause_button, 0, 0, getPreferredSize().width, getPreferredSize().height, null);
		}
		if(state.equals("Return")) {
			if(light)
				g.drawImage(return_button_light, 0, 0, getPreferredSize().width, getPreferredSize().height, null);				
			else
				g.drawImage(return_button, 0, 0, getPreferredSize().width, getPreferredSize().height, null);
		}
		if(state.equals("Main Menu")) {
			if(light)
				g.drawImage(mainmenu_button_light, 0, 0, getPreferredSize().width, getPreferredSize().height, null);				
			else
				g.drawImage(mainmenu_button, 0, 0, getPreferredSize().width, getPreferredSize().height, null);
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
