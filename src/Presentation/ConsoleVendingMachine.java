package Presentation;

public class ConsoleVendingMachine implements VendingMachineInterface {
	SellDrinkUI sellDrink = new SellDrinkUI();
	RechargeDrinkUI rechargeDrink = new RechargeDrinkUI();
	DefineDrinkUI defineDrinkAndPrice = new DefineDrinkUI();
	MonitorSalesUI monitorSales = new MonitorSalesUI(); // Not yet implemented
	LoginUI login = new LoginUI(); // Not yet implemented
	
	@Override
	public void sellDrink() {
		sellDrink.start();
		
	}

	@Override
	public void rechargeDrink() {
		rechargeDrink.start();
	}

	@Override
	public void defineDrinkAndPrice() {
		defineDrinkAndPrice.start();
		
	}

	@Override
	public void monitorSales() {
		monitorSales.start();
		
	}
	
	@Override
	public boolean login(String privilege) {
		login.setPrivilege(privilege);
		login.start();
		return login.isLoggedIn();
	}
	
	public static void main(String... args) {
		VendingMachineInterface vendingMachine = new ConsoleVendingMachine();
		boolean loggedIn;
		int action;
		
		while (true) {
			System.out.println("1. Buy Drinks");
			System.out.println("2. Recharge Drinks");
			System.out.println("3. Set Drink and Price");
			System.out.println("4. Monitor Sales");
			System.out.println("5. Switch Off Machine");
			
			loggedIn = false;
			action = ConsoleInput.askInt("your choice");
			switch(action) {
			case 1: vendingMachine.sellDrink();
					break;
			
			case 2: loggedIn = vendingMachine.login("recharge drink");
					if (loggedIn)
						vendingMachine.rechargeDrink();
					break;
					
			case 3: loggedIn = vendingMachine.login("define drink and price");
					if (loggedIn)
						vendingMachine.defineDrinkAndPrice();
					break;
					
			case 4: loggedIn = vendingMachine.login("monitor sales");
					if (loggedIn)
						vendingMachine.monitorSales();
					break;
			
			case 5: loggedIn = vendingMachine.login("switch off machine");
					if (loggedIn)
						return;
			
			default:;
			}
		}
	}
}
