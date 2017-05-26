import java.util.Random;
import java.util.Scanner;

public class VirtualPet {

	private Random generator = new Random();
	Scanner scanner = new Scanner(System.in);

	private String name;
	private int hunger;
	private int thirst;
	private int cold;

	public VirtualPet() {
		name = "Stacy";
	}

	public void tick() {
		hunger += (5 + generateRandom());
		thirst += (5 + generateRandom());
		cold += (5 + generateRandom());

	}

	public void reset() {
		hunger = 0;
		thirst = 0;
		cold = 0;

	}

	public int generateRandom() {
		return generator.nextInt(6); // random int 0-5
	}


	// hunger
	public boolean isHungry() {
		boolean hungry = (hunger >= 50);
		return hungry;
	}

	public int getHunger() {
		return hunger;
	}

	public void giveAMouse() {
		if (hunger <= -40) {
			System.out.println("Stacy is full and refuses the mouse.");
		} else {
			hunger -= 40;
			System.out.println("You give stacy a delicious mouse!");

		}
	}

	public boolean hasStarved() {
		boolean starved = (hunger >= 100);
		return starved;
	}

	// thirst
	public int getThirst() {
		return thirst;
	}

	public boolean isThirsty() {
		boolean thirsty = (thirst >= 50);
		return thirsty;
	}

	public void giveSomeWater() {
		if (thirst <= -50) {
			System.out.println("Stacy isn't thirsty and refuses the water.");
		} else {
			thirst -= 40;
			System.out.println("You give stacy a some water!");

		}

	}

	public boolean hasDehydrated() {
		boolean dehydrated = (thirst >= 100);
		return dehydrated;
	}

	// cold
	public int getTemp() {
		return cold;
	}

	public boolean isCold() {
		boolean coldSnake = (cold >= 50);
		return coldSnake;
	}

	public boolean isVeryCold() {
		boolean coldSnake = (cold >= 90);
		return coldSnake;
	}

	public void sunBathe() {
		if (cold <= -10) {
			System.out.println("Stacy isn't cold and slithers away.");
		} else {
			cold -= 50;
			System.out.println("You give stacy a sunbath with the heat lamp!");
		}

	}

	public void heatedRock() {
		cold -= 50;
		System.out.println("Stacy warmed herself up on her heated rock \n");

	}

}