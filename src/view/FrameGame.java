package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class FrameGame extends JLabel{
	private BufferedImage frame;
	
	public FrameGame() {
		try {
			frame = ImageIO.read(new File("src/resources/images/frame_1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setPreferredSize(new Dimension(800,600));
	}
	
	public void paint(Graphics g) {
			g.drawImage(frame, 0, 0, getPreferredSize().width, getPreferredSize().height, null);
	}

}
