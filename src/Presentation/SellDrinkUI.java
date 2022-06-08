package Presentation;

import BusinessLogic.SellDrinkController;

public class SellDrinkUI extends SuperUI {
	private SellDrinkController	controller = new SellDrinkController();
	
	// Buy 1 type of drink at a time
	public void start() {
		int cardId = readCard();
		if (cardId == -1)
			return;
		
		int drinkId = chooseDrink();
		if (!controller.setDrink(drinkId)) {
			System.out.println("Unknown drink.");
			return;
		}
		
		int quantityPurchased = selectQuantity();
		if (quantityPurchased <= 0)
			return;
		
		boolean paymentCompleted = processPayment(quantityPurchased);
		if (paymentCompleted)
			distributeDrink();
	}
	
	private int readCard() {
		int cardId = ConsoleInput.askInt("card number");
		
		if (controller.setSmartCard(cardId)) {
			return cardId;
		} else {
			System.out.println("Unknown card.");
			return -1;
		}
	}

	private int selectQuantity() {
		return ConsoleInput.askInt("quantity to purchase");
	}

	private boolean processPayment(int quantityPurchased) {
		double remainingBalance = controller.processPayment(quantityPurchased);
		
		if (remainingBalance >= 0) {
			System.out.printf("Remaining balance: %.2f$n", remainingBalance);
			return true;
		} else	{
			System.out.println("No enough balance.");
			return false;
		}
	}
	
	private void distributeDrink() {
		controller.distributeDrink();
		System.out.println("Please collect your drink(s).");
	}
}
