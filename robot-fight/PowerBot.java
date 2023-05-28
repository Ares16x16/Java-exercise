
public class PowerBot extends Robot {
	//property for boost attack
	private boolean boosted;
	
	public PowerBot(String name, int power, int lifeIndex) {
		//Constructor, which setup the three properties accordingly 
		super(name, power, lifeIndex); //invoke immediate parent class constructor.
		boosted = false; ////initialize boosted property
	}

	public void boost() {
		//boost itself
		boosted = true;
		//print ¡§robot_name boosts itself!¡¨, with robot_name replaced by an appropriate value.
		System.out.println(super.getName() + " boosts itself!");
	}
	
	@Override //overridden method
	public int attack() {
		if (boosted) { //Boost itself for the next attack
			//print ¡§robot_name makes a heavy strike!¡¨, with robot_name replaced by an appropriate value. 
			System.out.println(super.getName() + " makes a heavy strike!");
			//Reset boosting effect afterwards
			boosted = false;
			//return twice of the level value if it is boosted
			return super.getPower()*2;
		}
		else {
			//print ¡§robot_name strikes hard!¡¨ (robot_name must be replaced by an appropriate value).
			System.out.println(super.getName() + " strikes hard!");
			return super.getPower(); //return normal attack power
		}
	}
}
