package Presentation;

import BusinessLogic.SetUpMachineController;
import Domain.Drink;

public class DefineDrinkUI extends SuperUI {
	private SetUpMachineController controller = new SetUpMachineController();
	
	public void start() {
		int action;
		
		while (true) {
			System.out.println("1. Delete A Drink");
			System.out.println("2. Add A New Drink");
			System.out.println("3. Modify Price");
			System.out.println("4. Back to Main Menu");
			
			action = ConsoleInput.askInt("your choice");
			switch(action) {
			case 1: deleteDrink();
					break;
			
			case 2: addNewDrink();
					break;
					
			case 3: modifyPrice();
					break;
					
			case 4: return;
			
			default:;
			}
		}
	}
	
	private void deleteDrink() {
		int drinkId = chooseDrink();
		if (!controller.setDrink(drinkId)) {
			System.out.println("Unknown drink.");
			return;
		}
		dataStore.deleteDrink(drinkId);
	}
	
	private void addNewDrink() {
		// TODO get new drink info from console
		dataStore.addDrink(new Drink(2, 11, "Tea", 2, 0, 0));
	}
	
	private void modifyPrice() {
		int drinkId = chooseDrink();
		if (!controller.setDrink(drinkId)) {
			System.out.println("Unknown drink.");
			return;
		}
		double newPrice = ConsoleInput.askInt("new price");
		dataStore.getDrinkById(drinkId).setPrice(newPrice);
	}
}
