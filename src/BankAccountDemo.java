import javax.xml.crypto.Data;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Calendar;
import java.util.Random;

/**
 * Created by Lunanamic on 4/4/2017.
 */
public class BankAccountDemo {
    public static void main(String[] args) {

        deleteDatabase("./Database Files/", "Main.db");

        oneTimeSetup("Main.db");

        initialTableSetup();

        BankAccountDriver test = new BankAccountDriver();

        System.out.println("Withdrawing $100");
        test.withdraw(100.0, 717, 101);
        DatabaseDriver.viewTable("Account");

        test.deposit(5000.50, 717, 101);
        DatabaseDriver.viewTable("Account");

        test.transfer(4000.00, 717, 717, 101, 102);
        DatabaseDriver.viewTable("Account");

    }

    public static void deleteDatabase(String filepath, String dbName) {
        File f = null;
        boolean deleted = false;

        try {

            String path = filepath + dbName;

            f = new File(path);

            deleted = f.delete();

            if (deleted)
                System.out.println("Database deleted successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void oneTimeSetup(String dbName) {
        DatabaseDriver.createNewDatabase(dbName);
        DatabaseDriver.createNewTable(DatabaseDriver.createLocalAccount());
        DatabaseDriver.createNewTable(DatabaseDriver.createPerson());
        DatabaseDriver.createNewTable(DatabaseDriver.createAccount());
    }

    public static void initialTableSetup() {

        Random rand = new Random();

        Calendar calendar = Calendar.getInstance();

        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());

        String sql = String.format("INSERT INTO 'LOCAL ACCOUNT'(Pk_LocalAccount_Id, USERNAME, PASSWORD)" +
                "VALUES(\"100\", \"Admin\", \"pass\")");
        DatabaseDriver.run(sql);

        sql = "INSERT INTO Person ('Pk_Person_Id','FIRST_NAME', 'LAST_NAME', SSN, DOB, 'ADDRESS', CITY, STATE, 'ZIP CODE', 'HOME_NUMBER', 'WORK_NUMBER')" +
                "VALUES ((SELECT Pk_LocalAccount_Id FROM 'LOCAL ACCOUNT' WHERE USERNAME = \"Admin\" limit 1), \"1\", \"2\", \"2\", \"2\", \"2\", \"2\", \"2\", \"2\", \"2\", \"2\")";
        DatabaseDriver.run(sql);

        sql = sql = String.format("INSERT INTO Account ('Pk_Account_Id', Account_Number, Type, Balance, Interest_Rate, Overdraft, Last_Access_Time_Stamp)" +
                "VALUES (\"717\", \"101\", \"1\", \"500.14\", \"0\", \"0.00\", \"%s\")", currentTimestamp);
        DatabaseDriver.run(sql);


        sql = sql = String.format("INSERT INTO Account ('Pk_Account_Id', Account_Number, Type, Balance, Interest_Rate, Overdraft, Last_Access_Time_Stamp)" +
                "VALUES (\"717\", \"102\", \"0\", \"800.14\", \"0\", \"0.00\", \"%s\")", currentTimestamp);
        DatabaseDriver.run(sql);


        DatabaseDriver.viewTable("'LOCAL ACCOUNT'");
        DatabaseDriver.viewTable("Person");
        DatabaseDriver.viewTable("Account");


    }



}
