/**
 * The SavingsAccount is a type of BankAccount which has the
 * following properties: the account accrues interest over time
 * and the number of withdrawals per month is limited.
 */
public class SavingsAccount extends BankAccount {

    /**
     * The interestRate should fall between 0.01% to 0.09%
     */
    /**
     * The numOfMonthlyWithdrawals should never exceed the
     * maximum number of withdraws;
     */
    
    private double interestRate = .05;
    /**
    *Saving account will have fixed interest rate of .05% and will be
    *paid to the account every month.
    */
    private int numOfMonthlyWithdrawals;

    /**
     * The maximum number of monthly withdrawals is 5 and should never change.
     */
    private final int MAX_NUBMER_OF_MONTHLY_WITHDRAWLS = 5;
    /**
     * The addInterest() operation assumes that the balance and the interestRate
     * is non-negative. The operation adds interest to the current balance monthly.
     * @pre balance > 0.00
     * @pre interestRate > 0.00
     * @post balance = balance * interestRate
     */
    public  double addInterest(double balance, double interestRate) {
        double paidInterest = (balance * interestRate);
        return paidInterest;
    }
    
    /** 
     *The newBalance() operation adds the interest paid to the 
     *account to the current balance and returns the final balance.
     *@post balance = balance + paidInterest
     */
    
<<<<<<< HEAD:src/SavingsAccount.java
    public double newBalance(double balance){
        double finalBalance = (balance+addInterest(balance ,interestRate));
=======
    public double newBalance(double balance, double paidInterest){
        double finalBalance = (balance + paidInterest);
>>>>>>> 4a222c52ca86e52f721725bf760cf4e7e377ba05:interfaces/SavingsAccount.java
        return finalBalance;
    }

}
