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

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return currentBalance;

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

            conn.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void withhdraw(double balance, int pkID, int accNo) {

        String url = "jdbc:sqllite:/Database Files/Main.db";

        Connection conn = null;

        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:./Database Files/Main.db");

            String query = "UPDATE Account SET balance = ? WHERE Pk_Account_Id = ? AND Account_Number = ?";
            stmt = conn.prepareStatement(query);
            stmt.setDouble(1, balance - getBalance(pkID, accNo));
            stmt.setInt(2, pkID);
            stmt.setInt(3, accNo);
            stmt.executeUpdate();

            System.out.println("Withdraw successful");

            conn.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) { }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }

    public void transfer(double amount, int pkID, int fromAccNo, int toAccNo) {

        String url = "jdbc:sqllite:/Database Files/Main.db";

        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:./Database Files/Main.db");

            // deducts money from the account you are sending money from
            String deduct = "UPDATE Account SET balance = ? WHERE Pk_Account_Id = ? AND Account_Number = ?";
            PreparedStatement stmt = conn.prepareStatement(deduct);
            stmt.setDouble(1, balance - getBalance(pkID, fromAccNo));
            stmt.setInt(2, pkID);
            stmt.setInt(3, fromAccNo);
            stmt.executeUpdate();

            String applyt = "UPDATE Account SET balance = ? WHERE Pk_Account_Id = ? AND Account_Number = ?";
            PreparedStatement pstmt = conn.prepareStatement(deduct);
            pstmt.setDouble(1, balance + getBalance(pkID, toAccNo));
            stmt.setInt(2, pkID);
            stmt.setInt(3, toAccNo);
            stmt.executeUpdate();

            System.out.println("Transaction successful");

            conn.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
