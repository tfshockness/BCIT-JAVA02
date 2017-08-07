package ca.a00972539.assignment3.data;

/**
 * GoldAccount data class
 * 
 * @author Timoteo Shockness
 * @version 2.0
 */
public class GoldAccount extends Account {

	private boolean overdraft;

	public static final double INTEREST_RATE = 0.025;
	public static final double FEE = 10.0;
	public static final double OVERDRAFT_AMT = -5000.0;

	/**
	 * Default constructor
	 */
	public GoldAccount() {
		super();
		subtract = new SubtractGold();
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
	public GoldAccount(double balance, String accountNumber) {
		super(balance, accountNumber);
		subtract = new SubtractGold();
		overdraft = false;
	}

	/**
	 * 
	 * @return the interestRate as double
	 */
	public double getInterestRate() {

		return INTEREST_RATE;
	}

	/**
	 * 
	 * @return the inOverdraft as boolean
	 */
	public boolean isOverdraft() {

		return overdraft;
	}

	/**
	 * 
	 * @param inOverdraft
	 *            the inOverdraft to set
	 */
	public void setOverdraft(boolean overdraft) {

		this.overdraft = overdraft;
	}
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GoldAccount [interestRate=" + INTEREST_RATE + ", overdraft=" + overdraft + ", toString()="
				+ super.toString() + "]";
	}

}
