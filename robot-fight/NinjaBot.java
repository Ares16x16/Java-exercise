
public class NinjaBot extends Robot {
	//property for hide
	private boolean hidden;
	
	public NinjaBot(String name, int power, int lifeIndex) {
		//Constructor, which setup the three properties accordingly 
		super(name, power, lifeIndex); //invoke immediate parent class constructor.
		hidden = false; //initialize hidden property
	}
	

	public void hide() {
		//hide itself
		hidden = true;
		//print ¡§robot_name hides itself from attacks!¡¨, with robot_name replaced by an appropriate value.
		System.out.println(super.getName() + " hides itself from attacks!");
	}
	
	@Override //overridden method
	public void damage(int amount) {
		if (hidden) { //If hidden, it takes no damage at all
			amount = 0;
			// print ¡§robot_name hides from the attack!¡¨
			System.out.println(super.getName() + " hides from the attack!");
			hidden = false; //. Reset the hiding status afterwards. 
		}
		else {
			//print ¡§robot_name takes a damage of amount!¡¨ as usual. (robot_name and amount must be replaced by an appropriate value.)
			System.out.println(super.getName() + " takes a damage of " + amount + "!");
			super.dmgForNBot(amount);
			
		}
	
	}
		


}
