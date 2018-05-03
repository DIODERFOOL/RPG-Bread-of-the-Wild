package botw;

import java.awt.image.BufferedImage;

public class MapLoader {
	private BufferedImage map;

	public MapLoader(BufferedImage sm) {
		this.map = sm;
	}

	public BufferedImage grabImageM(int col, int row, int width, int height) {
		BufferedImage img = map.getSubimage(0, 0, width, height);
		return img;
	}
}