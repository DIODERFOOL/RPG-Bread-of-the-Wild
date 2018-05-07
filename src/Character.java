package botw;

public interface Character{

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

	int getMana();
	void setMana(int mana);

	int specialAttack();


	/*void setWeapon(Weapons wpn);
	Weapons getWeapon();*/
}
