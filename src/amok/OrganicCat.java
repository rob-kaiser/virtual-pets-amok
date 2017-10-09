package amok;

public class OrganicCat extends Cat implements OrganicPet {

	protected int hunger;
	protected int thirst;

	public OrganicCat(String name, String description) {
		super(name, description);
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
	public void play() {
		happiness += 2;
		hunger += 1;
		thirst += 1;
		health += 1;
	}

	@Override
	public int tick() {
		happiness -= 1;
		health -= 1;
		hunger += 1;
		thirst += 1;
		return 1;
	}

	@Override
	public void feed() {
		hunger += 3;
		thirst += 1;
		health += 1;
		happiness += 1;
	}

	@Override
	public void water() {
		health += 1;
		happiness += 1;
		hunger += 1;
	}

	@Override
	public int getHunger() {
		return hunger;
	}

	@Override
	public int getThirst() {
		return thirst;
	}

	public void decreaseHealth() {
		health -= 1;

	}

}
