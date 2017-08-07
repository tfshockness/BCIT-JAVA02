package ca.a00972539.assignment3.data;

import java.util.Date;

import ca.a00972539.assignment3.interfaces.SubtractAction;

/**
 * Class responsible for hold the subtract algorithm for Chequing accounts.
 * @author Timoteo Shockness
 * @version 1.0
 *
 */
public class SubtractChequing implements SubtractAction {

	@Override
	public void subtractFromBalance(double amount, Account account) {
		
			if (account.getBalance() - amount >= ChequingAccount.MIN_AMOUNT) {
			
			account.setBalance(account.getBalance() - amount);
			account.addTransaction(String.format("%s - withdrawal: $%.2f", new Date(), amount));
			
			//I dont have idea how I could solve this problem here. The only solution that I found is casting
			//However, seems not correct to me.
			
			ChequingAccount acc = (ChequingAccount) account;
			acc.addACheque();
			acc.setTotalFees(acc.getNumberOfCheques() * ChequingAccount.FEE);

		}
		
	}

}
