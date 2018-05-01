package botw;

public abstract class Weapons{

	private String type;
	private double dmg, rare, mp, range;

	public Weapons(String type, double dmg, double rare, double mp, double range){

		this.type = type;
		this.dmg = dmg;
		this.rare = rare;
		this.mp = mp;
		this.range = range;
	}


	public abstract void setType(String type);

	public abstract String getType();

	public abstract void setDmg(double dmg);

	public abstract double getDmg();

	public abstract void setRare(double rare);

	public abstract double getRare();

	public abstract void setMp(double mp);

	public abstract double getMp();

	public abstract void setRange(double range);

	public abstract double getRange();


}