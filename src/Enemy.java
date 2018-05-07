package botw;

public class Enemy implements Character{
		private String name;
		private int hp, dmg, dfs,lvl, mana;

	// private Weapons wpn;

	public Enemy(String name, int hp, int dmg, int dfs, int lvl){
		this.name=name;
		this.hp=hp;
		this.dmg=dmg;
		this.dfs=dfs;
		this.lvl=lvl;
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
		return dmg*lvl;
	}


	public void setDefense(int dfs){
		this.dfs = dfs;
	}
	public int getDefense(){
		dfs=dfs*lvl;
		return dfs;
	}

	public void setLvl(int lvl){
		this.lvl=lvl;
	}

	public int getLvl(){
		return lvl;
	}


	public int getMana(){
		return mana;

	}

	public void setMana(int mana){
		this.mana=mana;
	}

	public int specialAttack(){
		return 0;
	}

	/*public void setWeapon(Weapons wpn){
		this.wpn = wpn;
	}
	public Weapons getWeapon(){
		return wpn;
	}*/

}
