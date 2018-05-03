package botw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class PJ extends Gobject {

	private BufferedImage pj_image;
	SpriteSheet ss = new SpriteSheet(Game.ss);

	public PJ(int x, int y, ID id, int posX, int posY) {
		super(x, y, id, posX, posY);
		pj_image = ss.grabImage(posX ,posY , 64, 64);
	}

	public void tick() {
		pj_image = ss.grabImage(posX, posY, 64, 64);
	}
	public void render(Graphics g) {
		//g.setColor(Color.white);
		//g.fillRect(x, y, 100, 100);
		
		g.drawImage(pj_image, x, y, null);
	}
}