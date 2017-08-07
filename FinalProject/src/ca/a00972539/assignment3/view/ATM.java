package ca.a00972539.assignment3.view;
import ca.a00972539.assignment3.data.Account;
import ca.a00972539.assignment3.data.BankCustomer;
import ca.a00972539.assignment3.data.BankReport;
import ca.a00972539.assignment3.data.RepositorySeeder;
import ca.a00972539.assignment3.db.Bank;
import ca.a00972539.assignment3.util.InputReader;

/**
 * ATM class, The COMP 1451 Assignment application driver
 */

/**
 * @author Timoteo Shockness
 * @version 2.0
 *
 */
public class ATM {
	private InputReader reader;
	private String accountNumber;
	private String passcode;
	private boolean customerVerified; //false

	private Bank theBank;
	private BankCustomer currentCustomer;
	private Account currentAccount;
	private RepositorySeeder seeder;


	/**
	 * Default constructor. Calls the initialize() method to seed the Bank with
	 * some BankCustomers. Calls the run() method to perform the primary program
	 * functions.
	 */
	public ATM() {
		theBank = new Bank();
		seeder = new RepositorySeeder();
		reader = new InputReader();
		initialize();
		run();
	}

	/**
	 * Main method calls the class default constructor.
	 * 
	 * @param args
	 *            for program arguments (not used)
	 */
	public static void main(String[] args) {
		new ATM();

	}

	/**
	 * Adds Customer references to the Bank HashMap as seed data for testing.
	 */
	public void initialize() {

		seeder.seed(theBank);

	}
	
	/**
	 * The primary application processor. All application functions are called
	 * from here. Starts by seeding the Bank class HashMap with BankCustomers,
	 * and display a menu of choices. Uses a loop to prompt users to perform
	 * banking transactions. Must use switch/case selection to determine uses
	 * choices.
	 */
	public void run() {
		
		boolean exit = false;
		System.out.println("Welcome to Bullwinkle's Bank.");

		while (!exit) {
			System.out.println("");
			System.out.println("Choose one of the following options:");
			System.out.println("1 - Sign In");
			
			if(customerVerified){
				if(currentAccount.getAccountNumber() == "admin"){
					adminMenu();
				}else{
					userMenu();
				}
				
			}else{
				userMenu();
			}
			
			System.out.print("> ");
			int choice = reader.getIntInput();

			if(customerVerified){
				if(currentAccount.getAccountNumber() == "admin"){
					adminSwitch(choice);
				}else{
					userSwitch(choice);
				}
			}else{
				userSwitch(choice);
			}
			
		}
	}


	/**
	 * Performs a deposit into a BankCustomer's account. Checks to see if the
	 * user has signed in. If not, then verifyCustomer() is called and the menu
	 * is displayed again.
	 */
	public void transactDeposit() {

		if (customerVerified) {
			System.out.println("Enter the amount to deposit: ");
			double amount = reader.getDoubleInput();
			currentCustomer.getAccount().addToBalance(amount);
			

		} else {

			System.out.println("ERROR: You must LOGIN before you can perform a transaction.");
			verifyCustomer();
		}
	}

	/**
	 * Performs a withdrawal from a BankCustomer's account. Checks to see if the
	 * user has signed in. If not, then verifyCustomer() is called and the menu
	 * is displayed again.
	 */
	public void transactWithdraw() {

		if (customerVerified) {
			System.out.println("Enter the amount to withdraw: ");
			double amount = reader.getDoubleInput();

			currentCustomer.getAccount().subtractFromBalance(amount);
		
		} else {

			System.out.println("ERROR: You must LOGIN before you can perform a transaction.");
			verifyCustomer();
		}

	}

	/**
	 * Performs a withdrawal from a BankCustomer's account. Checks to see if the
	 * user has signed in. If not, then verifyCustomer() is called and the menu
	 * is displayed again.
	 */
	public void displayAccountInformation() {

		if (customerVerified) {
			System.out.println("Here is your information.");
			Bank.displayCustomerInformation(currentCustomer);
		} else {

			System.out.println("ERROR: You must LOGIN before you can perform a transaction.");
			verifyCustomer();
		}

	}

	/**
	 * To confirm a BankCustomer's account number and passcode. Called when the
	 * user is required to sign in to the application. Will set a boolean so the
	 * user does not have to sign in again during the session.
	 */
	public void verifyCustomer() {

		System.out.println("Enter Account Number: ");
		accountNumber = reader.getStringInput();
		System.out.println("Enter Passcode: ");
		passcode = reader.getStringInput();
		//Retrieve the customer from the Array
		currentCustomer = Bank.theBank.get(accountNumber);



		if (currentCustomer != null) {
			//Get the Account from the current customer
			currentAccount = currentCustomer.getAccount();
			if (passcode.equals(currentCustomer.getPasscode())) {

				customerVerified = true;
			} else {
				System.out.println("ERROR: Either account number or passcode is not correct.");
				run();
			}

		} else {
			System.out.println("ERROR: Either account number or passcode is not correct.");
			run();
		}

	}

	/**
	 * Displays the final information for the current account along with the
	 * account transaction history. Then displays all the account data for all
	 * bank customer and terminates the program run.
	 */
	public void shutDown() {

		System.out.println("Thank you for banking at Bullwinkle's Bank");

		
		if(currentAccount != null) {
			System.out.println("ACCOUNT SUMMARY:");
			Bank.displayCustomerInformation(currentCustomer);
			currentAccount.displayAccountRecords();
		}
		

		System.out.println("");

		System.out.println("Displaying all the accounts in the bank.");
		Bank.displayAllCustomers();
		System.exit(0);
	}
	
	
	
	
	
	/**
	 * Help method to display admin Menu when admin login
	 */
	private void adminMenu(){
		System.out.println("2 - Display all Accounts by Code");
		System.out.println("3 - Display all Accounts");
		System.out.println("4 - Display Inactive Accounts");
		System.out.println("5 - Display Total of Money in the Bank");
		System.out.println("6 - Exit");
	}
	
	/**
	 * Helo method to display user menu when a User account login in
	 */
	private void userMenu(){
		System.out.println("2 - Deposit");
		System.out.println("3 - Withdraw");
		System.out.println("4 - Display Account Info");
		System.out.println("5 - Exit");
	}
	/**
	 * Helper method for the Admin Login. 
	 * @param int opt - Option for the switch.
	 */
	private void adminSwitch(int opt){
		BankReport br = new BankReport();
		switch (opt) {
		case 1:
			verifyCustomer();
			break;
		case 2:
			System.out.print("Type the prefix: ");
			System.out.print("> ");
			String prefix = reader.getStringInput();
			br.displayByCode(Bank.theBank, prefix);
			break;
		case 3:
			br.displayAllCodes(Bank.theBank);
			break;
		case 4:
			br.displayInactiveCodes(Bank.theBank);
			break;
		case 5:
			br.dislayAccountTotals(Bank.theBank);
			break;
		case 6:
			shutDown();
			break;
		default:
			System.out.println("??????");
			System.exit(0);
		}
	}
	
	
	/**
	 * Helper method for the User Login. 
	 * @param int opt - Option for the switch.
	 */
	private void userSwitch(int opt){
		switch (opt) {
		case 1:
			verifyCustomer();
			break;
		case 2:
			transactDeposit();
			break;
		case 3:
			transactWithdraw();
			break;
		case 4:
			displayAccountInformation();
			break;
		case 5:
			shutDown();
		default:
			System.out.println("??????");
			System.exit(0);
		}
	}
}
