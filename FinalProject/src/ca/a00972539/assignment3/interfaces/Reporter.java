package ca.a00972539.assignment3.interfaces;
import java.util.HashMap;

import ca.a00972539.assignment3.data.BankCustomer;

/**
 * 
 */

/**
 * @author Timoteo Shockness
 * @version 1.0
 *
 */
public interface Reporter {

	void displayByCode(HashMap<String, BankCustomer> records, String prefix);
	
	void displayAllCodes(HashMap<String, BankCustomer> records);
	
	void displayInactiveCodes(HashMap<String, BankCustomer> records);
}
