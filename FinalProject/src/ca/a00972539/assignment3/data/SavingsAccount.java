package ca.a00972539.assignment3.data;

/**
 * SavingsAccount data class
 * 
 * @author Timoteo Shockness
 * @version 2.0
 */
public class SavingsAccount extends Account {	
	
	public static final double MIN_AMOUNT = 100.0;
	
	/**
	 * Default constructor
	 */
	public SavingsAccount() {
		super();
		subtract = new SubtractSavings();
	}

	/**
	 * Overloaded constructor
	 * 
	 * @param balance
	 *            the balance to set
	 * @param accountNumber
	 *            the account number to set
	 */
	public SavingsAccount(double balance, String accountNumber) {
		super(balance, accountNumber);
		subtract = new SubtractSavings();
	}
		

	/**
	 * @return the minAmount constant as a double
	 */
	public static double getMinAmount() {
		
		return MIN_AMOUNT;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SavingsAccount [toString()=" + super.toString() + "]";
	}

	
}
