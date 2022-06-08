package Presentation;

import BusinessLogic.RechargeMachineController;

public class RechargeDrinkUI extends SuperUI {
	private RechargeMachineController controller = new RechargeMachineController();
	
	public void start() {
		int drinkId = chooseDrink();
		if (!controller.setDrink(drinkId)) {
			System.out.println("Unknown drink.");
			return;
		}
		
		addDrink();
	}
	
	private void addDrink() {
		int addedQuantity = ConsoleInput.askInt("added quantity");
		if (addedQuantity > 0)
			controller.addDrink(addedQuantity);
		else
			System.out.println("Failed to recharge.");
	}
}
