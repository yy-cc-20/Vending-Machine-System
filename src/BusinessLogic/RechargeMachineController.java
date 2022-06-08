package BusinessLogic;

public class RechargeMachineController extends SuperController {
	public void addDrink(int addedQuantity) {
		// Code to let the machine open the depository to be recharged...
		drink.recharge(addedQuantity);
	}
}
