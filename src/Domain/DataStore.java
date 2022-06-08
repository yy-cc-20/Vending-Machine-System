package Domain;

import java.util.List;

public interface DataStore {
	// Drink
	List<Drink> getDrinkList();
	Drink getDrinkById(int id);
	void displayDrinkList();
	void updateQuantity(Drink drink);
	void addDrink(Drink drink);
	void deleteDrink(int drinkId);
	
	// Smart Card
	List<SmartCard> getSmartCardList();
	SmartCard getSmartCardById(int id);
	void updateBalance(SmartCard smartCard);
}
