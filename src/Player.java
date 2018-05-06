package botw;

public class Player implements Character{

	private String name;
	private int hp, dmg, dfs, xp, lvl;

	// private Weapons wpn;
	//private Items itm

	public Player(String name, int hp, int dmg, int dfs, int xp, int lvl){
		this.name = name;
		this.hp = hp;
		this.dmg = dmg;
		this.dfs = dfs;
		this.xp = xp;
		this.lvl = lvl;

		//this.wpn = wpn;
		//this.itm = tim;
	}

	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}

	public void setLife(int hp){
		this.hp = hp;
	}
	public int getLife(){
		return hp;
	}

	public void setDamage(int dmg){
		this.dmg = dmg;
	}
	public int getDamage(){
		return dmg;
	}

	public void setDefense(int dfs){
		this.dfs = dfs;
	}
	public int getDefense(){
		return dfs;
	}

	public int getLvl(){
		return lvl;
	}

	public void setLvl(int lvl){
		this.lvl=lvl;
	}

	public void setXp(int xp){
		this.xp=xp;
	}

	public int getXp(int xp){
		return xp;
	}


	/*public void setWeapon(Weapons wpn){
		this.wpn = wpn;
	}
	public Weapons getWeapon(){
		return wpn;
	}*/

	/*public void setWeapon(Weapons itm){
		this.itm = itm;
	}
	public Weapons getWeapon(){
		return itm;
	}*/

}
