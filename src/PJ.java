package botw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class PJ extends Gobject {

	private BufferedImage testImage;

	public PJ(int x, int y, ID id) {
		super(x, y, id);
		testImage = ImageLoader.loadImage("../res/IMG/Sprite_map_test.png");

	}

	public void tick() {
		x += velX;
		y += velY;
	}
	public void render(Graphics g) {
		g.drawImage(testImage, x, y, null);
		g.fillRect(x, y, 32, 32);
	}
}