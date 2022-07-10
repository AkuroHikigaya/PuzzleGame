package view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class Image {
	private HashMap<String, BufferedImage> hashImage;
	
	public HashMap<String, BufferedImage> getHashImage() {
		return hashImage;
	}

	public void setHashImage(HashMap<String, BufferedImage> hashImage) {
		this.hashImage = hashImage;
	}

	public Image() {
		hashImage = new HashMap<String, BufferedImage>();
		try {
			File f = new File("klee.gif");
			BufferedImage img = ImageIO.read(f);
			hashImage.put("Klee", img);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
