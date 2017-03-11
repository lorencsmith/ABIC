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
     * @return The date of the transaction
     */
    private String getDate() {...}

    /**
     * @return The time of the transaction
     */
    private String getTimeStamp() {...}

    /**
     * @return The total amount of the transaction
     */
    private double getTotalAmount() {...}

    /**
     * @return The category of the transaction
     */
    private String getCategory() {...}

    /**
     * The viewTransaction() operation assumes that there are items
     * in the transactionRecord.
     * @pre transactoinRecord.size() > 0
     * @post A list of all items in the transaction with their respective
     * prices
     */
    private String viewTransaction(HashMap transactionRecord) {...}

}
