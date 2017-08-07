package ca.a00972539.assignment3.data;

/**
 * ChequingAccount data class
 * 
 * @author Timoteo Shockness
 * @version 2.0
 */
public class ChequingAccount extends Account {
	
	public static final double FEE = 0.25;
	public static final double MIN_AMOUNT = 0.0;
	private int numberOfCheques;
	private double totalFees;

	/**
	 * Default constructor
	 */
	public ChequingAccount() {
		super();
		subtract = new SubtractChequing();
	}

	/**
	 * Overloaded constructor
	 * 
	 * @param balance
	 *            the balance to set
	 * @param accountNumber
	 *            the account number to set
	 *            
	 */
	public ChequingAccount(double balance, String accountNumber) {

		super(balance, accountNumber);
		subtract = new SubtractChequing();
		numberOfCheques = 0;
	}

	/**
	 * 
	 * @return the numberOfCheques as int
	 */
	public int getNumberOfCheques() {

		return numberOfCheques;
	}

	/**
	 * 
	 * @param numberOfCheques
	 *            the numberOfCheques to set
	 */
	public void setNumberOfCheques(int numberOfCheques) {

		if (numberOfCheques > 0) {
			this.numberOfCheques = numberOfCheques;
		}
	}
	
	/**
	 * Adds 1 to the number of cheques whenever there is a withdrawal 
	 * from a ChequingAccount
	 */
	public void addACheque(){
		
		numberOfCheques ++;
	}
		
	
	public void setTotalFees(double totalFees){
		this.totalFees = totalFees;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ChequingAccount [numberOfCheques=" + numberOfCheques + ", totalFees=" + totalFees + ", toString()="
				+ super.toString() + "]";
	}

	

}
