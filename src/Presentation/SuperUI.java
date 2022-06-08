package Presentation;

import Domain.DataLists;
import Domain.DataStore;

public abstract class SuperUI {
	protected DataStore dataStore = DataLists.getInstance();
	
	public abstract void start();
	
	protected int chooseDrink() {
		dataStore.displayDrinkList();
		
		System.out.println("Select a drink. Enter -1 to cancel.");
		return ConsoleInput.askInt("drink id");
	}
}
