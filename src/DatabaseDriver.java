/**
 * Created by Grandy Nguyen on 3/29/2017.
 */

import java.sql.*;

public class DatabaseDriver {

    public static void createNewDatabase(String filename) {
        String url = "jdbc:sqlite:./Database Files/" + filename;

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

    public static void viewTable() {
        String url = "jdbc:sqllite:/Database Files/Main.db";

        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:./Database Files/Main.db");
            System.out.println("Opened database Successfully");



            DBTablePrinter.printTable(c, "'LOCAL ACCOUNT'");



        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

        System.out.println("Viewing Table");

    }

    public static void insert() {
        String url = "jdbc:sqllite:/Database Files/Main.db";

        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:./Database Files/Main.db");
            c.setAutoCommit(false);
            System.out.println("Opened database Successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO 'LOCAL ACCOUNT' (ID, USERNAME, PASSWORD) " +
                         "VALUES (14, \"ADMIN\", \"1234\");";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO 'LOCAL ACCOUNT' (ID, USERNAME, PASSWORD) " +
            "VALUES (235, \"ADMIN\", \"1234\");";
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
    public static String localAccount() {
        return "CREATE TABLE 'LOCAL ACCOUNT' " +
                "(ID INT PRIMARY KEY     NOT NULL," +
                " USERNAME       TEXT    NOT NULL," +
                " PASSWORD       INT     NOT NULL)";
    }






    public static void main(String[] args) {
        //createNewTable(localAccount());
        //insert();
        viewTable();
    }


}
