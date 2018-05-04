package botw;

import java.awt.image.BufferedImage;

public class MapLoader {
	private BufferedImage map;

	public MapLoader(BufferedImage sm) {
		this.map = sm;
	}

	public BufferedImage grabImageM(int x, int y, int width, int height) {
		BufferedImage img = map.getSubimage(x, y, width, height);
		return img;
	}
}