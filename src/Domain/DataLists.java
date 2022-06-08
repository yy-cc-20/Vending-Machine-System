package Domain;

import java.util.ArrayList;
import java.util.List;

//The password for maintenance employee and admin are stored in a txt file
//The information of drinks and smart card is stored in mysql database via JDBC

public class DataLists implements DataStore {
	private static final DataStore instance = new DataLists();
	
	private List<Drink> drinkList;
	
	public static DataStore getInstance() {
		return instance;			
	}
	
	public void loadDrinkList() {
		// TODO read from database
		drinkList  = new ArrayList<>();
		drinkList.add(new Drink(1, 10, "Coffee", 1, 0, 0));
		drinkList.add(new Drink(2, 11, "Tea", 2, 0, 0));
		drinkList.add(new Drink(3, 12, "Mineral Water", 3, 0, 0));
		drinkList.add(new Drink(4, 13, "Carbonated Drink", 4, 0, 0));		
	}
	
	public List<Drink> getDrinkList() {
		if (drinkList == null)
			loadDrinkList();
		return drinkList;
	}
	
	public Drink getDrinkById(int id) {
		for (Drink d : drinkList) {
			if (d.getId() == id)
				return d;
		}
		return null;
	}
	
	public void displayDrinkList() {
		// TODO
	}
	
	public void addDrink(Drink drink) {
		// TODO update database
		drinkList.add(drink);
	}
	
	public void deleteDrink(int drinkId) {
		// TODO update database
	}
	
	public void loadSmartCardList() {
		// TODO
	}
	
	public List<SmartCard> getSmartCardList() {
		// TODO
	}
	
	public SmartCard getSmartCardById(int id) {
		// TODO
	}
	
	public void updateQuantity(Drink drink) {
		// TODO update database
	}
	
	public void updateBalance(SmartCard smartCard) {
		// TODO update database
	}
}
