package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class Images {

	HashMap<String, BufferedImage> list_imgs;
	
	public Images() {
		list_imgs = new HashMap<String, BufferedImage>();
		try {
			BufferedImage img_true = ImageIO.read(new File("/PuzzleGame/src/resource/img_false.png"));
//			BufferedImage img_false = ImageIO.read(new File("/PuzzleGame/src/resource/img_false.png"));
			list_imgs.put("img_true", img_true);
//			list_imgs.put("img_false", img_false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public HashMap<String, BufferedImage> getList_imgs() {
		return list_imgs;
	}

	public void setList_imgs(HashMap<String, BufferedImage> list_imgs) {
		this.list_imgs = list_imgs;
	}
	
}
