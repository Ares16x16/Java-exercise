import java.util.ArrayList;

public class CmdPurchase implements Command {

  @Override
  public String execute(VendingMachine v, String cmdPart) {
	  int sum = v.getSumOfCoin();
	  int qP = v.getQuan(1);
	  int qC = v.getQuan(0);

	  String s = "";
	  String t = "";
	  
	  if (cmdPart.equals("Pepsi")) {
		  if (qP <= 0) {
			  s = cmdPart + " is out of stock!";
		  } else if (sum < 5) {
				  s = "Not enough credit to buy Pepsi! Inserted $" + sum + " but needs $5.";
				  return s;
		  } else if (sum == 5) {
			  		sum -= 5;
					s = "Dropped Pepsi. Paid $5. No change.";
					v.clearCoin();
					v.reduceQuan(1);
					return s;
		  }else if (sum > 5) {
			  t = "Your change: ";
			  s = "Dropped Pepsi. Paid $" + sum + ". ";
			  sum -= 5;
			  v.reduceQuan(1);
			  while (sum >= 10) {
				  v.addChanges(10);
				  sum -= 10;
			  }
			  while (sum >= 5) {
				  v.addChanges(5);
				  sum -= 5;
			  }
			  while (sum >= 2) {
				  v.addChanges(2);
				  sum -= 2;
			  }
			  while (sum >= 1) {
				  v.addChanges(1);
				  sum -= 1;
			  }
			  
			  v.sortChanges();
			  for (int i=0; i < v.getChangesSize(); i++) {
				  t += v.getChanges(i);
				  if (i != v.getChangesSize()) {
					  t += ", ";
				  }else {
					  t += ".";
				  }
			  }
			  v.clearCoin();
			  v.clearChange();
		  }
			
	  }
	  if (cmdPart.equals("Cocacola")) {
		  if (qC <= 0) {
			  s = cmdPart + " is out of stock!";
		  } else if (sum < 4) {
				  s = "Not enough credit to buy Pepsi! Inserted $" + sum + " but needs $4.";
				  return s;
		  } else if (sum == 4) {
			  		sum -= 4;
					s = "Dropped Cocacola. Paid $4. No change.";
					v.clearCoin();
					v.reduceQuan(0);
					return s;
		  }else if (sum > 4) {
			  t = "Your change: ";
			  s = "Dropped Cocacola. Paid $" + sum + ". ";
			  sum -= 4;
			  v.reduceQuan(0);
			  while (sum >= 10) {
				  v.addChanges(10);
				  sum -= 10;
			  }
			  while (sum >= 5) {
				  v.addChanges(5);
				  sum -= 5;
			  }
			  while (sum >= 2) {
				  v.addChanges(2);
				  sum -= 2;
			  }
			  while (sum >= 1) {
				  v.addChanges(1);
				  sum -= 1;
			  }
			  
			  v.sortChanges();
			  for (int i=0; i < v.getChangesSize(); i++) {
				  t += v.getChanges(i);
				  if (i != v.getChangesSize()) {
					  t += ", ";
				  }else {
					  t += ".";
				  }
			  }
			  v.clearCoin();
			  v.clearChange();
		  }
			
	  }
	  return s + t;	  
  }
	  
}
	  
	  
