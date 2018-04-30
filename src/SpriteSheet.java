package botw;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	private BufferedImage sprite;

	public SpriteSheet(BufferedImage ss) {
		this.sprite = ss;
	}

	public BufferedImage grabImage(int col, int row, int width, int height) {
		BufferedImage img = sprite.getSubimage((row * 64) -64, (col * 64)-64, width, height);
		return img;
	}
}