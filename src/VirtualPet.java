import java.util.Random;

public class VirtualPet {

	private Random generator = new Random();

	private String name = "Stacy"; //instance variables
	private int hunger;
	private int thirst;
	private int temp = 72;

	//increments variables semi-randomly to simulate passage of time 
	public void tick() {
		hunger += (10 + generateRandom());
		thirst += (10 + generateRandom());
		temp -= (1 + generateRandom());
	}
	
	public void play() {
		hunger += 5;
		thirst += 5;
		temp += 4;			
	}

	public void reset() {
		hunger = 0;
		thirst = 0;
		temp = 72;
	}

	public int generateRandom() {
		return generator.nextInt(10); // random int 0-9
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
		return hunger >= 20;
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
		temp -= 10;
	}

	public boolean hasDehydrated() {
		return thirst>=180;
	}

	// cold
	public int getTemp() {
		return temp;
	}

	public boolean isCold() {
		return temp<=68;
	}

	public boolean isVeryCold() {
		return temp<=60;
	}
	
	public boolean isHot() {
		return temp>=95;
	}
	
	public void giveHeatLamp() {
		temp += 20;
	}
	public void slithersIntoWater() {
		temp -= 20;
	}

}