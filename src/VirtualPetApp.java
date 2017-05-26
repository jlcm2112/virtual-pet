import java.util.Scanner;

public class VirtualPetApp {

	public static void main(String[] args) {

		VirtualPet snake = new VirtualPet();
		Scanner input = new Scanner(System.in);

		boolean wantsToQuit = false;

		System.out.println(
				"This is " + snake.getName() + " the snake (You can type \"rename\" or \"quit\" at any time).");
		System.out.println("         ,,'6''-,.");
		System.out.println("        <====,.;;--.");
		System.out.println("        _`---===. \"\"\"==__");
		System.out.println("      //\"\"@@-\\===\\@@@@ \"\"\\\\");
		System.out.println("     |( @@@  |===|  @@@  ||");
		System.out.println("      \\\\ @@   |===|  @@  //");
		System.out.println("        \\\\ @@ |===|@@@ //");
		System.out.println("         \\\\  |===|  //");
		System.out.println("___________\\\\|===| //_____,----\"\"\"\"\"\"\"\"\"\"-----,_");
		System.out.println("  \"\"\"\"---,__`\\===`/ _________,---------,____    `,");
		System.out.println("             |==||                           `\\   \\");
		System.out.println("            |==| |                             )   |");
		System.out.println("           |==| |       _____         ______,--'   '");
		System.out.println("           |=|  `----\"\"\"     `\"\"\"\"\"\"\"\"         _,-'");
		System.out.println("            `=\\     __,---\"\"\"-------------\"\"\"''");
		System.out.println("                \"\"\"\"		");

		do {
			System.out
					.println(snake.getName() + "'s level of hunger is: " + snake.hunger() + " | level of thirst is: "
							+ snake.getThirst() + " | temperature is: " + snake.getTemp() + " degrees F.\n");

			// Stacy will ask for help when she needs it
			if (snake.isVeryHungry()) {
				System.out.println(snake.getName() + " says: \"Got any deliciousss rabbits?\"\n"
						+ "");
			} else if (snake.isHungry()) {
				System.out.println(snake.getName() + " says: \"Got any deliciousss mice?\"\n");
			}
			if (snake.isVeryThirsty()) {
				System.out.println(snake.getName() + " says: \"I really need some water.\"\n");
			} else if (snake.isThirsty()) {
				System.out.println(snake.getName() + " says: \"I need some water.\"\n");
			}
			if (snake.isCold()) {
				System.out.println(snake.getName() + " says: \"I'm cold.\"\n");
			}

			System.out.println("What would you like to do?");
			System.out.println("1. Feed " + snake.getName() + " a mouse");
			System.out.println("2. Feed " + snake.getName() + " a rabbit");
			System.out.println("3. Feed " + snake.getName() + " a cricket");
			System.out.println("4. Give " + snake.getName() + " some water");
			System.out.println("5. Give " + snake.getName() + " her heated lamp");
			System.out.println("6. Display your snake");
			System.out.println("7. Do Nothing");

			String response = input.next().toLowerCase();
=
			switch (response) {
			case "1":
				if (snake.isHungry()) {
					snake.giveAMouse();
					System.out.println("You give " + snake.getName() + " a delicious mouse!\n");
				} else {
					System.out.println(snake.getName() + " is full and refuses the mouse.\n");
				}
				break;
			case "2":
				if (snake.isHungry()) {
					snake.giveARabbit();
					System.out.println("You give " + snake.getName()
							+ " a delicious rabbit! Stacy dances in excitement because this is her favorite food!\n");
				} else {
					System.out.println(snake.getName() + " is full and refuses the rabbit.\n");
				}
				break;
			case "3":
				if (snake.isVeryHungry()) {
					System.out.println("You give " + snake.getName()
					+ " a delicious cricket! Stacy reluctantly accepts it because she's very hungry.\n");
			    snake.giveACricket();
				} else if (snake.isHungry()) {
					System.out.println("You try to give " + snake.getName()
					+ " a delicious cricket! Stacy doesn't want it because she hates crickets.\n");
				} else {
					System.out.println(snake.getName() + " is full and hates crickets.\n");
				}
				break;

			case "4":
				if (snake.isThirsty()) {
					snake.giveSomeWater();
					System.out.println("You give " + snake.getName() + " some water!");
				} else {
					System.out.println(snake.getName() + " isn't thirsty and refuses the water.\n");
				}
				break;

			case "5":
				if (snake.isCold()) {
					snake.giveHeatLamp();
					System.out.println("You give " + snake.getName() + " a sunbath with the heat lamp!\n");
				} else {
					System.out.println(snake.getName() + " isn't cold and slithers away.\n");
				}
				break;

			case "6":
				System.out.println("This is " + snake.getName() + "; isn't she pretty?");
				System.out.println("         ,,'6''-,.");
				System.out.println("        <====,.;;--.");
				System.out.println("        _`---===. \"\"\"==__");
				System.out.println("      //\"\"@@-\\===\\@@@@ \"\"\\\\");
				System.out.println("     |( @@@  |===|  @@@  ||");
				System.out.println("      \\\\ @@   |===|  @@  //");
				System.out.println("        \\\\ @@ |===|@@@ //");
				System.out.println("         \\\\  |===|  //");
				System.out.println("___________\\\\|===| //_____,----\"\"\"\"\"\"\"\"\"\"-----,_");
				System.out.println("  \"\"\"\"---,__`\\===`/ _________,---------,____    `,");
				System.out.println("             |==||                           `\\   \\");
				System.out.println("            |==| |                             )   |");
				System.out.println("           |==| |       _____         ______,--'   '");
				System.out.println("           |=|  `----\"\"\"     `\"\"\"\"\"\"\"\"         _,-'");
				System.out.println("            `=\\     __,---\"\"\"-------------\"\"\"''");
				System.out.println("                \"\"\"\"		\n");
				break;

			case "7":
				break;

			case "quit":
				System.out.println("Nobody likes a quitter...");
				System.exit(0);

			case "rename":
				System.out.println("Enter a new name for your snake: ");
				response = input.next();
				snake.rename(response);
				break;

			default:
				System.out.println("You did not enter a valid response. Try again.\n");
				break;
			}

			// passage of time
			snake.tick();

			// if you neglect her long enough she will die from hunger or
			// thirst.
			if (snake.hasStarved() || snake.hasDehydrated()) {
				if (snake.hasStarved()) {
					System.out.println(snake.getName() + " has starved. Do you want to try again (yes/no)?");
				}
				if (snake.hasDehydrated()) {
					System.out.println(snake.getName() + " has starved. Do you want to try again (yes/no)?");
				}
				snake.reset();
				response = input.next();
				response = response.toLowerCase();
				wantsToQuit = !response.equals("yes"); // if they type yes,
														// wantsToQuit becomes
														// true
			}
			
			// Stacy will do these on her own if you ignore her needs
			if (snake.isVeryCold()) {
				snake.giveHeatLamp();
				System.out.println("\n" +snake.getName() + " is very cold, so she warms herself up on her heated rock.\n");
				continue;
			}
			if (snake.isHot()) {
				snake.slithersIntoWater();
				System.out.println("\n" + snake.getName() + " is hot, so she slithers into some water.\n");
				continue;
			}
		} while (!wantsToQuit);

		System.out.println("Goodbye.");
		input.close();
	}

}