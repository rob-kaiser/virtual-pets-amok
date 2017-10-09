package amok;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	Map<String, VirtualPet> shelterPets = new HashMap<String, VirtualPet>();

	private int litterBox = 0;

	public int getLitterBox() {
		return litterBox;
	}

	public void cleanLitterBox() {
		litterBox = 0;
	}

	public void maintainAllRobots() {
		for (VirtualPet pet : pets()) {
			if (pet instanceof RoboticPet) {
				((RoboticPet) pet).oilPet();
			}
		}
	}

	public void cleanDogCages() {
		for (VirtualPet pet : pets()) {
			if (pet instanceof OrganicDog) {
				((OrganicDog) pet).cleanCage();
			}
		}
	}

	public void walkDogs() {
		for (VirtualPet pet : pets()) {
			if (pet instanceof Dog) {
				((Dog) pet).walk();
			}
		}

	}

	public void foundPet(VirtualPet pet) {
		shelterPets.put(pet.getName(), (VirtualPet) pet);
	}

	public void foundPet(RoboticPet pet) {
		shelterPets.put(pet.getName(), (VirtualPet) pet);
	}

	public void foundPet(OrganicPet pet) {
		shelterPets.put(pet.getName(), (VirtualPet) pet);
	}

	public void feedAllOrganic() {
		for (VirtualPet pet : pets()) {
			if (pet instanceof OrganicPet) {
				((OrganicPet) pet).feed();
			}
		}
		litterBox += 5;
	}

	public void waterAllOrganic() {
		for (VirtualPet pet : pets()) {
			if (pet instanceof OrganicPet) {
				((OrganicPet) pet).water();
			}
		}
		litterBox += 5;
	}

	public void tick() {
		for (VirtualPet pet : pets()) {
			if (pet instanceof RoboticCat) {
				pet.tick();
				litterBox += 1;
			}
			if (pet instanceof RoboticDog) {
				pet.tick();
				litterBox += 1;
			}
			if (pet instanceof OrganicCat) {
				pet.tick();
				litterBox += 1;
			}
			if (pet instanceof OrganicDog) {
				pet.tick();
				litterBox += 1;
			}
		}
	}

	public Collection<VirtualPet> pets() {
		return shelterPets.values();
	}

	public VirtualPet getPet(String name) {
		return shelterPets.get(name);

	}

	public void playOne(VirtualPet playingWithOnePet) {
		playingWithOnePet.play();
	}

	public void adoptPet(VirtualPet pet) {
		shelterPets.remove(pet.getName());
	}
}