
import java.util.Scanner;

public class VirtualPetApp {

	public static void main(String[] args) {

		VirtualPet stacy = new VirtualPet();
		Scanner input = new Scanner(System.in);

		boolean wantsToQuit = false;

		System.out.println("This is Stacy the snake");
		System.out.println("           /^\\/^\\ ");
		System.out.println("         _|__|  O|");
		System.out.println("\\/     /~     \\_/ \\");
		System.out.println(" \\____|__________/  \\");
		System.out.println("        \\_______     \\");
		System.out.println("               `\\     \\                  ");
		System.out.println("                 |     |                    \\");
		System.out.println("                 /     /                     \\");
		System.out.println("                /     /                       \\ \\");
		System.out.println("               /     /                         \\  \\");
		System.out.println("             /     /                            \\   \\");
		System.out.println("           /      /             _----_           \\   \\");
		System.out.println("          /      /           _-~      ~-_         |   |");
		System.out.println("         (      (        _-~    _--_    ~-_     _/    |");
		System.out.println("          \\      ~-____-~    _-~    ~-_    ~-_-~    /");
		System.out.println("            ~-_           _-~          ~-_       _-~");
		System.out.println("               ~--______-~                ~-___-~");
		

		do {
			System.out.println("Stacy's level of hunger is: " + stacy.getHunger());
			System.out.println("Stacy's level of thirst is: " + stacy.getThirst());
			System.out.println("Stacy's temperature comfort is: " + stacy.getTemp() + " ");


			if (stacy.isHungry()) {
				System.out.println("Stacy says: \"Got any deliciousss mice?\"");
			}
			if (stacy.isThirsty()) {
				System.out.println("Stacy says: \"I need some water.\"");
			}
			if (stacy.isCold()) {
				System.out.println("Stacy says: \"I'm cold.\"");
			}
			if (stacy.isVeryCold()) {
				stacy.heatedRock();
				continue;
			}

			System.out.println("\nWhat would you like to do?");
			System.out.println("1. Feed Stacy a mouse");
			System.out.println("2. Feed Stacy a rabbit");
			System.out.println("3. Feed Stacy a cricket");
			System.out.println("4. Give Stacy some water");
			System.out.println("5. Give Stacy her heated lamp");
			System.out.println("6. Do Nothing");

			int intResponse = input.nextInt();
			String stringResponse;
			stacy.tick();

			switch (intResponse) {
			case 1: 
				stacy.giveAMouse();
				stacy.tick();
				break;
			case 2: 
				stacy.giveARabbit();
				stacy.tick();
				break;
			case 3: 
				stacy.giveACricket();
				stacy.tick();
				break;
			
			case 4: 
				stacy.giveSomeWater();
				stacy.tick();
				break;
			 
			case 5: 
				stacy.sunBathe();
				stacy.tick();
				break;
			 
			case 6:
				stacy.tick();
				break;
			}

			if (stacy.hasStarved() || stacy.hasDehydrated()) {
				System.out.println("Stacy has died. Do you want to try again (yes/no)?");
				stacy.reset();
				stringResponse = input.next();
				stringResponse = stringResponse.toLowerCase();
				wantsToQuit = !stringResponse.equals("yes");
			}
		} while (!wantsToQuit);

		System.out.println("Goodbye");
		input.close();
	}

}