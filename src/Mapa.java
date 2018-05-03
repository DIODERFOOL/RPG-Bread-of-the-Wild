package botw;

import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class Mapa extends Gobject {
	
	private BufferedImage map_images;
	MapLoader sm = new MapLoader(Game.sm);

	public Mapa(int x, int y, ID id) {
		super(x, y, id);
		map_images = sm.grabImageM(1, 1, 960, 960);
	}
	public void tick() {
		x += velX;
		y += velY;
	}
	public void render(Graphics g) {
		//g.setColor(Color.white);
		//g.fillRect(x, y, 100, 100);

		g.drawImage(map_images, x, y, null);
	}
}