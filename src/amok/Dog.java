package amok;

public abstract class Dog extends VirtualPet {

	public Dog(String name, String description) {
		super(name, description);
	}

	public abstract void walk();

}