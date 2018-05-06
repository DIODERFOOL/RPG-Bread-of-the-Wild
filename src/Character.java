package botw;

interface Character{

	void setName(String name);
	String getName();

	void setLife(int life);
	int getLife();

	void setDamage(int dmg);
	int getDamage();

	void setDefense(int dfs);
	int getDefense();

	void setLvl(int lvl);
	int getLvl();

	void attack(int dmg, int hp);

	void defend(int dmg, int dfs);


	/*void setWeapon(Weapons wpn);
	Weapons getWeapon();*/
}
