/**
 * Created by Grandy Nguyen on 3/29/2017.
 */

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
     *
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
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
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
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    public static void insert(String sql) {
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
        System.out.println("Records created successfully");
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
                " USERNAME       TEXT    NOT NULL," +
                " PASSWORD       INT     NOT NULL)";
    }

    public static String createCustomer() {
        return "CREATE TABLE CUSTOMER " +
                "('FIRST NAME'   TEXT  NOT NULL," +
                "'LAST NAME'    TEXT  NOT NULL," +
                "'SSN'          TEXT NOT NULL,"  +
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
        //createNewTable(createLocalAccount());
        //createNewTable(createCustomer());

        Random rand = new Random();
        int randomNumber = rand.nextInt(99999999);






        String sql = String.format("INSERT INTO 'LOCAL ACCOUNT' (ID, USERNAME, PASSWORD)" +
                "VALUES (%d, \"%s\", \"%s\")", randomNumber, "admin", "password");
        viewTable("'LOCAL ACCOUNT'");

        insert(sql);

        sql = String.format("INSERT INTO CUSTOMER ('FIRST NAME', 'LAST NAME', SSN, DOB, 'ADDRESS', CITY, STATE, 'ZIP CODE', 'HOME NUMBER', 'WORK NUMBER', ID)" +
                "VALUES (\"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", (SELECT ID FROM 'LOCAL ACCOUNT' WHERE USERNAME = 'admin' limit 1))",  "one", "two", "three", "four", "five", "six", "seven",
                                                                                                      "eight", "nine", "ten");

//        String test = String.format("INSERT INTO CUSTOMER ('FIRST NAME')" +
//                "VALUES (\"%s\")", "one");

        insert(sql);

        viewTable("CUSTOMER");

    }


}
