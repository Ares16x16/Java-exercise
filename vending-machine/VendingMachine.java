import java.util.ArrayList;
import java.util.Collections;

public class VendingMachine {
  // ArrayList of Integers represents inserted coins in Coin Slot
  private ArrayList<Integer> insertedCoins;
	
  // ArrayList of Product represents inventories of products
  private ArrayList<Product> products;
  
  private ArrayList<Integer> changes;
  
  public VendingMachine() {
    insertedCoins = new ArrayList<Integer>();
    products = new ArrayList<Product>();
    changes = new ArrayList<Integer>();
  }

  public void addProduct(Product p) {
    products.add(p);
  }
	
  public void insertCoin(Integer c) {
    insertedCoins.add(c);
  }	
  public void addChanges(Integer c) {
	  changes.add(c);
  }	
  
  public void rejectCoin() {
	insertedCoins.remove(0);
  }
  public int getCoin() {
	if (insertedCoins.size() != 0) {
		return insertedCoins.get(0);
	}else {
		return 0;
	}
  }
  
  public int getSumOfCoin() {
	  int sum = 0;
	  if (insertedCoins.size() != 0) {
		  for(int i = 0; i < insertedCoins.size(); i++)
			  sum += insertedCoins.get(i);
	  }
	  return sum;
  }
  
  public void sortCoin() {
	  Collections.sort(insertedCoins);
  }
  
  public void sortChanges() {
	  Collections.sort(changes);
  }
  
  public int getChanges(int i) {
	return changes.get(i);  
  }
  public int getChangesSize() {
	  return changes.size();
  }
  
  public Product getProduct(Integer p) {
	  return products.get(p);
  }
  
  public int getQuan(int i) {
	  return products.get(i).getQuantity();
  }
  
  public void clearCoin() {
	  insertedCoins.clear();
  }
  
  public void clearChange() {
	  changes.clear();
  }

  public void reduceQuan(int i) {
	  products.get(i).reduceQuantity();
  }
  
}

