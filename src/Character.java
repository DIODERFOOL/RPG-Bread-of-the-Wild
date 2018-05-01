package botw;

interface Character{

	void setName(String name);
	String getName();

	void setLife(int life);
	int getLife();

	void setDamage(double dmg);
	double getDamage();

	void setDefense(double dfs);
	double getDefense();

	void setArmor(double amr);
	double getArmor();

	/*void setWeapon(Weapons wpn);
	Weapons getWeapon();*/
}