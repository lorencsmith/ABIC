import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;

/**
 * Created by Daniel Oh on 3/22/2017.
 * This is Display class for ABIC
 */
public class Display extends Application{

    Stage mainStage;
    Scene Login_Scene, Forgot_Password_Scene, Enroll_Scene, Employee_Login_Scene, User_Login_Scene;
    File file = new File(".");
    Image Logo = new Image("ABIC_Logo.png");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        mainStage = primaryStage;
        Login_Scene_Call();
        mainStage.setTitle("ABIC");
        mainStage.show();
    }

    public void Login_Scene_Call(){
        //Main Gridpane set up
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(10,10,20,20));
        grid.setStyle("-fx-background-color: white");

        //Row 1 (Logo)
        ImageView LogoView = new ImageView();
        LogoView.setImage(Logo);
        LogoView.setFitWidth(Logo.getWidth() / 4);
        LogoView.setFitHeight(Logo.getHeight() / 4);
        grid.add(LogoView, 6,0,3,1);

        //Row 2
        Button Employee_Login_Button = new Button("Employee Login");
        Employee_Login_Button.setAlignment(Pos.CENTER);
        Employee_Login_Button.setPadding(new Insets(5,5,5,5));
        Employee_Login_Button.setFont(Font.font("Tahoma", FontWeight.BOLD, 12));
        Employee_Login_Button.setMinWidth(200);
        grid.add(Employee_Login_Button,0,2,2,1);
        Employee_Login_Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Employee_Login_Call();
            }
        });

        //Row3
        Button User_Login_Button = new Button("User Login");
        User_Login_Button.setAlignment(Pos.CENTER);
        User_Login_Button.setPadding(new Insets(5,5,5,5));
        User_Login_Button.setFont(Font.font("Tahoma", FontWeight.BOLD, 12));
        User_Login_Button.setMinWidth(200);
        grid.add(User_Login_Button,0,3,2,1);
        User_Login_Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                User_Login_Call();
            }
        });

        //Row4
        Button Enroll_Button = new Button("Enroll");
        Enroll_Button.setAlignment(Pos.CENTER);
        Enroll_Button.setPadding(new Insets(5,5,5,5));
        Enroll_Button.setFont(Font.font("Tahoma", FontWeight.BOLD, 12));
        Enroll_Button.setMinWidth(70);
        grid.add(Enroll_Button, 0, 4, 1,1);

        Enroll_Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Enroll_Call();
            }
        });

        Button Forgot_Button = new Button("Forgot Password");
        Forgot_Button.setAlignment(Pos.CENTER);
        Forgot_Button.setPadding(new Insets(5,5,5,5));
        Forgot_Button.setFont(Font.font("Tahoma", FontWeight.BOLD, 12));
        Forgot_Button.setMinWidth(125);
        grid.add(Forgot_Button,1,4,1,1);

        Forgot_Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Forgot_Password_Call();
            }
        });
        Login_Scene = new Scene(grid, 800,600);
        mainStage.setScene(Login_Scene);

    }

    public void Employee_Login_Call(){
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(10,10,20,20));
        grid.setStyle("-fx-background-color: white");

        //Row 0 (Logo)
        ImageView LogoView = new ImageView();
        LogoView.setImage(Logo);
        LogoView.setFitWidth(Logo.getWidth()/4);
        LogoView.setFitHeight(Logo.getHeight()/4);
        grid.add(LogoView,6,0,3,1);

        //Row 1
        Label welcome = new Label();
        welcome.setText("Welcome to ABIC");
        welcome.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
        grid.add(welcome, 0,1,2,1);

        //Row 2
        Label user_Label = new Label();
        user_Label.setText("Username");
        user_Label.setFont(Font.font("",FontWeight.NORMAL,12));
        user_Label.setAlignment(Pos.CENTER_LEFT);
        grid.add(user_Label,1,2,1,1);

        //Row 3
        TextField user_Field = new TextField();
        grid.add(user_Field, 1, 3,1,1);

        //Row 4


        //Row 5
        Label password_Label = new Label();
        password_Label.setText("Password");
        password_Label.setFont(Font.font("",FontWeight.NORMAL,12));
        password_Label.setAlignment(Pos.CENTER_LEFT);
        grid.add(password_Label,1,5,1,1);

        //Row 6
        TextField password_Field = new TextField();
        grid.add(password_Field, 1, 6,1,1);

        //Row 7
        HBox button_Box = new HBox();
        button_Box.setAlignment(Pos.CENTER_RIGHT);
        button_Box.setSpacing(5);
        Button submit = new Button();
        submit.setText("Submit");
        submit.setAlignment(Pos.CENTER);
        button_Box.getChildren().addAll(Cancel_Button(),submit);
        grid.add(button_Box,1,7,1,1);
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String username = user_Field.getText();
                String password = password_Field.getText();
                //Validate username and password
                //Search DB
            }
        });

        //Start the Scene
        Employee_Login_Scene = new Scene(grid,800,600);
        mainStage.setScene(Employee_Login_Scene);
    }

    public void User_Login_Call(){
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(10,10,20,20));
        grid.setStyle("-fx-background-color: white");

        //Row 0 (Logo)
        ImageView LogoView = new ImageView();
        LogoView.setImage(Logo);
        LogoView.setFitWidth(Logo.getWidth()/4);
        LogoView.setFitHeight(Logo.getHeight()/4);
        grid.add(LogoView,6,0,3,1);

        //Row 1
        Label welcome = new Label();
        welcome.setText("Welcome Back to ABIC");
        welcome.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
        grid.add(welcome, 0,1,2,1);

        //Row 2
        Label user_Label = new Label();
        user_Label.setText("Username");
        user_Label.setFont(Font.font("",FontWeight.NORMAL,12));
        user_Label.setAlignment(Pos.CENTER_LEFT);
        grid.add(user_Label,1,2,1,1);

        //Row 3
        TextField user_Field = new TextField();
        grid.add(user_Field, 1, 3,1,1);

        //Row 4


        //Row 5
        Label password_Label = new Label();
        password_Label.setText("Password");
        password_Label.setFont(Font.font("",FontWeight.NORMAL,12));
        password_Label.setAlignment(Pos.CENTER_LEFT);
        grid.add(password_Label,1,5,1,1);

        //Row 6
        TextField password_Field = new TextField();
        grid.add(password_Field, 1, 6,1,1);

        //Row 7
        HBox button_Box = new HBox();
        button_Box.setAlignment(Pos.CENTER_RIGHT);
        button_Box.setSpacing(5);
        Button submit = new Button();
        submit.setText("Submit");
        submit.setAlignment(Pos.CENTER);
        button_Box.getChildren().addAll(Cancel_Button(),submit);
        grid.add(button_Box,1,7,1,1);
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String username = user_Field.getText();
                String password = password_Field.getText();
                //Validate username and password
                //Search DB
            }
        });

        //Start the Scene
        User_Login_Scene = new Scene(grid,800,600);
        mainStage.setScene(User_Login_Scene);
    }

    public void Forgot_Password_Call(){
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(10,10,20,20));
        grid.setStyle("-fx-background-color: white");

        //Row 0 (Logo)
        ImageView LogoView = new ImageView();
        LogoView.setImage(Logo);
        LogoView.setFitWidth(Logo.getWidth()/4);
        LogoView.setFitHeight(Logo.getHeight()/4);
        grid.add(LogoView,6,0,3,1);

        //Row 1
        Label Forgot_Password_Label = new Label("Forgot Password");
        Forgot_Password_Label.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
        grid.add(Forgot_Password_Label,0,1,2,1);


        //Row 2
        Label reset_password_info = new Label("Reset Password through:");
        reset_password_info.setFont(Font.font("Calibri", FontWeight.NORMAL, 11));
        grid.add(reset_password_info,0,2,2,1);

        //Row 3
        Label email_label = new Label();
        email_label.setText("○ E-mail verification:");
        email_label.setFont(Font.font("Calibri", FontWeight.NORMAL, 11));
        TextField email_Field = new TextField();
        email_Field.setPromptText("Enter email");
        grid.add(email_label, 1,3,1,1);
        grid.add(email_Field, 2,3,2,1);

        //Row 4
        Label mobile_label = new Label();
        mobile_label.setText("○ Mobile number:");
        mobile_label.setFont(Font.font("Calibri", FontWeight.NORMAL, 11));
        TextField mobile_Field = new TextField();
        mobile_Field.setPromptText("Enter mobile number");
        grid.add(mobile_label, 1,4,1,1);
        grid.add(mobile_Field,2,4,2,1);

        //Row 5
        Label empty_label = new Label(" ");
        grid.add(empty_label,0,5,1,1);

        //Row 6
        Label ssn_Label = new Label();
        ssn_Label.setText("Please verify your Social Security Number: ");
        ssn_Label.setFont(Font.font("Calibri", FontWeight.NORMAL, 11));
        TextField ssn_Field = new TextField();
        ssn_Field.setPromptText("___-__-____");
        grid.add(ssn_Label, 0,6,2,1);
        grid.add(ssn_Field,2,6,2,1);

        //Row 7
        Button submit_Button = new Button("Submit");
        submit_Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Validate information on textfields
                //Search Database and return informations.
            }
        });
        HBox button_Box = new HBox();
        button_Box.setSpacing(5);
        button_Box.setPadding(new Insets(5,5,5,5));
        button_Box.getChildren().addAll(Cancel_Button(),submit_Button);
        grid.add(button_Box, 0,7,3,1);

        //Change the Scene
        Forgot_Password_Scene = new Scene(grid, 800,600);
        mainStage.setScene(Forgot_Password_Scene);
    }

    public void Enroll_Call(){
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(10,10,20,20));
        grid.setStyle("-fx-background-color: white");

        //Row 0
        ImageView LogoView = new ImageView();
        LogoView.setImage(Logo);
        LogoView.setFitWidth(Logo.getWidth()/4);
        LogoView.setFitHeight(Logo.getHeight()/4);
        grid.add(LogoView,6,0,3,1);

        //Row 1
        Label Welcome_Logo = new Label();
        Welcome_Logo.setText("Welcome to ABIC Banking Enrollment");
        Welcome_Logo.setFont(Font.font("Calibri", FontWeight.BOLD, 13));
        grid.add(Welcome_Logo,0,1,3,1);

        //Row 2
        Label Info_Logo = new Label();
        Info_Logo.setText("Please enter your information in the spaces provided below");
        Info_Logo.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
        grid.add(Info_Logo,0,2,3,1);

        //Row 3
        HBox First_Name_Box = new HBox();
        First_Name_Box.setAlignment(Pos.CENTER_LEFT);
        Label First_Name_Label = new Label();
        First_Name_Label.setText("First Name");
        First_Name_Label.setFont(Font.font("",FontWeight.BOLD, 11));
        First_Name_Box.getChildren().addAll(First_Name_Label,red_star());
        TextField First_Name_Field = new TextField();
        First_Name_Field.setPromptText("Enter First Name");
        grid.add(First_Name_Box,0,3,1,1);
        grid.add(First_Name_Field, 1, 3,1,1);

        //Row 4
        Label First_Name_Info = new Label();
        First_Name_Info.setText("Enter your first name as it appears on your primary billing account.");
        First_Name_Info.setFont(Font.font("",FontWeight.NORMAL, 11));
        grid.add(First_Name_Info, 0,4,3,1);

        //Row 5
        HBox Last_Name_Box = new HBox();
        Last_Name_Box.setAlignment(Pos.CENTER_LEFT);
        Label Last_Name_Label = new Label();
        Last_Name_Label.setText("Last Name");
        Last_Name_Label.setFont(Font.font("",FontWeight.BOLD, 11));
        Last_Name_Box.getChildren().addAll(Last_Name_Label,red_star());
        TextField Last_Name_Field = new TextField();
        Last_Name_Field.setPromptText("Enter Last Name");
        grid.add(Last_Name_Box,0,5,1,1);
        grid.add(Last_Name_Field, 1, 5,1,1);

        //Row 6
        Label Last_Name_Info = new Label();
        Last_Name_Info.setText("Enter your last name as it appears on your primary billing account.");
        Last_Name_Info.setFont(Font.font("",FontWeight.NORMAL, 11));
        grid.add(Last_Name_Info, 0,6,3,1);

        //Row 7
        HBox ssn_Box = new HBox();
        ssn_Box.setAlignment(Pos.CENTER_LEFT);
        Label ssn_Label = new Label();
        ssn_Label.setText("Social Security Number");
        ssn_Label.setFont(Font.font("",FontWeight.BOLD, 11));
        ssn_Box.getChildren().addAll(ssn_Label,red_star());
        TextField ssn_Field = new TextField();
        ssn_Field.setPromptText("___-__-____");
        grid.add(ssn_Box,0,7,1,1);
        grid.add(ssn_Field, 1, 7,1,1);

        //Row 8
        HBox pAccount_Box = new HBox();
        pAccount_Box.setAlignment(Pos.CENTER_LEFT);
        Label pAccount_Label = new Label();
        pAccount_Label.setText("Primary Billing Account");
        pAccount_Label.setFont(Font.font("",FontWeight.BOLD, 11));
        pAccount_Box.getChildren().addAll(pAccount_Label,red_star());
        TextField pAccount_Field = new TextField();
        pAccount_Field.setPromptText("___-__-____");
        grid.add(pAccount_Box,0,8,1,1);
        grid.add(pAccount_Field, 1, 8,1,1);

        //Row 9
        Label pAccount_Info = new Label();
        pAccount_Info.setText("This account may be subject to billing or fees per our Terms and Conditions agreement. Enter numbers only as they appear on your monthly account statement. Do not use spaces or dashes.");
        pAccount_Info.setFont(Font.font("",FontWeight.NORMAL, 11));
        pAccount_Info.setWrapText(true);
        grid.add(pAccount_Info,0,9,3,1);

        //Row 10
        HBox dob_Box = new HBox();
        dob_Box.setAlignment(Pos.CENTER_LEFT);
        Label dob_Label = new Label();
        dob_Label.setText("Date of Birth");
        dob_Label.setFont(Font.font("",FontWeight.BOLD, 11));
        dob_Box.getChildren().addAll(dob_Label,red_star());
        TextField dob_Field = new TextField();
        dob_Field.setPromptText("MM/DD/YYYY");
        grid.add(dob_Box,0,10,1,1);
        grid.add(dob_Field, 1, 10,1,1);

        //Row 11
        HBox wPhone_Box = new HBox();
        wPhone_Box.setAlignment(Pos.CENTER_LEFT);
        Label wPhone_Label = new Label();
        wPhone_Label.setText("Work Phone");
        wPhone_Label.setFont(Font.font("",FontWeight.BOLD, 11));
        wPhone_Box.getChildren().addAll(wPhone_Label,red_star());
        TextField wPhone_Field = new TextField();
        wPhone_Field.setPromptText("XXX-XXX-XXXX");
        grid.add(wPhone_Box,0,11,1,1);
        grid.add(wPhone_Field, 1, 11,1,1);


        //Row 12
        HBox hPhone_Box = new HBox();
        hPhone_Box.setAlignment(Pos.CENTER_LEFT);
        Label hPhone_Label = new Label();
        hPhone_Label.setText("Home Phone");
        hPhone_Label.setFont(Font.font("",FontWeight.BOLD, 11));
        hPhone_Box.getChildren().addAll(hPhone_Label,red_star());
        TextField hPhone_Field = new TextField();
        hPhone_Field.setPromptText("XXX-XXX-XXXX");
        grid.add(hPhone_Box,0,12,1,1);
        grid.add(hPhone_Field, 1, 12,1,1);

        //Row 13
        Label phone_Info = new Label();
        phone_Info.setText("If only one phone number is available, please enter it in Home and Work phone categories.");
        phone_Info.setFont(Font.font("",FontWeight.NORMAL,11));
        phone_Info.setWrapText(true);
        grid.add(phone_Info,0,13,3,1);

        //Row 14
        HBox address_Box = new HBox();
        address_Box.setAlignment(Pos.CENTER_LEFT);
        Label address_Label = new Label();
        address_Label.setText("Address");
        address_Label.setFont(Font.font("",FontWeight.BOLD, 11));
        address_Box.getChildren().addAll(address_Label,red_star());
        TextField address_Field = new TextField();
        address_Field.setPromptText("Enter Address");
        grid.add(address_Box,0,14,1,1);
        grid.add(address_Field, 1, 14,1,1);

        //Row 15
        HBox address_Info_Box = new HBox();
        Label address_Info1 = new Label();
        address_Info1.setText("All Fields marked with an asterisk (");
        Label address_Info2 = new Label();
        address_Info2.setText(") are required.");
        address_Info_Box.getChildren().addAll(address_Info1,red_star(),address_Info2);
        grid.add(address_Info_Box,0,15,3,1);

        //Row 16
        HBox button_Box = new HBox();
        button_Box.setSpacing(5);
        Button submit = new Button();
        submit.setText("Submit");
        submit.setAlignment(Pos.CENTER);
        button_Box.getChildren().addAll(Cancel_Button(), submit);
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Validate if the informations are correct
                //Save the values in the textfield into database
            }
        });
        grid.add(button_Box,3,16,1,1);

        //Start new screen
        Enroll_Scene = new Scene(grid, 800,600);
        mainStage.setScene(Enroll_Scene);
    }

    private Button Cancel_Button(){
        Button cancel_Button = new Button("Cancel");
        cancel_Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainStage.setScene(Login_Scene);
            }
        });
        return cancel_Button;
    }

    public Text red_star(){
        //Red Star
        Text rs = new Text();
        rs.setText("*");
        rs.setFill(Color.RED);
        return rs;
    }
}