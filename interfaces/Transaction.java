import java.util.HashMap;

/** The Transaction class holds a record of each transaction, including
 *  the following elements. The items in the transaction with their
 *  respective prices, the total amount of the transaction, what category
 *  the transaction falls into, as well as the date the time of the transaction.
 */
public class Transaction {
    
    

    /**
     * The date is formatted as follows MM/DD/YYYY
     */
    private String date;
    
    /**
     * The timeStamp is formatted as follows XX:XX:XX AM/PM
     */
    private String timeStamp;
    
    /**
     * The totalAmount is positive at all times.
     * @invariant totalAmount > 0
     */
    private double totalAmount;
    
    /** 
     * The transAmount is the amount involved in a transaction involving
     * the account.
     * update:3/28/17: added transAmount
     */
    private double transAmount;
    
    /**
     * The category is the category of the majority of items
     * in the transaction.
     */
    private String category;

    /**
     * The transactionRecord HashMap maps items in the transaction
     * with their respective prices.
     */
    private HashMap<String, Float> transactionRecord;

    /**
     * Transaction class constructor.
     *
     */
    Transaction(String currentDate, String time, double transValue, double amountAvail){
        this.date = currentDate;
        this.timeStamp = time;
        this.transAmount = transValue;
        this.totalAmount = amountAvail;
    }
    
    /**
     * @return The date of the transaction
     */
    private String getDate() {
        return date;
    }
    
    
    /**
     * @return The date of the transaction
     * update:3/28/17: added method to set date
     */
    private String setDate(String newDate) {
    	date = newDate;
        return date;
    }
    /**
     * @return The time of the transaction
     */
    private String getTimeStamp() {
        return timeStamp;
    }

    /**
     * @return The total amount available in the account
     */
    private double getTotalAmount() {
        return totalAmount;
    }
    /**
     * @return The total amount of the transaction
     * update: 3/28/17: added getTransAmount() method 
     */    
    private double getTransAmount(){
    	return transAmount;
    }
    /**
     * @return The category of the transaction
     */
    private String getCategory() {
        return category;
    }
    /**
     * Method increases or decreases the total amount of the account by value of transAmount.
     * update:3/28/17: added transact method
     */
    private void transact(double transAmount){	
    	if(transAmount >= 0){
    		totalAmount += transAmount;
    	}else{
    		totalAmount -= transAmount;
    	}
    }

    /**
     * The viewTransaction() operation assumes that there are items
     * in the transactionRecord.
     * @pre transactionRecord.size() > 0
     * @post A list of all items in the transaction with their respective
     * values
     */
    private String viewTransaction(HashMap transactionRecord) {
        //Placeholder
        return "0";
    }
    Transaction testCase = new Transaction(date.getDate(), time.getTimeStamp(), transValue.getTransAmount(), totalAmount.getTotalAmount());
    
    System.out.println("date: " + testCase.currentDate, "time: " + testCase.time,
                       "Amount of transaction: " + testCase.transValue, "Available Amount: " + testCase.amountAvail);
}