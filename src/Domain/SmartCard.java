package Domain;

public class SmartCard {
	private static DataStore dataStore = DataLists.getInstance();
	
	private int id;
	private double balance;
	
	public SmartCard(int id, double balance) {
		this.id = id;
		this.balance = balance;
	}
	
	public int getId() {
		return id;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public boolean isSufficient(double payment) {
		return balance - payment > 0;
	}
	
	public void deductBalance(double payment) {
		if (isSufficient(payment)) {
			balance -= payment;
			dataStore.updateBalance(this);
		}
		else 
			throw new IllegalArgumentException("No enough balance.");
	}
}
