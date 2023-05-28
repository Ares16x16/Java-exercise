
public class Robot{
	
	//properties
	private String name;
	private int power;
	private int lifeIndex;
	
	public Robot(String name, int power, int lifeIndex) {
		//constructor, setup 3 properties accordingly (initialization)
		this.name = name;
		this.power = power;
		this.lifeIndex = lifeIndex;
		
	}
	
	public String getName() {  //get the name of the robot
		return name;
		
	}
	
	public int getPower() {  //added for boost 
		return power;          //get the power of the robot
		
	}

	public void dmgForNBot(int amount) {  //added for hide
		lifeIndex -= amount ;          //reduce health value for nbot damage()
		
	}
	
	public void damage(int amount) {
		//reduce the life index of the robot by the specific amount.
		lifeIndex-= amount;
		//print out ¡§robot_name takes a damage of amount!¡¨, with robot_name and amount replaced by the appropriate values.
		System.out.println(name + " takes a damage of " + amount + "!");
		
	}
	
	public int attack() { 
		//print out ¡§robot_name launches an attack!¡¨, with robot_name replaced by an appropriate value.
		System.out.println(name + " launches an attack!");
		//Return the power of the next attack. It always return the value of the level property.
		return power;
	}
	
	public boolean isBroken() {
		//Return true if its life drops to zero or below.
		if (lifeIndex <= 0) {
			return true;
		}
		else return false;
	}
	
	
	
	
	
	
	
	
}