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
                System.out.println("A new database has been created");
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
            System.out.println("Opened database Successfully");

            stmt = c.createStatement();

            stmt.executeUpdate(sql);
            stmt.close();
            c.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }

    public static void viewTable(String tableName) {
        String url = "jdbc:sqllite:/Database Files/Main.db";

        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:./Database Files/Main.db");
            System.out.println("Opened database Successfully");

            DBTablePrinter.printTable(c, tableName);

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Viewing Table");

    }

    public static void run(String sql) {
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
        System.out.println("Records created successfully");
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
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    public static boolean checkDuplicates(String field, String Table, String check) {
        String url = "jdbc:sqllite:/Database Files/Main.db";

        Connection c = null;
        ResultSet result = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:./Database Files/Main.db");

            String sql = String.format("SELECT \"%s\" FROM \"%s\" WHERE \"%s\"", field, Table, check);
            Statement stmt = c.createStatement();

            result = stmt.executeQuery(sql);
            if (!result.isBeforeFirst()) {

                return false;
            }

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return true;
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
                "(ID INT PRIMARY KEY     NOT NULL," +
                " USERNAME       TEXT    NOT NULL UNIQUE," +
                " PASSWORD       INT     NOT NULL)";
    }

    public static String createCustomer() {
        return "CREATE TABLE IF NOT EXISTS CUSTOMER  " +
                "('FIRST NAME'   TEXT  NOT NULL," +
                "'LAST NAME'    TEXT  NOT NULL," +
                "'SSN'          TEXT NOT NULL," +
                "DOB            TEXT NOT NULL," +
                "'ADDRESS'      TEXT  NOT NULL," +
                "'CITY'         TEXT  NOT NULL," +
                "'STATE'        TEXT  NOT NULL," +
                "'ZIP CODE'     INT   NOT NULL," +
                "'HOME NUMBER' TEXT  NOT NULL," +
                "'WORK NUMBER'  TEXT NOT NULL," +
                "ID            INT PRIMARY KEY  NOT NULL, " +
                "FOREIGN KEY (ID) REFERENCES 'LOCAL ACCOUNT' (ID))";
    }

    public static String testCustomer() {
        return "CREATE TABLE suppliers (\n" +
                " supplier_id integer PRIMARY KEY,\n" +
                " supplier_name text NOT NULL,\n" +
                " group_id integer,\n" +
                " FOREIGN KEY (group_id) REFERENCES supplier_groups (group_id) \n" +
                "  ON UPDATE SET NULL\n" +
                ")";
    }

    public static void main(String[] args) {
        createNewDatabase("Main.db");
        createNewTable(createLocalAccount());
        createNewTable(createCustomer());

    }


}
