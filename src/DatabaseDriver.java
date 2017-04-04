/**
 * Created by Grandy Nguyen on 3/29/2017.
 */

import com.sun.istack.internal.NotNull;

import java.sql.*;
import java.util.Random;

public class DatabaseDriver {

    public static void createNewDatabase(String filename) {
        String url = "jdbc:sqlite:./Database Files/" + filename;
        //String url = "jdbc:sqllite:\\Database Files\\" + filename;

        System.out.println("The URL is: " + url);

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                //System.out.println("The driver name is " + meta.getDriverName());
//                System.out.println("A new database has been created");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param sql SQL statement in the form of a string
     */

    public static void createNewTable(String sql) {
        String url = "jdbc:sqllite:/Database Files/Main.db";

        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:./Database Files/Main.db");
//            System.out.println("Opened database Successfully");

            stmt = c.createStatement();

            stmt.executeUpdate(sql);
            stmt.close();
            c.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
//        System.out.println("Table created successfully");
    }

    public static void viewTable(String tableName) {
        String url = "jdbc:sqllite:/Database Files/Main.db";

        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:./Database Files/Main.db");
//            System.out.println("Opened database Successfully");

            DBTablePrinter.printTable(c, tableName);

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
//        System.out.println("Viewing Table");

    }

    public static void run(String sql) {
        String url = "jdbc:sqllite:/Database Files/Main.db";

        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:./Database Files/Main.db");
            c.setAutoCommit(false);
//            System.out.println("Opened database Successfully");

            stmt = c.createStatement();
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) { /* ignored */}
            }
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
//        System.out.println("Records created successfully");
    }


    public static boolean checkDuplicates(String username) {
        String url = "jdbc:sqllite:/Database Files/Main.db";

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;

        int count = 0;

        boolean value = false;

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:./Database Files/Main.db");

            String query = "SELECT COUNT(*) FROM 'LOCAL ACCOUNT' WHERE USERNAME = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                count = rs.getInt("COUNT(*)");
            }

            if (count > 0) {
                value = true;
            }

            System.out.println(value);

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return value;
    }

    /**
     * LOCAL ACCOUNT table consists of
     * ID: RANDOM #
     * USERNAME: STRING
     * PASSWORD: STRING
     * Note: Encrypt Password (using SALT)
     */
    public static String createLocalAccount() {
        return "CREATE TABLE IF NOT EXISTS 'LOCAL ACCOUNT' " +
                "(Pk_LocalAccount_Id INT PRIMARY KEY     NOT NULL," +
                " USERNAME       TEXT    NOT NULL UNIQUE," +
                " PASSWORD       INT     NOT NULL)";
    }

    public static String createPerson() {
        return "CREATE TABLE IF NOT EXISTS Person" +
                "(Pk_Person_Id INT PRIMARY KEY," +
                "'FIRST NAME'   TEXT  NOT NULL," +
                "'LAST NAME'    TEXT  NOT NULL," +
                "'SSN'          TEXT NOT NULL," +
                "DOB            TEXT NOT NULL," +
                "'ADDRESS'      TEXT  NOT NULL," +
                "'CITY'         TEXT  NOT NULL," +
                "'STATE'        TEXT  NOT NULL," +
                "'ZIP CODE'     INT   NOT NULL," +
                "'HOME NUMBER' TEXT  NOT NULL," +
                "'WORK NUMBER'  TEXT NOT NULL," +
                "FOREIGN KEY (Pk_Person_Id) REFERENCES 'LOCAL ACCOUNT' (Pk_LocalAccount_Id))";
    }

    /**
     * Account table stores bank account details, it consists of
     * Pk_Account_Id: Random number generated on 'LOCAL ACCOUNT' Creation, used to link tables
     * Account_Number: Random number, unique, used to identify bank accounts
     * Type: 0 or 1, 0 = Checking, 1 = Savings
     * Balance: The ammount of money in the account
     * Interest_Rate: The interest rate on the account
     * Overdraft: Ammount overdrafted
     * Last_Access_Time_Stamp
     * @return
     */

    public static String createAccount() {
        return "CREATE TABLE IF NOT EXISTS Account" +
                "(Pk_Account_Id INTEGER," +
                "Account_Number INTEGER UNIQUE," +
                "Type INTEGER," +
                "Balance DECIMAL(5, 2)," +
                "Interest_Rate DECIMAL," +
                "Overdraft DECIMAL(5, 2)," +
                "Last_Access_Time_Stamp TIMESTAMP," +
                "FOREIGN KEY (Pk_Account_Id) REFERENCES Person(Pk_Customer_Id))";
    }

}
