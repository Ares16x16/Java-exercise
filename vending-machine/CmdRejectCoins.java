public class CmdRejectCoins implements Command {

  @Override
  public String execute(VendingMachine v, String cmdPart) {
	  String s = "Rejected ";
	  int sum = v.getSumOfCoin();
	  if (sum == 0) {
		  s += "no coin!";  
	  }else {
		  v.sortCoin();
		 int coin = v.getCoin();
		 s += "$" + String.valueOf(coin);
		 while (coin != 0) {
			 v.rejectCoin();
			 coin = v.getCoin();
			if (coin == 0) {
				break;
			}
			 String x = ", $" + coin;
			 s += x;
		 }
		 s += ". $" + sum + " in total.";
	  }
	  return s;
  }
}