import java.util.Random;
import java.util.Scanner;

public class VirtualPet {

	private Random generator = new Random();
	Scanner scanner = new Scanner(System.in);

	private String name = "Stacy"; //instance variables
	private int hunger;
	private int thirst;
	private int cold = 72;

	//increments variables semi-randomly to simulate passage of time 
	public void tick() {
		hunger += (15 + generateRandom());
		thirst += (15 + generateRandom());
		cold -= (1 + generateRandom());
	}
	

	public void reset() {
		hunger = 0;
		thirst = 0;
		cold = 72;
	}

	public int generateRandom() {
		return generator.nextInt(6); // random int 0-5
	}
	
	//name
	public String getName() {
		return name;
	}
	public void rename(String newName) {
		name = newName;
	}

	//hunger
	public int getHunger() {
		return hunger;
	}
	
	public boolean isHungry() {
		return hunger >= 40;
	}
	
	public boolean isVeryHungry() {
		return hunger >= 80;
	}

	public void giveAMouse() {
		hunger -= 60;
		thirst -= 20;
	}
	
	public void giveARabbit() {
		hunger -= 100;
		thirst -= 30;
	}
	
	public void giveACricket() {
		hunger -= 40;
		thirst -= 10;
	}

	public boolean hasStarved() {
		return hunger >=140;
	}

	// thirst
	public int getThirst() {
		return thirst;
	}

	public boolean isThirsty() {
		return thirst>=50;
	}
	
	public boolean isVeryThirsty() {
		return thirst>=100;
	}

	public void giveSomeWater() {
		thirst = 0;
		cold -= 10;
	}

	public boolean hasDehydrated() {
		return thirst>=180;
	}

	// cold
	public int getTemp() {
		return cold;
	}

	public boolean isCold() {
		return cold<=68;
	}

	public boolean isVeryCold() {
		return cold<=60;
	}
	
	public boolean isHot() {
		return cold>=95;
	}
	
	public void giveHeatLamp() {
		cold += 20;
	}
	public void slithersIntoWater() {
		cold -= 20;
	}

}