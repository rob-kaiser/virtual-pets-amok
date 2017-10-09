package amok;

import java.util.Scanner;

public class VirtualPetShelterAmokApp {

	public static void main(String[] args) {

		VirtualPetShelter shelter = new VirtualPetShelter();
		Scanner input = new Scanner(System.in);

		OrganicPet John = new OrganicDog("John", "dog");
		shelter.foundPet(John);

		RoboticPet Tom = new RoboticDog("Tom", "robotic dog");
		shelter.foundPet(Tom);

		OrganicPet Stu = new OrganicCat("Stu", "cat");
		shelter.foundPet(Stu);

		RoboticPet Doug = new RoboticCat("Doug", "robotic cat");
		shelter.foundPet(Doug);

		boolean exit = false;

		do {
			for (VirtualPet pet : shelter.pets()) {
				if (pet instanceof OrganicDog) {
					if (((OrganicDog) pet).getCageCleanliness() >= 10) {
						System.out.print(pet.getName() + "'s cage needs cleaning.");
						((OrganicDog) pet).decreaseHealth();
					}
				}
			}
			if (shelter.getLitterBox() >= 15) {
				System.out.print(" The cats are getting sick because the litter box needs changed.");
				for (VirtualPet pet : shelter.pets()) {
					if (pet instanceof OrganicCat) {
						((OrganicCat) pet).decreaseHealth();
					}
				}
			}
			System.out.println("\nWelcome to Robs Humane Society");
			System.out.println("\nThis is the status of the pets: ");
			System.out.println("\nName\t|Mood\t|Health\t|Hunger\t|Thirst\t|Oil\t|CleanCage");
			System.out.println("________|_______|_______|_______|_______|_______|_________|");

			for (VirtualPet currentPet : shelter.pets()) {
				System.out.print(currentPet.getName() + "\t|" + ((VirtualPet) currentPet).getHappiness() + "\t|"
						+ ((VirtualPet) currentPet).getHealth() + "\t|");
				if (currentPet instanceof OrganicPet) {
					System.out.print(((OrganicPet) currentPet).getHunger() + "\t|"
							+ ((OrganicPet) currentPet).getThirst() + "\t|0\t|");
				} else if (currentPet instanceof RoboticPet) {
					System.out.print("0\t|0\t|" + ((RoboticPet) currentPet).getOilLevel() + "\t|");
				}
				if (currentPet instanceof OrganicDog) {
					System.out.print("" + ((OrganicDog) currentPet).getCageCleanliness() + "\t|");
				} else {
					System.out.print("0\t|");
				}
				System.out.print("\n");

			}

			System.out.println("\nLitterbox\n" + " level:" + shelter.getLitterBox());
			System.out.println("\nWhat would you like to do next?");
			System.out.println("Select a number to continue");
			System.out.println(" ______________________");
			System.out.println("|                      |");
			System.out.println("| 1. Give Food         |");
			System.out.println("| 2. Give Water        |");
			System.out.println("| 3. Play With a Pet   |");
			System.out.println("| 4. Adopt             |");
			System.out.println("| 5. Drop off a Pet    |");
			System.out.println("| 6. Clean Dog Cages   |");
			System.out.println("| 7. Clean Litterbox   |");
			System.out.println("| 8. Walk the dogs     |");
			System.out.println("| 9. Oil the robots    |");
			System.out.println("| 10. Exit the shelter |");
			System.out.println("|______________________|");

			String userResponse = input.nextLine();

			switch (userResponse) {
			case "1":
				shelter.feedAllOrganic();
				System.out.print("You fed all the organic pets.");
				break;
			case "2":
				shelter.waterAllOrganic();
				System.out.print("You watered all the organic pets.");
				break;
			case "3":
				System.out.println("Which pet would you like to play with?");
				displayPets(shelter);
				String petName = input.nextLine();
				shelter.playOne(shelter.getPet(petName));
				System.out.println("You played with " + shelter.getPet(petName) + ". ");
				break;
			case "4":
				System.out.print("You selected to adopt a pet. Please choose one:\n");
				displayPets(shelter);
				System.out.print("\nWhich pet would you like to adopt");
				String nameToAdopt = input.nextLine();
				VirtualPet x = shelter.getPet(nameToAdopt);
				shelter.adoptPet(x);
				System.out.print("You adopted " + nameToAdopt + ". Please take good care of him/her!");
				break;
			case "5":
				System.out.print("Is this an organic or robotic pet?");
				String response2 = input.next();
				if (response2.equalsIgnoreCase("organic")) {
					System.out.print("Is this a cat or dog?");
					String response3 = input.next();
					input.nextLine();

					if (response3.equalsIgnoreCase("dog")) {
						System.out.print("What is the dog's name?");
						String name = input.nextLine();

						System.out.print("What type of dog is this?");
						String description = input.nextLine();

						OrganicPet pet = new OrganicDog(name, description);
						shelter.foundPet(pet);
						System.out.print("We'll take good care of " + pet.getName() + ".");
					} else if (response3.equalsIgnoreCase("cat")) {
						System.out.print("What is the cat's name?");
						String name = input.nextLine();

						System.out.print("What type of cat is this?");
						String description = input.nextLine();

						OrganicPet pet = new OrganicCat(name, description);
						shelter.foundPet(pet);
						System.out.print("We'll take good care of " + pet.getName() + ".");
					}

				} else if (response2.equalsIgnoreCase("robotic")) {
					System.out.print("Is this a dog or cat?");
					String response3 = input.next();
					input.nextLine();

					if (response3.equalsIgnoreCase("dog")) {
						System.out.print("What is the dog's name?");
						String name = input.nextLine();
						System.out.print("What type of robotic dog is this?");
						String description = input.nextLine();

						RoboticPet pet = new RoboticDog(name, description);
						shelter.foundPet(pet);
						System.out.print("We'll take good care of " + pet.getName() + ".");

					} else if (response3.equalsIgnoreCase("cat")) {
						System.out.print("What is the cat's name?");
						String name = input.nextLine();
						System.out.print("What type of robotic cat is this?");
						String description = input.nextLine();

						RoboticPet pet = new RoboticCat(name, description);
						shelter.foundPet(pet);
						System.out.print("We'll take good care of " + pet.getName() + ".");
					}
				}
				break;
			case "6":
				shelter.cleanDogCages();
				System.out.print("You cleaned all the dog cages.");
				break;
			case "7":
				shelter.cleanLitterBox();
				System.out.print("You cleaned the litter box.");
				break;
			case "8":
				shelter.walkDogs();
				System.out.print("You walked the dogs! Their cages are less messy and they are happier.");
				break;
			case "9":
				shelter.maintainAllRobots();
				System.out.print("You oiled the robotic pets!");
				break;
			case "10":
				System.out.print("Insert AOL 'GOODBYE' voice here. ");
				System.exit(0);
			default:
				System.out.print("Please make a valid selection.");
				break;

			}
			shelter.tick();

		} while (!exit);
		input.close();

	}

	private static void displayPets(VirtualPetShelter shelter) {
		for (VirtualPet currentPet : shelter.pets()) {
			System.out.print("" + currentPet);
		}
	}

}