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
			BufferedImage img = ImageIO.read(new File("src/resources/theme.png"));	
			list_imgs.put("blue_cell", img.getSubimage(1, 1, 150, 150));
			list_imgs.put("red_cell", img.getSubimage(152, 1, 150, 150));
			list_imgs.put("null_cell", img.getSubimage(303, 1, 150, 150));
			list_imgs.put("r0", img.getSubimage(1, 152, 50, 50));
			list_imgs.put("r1", img.getSubimage(52, 152, 50, 50));
			list_imgs.put("r2", img.getSubimage(103, 152, 50, 50));
			list_imgs.put("r3", img.getSubimage(154, 152, 50, 50));
			list_imgs.put("r4", img.getSubimage(205, 152, 50, 50));
			list_imgs.put("r5", img.getSubimage(256, 152, 50, 50));
			list_imgs.put("r6", img.getSubimage(307, 152, 50, 50));
			list_imgs.put("r7", img.getSubimage(358, 152, 50, 50));
			list_imgs.put("r8", img.getSubimage(409, 152, 50, 50));
			list_imgs.put("r9", img.getSubimage(460, 152, 50, 50));
			list_imgs.put("b0", img.getSubimage(1, 203, 50, 50));
			list_imgs.put("b1", img.getSubimage(52, 203, 50, 50));
			list_imgs.put("b2", img.getSubimage(103, 203, 50, 50));
			list_imgs.put("b3", img.getSubimage(154, 203, 50, 50));
			list_imgs.put("b4", img.getSubimage(205, 203, 50, 50));
			list_imgs.put("b5", img.getSubimage(256, 203, 50, 50));
			list_imgs.put("b6", img.getSubimage(307, 203, 50, 50));
			list_imgs.put("b7", img.getSubimage(358, 203, 50, 50));
			list_imgs.put("b8", img.getSubimage(409, 203, 50, 50));
			list_imgs.put("b9", img.getSubimage(460, 203, 50, 50));
			
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
