package amok;

public class OrganicDog extends Dog implements OrganicPet {

	private int hunger;
	private int cageCleanliness;
	private int thirst;

	public OrganicDog(String newName, String newDescription) {
		super(newName, newDescription);
	}

	public void feed() {
		hunger += 3;
		thirst += 1;
		health += 1;
		happiness += 1;
	}

	public void water() {
		health += 1;
		happiness += 1;
		hunger += 1;
	}

	@Override
	public void walk() {
		health += 1;
		happiness += 1;
		cageCleanliness -= 2;
	}

	@Override
	public void play() {
		happiness += 2;
		hunger += 1;
		thirst += 1;
		health += 1;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getHealth() {
		return health;
	}

	@Override
	public int getHappiness() {
		return happiness;
	}

	@Override
	public int tick() {
		happiness -= 1;
		health -= 1;
		hunger += 1;
		thirst += 1;
		cageCleanliness += 1;
		return cageCleanliness;

	}

	public void cleanCage() {
		happiness += 1;
		health += 1;
		cageCleanliness = 0;
	}

	public void decreaseHealth() {
		health -= 1;
	}

	@Override
	public int getHunger() {
		return hunger;
	}

	@Override
	public int getThirst() {
		return thirst;
	}

	public int getCageCleanliness() {
		return cageCleanliness;
	}

}
