package amok;

public class RoboticDog extends Dog implements RoboticPet {

	public RoboticDog(String name, String description) {
		super(name, description);
	}

	int oil;

	@Override
	public void oilPet() {
		oil -= 10;
	}

	@Override
	public int getOilLevel() {
		return oil;
	}

	@Override
	public void walk() {

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
		happiness += 1;
		health += 1;
	}

	@Override
	public int tick() {
		return oil += 5;
	}
}
