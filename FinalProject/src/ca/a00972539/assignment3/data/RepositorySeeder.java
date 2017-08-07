package ca.a00972539.assignment3.data;

import ca.a00972539.assignment3.db.Bank;

/**
 * Class RepositorySeeder - Seeds the List for testing.
 * @author Timoteo Shockness
 * @version 1.0
 *
 */
public class RepositorySeeder {

	private  AccountFactory factory;
	private  BankCustomer customer;
	
	/**
	 * Default constructor
	 * instantiate the AccountFactory.
	 */
	public RepositorySeeder() {
		this.factory = new AccountFactory();
	}
	
	/**
	 * Method to seed the list.
	 * @param Bank theBank - Where is stored the list of customer.
	 */
	public void seed(Bank theBank) {

		customer = new BankCustomer("Timoteo", "Shockness", "123", 28);
		customer.setAccount(factory.createAccount(customer));
		theBank.createAccount(customer);
		
		customer = new BankCustomer("Nicolly", "Shockness", "123", 13);
		customer.setAccount(factory.createAccount(customer));
		theBank.createAccount(customer);
		
		customer = new BankCustomer("Alcina", "Farias", "123", 70);
		customer.setAccount(factory.createAccount(customer));
		theBank.createAccount(customer);
		
		customer = new BankCustomer("Admin", "adm", "admin", 0);
		customer.setAccount(factory.createAccount(customer));
		theBank.createAccount(customer);
		
		
		
		
	}
}
