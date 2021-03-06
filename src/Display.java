import com.sun.javaws.exceptions.InvalidArgumentException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Daniel Oh on 3/22/2017.
 * This is Display class for ABIC
 * Last Update: 4/5/2017
 */
public class Display extends Application {

    Stage mainStage;
    Scene Login_Scene, Forgot_Password_Scene, Enroll_idpass_Scene, Login_Help_Scene,
            Enroll_Scene, Profile_Scene, Withdrawal_Scene, Post_Transfer_Scene,
            Deposit_Scene, Transfer_Scene, Billpay_Scene, Post_Transaction_Scene, Help_Scene,User_Login_Scene,
            Post_Login_Scene, Enroll_Success_Scene, Reset_Password_Scene, Reset_Password_Success_Scene;
    Image Logo = new Image("ABIC_Logo.png");

    public static void main(String[] args) {
        DatabaseDriver db = new DatabaseDriver();
        db.createNewDatabase("Main.db");
        db.createNewTable(db.createLocalAccount());
        db.createNewTable(db.createAccount());
        db.createNewTable(db.createPerson());
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //Call Login scene at the start of the program
        mainStage = primaryStage;
        Login_Scene_Call();
        mainStage.getIcons().add(new Image("ABIC_icon.png"));
        mainStage.setTitle("");
        mainStage.show();
    }

    /**
     * Login Scene will be called at the beginning of the program
     * And it will be the main menu throughout the program
     */
    protected void Login_Scene_Call() {
        //Main Gridpane set up
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(10, 10, 20, 20));
        grid.setStyle("-fx-background-color: white");

        //Row 1 (Logo)
        ImageView LogoView = new ImageView();
        LogoView.setImage(Logo);
        LogoView.setFitWidth(Logo.getWidth() / 4);
        LogoView.setFitHeight(Logo.getHeight() / 4);
        grid.add(LogoView, 6, 0, 3, 1);

        //Row 2


        //Row3
        Button User_Login_Button = new Button("User Login");
        User_Login_Button.setAlignment(Pos.CENTER);
        User_Login_Button.setPadding(new Insets(5, 5, 5, 5));
        User_Login_Button.setFont(Font.font("Tahoma", FontWeight.BOLD, 12));
        User_Login_Button.setMinWidth(200);
        grid.add(User_Login_Button, 0, 3, 2, 1);
        User_Login_Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                User_Login_Call();
            }
        });

        //Row4
        Button Enroll_Button = new Button("Enroll");
        Enroll_Button.setAlignment(Pos.CENTER);
        Enroll_Button.setPadding(new Insets(5, 5, 5, 5));
        Enroll_Button.setFont(Font.font("Tahoma", FontWeight.BOLD, 12));
        Enroll_Button.setMinWidth(70);
        grid.add(Enroll_Button, 0, 4, 1, 1);

        Enroll_Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Enroll_idpass_Call();
            }
        });

        Button Forgot_Button = new Button("Forgot Password");
        Forgot_Button.setAlignment(Pos.CENTER);
        Forgot_Button.setPadding(new Insets(5, 5, 5, 5));
        Forgot_Button.setFont(Font.font("Tahoma", FontWeight.BOLD, 12));
        Forgot_Button.setMinWidth(125);
        grid.add(Forgot_Button, 1, 4, 1, 1);

        Button help_Button = new Button("Help");
        help_Button.setAlignment(Pos.CENTER);
        help_Button.setPadding(new Insets(5, 5, 5, 5));
        help_Button.setFont(Font.font("Tahoma", FontWeight.BOLD, 12));
        help_Button.setMinWidth(200);
        grid.add(help_Button, 0, 5, 2, 1);

        help_Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                help_Call();
            }
        });

        Forgot_Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Forgot_Password_Call();
            }
        });
        Login_Scene = new Scene(grid, 800, 600);
        mainStage.setScene(Login_Scene);
    }

    protected void help_Call(){
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(10, 10, 20, 20));
        grid.setStyle("-fx-background-color: white");

        //Row 0 (Logo)
        ImageView LogoView = new ImageView();
        LogoView.setImage(Logo);
        LogoView.setFitWidth(Logo.getWidth() / 4);
        LogoView.setFitHeight(Logo.getHeight() / 4);
        grid.add(LogoView, 3, 0, 3, 1);

        Help help = new Help();
        help.FAQ(grid);
        help.contact(grid);
        help.privacy(grid);

        Button back_Button = new Button();
        back_Button = Cancel_Button();
        back_Button.setText("Back");
        grid.add(back_Button, 1,21,1,1);

        Login_Help_Scene = new Scene(grid,800,600);
        mainStage.setScene(Login_Help_Scene);


    }

    protected void User_Login_Call() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(10, 10, 20, 20));
        grid.setStyle("-fx-background-color: white");

        //Row 0 (Logo)
        ImageView LogoView = new ImageView();
        LogoView.setImage(Logo);
        LogoView.setFitWidth(Logo.getWidth() / 4);
        LogoView.setFitHeight(Logo.getHeight() / 4);
        grid.add(LogoView, 3, 0, 3, 1);

        //Row 1
        Label welcome = new Label();
        welcome.setText("Welcome Back to ABIC");
        welcome.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
        grid.add(welcome, 0, 1, 2, 1);

        //Row 2
        Label user_Label = new Label();
        user_Label.setText("Username");
        user_Label.setFont(Font.font("", FontWeight.NORMAL, 12));
        user_Label.setAlignment(Pos.CENTER_LEFT);
        grid.add(user_Label, 1, 2, 1, 1);

        //Row 3
        TextField user_Field = new TextField();
        grid.add(user_Field, 1, 3, 1, 1);

        //Row 4


        //Row 5
        Label password_Label = new Label();
        password_Label.setText("Password");
        password_Label.setFont(Font.font("", FontWeight.NORMAL, 12));
        password_Label.setAlignment(Pos.CENTER_LEFT);
        grid.add(password_Label, 1, 5, 1, 1);

        //Row 6
        PasswordField password_Field = new PasswordField();
        grid.add(password_Field, 1, 6, 1, 1);

        //Row 7
        HBox button_Box = new HBox();
        button_Box.setAlignment(Pos.CENTER_RIGHT);
        button_Box.setSpacing(5);
        Button submit = new Button();
        submit.setText("Submit");
        submit.setAlignment(Pos.CENTER);
        button_Box.getChildren().addAll(Cancel_Button(), submit);
        grid.add(button_Box, 1, 7, 1, 1);

        //Row 8
        Label console_Label = new Label();
        console_Label.setText("");
        console_Label.setTextFill(Color.RED);
        grid.add(console_Label,0,8,4,1);

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (user_Field.getText().isEmpty() || password_Field.getText().isEmpty()){
                    console_Label.setText("Please enter username and password");
                }
                else{
                    String username = user_Field.getText();
                    String password = password_Field.getText();
                    //Validate username and password
                    //Search DB
                    String sql;
                    sql = "SELECT PASSWORD "
                            + "FROM 'LOCAL ACCOUNT' WHERE USERNAME = " + "\"" + username + "\"";
                    DatabaseDriver db = new DatabaseDriver();
                    if(password.equals(db.getPassword(sql))){
                        String sql2;
                        sql2 = "SELECT Pk_LocalAccount_Id "
                                + "FROM 'LOCAL ACCOUNT' WHERE USERNAME = " + "\"" + username + "\"";
                        String accountNumber = db.getAccountNumber(sql2);
                        Post_Login_Call(accountNumber);
                    }
                    else{
                        console_Label.setText("Username and password does not match");
                    }
                }
            }
        });

        //Start the Scene
        User_Login_Scene = new Scene(grid, 800, 600);
        mainStage.setScene(User_Login_Scene);
    }

    /**
     * Forgot password scene will be called when user presses forgot password button
     * it will search and validate the input using database and return current password back to user
     * Since the program is strictly used in infranet, it won't involve sending emails
     */
    protected void Forgot_Password_Call() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(10, 10, 20, 20));
        grid.setStyle("-fx-background-color: white");

        //Row 0 (Logo)
        ImageView LogoView = new ImageView();
        LogoView.setImage(Logo);
        LogoView.setFitWidth(Logo.getWidth() / 4);
        LogoView.setFitHeight(Logo.getHeight() / 4);
        grid.add(LogoView, 4, 0, 3, 1);

        //Row 1
        Label Forgot_Password_Label = new Label("Forgot Password");
        Forgot_Password_Label.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
        grid.add(Forgot_Password_Label, 0, 1, 2, 1);


        //Row 2
        Label reset_password_info = new Label("Reset Password through:");
        reset_password_info.setFont(Font.font("Calibri", FontWeight.NORMAL, 11));
        grid.add(reset_password_info, 0, 2, 2, 1);

        //Row 3
        Label username_label = new Label();
        username_label.setText("○ Username:");
        username_label.setFont(Font.font("Calibri", FontWeight.NORMAL, 11));
        TextField username_Field = new TextField();
        username_Field.setPromptText("Enter username");
        grid.add(username_label, 1, 3, 1, 1);
        grid.add(username_Field, 2, 3, 2, 1);

        //Row 4
        Label ssn_label = new Label();
        ssn_label.setText("○ Social Security Number:");
        ssn_label.setFont(Font.font("Calibri", FontWeight.NORMAL, 11));
        TextField ssn_Field = new TextField();
        ssn_Field.setPromptText("Enter SSN");
        grid.add(ssn_label, 1, 4, 1, 1);
        grid.add(ssn_Field, 2, 4, 2, 1);

        //Row 5
        Label empty_label = new Label(" ");
        empty_label.setTextFill(Color.RED);
        grid.add(empty_label, 0, 5, 5, 1);

        //Row 6

        //Row 7
        Button submit_Button = new Button("Submit");
        submit_Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseDriver db = new DatabaseDriver();
                String sql = "";
                if (username_Field.getText().isEmpty() || ssn_Field.getText().isEmpty()){
                    empty_label.setText("Please enter username and Social security number");
                }
                else {
                    sql = "SELECT * "
                            + " FROM Person WHERE SSN = " + "\"" + ssn_Field.getText() + "\"";
                    String result = db.getSSN(sql);
                    if (result.isEmpty()){
                        empty_label.setText("No such account exists");
                    }
                    else{
                        sql = "SELECT Pk_Person_Id FROM Person WHERE SSN = " + "\"" + ssn_Field.getText() + "\"";
                        String accountNumber = db.getAccountNumber2(sql);
                        Reset_Password_Call(accountNumber);
                    }
                }
            }
        });

        HBox button_Box = new HBox();
        button_Box.setSpacing(5);
        button_Box.setPadding(new Insets(5, 5, 5, 5));
        button_Box.getChildren().addAll(Cancel_Button(), submit_Button);
        grid.add(button_Box, 0, 7, 3, 1);

        //Change the Scene
        Forgot_Password_Scene = new Scene(grid, 800, 600);
        mainStage.setScene(Forgot_Password_Scene);
    }

    /**
     * Program will ask user to input username and password for enrollment.
     * it will take username parameter and search the database to see if it already exists in the database
     */
    protected void Enroll_idpass_Call() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(10, 10, 20, 20));
        grid.setStyle("-fx-background-color: white");

        //Row 0
        ImageView LogoView = new ImageView();
        LogoView.setImage(Logo);
        LogoView.setFitWidth(Logo.getWidth() / 4);
        LogoView.setFitHeight(Logo.getHeight() / 4);
        grid.add(LogoView, 3, 0, 3, 1);

        //Row 1
        Label username_Label = new Label();
        username_Label.setText("Username");
        grid.add(username_Label, 0, 1, 1, 1);

        //Row 2
        TextField username_Field = new TextField();
        username_Field.setPromptText("Enter username");
        grid.add(username_Field, 0, 2, 1, 1);

        //Row 3
        Label password_Label = new Label();
        password_Label.setText("Enter password");
        Label password_Label2 = new Label();
        password_Label2.setText("Confirm Password");
        grid.add(password_Label, 0, 3, 1, 1);
        grid.add(password_Label2,1,3,1,1);

        //Row 4
        PasswordField password_Field = new PasswordField();
        grid.add(password_Field, 0, 4, 1, 1);
        PasswordField password_Field2 = new PasswordField();
        grid.add(password_Field2,1,4,1,1);

        //Row 5

        //Row 6
        HBox button_Box = new HBox();
        Button submit = new Button();
        submit.setText("Submit");
        grid.add(button_Box, 0, 6, 1, 1);

        //Row 7
        Label username_Console = new Label();
        username_Console.setTextFill(Color.RED);
        username_Console.setText("");
        grid.add(username_Console, 0, 7, 3, 1);

        /**
         EventHandle
         If username or password textfield is empty, it will ask user to enter the fields
         else it will add the value into database and proceed to next screen
         */
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean passed = true;
                String username = username_Field.getText();
                String password = password_Field.getText();
                String password2 = password_Field2.getText();
                //If the username or password field is empty, it will ask user to fill the field
                if (username.isEmpty() || password.isEmpty()) {
                    username_Console.setText("Please Enter username and password");
                    passed = false;
                }
                else if (!password.equals(password2)){
                    username_Console.setText("Passwords does not match");
                }
                else if (password.length() < 4){
                    username_Console.setText("Password is too short. Please enter more than 4 letters");
                }
                else {
                    int max = 999999999;
                    int min = 100000000;
                    int randomNumber = ThreadLocalRandom.current().nextInt(min, max + 1);

                    String sql = "";

                    // Tries to insert username into database, tells user if username already exists
                    try {
                        sql = String.format("INSERT INTO  'LOCAL ACCOUNT' (Pk_LocalAccount_Id, USERNAME, PASSWORD)" +
                                "VALUES (%d, \"%s\", \"%s\")", randomNumber, username, password);

                        if (!DatabaseDriver.checkDuplicates(username)) {

                            DatabaseDriver.run(sql);

                            DatabaseDriver.viewTable("'LOCAL ACCOUNT'");
                            Enroll_Call(username);
                        }
                        else {
                            username_Console.setText("Username already Exists.");
                            passed = false;
                        }
                    } catch (Exception e) {
                        username_Console.setText("Username already Exists.");
                        passed = false;
                    }
                }
            }
        });

        button_Box.setAlignment(Pos.CENTER_RIGHT);
        button_Box.setSpacing(5);
        button_Box.getChildren().addAll(Cancel_Button(), submit);



        //Start the scene
        Enroll_idpass_Scene = new Scene(grid, 800, 600);
        mainStage.setScene(Enroll_idpass_Scene);

    }

    /**
     * After username and password is validated, program will ask for personal information and validate it.
     * After validation, it will store the data into database
     */
    protected void Enroll_Call(String username) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(10, 10, 20, 20));
        grid.setStyle("-fx-background-color: white");

        //Row 0
        ImageView LogoView = new ImageView();
        LogoView.setImage(Logo);
        LogoView.setFitWidth(Logo.getWidth() / 4);
        LogoView.setFitHeight(Logo.getHeight() / 4);
        grid.add(LogoView, 3, 1, 3, 1);

        //Row 1
        Label Welcome_Logo = new Label();
        Welcome_Logo.setText("Welcome to ABIC Banking Enrollment");
        Welcome_Logo.setFont(Font.font("Calibri", FontWeight.BOLD, 13));
        grid.add(Welcome_Logo, 0, 1, 3, 1);

        //Row 2
        Label Info_Logo = new Label();
        Info_Logo.setText("Please enter your information in the spaces provided below");
        Info_Logo.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
        grid.add(Info_Logo, 0, 2, 3, 1);

        //Row 3
        HBox First_Name_Box = new HBox();
        First_Name_Box.setAlignment(Pos.CENTER_LEFT);
        Label First_Name_Label = new Label();
        First_Name_Label.setText("First Name");
        First_Name_Label.setFont(Font.font("", FontWeight.BOLD, 11));
        First_Name_Box.getChildren().addAll(First_Name_Label, red_star());
        TextField First_Name_Field = new TextField();
        First_Name_Field.setPromptText("Enter First Name");
        Label First_Name_Console = new Label();
        /**
         * ***_Console is a label that will only appear when user pressed submit, and when there is/are an invalid
         * input. Once user inputs valid value, it will disappear
         */
        First_Name_Console.setText("");
        grid.add(First_Name_Box, 0, 3, 1, 1);
        grid.add(First_Name_Field, 1, 3, 1, 1);
        grid.add(First_Name_Console, 2, 3, 1, 1);

        //Row 4
        Label First_Name_Info = new Label();
        First_Name_Info.setText("Enter your first name as it appears on your primary billing account.");
        First_Name_Info.setFont(Font.font("", FontWeight.NORMAL, 11));
        grid.add(First_Name_Info, 0, 4, 3, 1);

        //Row 5
        HBox Last_Name_Box = new HBox();
        Last_Name_Box.setAlignment(Pos.CENTER_LEFT);
        Label Last_Name_Label = new Label();
        Last_Name_Label.setText("Last Name");
        Last_Name_Label.setFont(Font.font("", FontWeight.BOLD, 11));
        Last_Name_Box.getChildren().addAll(Last_Name_Label, red_star());
        TextField Last_Name_Field = new TextField();
        Last_Name_Field.setPromptText("Enter Last Name");
        Label Last_Name_Console = new Label();
        Last_Name_Console.setText("");
        grid.add(Last_Name_Box, 0, 5, 1, 1);
        grid.add(Last_Name_Field, 1, 5, 1, 1);
        grid.add(Last_Name_Console, 2, 5, 1, 1);

        //Row 6
        Label Last_Name_Info = new Label();
        Last_Name_Info.setText("Enter your last name as it appears on your primary billing account.");
        Last_Name_Info.setFont(Font.font("", FontWeight.NORMAL, 11));
        grid.add(Last_Name_Info, 0, 6, 3, 1);

        //Row 7
        HBox ssn_Box = new HBox();
        ssn_Box.setAlignment(Pos.CENTER_LEFT);
        Label ssn_Label = new Label();
        ssn_Label.setText("Social Security Number");
        ssn_Label.setFont(Font.font("", FontWeight.BOLD, 11));
        ssn_Box.getChildren().addAll(ssn_Label, red_star());
        TextField ssn_Field = new TextField();
        ssn_Field.setPromptText("_________");
        Label ssn_Console = new Label();
        ssn_Console.setText("");
        grid.add(ssn_Box, 0, 7, 1, 1);
        grid.add(ssn_Field, 1, 7, 1, 1);
        grid.add(ssn_Console, 2, 7, 1, 1);

        //Row 8
        Label pAccount_Info = new Label();
        pAccount_Info.setText("This account may be subject to billing or fees per our Terms and Conditions agreement. Enter numbers only as they appear on your monthly account statement. Do not use spaces or dashes.");
        pAccount_Info.setFont(Font.font("", FontWeight.NORMAL, 11));
        pAccount_Info.setWrapText(true);
        grid.add(pAccount_Info, 0, 8, 3, 1);

        //Row 9
        HBox dob_Box = new HBox();
        dob_Box.setAlignment(Pos.CENTER_LEFT);
        Label dob_Label = new Label();
        dob_Label.setText("Date of Birth");
        dob_Label.setFont(Font.font("", FontWeight.BOLD, 11));
        dob_Box.getChildren().addAll(dob_Label, red_star());
        final DatePicker datePicker = new DatePicker();
        datePicker.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LocalDate date = datePicker.getValue();
            }
        });
        Label dob_Console = new Label();
        dob_Console.setText("");
        grid.add(dob_Box, 0, 9, 1, 1);
        grid.add(datePicker, 1, 9, 1, 1);
        grid.add(dob_Console, 2, 9, 1, 1);

        //Row 10
        HBox hPhone_Box = new HBox();
        hPhone_Box.setAlignment(Pos.CENTER_LEFT);
        Label hPhone_Label = new Label();
        hPhone_Label.setText("Home Phone");
        hPhone_Label.setFont(Font.font("", FontWeight.BOLD, 11));
        hPhone_Box.getChildren().addAll(hPhone_Label, red_star());
        TextField hPhone_Field = new TextField();
        hPhone_Field.setPromptText("XXXXXXXXXX");
        Label hPhone_Console = new Label();
        hPhone_Console.setText("");
        grid.add(hPhone_Box, 0, 10, 1, 1);
        grid.add(hPhone_Field, 1, 10, 1, 1);
        grid.add(hPhone_Console, 2, 10, 1, 1);

        //Row 11
        HBox wPhone_Box = new HBox();
        wPhone_Box.setAlignment(Pos.CENTER_LEFT);
        Label wPhone_Label = new Label();
        wPhone_Label.setText("Work Phone");
        wPhone_Label.setFont(Font.font("", FontWeight.NORMAL, 11));
        wPhone_Box.getChildren().addAll(wPhone_Label);
        TextField wPhone_Field = new TextField();
        wPhone_Field.setPromptText("XXXXXXXXXX");
        Label wPhone_Console = new Label();
        wPhone_Console.setText("");
        grid.add(wPhone_Box, 0, 11, 1, 1);
        grid.add(wPhone_Field, 1, 11, 1, 1);
        grid.add(wPhone_Console, 2, 11, 1, 1);

        //Row 12
        Label phone_Info = new Label();
        phone_Info.setText("If only one phone number is available, please enter it in Home phone categories. No Dashes");
        phone_Info.setFont(Font.font("", FontWeight.NORMAL, 11));
        phone_Info.setWrapText(true);
        grid.add(phone_Info, 0, 12, 3, 1);

        //Row 13
        HBox address_Box = new HBox();
        address_Box.setAlignment(Pos.CENTER_LEFT);
        Label address_Label = new Label();
        address_Label.setText("Address Line 1");
        address_Label.setFont(Font.font("", FontWeight.BOLD, 11));
        address_Box.getChildren().addAll(address_Label, red_star());
        TextField address_Field = new TextField();
        address_Field.setPromptText("Street Address");
        Label address_Console = new Label();
        address_Console.setText("");
        grid.add(address_Box, 0, 13, 1, 1);
        grid.add(address_Field, 1, 13, 1, 1);
        grid.add(address_Console, 2, 13, 1, 1);

        //Row 14
        Label address2_Label = new Label();
        address2_Label.setText("Address Line 2");
        address2_Label.setFont(Font.font("", FontWeight.NORMAL, 11));
        TextField address2_Field = new TextField();
        address2_Field.setPromptText("Apartment, suite, unit");
        grid.add(address2_Label, 0, 14, 1, 1);
        grid.add(address2_Field, 1, 14, 1, 1);

        //Row 15

        //Row 16
        HBox city_Box = new HBox();
        city_Box.setAlignment(Pos.CENTER_LEFT);
        Label city_Label = new Label();
        city_Label.setText("City");
        city_Label.setFont(Font.font("", FontWeight.BOLD, 11));
        city_Box.getChildren().addAll(city_Label, red_star());
        TextField city_Field = new TextField();
        city_Field.setPromptText("Enter City");
        Label city_Console = new Label();
        city_Console.setText("");
        grid.add(city_Box, 0, 16, 1, 1);
        grid.add(city_Field, 1, 16, 1, 1);
        grid.add(city_Console, 2, 16, 1, 1);

        //Row 17
        HBox State_Box = new HBox();
        State_Box.setAlignment(Pos.CENTER_LEFT);
        Label State_Label = new Label();
        State_Label.setText("State");
        State_Label.setFont(Font.font("", FontWeight.BOLD, 11));
        ObservableList<String> states =
                FXCollections.observableArrayList(
                        "Alabama",
                        "Alaska",
                        "Arizona",
                        "Arkansas",
                        "California",
                        "Colorado",
                        "Connecticut",
                        "Delaware",
                        "Florida",
                        "Georgia",
                        "Hawaii",
                        "Idaho",
                        "Illinois",
                        "Indiana",
                        "Iowa",
                        "Kansas",
                        "Kentucky",
                        "Louisiana",
                        "Maine",
                        "Maryland",
                        "Massachusetts",
                        "Michigan",
                        "Minnesota",
                        "Mississippi",
                        "Missouri",
                        "Montana",
                        "Nebraska",
                        "Nevada",
                        "New Hampshire",
                        "New Jersey",
                        "New Mexico",
                        "New York",
                        "North Carolina",
                        "North Dakota",
                        "Ohio",
                        "Oklahoma",
                        "Oregon",
                        "Pennsylvania",
                        "Rhode Island",
                        "South Carolina",
                        "South Dakota",
                        "Tennessee",
                        "Texas",
                        "Utah",
                        "Vermont",
                        "Virginia",
                        "Washington",
                        "West Virginia",
                        "Wisconsin",
                        "Wyoming"
                );
        ComboBox state_combo_box = new ComboBox(states);
        state_combo_box.setMaxWidth(Double.MAX_VALUE);
        Label state_Console = new Label();
        state_Console.setText("");
        State_Box.getChildren().addAll(State_Label, red_star());
        grid.add(State_Box, 0, 17, 1, 1);
        grid.add(state_combo_box, 1, 17, 1, 1);
        grid.add(state_Console, 2, 17, 1, 1);

        //Row 18
        HBox zip_Box = new HBox();
        zip_Box.setAlignment(Pos.CENTER_LEFT);
        Label zip_Label = new Label();
        zip_Label.setText("Zip Code");
        zip_Label.setFont(Font.font("", FontWeight.BOLD, 11));
        zip_Box.getChildren().addAll(zip_Label, red_star());
        TextField zip_Field = new TextField();
        zip_Field.setPromptText("Enter Zip");
        Label zip_Console = new Label();
        zip_Console.setText("");
        grid.add(zip_Box, 0, 18, 1, 1);
        grid.add(zip_Field, 1, 18, 1, 1);
        grid.add(zip_Console, 2, 18, 1, 1);

        //Row 19
        HBox address_Info_Box = new HBox();
        Label address_Info1 = new Label();
        address_Info1.setText("All Fields marked with an asterisk (");
        Label address_Info2 = new Label();
        address_Info2.setText(") are required.");
        address_Info_Box.getChildren().addAll(address_Info1, red_star(), address_Info2);
        grid.add(address_Info_Box, 0, 19, 3, 1);

        //Row 20
        HBox button_Box = new HBox();
        button_Box.setSpacing(5);
        Button submit = new Button();
        submit.setText("Submit");
        submit.setAlignment(Pos.CENTER);
        button_Box.getChildren().addAll(Cancel_Button(), submit);
        grid.add(button_Box, 3, 20, 1, 1);

        //EventHandler
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //validate inputs and compare it with db
                ssn_Console.setTextFill(Color.RED);
                First_Name_Console.setTextFill(Color.RED);
                Last_Name_Console.setTextFill(Color.RED);
                dob_Console.setTextFill(Color.RED);
                wPhone_Console.setTextFill(Color.RED);
                hPhone_Console.setTextFill(Color.RED);
                address_Console.setTextFill(Color.RED);
                city_Console.setTextFill(Color.RED);
                state_Console.setTextFill(Color.RED);
                zip_Console.setTextFill(Color.RED);

                boolean passed = true;
                if (First_Name_Field.getText().isEmpty()) {
                    First_Name_Console.setText("Please enter first name");
                    passed = false;
                } else
                    First_Name_Console.setText("");

                if (Last_Name_Field.getText().isEmpty()) {
                    Last_Name_Console.setText("Please enter last name");
                    passed = false;
                } else
                    Last_Name_Console.setText("");

                if (ssn_Field.getText().isEmpty()) {
                    ssn_Console.setText("Please enter Social Security Number");
                    passed = false;
                } else if (ssn_Field.getText().matches("[0-9]+") && ssn_Field.getText().length() == 9) {
                    ssn_Console.setText("");
                } else {
                    ssn_Console.setText("Invalid Social Security Number");
                    passed = false;
                }

                if (datePicker.getValue() == null) {
                    dob_Console.setText("Please enter Date of Birth");
                    passed = false;
                } else
                    dob_Console.setText("");

                if (hPhone_Field.getText().isEmpty()) {
                    hPhone_Console.setText("Please Enter Home Phone");
                    passed = false;
                } else if (hPhone_Field.getText().matches("[0-9]+") && hPhone_Field.getText().length() == 10) {
                    hPhone_Console.setText("");
                } else {
                    hPhone_Console.setText("Invalid Phone number");
                    passed = false;
                }

                if (address_Field.getText().isEmpty()) {
                    address_Console.setText("Please Enter Address");
                    passed = false;
                } else
                    address_Console.setText("");

                if (city_Field.getText().isEmpty()) {
                    city_Console.setText("Please Enter City");
                    passed = false;
                } else
                    city_Console.setText("");

                if (state_combo_box.getValue() == null) {
                    state_Console.setText("Please choose State");
                    passed = false;
                } else
                    state_Console.setText("");

                if (zip_Field.getText().isEmpty()) {
                    zip_Console.setText("Please enter Zip code");
                    passed = false;
                } else if (zip_Field.getText().matches("[0-9]+") && zip_Field.getText().length() == 5) {
                    zip_Console.setText("");
                } else {
                    zip_Console.setText("Invalid Zip Code");
                    passed = false;
                }
                if (passed) {
                    String sql = String.format("INSERT INTO Person (Pk_Person_Id, 'FIRST NAME', 'LAST NAME', SSN, DOB, 'ADDRESS', CITY, STATE, 'ZIP CODE', 'HOME NUMBER', 'WORK NUMBER')" +
                                    "VALUES ((SELECT Pk_LocalAccount_Id FROM 'LOCAL ACCOUNT' WHERE USERNAME = \"%s\" limit 1), \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\")",
                            username, First_Name_Field.getText(), Last_Name_Field.getText(), ssn_Field.getText(), datePicker.getValue().toString(),
                            address_Field.getText() + " " + address2_Field.getText(), city_Field.getText(), state_combo_box.getValue().toString(), zip_Field.getText(), hPhone_Field.getText(),
                            wPhone_Field.getText());

                    DatabaseDriver.run(sql);
                    DatabaseDriver.viewTable("Person");

                    Calendar calendar = Calendar.getInstance();

                    java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());

                    int min = 100000000;
                    int max = 999999999;
                    int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
                    String sql2 = String.format("INSERT INTO Account ('Pk_Account_Id', Account_Number, Type, Balance, Interest_Rate, Overdraft, Last_Access_Time_Stamp)" +
                            "VALUES ((SELECT Pk_LocalAccount_Id FROM 'LOCAL ACCOUNT' WHERE USERNAME = \"%s\" limit 1), \"%s\", \"1\", \"0.0\", \"0\", \"0.00\", \"%s\")", username, randomNum, currentTimestamp);
                    DatabaseDriver.run(sql2);
                    System.out.println("Passed!");
                    Enroll_Success_Call(First_Name_Field.getText(), ssn_Field.getText());
                }
            }
        });

        //Start new screen
        Enroll_Scene = new Scene(grid, 800, 600);
        mainStage.setScene(Enroll_Scene);
    }


    protected void Enroll_Success_Call(String first_Name, String ssn){
        //Main Gridpane set up
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(10, 10, 20, 20));
        grid.setStyle("-fx-background-color: white");

        //Row 1 (Logo)
        ImageView LogoView = new ImageView();
        LogoView.setImage(Logo);
        LogoView.setFitWidth(Logo.getWidth() / 4);
        LogoView.setFitHeight(Logo.getHeight() / 4);
        grid.add(LogoView, 4, 0, 3, 1);

        //Row 1 (Label with users name)
        Label thanks_Label = new Label();
        thanks_Label.setText("Thank you " + first_Name + "!");
        thanks_Label.setFont(Font.font("", FontWeight.BOLD, 13));
        grid.add(thanks_Label,0,1,1,1);

        //Row 2
        String sql = "SELECT * FROM Person WHERE SSN = " + ssn;
        DatabaseDriver db = new DatabaseDriver();
        Label account_Info_Label = new Label();
        account_Info_Label.setText("Your account number is " + db.getAccountNumber2(sql));
        account_Info_Label.setFont(Font.font("",FontWeight.BOLD,13));
        grid.add(account_Info_Label,0,2,1,1);

        //Row 3
        Label info_Label = new Label();
        info_Label.setText("You can now use your account to use our online banking service");
        info_Label.setFont(Font.font("", FontWeight.NORMAL, 12));
        grid.add(info_Label,0,3,1,1);

        //Row 4
        Button back_Button = new Button();
        back_Button = Cancel_Button();
        back_Button.setText("Login Page");
        grid.add(back_Button,1,4,1,1);

        Enroll_Success_Scene = new Scene(grid,800,600);
        mainStage.setScene(Enroll_Success_Scene);
    }

    /**
     * @return Return cancel button that will take user back to main menu(login scene)
     */

    protected void Post_Login_Call(String accountNumber){
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER_LEFT);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(10,10,20,20));
        grid.setStyle("-fx-background-color: white");

        //Row 0 (Logo)
        ImageView LogoView = new ImageView();
        LogoView.setImage(Logo);
        LogoView.setFitWidth(Logo.getWidth()/4);
        LogoView.setFitHeight(Logo.getHeight()/4);
        grid.add(LogoView,4,0,1,1);

        //Menu Box
        VBox menu_Box = new VBox();
        menu_Box.setAlignment(Pos.CENTER_LEFT);
        menu_Box.setMinWidth(100);

        Hyperlink overview_Link = new Hyperlink();
        overview_Link.setText("Overview");
        overview_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        overview_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                overview_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        overview_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                overview_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        overview_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Post_Login_Call(accountNumber);
            }
        });
        overview_Link.setBorder(Border.EMPTY);

        Hyperlink profile_Link = new Hyperlink();
        profile_Link.setText("Profile");
        profile_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        profile_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                profile_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        profile_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                profile_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        profile_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Profile_Call(accountNumber);
            }
        });
        profile_Link.setBorder(Border.EMPTY);

        Hyperlink transaction_Link = new Hyperlink();
        transaction_Link.setText("Transaction");
        transaction_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        transaction_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transaction_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        transaction_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transaction_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        transaction_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Withdrawal_Call(accountNumber);
            }
        });
        transaction_Link.setBorder(Border.EMPTY);

        Hyperlink deposit_Link = new Hyperlink();
        deposit_Link.setText("Deposit");
        deposit_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        deposit_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                deposit_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        deposit_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                deposit_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        deposit_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Deposit_Call(accountNumber);
            }
        });
        deposit_Link.setBorder(Border.EMPTY);

        Hyperlink transfer_Link = new Hyperlink();
        transfer_Link.setText("Transfer");
        transfer_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        transfer_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transfer_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        transfer_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transfer_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        transfer_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Transfer_Call(accountNumber);
            }
        });
        transfer_Link.setBorder(Border.EMPTY);

        Hyperlink billpay_Link = new Hyperlink();
        billpay_Link.setText("Bill pay");
        billpay_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        billpay_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                billpay_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        billpay_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                billpay_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        billpay_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Billpay_Call(accountNumber);
            }
        });
        billpay_Link.setBorder(Border.EMPTY);


        Hyperlink help_Link = new Hyperlink();
        help_Link.setText("Help");
        help_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        help_Link.setTextFill(Color.BLUE);
        help_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                help_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        help_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                help_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        help_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Help_Call(accountNumber);
            }
        });
        help_Link.setBorder(Border.EMPTY);

        Hyperlink logout_Link = new Hyperlink();
        logout_Link.setText("Logout");
        logout_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        logout_Link.setTextFill(Color.RED);
        logout_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                logout_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        logout_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                logout_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        logout_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Login_Scene_Call();
            }
        });
        logout_Link.setBorder(Border.EMPTY);

        menu_Box.getChildren().addAll(
                overview_Link,
                profile_Link,
                deposit_Link,
                transfer_Link,
                billpay_Link,
                help_Link,
                logout_Link);
        grid.add(menu_Box,0,2,1,10);

        //Row 1
        Label account_Detail = new Label();
        account_Detail.setText("Account Details");
        account_Detail.setFont(Font.font("",FontWeight.BOLD,12));
        grid.add(account_Detail,1,1,1,1);

        //Row 2
        DatabaseDriver db = new DatabaseDriver();
        System.out.println(accountNumber);;
        Label hello_Label = new Label();
        hello_Label.setFont(Font.font("",FontWeight.NORMAL,13));
        hello_Label.setAlignment(Pos.CENTER);
        String hello_text = "Hello ";
        String sql = "SELECT * "
                + " FROM Person WHERE Pk_Person_Id = " + "\"" + accountNumber + "\"";
        hello_text = hello_text + db.getFirstName(sql)+ " " + db.getLastName(sql);
        hello_Label.setText(hello_text);
        grid.add(hello_Label,1,2,1,1);

        //Row 3
        Label balance_Label = new Label();
        balance_Label.setText("Your balance is: ");
        balance_Label.setFont(Font.font("",FontWeight.BOLD,12));
        grid.add(balance_Label,1,3,1,1);

        sql = "SELECT Balance "
                + "FROM Account WHERE Pk_Account_Id = " + "\"" + accountNumber + "\"";

        Label balance = new Label();
        balance.setAlignment(Pos.CENTER_RIGHT);
        balance.setText("$ " + db.getBalance(sql));
        balance.setFont(Font.font("",FontWeight.NORMAL,12));
        grid.add(balance,2,3,1,1);

        //Start the scene
        Post_Login_Scene = new Scene(grid, 800, 600);
        mainStage.setScene(Post_Login_Scene);
    }

    protected void Profile_Call(String accountNumber){
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER_LEFT);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(10,10,20,20));
        grid.setStyle("-fx-background-color: white");

        //Row 0 (Logo)
        ImageView LogoView = new ImageView();
        LogoView.setImage(Logo);
        LogoView.setFitWidth(Logo.getWidth()/4);
        LogoView.setFitHeight(Logo.getHeight()/4);
        grid.add(LogoView,4,0,1,1);

        //Menu Box
        VBox menu_Box = new VBox();
        menu_Box.setAlignment(Pos.CENTER_LEFT);
        menu_Box.setMinWidth(100);

        Hyperlink overview_Link = new Hyperlink();
        overview_Link.setText("Overview");
        overview_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        overview_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                overview_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        overview_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                overview_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        overview_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Post_Login_Call(accountNumber);
            }
        });
        overview_Link.setBorder(Border.EMPTY);

        Hyperlink profile_Link = new Hyperlink();
        profile_Link.setText("Profile");
        profile_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        profile_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                profile_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        profile_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                profile_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        profile_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Profile_Call(accountNumber);
            }
        });
        profile_Link.setBorder(Border.EMPTY);


        Hyperlink transaction_Link = new Hyperlink();
        transaction_Link.setText("Transaction");
        transaction_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        transaction_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transaction_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        transaction_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transaction_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        transaction_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Withdrawal_Call(accountNumber);
            }
        });
        transaction_Link.setBorder(Border.EMPTY);


        Hyperlink deposit_Link = new Hyperlink();
        deposit_Link.setText("Deposit");
        deposit_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        deposit_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                deposit_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        deposit_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                deposit_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        deposit_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Deposit_Call(accountNumber);
            }
        });
        deposit_Link.setBorder(Border.EMPTY);

        Hyperlink transfer_Link = new Hyperlink();
        transfer_Link.setText("Transfer");
        transfer_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        transfer_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transfer_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        transfer_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transfer_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        transfer_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Transfer_Call(accountNumber);
            }
        });
        transfer_Link.setBorder(Border.EMPTY);

        Hyperlink billpay_Link = new Hyperlink();
        billpay_Link.setText("Bill pay");
        billpay_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        billpay_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                billpay_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        billpay_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                billpay_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        billpay_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Billpay_Call(accountNumber);
            }
        });
        billpay_Link.setBorder(Border.EMPTY);

        Hyperlink logout_Link = new Hyperlink();
        logout_Link.setText("Logout");
        logout_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        logout_Link.setTextFill(Color.RED);
        logout_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                logout_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        logout_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                logout_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        logout_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Login_Scene_Call();
            }
        });
        logout_Link.setBorder(Border.EMPTY);

        Hyperlink help_Link = new Hyperlink();
        help_Link.setText("Help");
        help_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        help_Link.setTextFill(Color.BLUE);
        help_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                help_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        help_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                help_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        help_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Help_Call(accountNumber);
            }
        });
        help_Link.setBorder(Border.EMPTY);

        menu_Box.getChildren().addAll(
                overview_Link,
                profile_Link,
                deposit_Link,
                transfer_Link,
                billpay_Link,
                help_Link,
                logout_Link);
        grid.add(menu_Box,0,2,1,10);
        DatabaseDriver db = new DatabaseDriver();

        //Row 1
        Label profile_Top_Label = new Label();
        profile_Top_Label.setText("Profile");
        profile_Top_Label.setFont(Font.font("",FontWeight.BOLD,14));
        grid.add(profile_Top_Label,1,1,1,1);

        //Row 2
        Label first_Name_Label = new Label();
        first_Name_Label.setText("First name ");
        String sql = "SELECT * "
                + " FROM Person WHERE Pk_Person_Id = " + "\"" + accountNumber + "\"";
        TextField first_Name_Field = new TextField();
        first_Name_Field.setAlignment(Pos.CENTER_LEFT);
        first_Name_Field.setEditable(false);
        first_Name_Field.setText(db.getFirstName(sql));
        grid.add(first_Name_Label,1,2,1,1);
        grid.add(first_Name_Field,2,2,1,1);

        //Row 3
        Label last_Name_Label = new Label();
        last_Name_Label.setText("Last name ");
        TextField last_Name_Field = new TextField();
        last_Name_Field.setAlignment(Pos.CENTER_LEFT);
        last_Name_Field.setEditable(false);
        last_Name_Field.setText(db.getLastName(sql));
        grid.add(last_Name_Label,1,3,1,1);
        grid.add(last_Name_Field,2,3,1,1);

        //Row 4
        Label ssn_Label = new Label();
        ssn_Label.setText("Social Security Number ");
        TextField ssn_Field = new TextField();
        ssn_Field.setAlignment(Pos.CENTER_LEFT);
        ssn_Field.setEditable(false);
        ssn_Field.setText(db.getSSN(sql));
        grid.add(ssn_Label,1,4,1,1);
        grid.add(ssn_Field,2,4,1,1);

        //Row 5
        Label dob_Label = new Label();
        dob_Label.setText("Date of Birth ");
        TextField dob_Field = new TextField();
        dob_Field.setAlignment(Pos.CENTER_LEFT);
        dob_Field.setEditable(false);
        dob_Field.setText(db.getDOB(sql));
        grid.add(dob_Label,1,5,1,1);
        grid.add(dob_Field,2,5,1,1);

        //Row 6
        Label address_Label = new Label();
        address_Label.setText("Address ");
        TextField address_Field = new TextField();
        address_Field.setAlignment(Pos.CENTER_LEFT);
        address_Field.setEditable(false);
        address_Field.setText(db.getADDRESS(sql));
        grid.add(address_Label,1,6,1,1);
        grid.add(address_Field,2,6,1,1);

        //Row 7
        Label city_Label = new Label();
        city_Label.setText("City ");
        TextField city_Field = new TextField();
        city_Field.setAlignment(Pos.CENTER_LEFT);
        city_Field.setEditable(false);
        city_Field.setText(db.getCITY(sql));
        grid.add(city_Label,1,7,1,1);
        grid.add(city_Field,2,7,1,1);

        //Row 8
        Label state_Label = new Label();
        state_Label.setText("State ");
        TextField state_Field = new TextField();
        state_Field.setAlignment(Pos.CENTER_LEFT);
        state_Field.setEditable(false);
        state_Field.setText(db.getSTATE(sql));
        grid.add(state_Label,1,8,1,1);
        grid.add(state_Field,2,8,1,1);

        //Row 9
        Label zip_Label = new Label();
        zip_Label.setText("Zip Code ");
        TextField zip_Field = new TextField();
        zip_Field.setAlignment(Pos.CENTER_LEFT);
        zip_Field.setEditable(false);
        zip_Field.setText(db.getZIPCODE(sql));
        grid.add(zip_Label,1,9,1,1);
        grid.add(zip_Field,2,9,1,1);

        //Row 10
        Label home_Number_Label = new Label();
        home_Number_Label.setText("Home Phone Number ");
        TextField home_Number_Field = new TextField();
        home_Number_Field.setAlignment(Pos.CENTER_LEFT);
        home_Number_Field.setEditable(false);
        home_Number_Field.setText(db.getHOMENUMBER(sql));
        grid.add(home_Number_Label,1,10,1,1);
        grid.add(home_Number_Field,2,10,1,1);

        //Row 11
        Label work_Number_Label = new Label();
        work_Number_Label.setText("Work Phone Number ");
        TextField work_Number_Field = new TextField();
        work_Number_Field.setAlignment(Pos.CENTER_LEFT);
        work_Number_Field.setEditable(false);
        work_Number_Field.setText(db.getWORKNUMBER(sql));
        grid.add(work_Number_Label,1,11,1,1);
        grid.add(work_Number_Field,2,11,1,1);



        //Start the scene
        Profile_Scene = new Scene(grid, 800, 600);
        mainStage.setScene(Profile_Scene);

    }

    protected void Withdrawal_Call(String accountNumber){
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER_LEFT);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(10,10,20,20));
        grid.setStyle("-fx-background-color: white");

        //Row 0 (Logo)
        ImageView LogoView = new ImageView();
        LogoView.setImage(Logo);
        LogoView.setFitWidth(Logo.getWidth()/4);
        LogoView.setFitHeight(Logo.getHeight()/4);
        grid.add(LogoView,4,0,1,1);

        //Menu Box
        VBox menu_Box = new VBox();
        menu_Box.setAlignment(Pos.CENTER_LEFT);
        menu_Box.setMinWidth(100);

        Hyperlink overview_Link = new Hyperlink();
        overview_Link.setText("Overview");
        overview_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        overview_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                overview_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        overview_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                overview_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        overview_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Post_Login_Call(accountNumber);
            }
        });
        overview_Link.setBorder(Border.EMPTY);

        Hyperlink profile_Link = new Hyperlink();
        profile_Link.setText("Profile");
        profile_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        profile_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                profile_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        profile_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                profile_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        profile_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Profile_Call(accountNumber);
            }
        });
        profile_Link.setBorder(Border.EMPTY);


        Hyperlink transaction_Link = new Hyperlink();
        transaction_Link.setText("Transaction");
        transaction_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        transaction_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transaction_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        transaction_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transaction_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        transaction_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Withdrawal_Call(accountNumber);
            }
        });
        transaction_Link.setBorder(Border.EMPTY);


        Hyperlink deposit_Link = new Hyperlink();
        deposit_Link.setText("Deposit");
        deposit_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        deposit_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                deposit_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        deposit_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                deposit_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        deposit_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Deposit_Call(accountNumber);
            }
        });
        deposit_Link.setBorder(Border.EMPTY);

        Hyperlink transfer_Link = new Hyperlink();
        transfer_Link.setText("Transfer");
        transfer_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        transfer_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transfer_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        transfer_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transfer_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        transfer_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Transfer_Call(accountNumber);
            }
        });
        transfer_Link.setBorder(Border.EMPTY);

        Hyperlink billpay_Link = new Hyperlink();
        billpay_Link.setText("Bill pay");
        billpay_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        billpay_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                billpay_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        billpay_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                billpay_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        billpay_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Billpay_Call(accountNumber);
            }
        });
        billpay_Link.setBorder(Border.EMPTY);


        Hyperlink help_Link = new Hyperlink();
        help_Link.setText("Help");
        help_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        help_Link.setTextFill(Color.BLUE);
        help_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                help_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        help_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                help_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        help_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Help_Call(accountNumber);
            }
        });
        help_Link.setBorder(Border.EMPTY);

        Hyperlink logout_Link = new Hyperlink();
        logout_Link.setText("Logout");
        logout_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        logout_Link.setTextFill(Color.RED);
        logout_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                logout_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        logout_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                logout_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        logout_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Login_Scene_Call();
            }
        });
        logout_Link.setBorder(Border.EMPTY);

        menu_Box.getChildren().addAll(
                overview_Link,
                profile_Link,
                deposit_Link,
                transfer_Link,
                billpay_Link,
                help_Link,
                logout_Link);
        grid.add(menu_Box,0,2,1,10);

        String sql = "";

        //Row 1
        Label withdrawal_Label = new Label();
        withdrawal_Label.setText("Transaction History");
        withdrawal_Label.setFont(Font.font("",FontWeight.BOLD,13));
        grid.add(withdrawal_Label,1,1,1,1);

        //Start the scene
        Withdrawal_Scene = new Scene(grid,800,600);
        mainStage.setScene(Withdrawal_Scene);
    }

    protected void Deposit_Call(String accountNumber){
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER_LEFT);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(10,10,20,20));
        grid.setStyle("-fx-background-color: white");

        //Row 0 (Logo)
        ImageView LogoView = new ImageView();
        LogoView.setImage(Logo);
        LogoView.setFitWidth(Logo.getWidth()/4);
        LogoView.setFitHeight(Logo.getHeight()/4);
        grid.add(LogoView,4,0,1,1);

        //Menu Box
        VBox menu_Box = new VBox();
        menu_Box.setAlignment(Pos.CENTER_LEFT);
        menu_Box.setMinWidth(100);

        Hyperlink overview_Link = new Hyperlink();
        overview_Link.setText("Overview");
        overview_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        overview_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                overview_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        overview_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                overview_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        overview_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Post_Login_Call(accountNumber);
            }
        });
        overview_Link.setBorder(Border.EMPTY);

        Hyperlink profile_Link = new Hyperlink();
        profile_Link.setText("Profile");
        profile_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        profile_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                profile_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        profile_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                profile_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        profile_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Profile_Call(accountNumber);
            }
        });
        profile_Link.setBorder(Border.EMPTY);


        Hyperlink transaction_Link = new Hyperlink();
        transaction_Link.setText("Transaction");
        transaction_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        transaction_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transaction_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        transaction_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transaction_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        transaction_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Withdrawal_Call(accountNumber);
            }
        });
        transaction_Link.setBorder(Border.EMPTY);


        Hyperlink deposit_Link = new Hyperlink();
        deposit_Link.setText("Deposit");
        deposit_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        deposit_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                deposit_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        deposit_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                deposit_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        deposit_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Deposit_Call(accountNumber);
            }
        });
        deposit_Link.setBorder(Border.EMPTY);

        Hyperlink transfer_Link = new Hyperlink();
        transfer_Link.setText("Transfer");
        transfer_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        transfer_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transfer_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        transfer_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transfer_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        transfer_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Transfer_Call(accountNumber);
            }
        });
        transfer_Link.setBorder(Border.EMPTY);

        Hyperlink billpay_Link = new Hyperlink();
        billpay_Link.setText("Bill pay");
        billpay_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        billpay_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                billpay_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        billpay_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                billpay_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        billpay_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Billpay_Call(accountNumber);
            }
        });
        billpay_Link.setBorder(Border.EMPTY);


        Hyperlink help_Link = new Hyperlink();
        help_Link.setText("Help");
        help_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        help_Link.setTextFill(Color.BLUE);
        help_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                help_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        help_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                help_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        help_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Help_Call(accountNumber);
            }
        });
        help_Link.setBorder(Border.EMPTY);

        Hyperlink logout_Link = new Hyperlink();
        logout_Link.setText("Logout");
        logout_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        logout_Link.setTextFill(Color.RED);
        logout_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                logout_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        logout_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                logout_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        logout_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Login_Scene_Call();
            }
        });
        logout_Link.setBorder(Border.EMPTY);

        menu_Box.getChildren().addAll(
                overview_Link,
                profile_Link,
                deposit_Link,
                transfer_Link,
                billpay_Link,
                help_Link,
                logout_Link);
        grid.add(menu_Box,0,2,1,10);

        //Row 1
        Label deposit_Label = new Label();
        deposit_Label.setText("Deposit");
        deposit_Label.setFont(Font.font("",FontWeight.BOLD,13));
        grid.add(deposit_Label,1,1,1,1);

        //Row 2
        DatabaseDriver db = new DatabaseDriver();
        Label current_Label = new Label();
        current_Label.setText("Current Balance: $");
        current_Label.setFont(Font.font("",FontWeight.NORMAL, 11));
        grid.add(current_Label,1,2,1,1);
        TextField current_Field = new TextField();
        String sql = "SELECT * FROM Account WHERE Pk_Account_Id = " + accountNumber;
        double current_Balance = Double.valueOf(db.getBalance(sql));
        current_Field.setText(String.valueOf(current_Balance));
        current_Field.setEditable(false);
        grid.add(current_Field,2,2,1,1);

        //Row 3
        Label desire_Label = new Label();
        desire_Label.setText("Enter deposit amount");
        desire_Label.setFont(Font.font("",FontWeight.NORMAL, 11));
        grid.add(desire_Label,1,3,1,1);
        TextField desire_Field = new TextField();
        desire_Field.setPromptText("Enter amount");
        grid.add(desire_Field,2,3,1,1);

        //Row 4
        Label console = new Label();
        console.setTextFill(Color.RED);
        grid.add(console,1,4,4,1);

        //Row 5
        Button submit = new Button();
        submit.setText("Submit");
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (desire_Field.getText().isEmpty()){
                    console.setText("Please enter deposit amount");
                }
                else if (Double.valueOf(desire_Field.getText()) < 0){
                    console.setText("Please enter correct amount");
                }
                else {
                    String sql2 = "SELECT * FROM Account WHERE Pk_Account_Id = " + accountNumber;
                    BankAccountDriver bd = new BankAccountDriver();
                    bd.deposit(Double.valueOf(desire_Field.getText()), Integer.valueOf(accountNumber), Integer.valueOf(db.getBankAccount(sql2)));
                    double new_balance = current_Balance + Double.valueOf(desire_Field.getText());
                    Post_Transaction_Call(accountNumber, new_balance);
                }
            }
        });
        grid.add(submit, 1,5,1,1);

        //Start the scene
        Deposit_Scene = new Scene(grid,800,600);
        mainStage.setScene(Deposit_Scene);
    }

    protected void Transfer_Call(String accountNumber){
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER_LEFT);
        grid.setVgap(5);
        grid.setPadding(new Insets(10,10,20,20));
        grid.setStyle("-fx-background-color: white");

        //Row 0 (Logo)
        ImageView LogoView = new ImageView();
        LogoView.setImage(Logo);
        LogoView.setFitWidth(Logo.getWidth()/4);
        LogoView.setFitHeight(Logo.getHeight()/4);
        grid.add(LogoView,4,0,1,1);

        //Menu Box
        VBox menu_Box = new VBox();
        menu_Box.setAlignment(Pos.CENTER_LEFT);
        menu_Box.setMinWidth(100);

        Hyperlink overview_Link = new Hyperlink();
        overview_Link.setText("Overview");
        overview_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        overview_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                overview_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        overview_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                overview_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        overview_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Post_Login_Call(accountNumber);
            }
        });
        overview_Link.setBorder(Border.EMPTY);

        Hyperlink profile_Link = new Hyperlink();
        profile_Link.setText("Profile");
        profile_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        profile_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                profile_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        profile_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                profile_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        profile_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Profile_Call(accountNumber);
            }
        });
        profile_Link.setBorder(Border.EMPTY);


        Hyperlink transaction_Link = new Hyperlink();
        transaction_Link.setText("Transaction");
        transaction_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        transaction_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transaction_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        transaction_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transaction_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        transaction_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Withdrawal_Call(accountNumber);
            }
        });
        transaction_Link.setBorder(Border.EMPTY);


        Hyperlink deposit_Link = new Hyperlink();
        deposit_Link.setText("Deposit");
        deposit_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        deposit_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                deposit_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        deposit_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                deposit_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        deposit_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Deposit_Call(accountNumber);
            }
        });
        deposit_Link.setBorder(Border.EMPTY);

        Hyperlink transfer_Link = new Hyperlink();
        transfer_Link.setText("Transfer");
        transfer_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        transfer_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transfer_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        transfer_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transfer_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        transfer_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Transfer_Call(accountNumber);
            }
        });
        transfer_Link.setBorder(Border.EMPTY);

        Hyperlink billpay_Link = new Hyperlink();
        billpay_Link.setText("Bill pay");
        billpay_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        billpay_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                billpay_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        billpay_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                billpay_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        billpay_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Billpay_Call(accountNumber);
            }
        });
        billpay_Link.setBorder(Border.EMPTY);


        Hyperlink help_Link = new Hyperlink();
        help_Link.setText("Help");
        help_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        help_Link.setTextFill(Color.BLUE);
        help_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                help_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        help_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                help_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        help_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Help_Call(accountNumber);
            }
        });
        help_Link.setBorder(Border.EMPTY);

        Hyperlink logout_Link = new Hyperlink();
        logout_Link.setText("Logout");
        logout_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        logout_Link.setTextFill(Color.RED);
        logout_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                logout_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        logout_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                logout_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        logout_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Login_Scene_Call();
            }
        });
        logout_Link.setBorder(Border.EMPTY);

        menu_Box.getChildren().addAll(
                overview_Link,
                profile_Link,
                deposit_Link,
                transfer_Link,
                billpay_Link,
                help_Link,
                logout_Link);
        grid.add(menu_Box,0,2,1,10);

        //Row 1
        Label transfer_Label = new Label();
        transfer_Label.setText("Transfer");
        transfer_Label.setFont(Font.font("",FontWeight.BOLD,13));
        grid.add(transfer_Label,1,1,1,1);

        //Row 2
        Label current_acc_Label = new Label();
        current_acc_Label.setText("Your account number ");
        current_acc_Label.setFont(Font.font("",FontWeight.NORMAL,12));
        TextField current_acc_Field = new TextField();
        DatabaseDriver db = new DatabaseDriver();
        String sql = "SELECT Account_Number "
                + "FROM Account WHERE Pk_Account_Id = " + "\"" + accountNumber + "\"";
        current_acc_Field.setText(db.getBankAccount(sql));
        current_acc_Field.setEditable(false);
        current_acc_Field.setStyle("-fx-control-inner-background: lightgrey");
        grid.add(current_acc_Label,1,2,1,1);
        grid.add(current_acc_Field,2,2,1,1);
        //Saving user bank account number to use later
        int user_account_number = Integer.valueOf(db.getBankAccount(sql));

        //Row 3
        Label current_balance_Label = new Label();
        current_balance_Label.setText("Your current balance ");
        current_balance_Label.setFont(Font.font("",FontWeight.NORMAL,12));
        TextField current_balance_Field = new TextField();
        sql = "SELECT Balance "
                + "FROM Account WHERE Pk_Account_Id = " + "\"" + accountNumber + "\"";
        current_balance_Field.setText("$ " + db.getBalance(sql));
        current_balance_Field.setEditable(false);
        current_balance_Field.setStyle("-fx-control-inner-background: lightgrey");
        grid.add(current_balance_Label,1,3,1,1);
        grid.add(current_balance_Field,2,3,1,1);
        //Saving user bank account number to use later
        double user_balance = Double.valueOf(db.getBalance(sql));

        //Row 4
        Label destination_Label = new Label();
        destination_Label.setText("Designated account number ");
        destination_Label.setFont(Font.font("",FontWeight.NORMAL,12));
        TextField destination_Field = new TextField();
        grid.add(destination_Label,1,4,1,1);
        grid.add(destination_Field,2,4,1,1);

        //Row 5
        Label destination_balance_Label = new Label();
        destination_balance_Label.setText("Transfer amount ");
        destination_balance_Label.setFont(Font.font("",FontWeight.NORMAL,12));
        TextField destination_balance_Field = new TextField();
        grid.add(destination_balance_Label,1,5,1,1);
        grid.add(destination_balance_Field,2,5,1,1);

        //Row 6
        Button submit = new Button();
        submit.setText("Submit");
        Label console = new Label();
        console.setTextFill(Color.RED);
        grid.add(submit,1,6,1,1);
        grid.add(console,2,6,7,1);
        db.viewTable("Account");
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{
                    if (Double.valueOf(destination_balance_Field.getText()) > user_balance){
                        console.setText("Insufficient balance");
                    }
                    else if (Double.valueOf(destination_balance_Field.getText()) == 0 || destination_balance_Field.getText().isEmpty()){
                        console.setText("Enter amount");
                    }
                    else if (Double.valueOf(destination_balance_Field.getText()) < 0){
                        console.setText("Enter valid amount");
                    }
                    else{
                        String sql2 = "SELECT * FROM Account WHERE Account_Number = " + destination_Field.getText();
                        BankAccountDriver bd = new BankAccountDriver();
                        bd.withdraw(Double.valueOf(destination_balance_Field.getText()),
                                Integer.valueOf(accountNumber),
                                user_account_number);
                        bd.deposit(Double.valueOf(destination_balance_Field.getText()),
                                Integer.valueOf(db.getAccountNumber3(sql2)),
                                Integer.valueOf(destination_Field.getText()));
                        Post_Transaction_Call(accountNumber, user_balance -
                                Double.valueOf(destination_balance_Field.getText()));
                    }
                } catch (Exception e){
                    console.setText("Enter valid amount and account number");
                }
                System.out.println("Success!");
            }
        });
        Transfer_Scene = new Scene(grid,800,600);
        mainStage.setScene(Transfer_Scene);

    }

    protected void Billpay_Call(String accountNumber){
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER_LEFT);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(10,10,20,20));
        grid.setStyle("-fx-background-color: white");

        //Row 0 (Logo)
        ImageView LogoView = new ImageView();
        LogoView.setImage(Logo);
        LogoView.setFitWidth(Logo.getWidth()/4);
        LogoView.setFitHeight(Logo.getHeight()/4);
        grid.add(LogoView,4,0,1,1);

        //Menu Box
        VBox menu_Box = new VBox();
        menu_Box.setAlignment(Pos.CENTER_LEFT);
        menu_Box.setMinWidth(100);

        Hyperlink overview_Link = new Hyperlink();
        overview_Link.setText("Overview");
        overview_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        overview_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                overview_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        overview_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                overview_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        overview_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Post_Login_Call(accountNumber);
            }
        });
        overview_Link.setBorder(Border.EMPTY);

        Hyperlink profile_Link = new Hyperlink();
        profile_Link.setText("Profile");
        profile_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        profile_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                profile_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        profile_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                profile_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        profile_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Profile_Call(accountNumber);
            }
        });
        profile_Link.setBorder(Border.EMPTY);


        Hyperlink transaction_Link = new Hyperlink();
        transaction_Link.setText("Transaction");
        transaction_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        transaction_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transaction_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        transaction_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transaction_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        transaction_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Withdrawal_Call(accountNumber);
            }
        });
        transaction_Link.setBorder(Border.EMPTY);


        Hyperlink deposit_Link = new Hyperlink();
        deposit_Link.setText("Deposit");
        deposit_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        deposit_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                deposit_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        deposit_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                deposit_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        deposit_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Deposit_Call(accountNumber);
            }
        });
        deposit_Link.setBorder(Border.EMPTY);

        Hyperlink transfer_Link = new Hyperlink();
        transfer_Link.setText("Transfer");
        transfer_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        transfer_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transfer_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        transfer_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transfer_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        transfer_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Transfer_Call(accountNumber);
            }
        });
        transfer_Link.setBorder(Border.EMPTY);

        Hyperlink billpay_Link = new Hyperlink();
        billpay_Link.setText("Bill pay");
        billpay_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        billpay_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                billpay_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        billpay_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                billpay_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        billpay_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Billpay_Call(accountNumber);
            }
        });
        billpay_Link.setBorder(Border.EMPTY);


        Hyperlink help_Link = new Hyperlink();
        help_Link.setText("Help");
        help_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        help_Link.setTextFill(Color.BLUE);
        help_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                help_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        help_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                help_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        help_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Help_Call(accountNumber);
            }
        });
        help_Link.setBorder(Border.EMPTY);

        Hyperlink logout_Link = new Hyperlink();
        logout_Link.setText("Logout");
        logout_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        logout_Link.setTextFill(Color.RED);
        logout_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                logout_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        logout_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                logout_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        logout_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Login_Scene_Call();
            }
        });
        logout_Link.setBorder(Border.EMPTY);

        menu_Box.getChildren().addAll(
                overview_Link,
                profile_Link,
                deposit_Link,
                transfer_Link,
                billpay_Link,
                help_Link,
                logout_Link);
        grid.add(menu_Box,0,2,1,10);

        //Row 1
        Label transfer_Label = new Label();
        transfer_Label.setText("Bill Pay");
        transfer_Label.setFont(Font.font("",FontWeight.BOLD,13));
        grid.add(transfer_Label,1,1,1,1);

        //Row 2
        Label current_acc_Label = new Label();
        current_acc_Label.setText("Your account number ");
        current_acc_Label.setFont(Font.font("",FontWeight.NORMAL,12));
        TextField current_acc_Field = new TextField();
        DatabaseDriver db = new DatabaseDriver();
        String sql = "SELECT Account_Number "
                + "FROM Account WHERE Pk_Account_Id = " + "\"" + accountNumber + "\"";
        current_acc_Field.setText(db.getBankAccount(sql));
        current_acc_Field.setEditable(false);
        current_acc_Field.setStyle("-fx-control-inner-background: lightgrey");
        grid.add(current_acc_Label,1,2,1,1);
        grid.add(current_acc_Field,2,2,1,1);
        //Saving user bank account number to use later
        int user_account_number = Integer.valueOf(db.getBankAccount(sql));

        //Row 3
        Label current_balance_Label = new Label();
        current_balance_Label.setText("Your current balance ");
        current_balance_Label.setFont(Font.font("",FontWeight.NORMAL,12));
        TextField current_balance_Field = new TextField();
        sql = "SELECT Balance "
                + "FROM Account WHERE Pk_Account_Id = " + "\"" + accountNumber + "\"";
        current_balance_Field.setText("$ " + db.getBalance(sql));
        current_balance_Field.setEditable(false);
        current_balance_Field.setStyle("-fx-control-inner-background: lightgrey");
        grid.add(current_balance_Label,1,3,1,1);
        grid.add(current_balance_Field,2,3,1,1);
        //Saving user bank account number to use later
        double user_balance = Double.valueOf(db.getBalance(sql));

        //Row 4
        Label company_Label = new Label();
        company_Label.setText("Company name");
        company_Label.setFont(Font.font("",FontWeight.NORMAL,12));
        TextField company_Field = new TextField();
        grid.add(company_Label,1,4,1,1);
        grid.add(company_Field,2,4,1,1);

        //Row 5
        Label destination_Label = new Label();
        destination_Label.setText("Designated account number ");
        destination_Label.setFont(Font.font("",FontWeight.NORMAL,12));
        TextField destination_Field = new TextField();
        grid.add(destination_Label,1,5,1,1);
        grid.add(destination_Field,2,5,1,1);

        //Row 6
        Label destination_balance_Label = new Label();
        destination_balance_Label.setText("Pay amount ");
        destination_balance_Label.setFont(Font.font("",FontWeight.NORMAL,12));
        TextField destination_balance_Field = new TextField();
        grid.add(destination_balance_Label,1,6,1,1);
        grid.add(destination_balance_Field,2,6,1,1);

        //Row 7
        Button submit = new Button();
        submit.setText("Submit");
        Label console = new Label();
        console.setTextFill(Color.RED);
        grid.add(submit,1,7,1,1);
        grid.add(console,2,7,7,1);
        db.viewTable("Account");
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{
                    if (Double.valueOf(destination_balance_Field.getText()) > user_balance){
                        console.setText("Insufficient balance");
                    }
                    else if (Double.valueOf(destination_balance_Field.getText()) == 0 || destination_balance_Field.getText().isEmpty()){
                        console.setText("Enter amount");
                    }
                    else if (Double.valueOf(destination_balance_Field.getText()) < 0){
                        console.setText("Enter valid amount");
                    }
                    else{
                        String sql2 = "SELECT * FROM Account WHERE Account_Number = " + destination_Field.getText();
                        BankAccountDriver bd = new BankAccountDriver();
                        bd.withdraw(Double.valueOf(destination_balance_Field.getText()),
                                Integer.valueOf(accountNumber),
                                user_account_number);
                        bd.deposit(Double.valueOf(destination_balance_Field.getText()),
                                Integer.valueOf(db.getAccountNumber3(sql2)),
                                Integer.valueOf(destination_Field.getText()));
                        Post_BillPay_Call(accountNumber, company_Field.getText(),user_balance -
                                Double.valueOf(destination_balance_Field.getText()));
                    }
                } catch (Exception e){
                    console.setText("Enter valid amount and account number");
                }
                System.out.println("Success!");
            }
        });

        Billpay_Scene = new Scene(grid,800,600);
        mainStage.setScene(Billpay_Scene);
    }

    protected void Help_Call(String accountNumber){
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER_LEFT);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(10,10,20,20));
        grid.setStyle("-fx-background-color: white");

        //Row 0 (Logo)
        ImageView LogoView = new ImageView();
        LogoView.setImage(Logo);
        LogoView.setFitWidth(Logo.getWidth()/4);
        LogoView.setFitHeight(Logo.getHeight()/4);
        grid.add(LogoView,4,0,1,1);

        //Menu Box
        VBox menu_Box = new VBox();
        menu_Box.setAlignment(Pos.CENTER_LEFT);
        menu_Box.setMinWidth(100);

        Hyperlink overview_Link = new Hyperlink();
        overview_Link.setText("Overview");
        overview_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        overview_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                overview_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        overview_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                overview_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        overview_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Post_Login_Call(accountNumber);
            }
        });
        overview_Link.setBorder(Border.EMPTY);

        Hyperlink profile_Link = new Hyperlink();
        profile_Link.setText("Profile");
        profile_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        profile_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                profile_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        profile_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                profile_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        profile_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Profile_Call(accountNumber);
            }
        });
        profile_Link.setBorder(Border.EMPTY);


        Hyperlink transaction_Link = new Hyperlink();
        transaction_Link.setText("Transaction");
        transaction_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        transaction_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transaction_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        transaction_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transaction_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        transaction_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Withdrawal_Call(accountNumber);
            }
        });
        transaction_Link.setBorder(Border.EMPTY);


        Hyperlink deposit_Link = new Hyperlink();
        deposit_Link.setText("Deposit");
        deposit_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        deposit_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                deposit_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        deposit_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                deposit_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        deposit_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Deposit_Call(accountNumber);
            }
        });
        deposit_Link.setBorder(Border.EMPTY);

        Hyperlink transfer_Link = new Hyperlink();
        transfer_Link.setText("Transfer");
        transfer_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        transfer_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transfer_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        transfer_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transfer_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        transfer_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Transfer_Call(accountNumber);
            }
        });
        transfer_Link.setBorder(Border.EMPTY);

        Hyperlink billpay_Link = new Hyperlink();
        billpay_Link.setText("Bill pay");
        billpay_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        billpay_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                billpay_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        billpay_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                billpay_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        billpay_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Billpay_Call(accountNumber);
            }
        });
        billpay_Link.setBorder(Border.EMPTY);


        Hyperlink help_Link = new Hyperlink();
        help_Link.setText("Help");
        help_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        help_Link.setTextFill(Color.BLUE);
        help_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                help_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        help_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                help_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        help_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Help_Call(accountNumber);
            }
        });
        help_Link.setBorder(Border.EMPTY);

        Hyperlink logout_Link = new Hyperlink();
        logout_Link.setText("Logout");
        logout_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        logout_Link.setTextFill(Color.RED);
        logout_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                logout_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        logout_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                logout_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        logout_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Login_Scene_Call();
            }
        });
        logout_Link.setBorder(Border.EMPTY);

        menu_Box.getChildren().addAll(
                overview_Link,
                profile_Link,
                deposit_Link,
                transfer_Link,
                billpay_Link,
                help_Link,
                logout_Link);
        grid.add(menu_Box,0,2,1,10);

        Help help= new Help();

        help.FAQ(grid);
        help.contact(grid);
        help.privacy(grid);



        //Start the scene
        Help_Scene = new Scene(grid,800,600);
        mainStage.setScene(Help_Scene);
    }

    protected void Post_Transaction_Call(String accountNumber, double balance){
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER_LEFT);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(10,10,20,20));
        grid.setStyle("-fx-background-color: white");

        //Row 0 (Logo)
        ImageView LogoView = new ImageView();
        LogoView.setImage(Logo);
        LogoView.setFitWidth(Logo.getWidth()/4);
        LogoView.setFitHeight(Logo.getHeight()/4);
        grid.add(LogoView,4,0,1,1);

        //Menu Box
        VBox menu_Box = new VBox();
        menu_Box.setAlignment(Pos.CENTER_LEFT);
        menu_Box.setMinWidth(100);

        Hyperlink overview_Link = new Hyperlink();
        overview_Link.setText("Overview");
        overview_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        overview_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                overview_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        overview_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                overview_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        overview_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Post_Login_Call(accountNumber);
            }
        });
        overview_Link.setBorder(Border.EMPTY);

        Hyperlink profile_Link = new Hyperlink();
        profile_Link.setText("Profile");
        profile_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        profile_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                profile_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        profile_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                profile_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        profile_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Profile_Call(accountNumber);
            }
        });
        profile_Link.setBorder(Border.EMPTY);


        Hyperlink transaction_Link = new Hyperlink();
        transaction_Link.setText("Transaction");
        transaction_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        transaction_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transaction_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        transaction_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transaction_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        transaction_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Withdrawal_Call(accountNumber);
            }
        });
        transaction_Link.setBorder(Border.EMPTY);


        Hyperlink deposit_Link = new Hyperlink();
        deposit_Link.setText("Deposit");
        deposit_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        deposit_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                deposit_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        deposit_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                deposit_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        deposit_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Deposit_Call(accountNumber);
            }
        });
        deposit_Link.setBorder(Border.EMPTY);

        Hyperlink transfer_Link = new Hyperlink();
        transfer_Link.setText("Transfer");
        transfer_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        transfer_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transfer_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        transfer_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transfer_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        transfer_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Transfer_Call(accountNumber);
            }
        });
        transfer_Link.setBorder(Border.EMPTY);

        Hyperlink billpay_Link = new Hyperlink();
        billpay_Link.setText("Bill pay");
        billpay_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        billpay_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                billpay_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        billpay_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                billpay_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        billpay_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Billpay_Call(accountNumber);
            }
        });
        billpay_Link.setBorder(Border.EMPTY);


        Hyperlink help_Link = new Hyperlink();
        help_Link.setText("Help");
        help_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        help_Link.setTextFill(Color.BLUE);
        help_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                help_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        help_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                help_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        help_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Help_Call(accountNumber);
            }
        });
        help_Link.setBorder(Border.EMPTY);

        Hyperlink logout_Link = new Hyperlink();
        logout_Link.setText("Logout");
        logout_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        logout_Link.setTextFill(Color.RED);
        logout_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                logout_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        logout_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                logout_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        logout_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Login_Scene_Call();
            }
        });
        logout_Link.setBorder(Border.EMPTY);

        menu_Box.getChildren().addAll(
                overview_Link,
                profile_Link,
                deposit_Link,
                transfer_Link,
                billpay_Link,
                help_Link,
                logout_Link);
        grid.add(menu_Box,0,2,1,10);

        //Row 1
        Label post_trans_Label = new Label();
        post_trans_Label.setText("Your transaction was successful");
        post_trans_Label.setFont(Font.font("",FontWeight.BOLD,13));
        grid.add(post_trans_Label, 1,1,1,1);

        //Row 2
        Label post_Trans_balance_Label = new Label();
        post_Trans_balance_Label.setText("Your new balance is: $" + balance);
        post_Trans_balance_Label.setFont(Font.font("",FontWeight.NORMAL,11));
        grid.add(post_Trans_balance_Label, 1,2,1,1);

        Post_Transaction_Scene = new Scene(grid,800,600);
        mainStage.setScene(Post_Transaction_Scene);
    }

    protected void Post_BillPay_Call(String accountNumber, String company, double balance){
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER_LEFT);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(10,10,20,20));
        grid.setStyle("-fx-background-color: white");

        //Row 0 (Logo)
        ImageView LogoView = new ImageView();
        LogoView.setImage(Logo);
        LogoView.setFitWidth(Logo.getWidth()/4);
        LogoView.setFitHeight(Logo.getHeight()/4);
        grid.add(LogoView,4,0,1,1);

        //Menu Box
        VBox menu_Box = new VBox();
        menu_Box.setAlignment(Pos.CENTER_LEFT);
        menu_Box.setMinWidth(100);

        Hyperlink overview_Link = new Hyperlink();
        overview_Link.setText("Overview");
        overview_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        overview_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                overview_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        overview_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                overview_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        overview_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Post_Login_Call(accountNumber);
            }
        });
        overview_Link.setBorder(Border.EMPTY);

        Hyperlink profile_Link = new Hyperlink();
        profile_Link.setText("Profile");
        profile_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        profile_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                profile_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        profile_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                profile_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        profile_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Profile_Call(accountNumber);
            }
        });
        profile_Link.setBorder(Border.EMPTY);


        Hyperlink transaction_Link = new Hyperlink();
        transaction_Link.setText("Transaction");
        transaction_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        transaction_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transaction_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        transaction_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transaction_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        transaction_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Withdrawal_Call(accountNumber);
            }
        });
        transaction_Link.setBorder(Border.EMPTY);


        Hyperlink deposit_Link = new Hyperlink();
        deposit_Link.setText("Deposit");
        deposit_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        deposit_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                deposit_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        deposit_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                deposit_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        deposit_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Deposit_Call(accountNumber);
            }
        });
        deposit_Link.setBorder(Border.EMPTY);

        Hyperlink transfer_Link = new Hyperlink();
        transfer_Link.setText("Transfer");
        transfer_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        transfer_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transfer_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        transfer_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transfer_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        transfer_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Transfer_Call(accountNumber);
            }
        });
        transfer_Link.setBorder(Border.EMPTY);

        Hyperlink billpay_Link = new Hyperlink();
        billpay_Link.setText("Bill pay");
        billpay_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        billpay_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                billpay_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        billpay_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                billpay_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        billpay_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Billpay_Call(accountNumber);
            }
        });
        billpay_Link.setBorder(Border.EMPTY);


        Hyperlink help_Link = new Hyperlink();
        help_Link.setText("Help");
        help_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        help_Link.setTextFill(Color.BLUE);
        help_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                help_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        help_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                help_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        help_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Help_Call(accountNumber);
            }
        });
        help_Link.setBorder(Border.EMPTY);

        Hyperlink logout_Link = new Hyperlink();
        logout_Link.setText("Logout");
        logout_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
        logout_Link.setTextFill(Color.RED);
        logout_Link.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                logout_Link.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        logout_Link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                logout_Link.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        logout_Link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Login_Scene_Call();
            }
        });
        logout_Link.setBorder(Border.EMPTY);

        menu_Box.getChildren().addAll(
                overview_Link,
                profile_Link,
                deposit_Link,
                transfer_Link,
                billpay_Link,
                help_Link,
                logout_Link);
        grid.add(menu_Box,0,2,1,10);

        //Row 1
        Label post_trans_Label = new Label();
        post_trans_Label.setText("Your Billpay to " + company +" was successful");
        post_trans_Label.setFont(Font.font("",FontWeight.BOLD,13));
        grid.add(post_trans_Label, 1,1,1,1);

        //Row 2
        Label post_Trans_balance_Label = new Label();
        post_Trans_balance_Label.setText("Your new balance is: $" + balance);
        post_Trans_balance_Label.setFont(Font.font("",FontWeight.NORMAL,11));
        grid.add(post_Trans_balance_Label, 1,2,1,1);

        Post_Transaction_Scene = new Scene(grid,800,600);
        mainStage.setScene(Post_Transaction_Scene);
    }


    protected void Reset_Password_Call(String accountNumber){
        //Main Gridpane set up
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(10, 10, 20, 20));
        grid.setStyle("-fx-background-color: white");

        //Row 0 (Logo)
        ImageView LogoView = new ImageView();
        LogoView.setImage(Logo);
        LogoView.setFitWidth(Logo.getWidth() / 4);
        LogoView.setFitHeight(Logo.getHeight() / 4);
        grid.add(LogoView, 4, 0, 3, 1);

        //Row 1
        Label reset_Label = new Label();
        reset_Label.setText("Reset Password");
        reset_Label.setFont(Font.font("",FontWeight.NORMAL,13));
        grid.add(reset_Label,0,1,1,1);

        //Row 2
        Label new_Pass_Label = new Label();
        new_Pass_Label.setText("Enter new password ");
        PasswordField new_pass_Field = new PasswordField();
        grid.add(new_Pass_Label,0,2,1,1);
        grid.add(new_pass_Field,1,2,1,1);

        //Row 3
        Label new_Pass_Label2 = new Label();
        new_Pass_Label2.setText("Confirm new password ");
        PasswordField new_pass_Field2 = new PasswordField();
        grid.add(new_Pass_Label2,0,3,1,1);
        grid.add(new_pass_Field2,1,3,1,1);

        //Row 4
        Text console = new Text();
        console.setFill(Color.RED);
        grid.add(console, 0,4,6,1);

        //Row 5
        Button submit = new Button();
        submit.setText("Submit");
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (new_pass_Field.getText().equals(new_pass_Field2.getText())){
                    BankAccountDriver bd = new BankAccountDriver();
                    bd.reset_Password(new_pass_Field.getText(),Integer.valueOf(accountNumber));
                    Reset_Password_Success_Call();
                }
                else{
                    console.setText("Passwords does not match");
                }
            }
        });
        grid.add(submit,0,5,1,1);

        Reset_Password_Scene = new Scene(grid,800,600);
        mainStage.setScene(Reset_Password_Scene);
    }

    protected void Reset_Password_Success_Call(){
        //Main Gridpane set up
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(10, 10, 20, 20));
        grid.setStyle("-fx-background-color: white");

        //Row 0 (Logo)
        ImageView LogoView = new ImageView();
        LogoView.setImage(Logo);
        LogoView.setFitWidth(Logo.getWidth() / 4);
        LogoView.setFitHeight(Logo.getHeight() / 4);
        grid.add(LogoView, 4, 0, 3, 1);

        //Row 1
        Label reset_Label = new Label();
        reset_Label.setText("Password has been reseted. Please use your new password to login");
        reset_Label.setFont(Font.font("",FontWeight.NORMAL,13));
        grid.add(reset_Label,0,1,1,1);

        //Row 2
        Button back = new Button();
        back = Cancel_Button();
        back.setText("Back");
        grid.add(back,0,2,1,1);

        Reset_Password_Success_Scene = new Scene(grid,800,600);
        mainStage.setScene(Reset_Password_Success_Scene);
    }

    protected Button Cancel_Button() {
        Button cancel_Button = new Button("Cancel");
        cancel_Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainStage.setScene(Login_Scene);
            }
        });
        return cancel_Button;
    }


    /**
     * @return red-colored * to be used in various labels
     */
    public Text red_star() {
        //Red Star
        Text rs = new Text();
        rs.setText("*");
        rs.setFill(Color.RED);
        return rs;
    }
}
