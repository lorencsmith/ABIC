import java.util.ArrayList;

/** A BankAccount is an account which includes all the variables
 *  and methods of which all accounts should have. It is the main account
 *  from which other types of account extends from.
 */
public class BankAccount {

    /**
     * The firstName is assumed to be comprised of only alphabetical characters.
     */
    private String firstName;
    /**
     * The lastName is assumed to be comprised of only alphabetical characters.
     */
    private String lastName;

    /**
     * The id is should be unique.
     */
    private int id;
    /**
     * The balance refers to the total balance of the current bank account.
     * Can be positive or negative.
     */
    private double balance;

    /**
     * The transactions list refers to all the transactions made by the account,
     * including buying and selling operations.
     */
    private ArrayList<Transaction> transactions;

    /** The deposit() operation assumes that the amount deposited
     *  is a non-negative number and is greater than 0.00. The operation
     *  also assumes that the account being deposited into exists.
     *  @pre idValid() = True
     *  @pre 0.00 < amount
     *  @post balance = balance + amount
     */
    public void deposit(int id, double amount){

    }

    /** The withdraw() operation assumes that the amount withdrawn
     *  is a non-negative number and is less than the amount in the
     *  account. The operation also assumes that the account being withdrawn
     *  from exists.
     *  @pre idValid() = True
     *  @pre 0.00 < amount
     *  @pre amount < balance
     *  @post balance = balance - amount
     */
    public void withdraw(int id, double amount){

    }

    /**
     * @return The current total balance in the account
     */
    public double getBalance() {
        return balance;
    }

    /** The transfer() operation assumes that the specified
     *  BankAccount exists, and that the user has sufficient funds
     *  to be transferred.
     *  @pre BankAccount acc exists
     *  @pre Balance of current account > amount
     *  @post acc.balance += amount
     *  @post this.balance -= amount
     */
    public void transfer(BankAccount acc, double amount) {

    }

    /** The viewTransactions() operation assumes that there are
     *  transactions to view.
     *  @pre number of Transactions > 0
     *  @post List of transactions
     */
    public void viewTransactions(ArrayList<Transaction> t) {

    }

}