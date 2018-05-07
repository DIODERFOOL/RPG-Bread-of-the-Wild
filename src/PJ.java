package botw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class PJ extends Gobject implements Character{

	private String name;
	private int hp, dmg, dfs,lvl, xp, mana;

	private BufferedImage pj_image;
	SpriteSheet ss = new SpriteSheet(Game.ss);
	Player player;

	public PJ(int x, int y, ID id, int posX, int posY, String name, int hp, int dmg, int dfs, int lvl, int mana) {
		super(x, y, id, posX, posY);
		this.name = name;
		this.hp = hp;
		this.dmg = dmg;
		this.dfs = dfs;
		this.lvl = lvl;
		this.mana = mana;
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

	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}

	public void setLife(int dmg){
		this.hp = this.hp-dmg;
	}
	public int getLife(){
		return hp;
	}

	public void setDamage(int dmg){
		this.dmg = dmg;
	}
	public int getDamage(){
		dmg=dmg*getLvl();			//aqui se puede añadir weapon
		return dmg;
	}

	public void setDefense(int dfs){
		this.dfs = dfs;
	}
	public int getDefense(){
		dfs = dfs*getLvl();  //aqui se puede añadir armor
		return dfs;
	}

	public int getLvl(){
		return lvl;
	}

	public void setLvl(int lvl){
		this.lvl=lvl+1;
	}

	public void setMana(int mana){
		this.mana=mana;
	}

	public int getMana(){
		return mana;
	}


	public int specialAttack(){
		this.mana=this.mana-10;
		return this.dmg*3;
	}


}
