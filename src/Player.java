package botw;

public class Player implements Character{
	//El damage y el defense solo puede ser de 1 a 10

		private String name;
		private int hp, dmg, dfs,lvl, xp, mana;

	//private Weapons wpn;
	//private Items itm

	public Player(String name, int hp, int dmg, int dfs, int lvl, int mana){
		this.name = name;
		this.hp = hp;
		this.dmg = dmg;
		this.dfs = dfs;
		this.lvl = lvl;
		this.mana = mana;

		//this.wpn = wpn;
		//this.itm = tim;
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
