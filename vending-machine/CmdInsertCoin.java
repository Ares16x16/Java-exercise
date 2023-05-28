public class CmdInsertCoin implements Command {

  @Override
  public String execute(VendingMachine v, String cmdPart) {
    Integer c = Integer.valueOf(cmdPart);
    // Add the coin to Coin Slot
    v.insertCoin(c);
    String s = "Inserted a $" + c + " coin. $" + v.getSumOfCoin() + " in total.";
    return s;
  }
}