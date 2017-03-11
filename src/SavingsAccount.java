/**
 * The SavingsAccount is a type of BankAccount which has the
 * following properties: the account accrues interest over time
 * and the number of withdrawals per month is limited.
 */
public class SavingsAccount extends BankAccount {

    /**
     * The interestRate should fall between 0.01% to 0.09%
     */
    private double interestRate;

    /**
     * The numOfMonthlyWithdrawals should never exceed the
     * maximum number of withdraws;
     */
    private int numOfMonthlyWithdrawals;

    /**
     * The maximum number of monthly withdrawals is 5 and should never change.
     */
    private final int MAX_NUBMER_OF_MONTHLY_WITHDRAWLS = 5;
    /**
     * The addInterest() operation assumes that the balance and the interestRate
     * is non-negative. The operation adds interest to the current balance yearly.
     * @pre balance > 0.00
     * @pre interestRate > 0.00
     * @post balance = balance + balance * interestRate
     */
    public double addInterest(double balance, double interestRate) {...}

    /**
     * The canWithdraw() operation checks to see if the user has gone over
     * their number of monthly withdrawals.
     * @post The result of numOfMonthlyWithdrawals < MAX_NUMBER_OF_MONTHLY_WITHDRAWALS:
     */
    public boolean canWithdraw() {...}

}
