package Presentation;

public interface VendingMachineInterface {
	void sellDrink();
	void rechargeDrink();
	void defineDrinkAndPrice();
	void monitorSales();
	boolean login(String privilege);
}
