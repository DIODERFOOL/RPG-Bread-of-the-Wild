package botw;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.*;

public class ImageLoader {

	private BufferedImage image;

	public BufferedImage load(String path) {
		try{
			this.image = ImageIO.read(getClass().getResource(path));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Image not Loaded");
		}
		return image;
	}
}