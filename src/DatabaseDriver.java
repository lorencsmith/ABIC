/**
 * Created by Grandy Nguyen on 3/29/2017.
 */


import java.sql.Connection;
import java.sql.ResultSet;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;
import java.sql.*;



public class DatabaseDriver {

    private ObservableList<ObservableList> data;
    private TableView tableview;

    public static void main(String[] args) {
        createNewDatabase("Main.db");
        createNewTable(createLocalAccount());
        createNewTable(createAccount());
        createNewTable(createPerson());
    }

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

    public static void search(String sql) {
        String url = "jdbc:sqllite:/Database Files/Main.db";

        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:./Database Files/Main.db");
            c.setAutoCommit(false);
            System.out.println("Opened database Successfully");

            stmt = c.createStatement();
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void searchAll(String sql) {
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("ID") + "\t" +
                        rs.getString("USERNAME") + "\t" +
                        rs.getString("PASSWORD"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getPassword(String sql) {
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the value
            ResultSet rs = pstmt.executeQuery();

            return rs.getString("PASSWORD");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    public String getFirstName(String sql) {
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the value
            ResultSet rs = pstmt.executeQuery();
            return rs.getString("FIRST NAME");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    public String getLastName(String sql) {
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the value
            ResultSet rs = pstmt.executeQuery();
            return rs.getString("LAST NAME");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    public String getSSN(String sql) {
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the value
            ResultSet rs = pstmt.executeQuery();
            return rs.getString("SSN");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    public String getDOB(String sql) {
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the value
            ResultSet rs = pstmt.executeQuery();
            return rs.getString("DOB");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    public String getADDRESS(String sql) {
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the value
            ResultSet rs = pstmt.executeQuery();
            return rs.getString("ADDRESS");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    public String getCITY(String sql) {
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the value
            ResultSet rs = pstmt.executeQuery();
            return rs.getString("CITY");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    public String getSTATE(String sql) {
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the value
            ResultSet rs = pstmt.executeQuery();
            return rs.getString("STATE");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    public String getZIPCODE(String sql) {
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the value
            ResultSet rs = pstmt.executeQuery();
            return rs.getString("ZIP CODE");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    public String getHOMENUMBER(String sql) {
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the value
            ResultSet rs = pstmt.executeQuery();
            return rs.getString("HOME NUMBER");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    public String getWORKNUMBER(String sql) {
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the value
            ResultSet rs = pstmt.executeQuery();
            return rs.getString("WORK NUMBER");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }


    public String getAccountNumber(String sql) {
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the value
            ResultSet rs = pstmt.executeQuery();

            return rs.getString("Pk_LocalAccount_Id");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    public String getAccountNumber2(String sql) {
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the value
            ResultSet rs = pstmt.executeQuery();

            return rs.getString("Pk_Person_Id");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    public String getBalance(String sql) {
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the value
            ResultSet rs = pstmt.executeQuery();

            return rs.getString("Balance");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:./Database Files/Main.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
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
                " PASSWORD       TEXT     NOT NULL)";
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
                "FOREIGN KEY (Pk_Account_Id) REFERENCES Person(Pk_Person_Id))";
    }
}

