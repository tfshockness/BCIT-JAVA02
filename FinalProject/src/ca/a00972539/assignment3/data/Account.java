package ca.a00972539.assignment3.data;
import java.util.ArrayList;
import java.util.Date;

import ca.a00972539.assignment3.interfaces.SubtractAction;

/**
 * Abstract Class.
 * 
 * @author Timoteo Shockness
 * @version 2.0
 */
public abstract class Account {
	
	private double balance;
	private String accountNumber;
	private boolean active;
	private ArrayList<String> accountRecords;
	
	protected SubtractAction subtract;

	/**
	 * Default constructor
	 */
	public Account() {
	}

	/**
	 * Overloaded constructor
	 * 
	 * @param double balance
	 * @param String accountNumber
	 *            
	 *            
	 */
	public Account(double balance, String accountNumber) {
		setBalance(balance);
		setAccountNumber(accountNumber);
		active = true;
		accountRecords = new ArrayList<String>();
	}

	/**
	 * 
	 * @return double balance
	 */
	public double getBalance() {

		return balance;
	}

	/**
	 * 
	 * @param double balance - sets balance
	 *            
	 */
	public void setBalance(double balance) {

		if (balance >= 0) {
			this.balance = balance;
		}
	}

	/**
	 * 
	 * @return String accountNumber
	 */
	public String getAccountNumber() {

		return accountNumber;
	}

	/**
	 * 
	 * @param String accountNumber
	 *            
	 */
	public void setAccountNumber(String accountNumber) {

		if (accountNumber != null && !accountNumber.isEmpty()) {
			this.accountNumber = accountNumber;
		}
	}

	/**
	 * 
	 * @return boolean active
	 */
	public boolean isActive() {

		return active;
	}

	/**
	 * 
	 * @param boolean active
	 *            
	 */
	public void setActive(boolean active) {

		this.active = active;
	}



	/**
	 * @return the accountRecords
	 */
	public ArrayList<String> getAccountRecords() {
		return accountRecords;
	}

	/**
	 * @param accountRecords the accountRecords to set
	 */
	public void setAccountRecords(ArrayList<String> accountRecords) {
		this.accountRecords = accountRecords;
	}

	
	
	/**
	 * Displays the transaction information.
	 */
	public void displayAccountRecords() {

		System.out.println("Acount Activity: ");

		for (String info : accountRecords) {
			System.out.println(info);
		}

	}

	/**
	 * 
	 * @param amount
	 *            the amount to add to the existing field
	 */
	public void addToBalance(double amount) {

		if (amount > 0.0) {
			balance += amount;
			addTransaction(String.format("%s - deposit: $%.2f", new Date(), amount));
		}
	}
	
	/**
	 * Add information of the transaction to Array
	 * @param String transactionInfo - Info about the transaction
	 * @return void
	 */
	public void addTransaction(String transactionInfo){
		if (this.getAccountNumber() != null && !this.getAccountNumber().isEmpty()) {
			getAccountRecords().add(transactionInfo);
		}

	}
	
	/**
	 * Abstract Method
	 * @param amount
	 *            the amount to subtract from the balance
	 */
	public void subtractFromBalance(double amount) {
		subtract.subtractFromBalance(amount, this);
	}

	

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account [balance=" + balance + ", accountNumber="
				+ accountNumber + ", active=" + active + "]";
	}

}