package BusinessLogic;

import Domain.DataLists;
import Domain.DataStore;
import Domain.Drink;

public class SuperController {
	protected static DataStore dataStore = DataLists.getInstance();
	protected Drink drink;
	
	public boolean setDrink(int drinkId) {
		drink = dataStore.getDrinkById(drinkId);
		return drink != null;
	}
}
