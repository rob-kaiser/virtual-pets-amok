package amok;

public abstract class VirtualPet {

	protected String name;
	protected String description;

	protected int health;
	protected int happiness;

	public VirtualPet(String newName, String newDescription) {
		name = newName;
		description = newDescription;
		health = 5;
		happiness = 5;
	}

	public abstract String getName();

	public abstract int getHealth();

	public abstract int getHappiness();

	public abstract void play();

	public abstract int tick();

	@Override
	public String toString() {
		return (name + " the " + description + " , ");
	}
}