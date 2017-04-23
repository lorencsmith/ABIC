import com.sun.org.apache.xpath.internal.SourceTree;

import java.sql.*;

/**
 * Created by Lunanamic on 4/4/2017.
 */
public class BankAccountDriver {

    private int accountNumber;

    private double balance;

    public double getBalance(int pkID, int accountNumber) {

        String url = "jdbc:sqllite:/Database Files/Main.db";

        Connection conn = null;

        double currentBalance = 0.0;

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:./Database Files/Main.db");

            String sql = "SELECT Balance FROM Account WHERE Pk_Account_id = ? AND Account_Number = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, pkID);
            pstmt.setInt(2, accountNumber);
            ResultSet rs = pstmt.executeQuery();

            currentBalance = rs.getDouble("Balance");

            //System.out.println("bal: " + currentBalance);

            rs.close();
            pstmt.close();
            conn.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return currentBalance;

    }

    public void reset_Password(String password, int accountNumber) {

        String url = "jdbc:sqllite:/Database Files/Main.db";

        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:./Database Files/Main.db");

            String query = "UPDATE 'LOCAL ACCOUNT' SET PASSWORD = ? WHERE Pk_LocalAccount_Id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, password);
            stmt.setInt(2, accountNumber);
            stmt.executeUpdate();

            System.out.println("Deposit successful");

            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void deposit(double balance, int pkID, int accNo) {

        String url = "jdbc:sqllite:/Database Files/Main.db";

        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:./Database Files/Main.db");

            String query = "UPDATE Account SET balance = ? WHERE Pk_Account_Id = ? AND Account_Number = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setDouble(1, balance + getBalance(pkID, accNo));
            stmt.setInt(2, pkID);
            stmt.setInt(3, accNo);
            stmt.executeUpdate();

            System.out.println("Deposit successful");

            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void withdraw(double balance, int pkID, int accNo) {

        String url = "jdbc:sqllite:./Database Files/Main.db";

        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:./Database Files/Main.db");

            System.out.println("Current balance = " + getBalance(pkID, accNo));

            String query = "UPDATE Account SET balance = ? WHERE Pk_Account_Id = ? AND Account_Number = ?";
            PreparedStatement stmt = null;stmt = conn.prepareStatement(query);
            stmt.setDouble(1,getBalance(pkID, accNo) - balance);
            System.out.println(getBalance(pkID, accNo));
            stmt.setInt(2, pkID);
            stmt.setInt(3, accNo);
            stmt.executeUpdate();

            stmt.close();
            conn.close();

            System.out.println("New balance = " + getBalance(pkID, accNo));

            System.out.println("Withdraw successful");


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void transfer(double amount, int frompkID, int topkID, int fromAccNo, int toAccNo) {

        String url = "jdbc:sqllite:/Database Files/Main.db";

        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:./Database Files/Main.db");

            // deducts money from the account you are sending money from
            String deduct = "UPDATE Account SET balance = ? WHERE Pk_Account_Id = ? AND Account_Number = ?";
            PreparedStatement stmt = conn.prepareStatement(deduct);
            stmt.setDouble(1, getBalance(frompkID, fromAccNo) - amount);
            //System.out.printf("balance = %f",(double) getBalance(frompkID, fromAccNo) - amount);
            stmt.setInt(2, frompkID);
            stmt.setInt(3, fromAccNo);
            stmt.executeUpdate();

            String apply = "UPDATE Account SET balance = ? WHERE Pk_Account_Id = ? AND Account_Number = ?";
            PreparedStatement pstmt = conn.prepareStatement(apply);

            pstmt.setDouble(1, getBalance(topkID, toAccNo) + amount);
            pstmt.setInt(2, topkID);
            pstmt.setInt(3, toAccNo);
            pstmt.executeUpdate();

            System.out.println("Transfer successful");

            conn.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
