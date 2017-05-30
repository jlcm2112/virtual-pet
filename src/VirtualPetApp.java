import java.util.Scanner;

public class VirtualPetApp {

	public static void main(String[] args) {

		VirtualPet snake = new VirtualPet();
		Scanner input = new Scanner(System.in);

		writeLine("What would you name your (female) snake?");
		snake.rename(input.next());

		writeLine("This is " + snake.getName() + " the snake (You can type \"rename\" or \"quit\" at any time).");
		writeLine("         ,,'6''-,.");
		writeLine("        <====,.;;--.");
		writeLine("        _`---===. \"\"\"==__");
		writeLine("      //\"\"@@-\\===\\@@@@ \"\"\\\\");
		writeLine("     |( @@@  |===|  @@@  ||");
		writeLine("      \\\\ @@   |===|  @@  //");
		writeLine("        \\\\ @@ |===|@@@ //");
		writeLine("         \\\\  |===|  //");
		writeLine("___________\\\\|===| //_____,----\"\"\"\"\"\"\"\"\"\"-----,_");
		writeLine("  \"\"\"\"---,__`\\===`/ _________,---------,____    `,");
		writeLine("             |==||                           `\\   \\");
		writeLine("            |==| |                             )   |");
		writeLine("           |==| |       _____         ______,--'   '");
		writeLine("           |=|  `----\"\"\"     `\"\"\"\"\"\"\"\"         _,-'");
		writeLine("            `=\\     __,---\"\"\"-------------\"\"\"''");
		writeLine("                \"\"\"\"		");

		boolean wantsToQuit = false;
		do {
			System.out.println(snake.getName() + "'s level of hunger is: " + snake.getHunger()
					+ " | level of thirst is: " + snake.getThirst() + " | temperature is: " + snake.getTemp()
					+ " degrees F | boredom is: " + snake.getBoredom() + "\n");

			// snake will ask for help when she needs it
			if (snake.isVeryHungry()) {
				writeLine(snake.getName() + " says: \"Got any deliciousss rabbits?\"\n" + "");
			} else if (snake.isHungry()) {
				writeLine(snake.getName() + " says: \"Got any deliciousss mice?\"\n");
			}
			if (snake.isVeryThirsty()) {
				writeLine(snake.getName() + " says: \"I really need some water.\"\n");
			} else if (snake.isThirsty()) {
				writeLine(snake.getName() + " says: \"I need some water.\"\n");
			}
			if (snake.isCold()) {
				writeLine(snake.getName() + " says: \"I'm cold.\"\n");
			}

			writeLine("What would you like to do?");
			writeLine("1. Feed " + snake.getName() + " a mouse");
			writeLine("2. Feed " + snake.getName() + " a rabbit");
			writeLine("3. Feed " + snake.getName() + " a cricket");
			writeLine("4. Give " + snake.getName() + " some water");
			writeLine("5. Give " + snake.getName() + " her heated lamp");
			writeLine("6. Play with " + snake.getName());
			writeLine("7. Display your snake");
			writeLine("8. Do Nothing");

			String response = input.next().toLowerCase();

			switch (response) {
			case "1":
				if (snake.isHungry()) {
					snake.giveAMouse();
					writeLine("You give " + snake.getName() + " a delicious mouse!\n");
				} else {
					writeLine(snake.getName() + " is full and refuses the mouse.\n");
				}
				break;
			case "2":
				if (snake.isHungry()) {
					snake.giveARabbit();
					writeLine("You give " + snake.getName() + " a delicious rabbit! " + snake.getName()
							+ " dances in excitement because this is her favorite food!\n");
				} else {
					writeLine(snake.getName() + " is full and refuses the rabbit.\n");
				}
				break;
			case "3":
				if (snake.isVeryHungry()) {
					writeLine("You give " + snake.getName() + " a cricket! " + snake.getName()
							+ " reluctantly accepts it because she's very hungry.\n");
					snake.giveACricket();
				} else if (snake.isHungry()) {
					writeLine("You try to give " + snake.getName() + " a cricket! " + snake.getName()
							+ " doesn't want it because she HATES crickets.\n");
				} else {
					writeLine(snake.getName() + " is full and she HATES crickets.\n");
				}
				break;

			case "4":
				if (snake.isThirsty()) {
					snake.giveSomeWater();
					writeLine("You give " + snake.getName() + " some water!");
				} else {
					writeLine(snake.getName() + " isn't thirsty and refuses the water.\n");
				}
				break;

			case "5":
				if (snake.isCold()) {
					snake.giveHeatLamp();
					writeLine("You give " + snake.getName() + " a sunbath with the heat lamp!\n");
				} else {
					writeLine(snake.getName() + " isn't cold and slithers away.\n");
				}
				break;
			case "6":
				snake.play();
				writeLine("You play with " + snake.getName() + ". \n");
				break;

			case "7":
				writeLine("This is " + snake.getName() + "; isn't she pretty?");
				writeLine("         ,,'6''-,.");
				writeLine("        <====,.;;--.");
				writeLine("        _`---===. \"\"\"==__");
				writeLine("      //\"\"@@-\\===\\@@@@ \"\"\\\\");
				writeLine("     |( @@@  |===|  @@@  ||");
				writeLine("      \\\\ @@   |===|  @@  //");
				writeLine("        \\\\ @@ |===|@@@ //");
				writeLine("         \\\\  |===|  //");
				writeLine("___________\\\\|===| //_____,----\"\"\"\"\"\"\"\"\"\"-----,_");
				writeLine("  \"\"\"\"---,__`\\===`/ _________,---------,____    `,");
				writeLine("             |==||                           `\\   \\");
				writeLine("            |==| |                             )   |");
				writeLine("           |==| |       _____         ______,--'   '");
				writeLine("           |=|  `----\"\"\"     `\"\"\"\"\"\"\"\"         _,-'");
				writeLine("            `=\\     __,---\"\"\"-------------\"\"\"''");
				writeLine("                \"\"\"\"		\n");
				break;

			case "8":
				break;

			case "quit":
				writeLine("Nobody likes a quitter...");
				System.exit(0);

			case "rename":
				writeLine("Enter a new name for your snake: ");
				response = input.next();
				snake.rename(response);
				break;

			default:
				writeLine("You did not enter a valid response. Try again.\n");
				break;
			}

			// passage of time
			snake.tick();

			// if you neglect her long enough she will die from hunger or
			// thirst.
			if (snake.hasStarved() || snake.hasDehydrated()) {
				if (snake.hasStarved()) {
					writeLine(snake.getName() + " has starved. Do you want to try again (yes/no)?");
				}
				if (snake.hasDehydrated()) {
					writeLine(snake.getName() + " has dehydrated. Do you want to try again (yes/no)?");
				}
				snake.reset();
				response = input.next().toLowerCase();
				wantsToQuit = !response.equals("yes"); // if they type yes,
														// wantsToQuit becomes
														// true.
			}

			// snake will do these on her own if you ignore her needs
			if (snake.isVeryCold()) {
				snake.giveHeatLamp();
				writeLine("\n" + snake.getName() + " is very cold, so she warms herself up on her heated rock.\n");
				continue;
			}
			if (snake.isHot()) {
				snake.slithersIntoWater();
				writeLine("\n" + snake.getName() + " is hot, so she slithers into some water.\n");
				continue;
			}
			if (snake.isBored()) {
				snake.play();
				writeLine("\n" + snake.getName() + ", bored, climbs around the terrarium.\n");
				continue;
			}
		} while (!wantsToQuit);

		writeLine("Goodbye."); 
		input.close();
	}

	public static void writeLine(String message) {
		System.out.println(message);
	}

}