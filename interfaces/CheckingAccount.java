/**
 * The SavingsAccount is a type of BankAccount which has the
 * following properties: The account must have more or minimum balance
 * at all times
 */

public class CheckingAccount extends BankAccount {
    
    CheckingAccount(int id, double balance){
        super(id);
        this.setBalance(balance);
    }

    System.out.println(id);
    System.out.println(balance);

    /**
     * Since checking account don't balance to go negative,
     * if balance - withdraw is < 0, it will set isOverdrafted to true and stop the transaction
     * @pre 0.00 < balance
     * @pre 0.00 < withdraw
     * @post isOverdrafted = true | false
     */
    private boolean isOverdrafted;

    if((balance - withdraw) < 0) {
        isOverdrafted = true;
    }

}
