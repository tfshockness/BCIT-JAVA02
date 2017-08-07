package ca.a00972539.assignment3.data;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import ca.a00972539.assignment3.interfaces.Reporter;

/**
 * @author Timoteo Shockness
 * @version 2.0
 *
 */
public class BankReport implements Reporter {

	/**
	 * Default Constructor
	 */
	public BankReport() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see Reporter#displayByCode(java.util.HashMap, java.lang.String)
	 * Override Method from interface
	 * @param HashMap records - receive a hashMap with the data
	 * @param String prefix - the prefix to be displayed
	 */
	@Override
	public void displayByCode(HashMap<String, BankCustomer> records, String prefix) {
		// TODO Auto-generated method stub
		for(BankCustomer c : records.values()){
			String[] split = c.getAccount().getAccountNumber().split("-");

			if(split[0].equals(prefix)){
				System.out.println(c.getAccount().getAccountNumber());
			}
		}

	}

	/* (non-Javadoc)
	 * @see Reporter#displayAllCodes(java.util.HashMap)
	 * @param HashMap records - receive a hashMap with the data
	 */
	@Override
	public void displayAllCodes(HashMap<String, BankCustomer> records) {
		
		ArrayList<String> acc = new ArrayList<String>();
		for(BankCustomer c : records.values()){
			if(c.getAccount().isActive() == true ){
				acc.add(c.getAccount().getAccountNumber());
			}
		}
		
		Collections.sort(acc);
		
		for(String s : acc){
			System.out.println(s);
		}
		
	}

	/* (non-Javadoc)
	 * @see Reporter#displayInactiveCodes(java.util.HashMap)
	 * @param HashMap records - receive a hashMap with the data
	 */
	@Override
	public void displayInactiveCodes(HashMap<String, BankCustomer> records) {
		ArrayList<String> acc = new ArrayList<String>();
		for(BankCustomer c : records.values()){
			if(c.getAccount().isActive() == false ){
				acc.add(c.getAccount().getAccountNumber());
			}
		}
		
		Comparator cmp = Collections.reverseOrder();
		Collections.sort(acc, cmp);
		
		for(String s : acc){
			System.out.println(s);
		}

	}
	
	/**
	 * MEthod to display the Sum of all acounts and display in Dollars.
	 * @param HashMap records - receive a hashMap with the data
	 */
	public void dislayAccountTotals(HashMap<String, BankCustomer> records){
		double total = 0;
		for(BankCustomer c : records.values()){
			total += c.getAccount().getBalance();
		}
		System.out.println("$ " + total);
	}
	
}
