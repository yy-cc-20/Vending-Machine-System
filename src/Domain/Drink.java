package Domain;

public class Drink {
	private static DataStore dataStore = DataLists.getInstance();
	private double totalRevenue;
	private int soldQuantity;
	
	private int id;
	private double price;
	private String description;
	private int availableQuantity;
	
	public Drink(int id, double price, String description, int quantity, double totalRevenue, int soldQuantity) {
		this.id = id;
		setPrice(price);
		this.description = description;
		this.availableQuantity = quantity;
		
		this.totalRevenue = totalRevenue;
		this.soldQuantity = soldQuantity;
	}
	
	public int getId() {
		return id;
	}
	
	public void setPrice(double price) {
		if (price >= 0) {
			this.price = price;
			dataStore.updateQuantity(this);
		} else
			throw new IllegalArgumentException("Price cannot be negative");
	}

	public double getPrice() {
		return price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getQuantity() {
		return availableQuantity;
	}
	
	public boolean isSufficient(int quantityPurchased) {
		if (quantityPurchased < 0)
			throw new IllegalArgumentException("Quantity purchased cannot be negative.");
		return availableQuantity - quantityPurchased >= 0;
	}
	
	public void sell(int quantity, double payment) {
		if (quantity < 0)
			throw new IllegalArgumentException("Quantity sold cannot be negative.");
		if (payment < 0)
			throw new IllegalArgumentException("Payment cannot be negative.");
		
		if (isSufficient(quantity)) {
			totalRevenue += payment;
			availableQuantity -= quantity;
			soldQuantity += quantity;
			dataStore.updateQuantity(this);
		}
		else
			throw new IllegalArgumentException("No enough " + description);
	}
	
	public void recharge(int quantity) {
		if (quantity < 0)
			throw new IllegalArgumentException("Added quantity cannot be negative.");
		
		this.availableQuantity += quantity;
		dataStore.updateQuantity(this);
	}
	
	public double getTotalRevenue() {
		return totalRevenue;
	}
	
	public int getSoldQuantity() {
		return soldQuantity;
	}
}
