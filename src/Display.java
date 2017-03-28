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
    Scene Login_Scene, Forgot_Password_Scene, Enroll_Scene;
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
        mainStage.setScene(Login_Scene);
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
        Button Employee_Login_Button = new Button("Emplyoyee Login");
        Employee_Login_Button.setAlignment(Pos.CENTER);
        Employee_Login_Button.setPadding(new Insets(5,5,5,5));
        Employee_Login_Button.setFont(Font.font("Tahoma", FontWeight.BOLD, 12));
        Employee_Login_Button.setMinWidth(200);
        grid.add(Employee_Login_Button,0,2,2,1);

        //Row3
        Button User_Login_Button = new Button("User Login");
        User_Login_Button.setAlignment(Pos.CENTER);
        User_Login_Button.setPadding(new Insets(5,5,5,5));
        User_Login_Button.setFont(Font.font("Tahoma", FontWeight.BOLD, 12));
        User_Login_Button.setMinWidth(200);
        grid.add(User_Login_Button,0,3,2,1);

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
        Button cancel_Button = new Button("Cancel");
        cancel_Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainStage.setScene(Login_Scene);
            }
        });
        Button submit_Button = new Button("Submit");
        HBox button_Box = new HBox();
        button_Box.setSpacing(5);
        button_Box.setPadding(new Insets(5,5,5,5));
        button_Box.getChildren().addAll(cancel_Button,submit_Button);
        grid.add(button_Box, 0,7,3,1);

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
        First_Name_Box.setAlignment(Pos.CENTER);
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
        Last_Name_Box.setAlignment(Pos.CENTER);
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


        Enroll_Scene = new Scene(grid, 800,600);
        mainStage.setScene(Enroll_Scene);
    }

    public Text red_star(){
        //Red Star
        Text rs = new Text();
        rs.setText("*");
        rs.setFill(Color.RED);
        return rs;
    }
}