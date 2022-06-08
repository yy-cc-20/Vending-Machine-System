package BusinessLogic;

import Domain.SmartCard;

public class SellDrinkController extends SuperController {	
	private SmartCard smartCard;
	private int quantityPurchased;
	private double payment;
	
	public boolean setSmartCard(int smartCardId) {
		smartCard = dataStore.getSmartCardById(smartCardId);
		return smartCard != null;
	}
	
	private double calculatePayment() {
		return quantityPurchased * drink.getPrice();
	}
	
	private boolean canProceed() {
		return drink.isSufficient(quantityPurchased) && smartCard.isSufficient(payment);
	}
	
	/** @return negative if the transaction is failed, negative if completed */
	public double processPayment(int quantityPurchased) {	
		if (quantityPurchased < 0)
			
		this.quantityPurchased = quantityPurchased;
		payment = calculatePayment();
		
		if (canProceed()) {
			smartCard.deductBalance(payment);
			drink.sell(quantityPurchased, payment);
			return smartCard.getBalance();
		} else
			return -1;			
	}

	public void distributeDrink() {
		// Code to let the machine distribute the drink...
	}
}
