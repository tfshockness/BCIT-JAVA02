package ca.a00972539.assignment3.data;

/**
 * Class to serve as factory for the Accounts.
 * @author Timoteo Shockness
 * @version 1.0
 *
 */
public class AccountFactory {

	private static int countGold = 1;
	private static int countSavings = 1;
	private static int countChequing = 1;
	
	/**
	 * It creates an account based in the customer's age.
	 * 
	 * @param BankCustomer customer
	 * @return Account account
	 */
	public Account createAccount(BankCustomer customer) {
		
		Account account = null;
		
		if(customer.getAge() >= 65) {
			account =  new GoldAccount(0.0, "GL-" + countGold);
			countGold++;
			
		} else if(customer.getAge() == 0) {
			account = new SavingsAccount(0.0, "admin");
			
		} else if(customer.getAge() < 18 ) {
			account = new SavingsAccount(0.0, "SV-" + countSavings);
			countSavings++;
			
		}  else if(customer.getAge() >= 18) {
			account = new ChequingAccount(0.0, "CH-"+ countChequing);
			countChequing++;
			
		}
		
		return account;
	}
}
