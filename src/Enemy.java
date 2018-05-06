package botw;

public class Enemy implements Character{

	private String name;
	private int hp, dmg, dfs,lvl;
	// private Weapons wpn;

	public Enemy(String name, int hp, int dmg, int dfs, int lvl){
		this.name = name;
		this.hp = hp;
		this.dmg = dmg;
		this.dfs = dfs;
		//this.wpn = wpn;
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


	/*public int attack(int dmg, int hp){

	}

	public int defend(int dmg, int dfs){

	}*/

	/*public void setWeapon(Weapons wpn){
		this.wpn = wpn;
	}
	public Weapons getWeapon(){
		return wpn;
	}*/

}
