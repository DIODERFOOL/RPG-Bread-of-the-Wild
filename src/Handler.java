package botw;

import java.util.LinkedList;
import java.awt.Graphics;
import java.io.Serializable;

public class Handler implements Serializable{
	LinkedList<Gobject> ob = new LinkedList<Gobject>();

	public void tick() {
		for (int i = 0; i < ob.size() ; i++) {
			Gobject to = ob.get(i);
			to.tick();
		}
	}
	public void render(Graphics g) {
		for (int i = 0; i < ob.size() ; i++) {
			Gobject to = ob.get(i);
			to.render(g);
		}
	}

	public void addObject(Gobject ob) {
		this.ob.add(ob);
	}
	public void removeObject(Gobject ob) {
		this.ob.remove(ob);
	}

}