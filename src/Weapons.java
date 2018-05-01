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

	public abstract void set(double rare);

	public abstract double get();

	public abstract void setType(double mp);

	public abstract double getType();

	public abstract void setType(double range);

	public abstract double getType();


}