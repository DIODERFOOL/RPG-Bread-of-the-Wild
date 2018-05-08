package botw;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KInput extends KeyAdapter {

	private Handler h;

	public KInput(Handler h) {
		this.h = h;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		for (int i = 0; i < h.ob.size(); i++) {
			Gobject to = h.ob.get(i);


			if (to.getID() == ID.Mapa) {
				if (key == KeyEvent.VK_W) to.setVelY( 3);
				if (key == KeyEvent.VK_S) to.setVelY(-3);
				if (key == KeyEvent.VK_A) to.setVelX( 3);
				if (key == KeyEvent.VK_D) to.setVelX(-3);

			}
			if (to.getID() == ID.Player) {
				if (key == KeyEvent.VK_W) to.setPosXY(2, 5);
				if (key == KeyEvent.VK_S) to.setPosXY(1, 5);
				if (key == KeyEvent.VK_A) to.setPosXY(4, 5);
				if (key == KeyEvent.VK_D) to.setPosXY(3, 5);
			}
		}
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		for (int i = 0; i < h.ob.size(); i++) {
			Gobject to = h.ob.get(i);

			if (to.getID() == ID.Mapa) {
				if (key == KeyEvent.VK_W) to.setVelY(0);
				if (key == KeyEvent.VK_S) to.setVelY(0);
				if (key == KeyEvent.VK_A) to.setVelX(0);
				if (key == KeyEvent.VK_D) to.setVelX(0);

			}
		}
	}

}
