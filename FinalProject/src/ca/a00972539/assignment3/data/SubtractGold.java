package ca.a00972539.assignment3.data;

import java.util.Date;

import ca.a00972539.assignment3.interfaces.SubtractAction;

/**
 * Class responsible for hold the subtract algorithm for Gold accounts.
 * @author Timoteo Shockness
 * @version 1.0
 *
 */
public class SubtractGold implements SubtractAction {

	@Override
	public void subtractFromBalance(double amount, Account account) {
		if (account.getBalance() - amount >= GoldAccount.OVERDRAFT_AMT) {
			
			account.setBalance(account.getBalance() - amount);
			account.addTransaction(String.format("%s - withdrawal: $%.2f", new Date(), amount));

		}
		
	}

}
