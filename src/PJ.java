package botw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class PJ extends Gobject {

	private BufferedImage pj_image;

	public PJ(int x, int y, ID id) {
		super(x, y, id);
		SpriteSheet ss = new SpriteSheet(Game.ss);
		pj_image = ss.grabImage(2 ,1 , 64, 64);
	}

	public void tick() {
		x += velX;
		y += velY;
	}
	public void render(Graphics g) {
		//g.setColor(Color.white);
		//g.fillRect(x, y, 100, 100);

		g.drawImage(pj_image, x, y, null);
	}
}