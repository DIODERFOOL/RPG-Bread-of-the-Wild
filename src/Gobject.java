package botw;

import java.awt.Graphics;

public abstract class Gobject {
	protected int x, y;
	protected int posX, posY;
	protected ID id;
	protected int velX, velY;

	public Gobject(int x, int y, ID id) {
		this.x  = x;
		this.y  = y;
		this.id = id;

	}
	public Gobject(int x, int y, ID id, int posX, int posY) {
		this.x    = x;
		this.y    = y;
		this.id   = id;
		this.velX = 0;
		this.velY = 0;
		this.posX = posX;
		this.posY = posY;
	}

	public abstract void tick();
	public abstract void render(Graphics g);

	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setID(ID id) {
		this.id = id;
	}
	public void setVelX(int velX) {
		this.velX = velX;
	}
	public void setVelY(int velY) {
		this.velY = velY;
	}
	public void setPosXY(int posX, int posY) {
		this.posY = posY;
		this.posX = posX;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public ID getID() {
		return id;
	}



}
