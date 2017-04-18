import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by lorensmith on 4/18/17.
 */
public class Help {
    public void contact(GridPane grid) {

        Label contactTitle = new Label();
        contactTitle.setText("Contact Us");
        contactTitle.setFont(Font.font("", FontWeight.BOLD, 14));
        contactTitle.setWrapText(true);
        contactTitle.setAlignment(Pos.CENTER);
        contactTitle.setTextFill(Color.RED);
        grid.add(contactTitle, 1, 1, 1, 1);

        Label contactNo = new Label();
        contactNo.setText("Support                                               1-800-700-ABIC");
        contactNo.setFont(Font.font("", 12));
        contactNo.setWrapText(true);
        grid.add(contactNo, 1, 2, 1, 1);


        Label contactE = new Label();
        contactE.setText("E-mail                                                 CustomerSupport@ABIC.com");
        contactE.setFont(Font.font("", 12));
        contactE.setWrapText(true);
        grid.add(contactE, 1, 3, 1, 1);

        Label contactMailTitle = new Label();
        contactMailTitle.setText("Mailing Address:");
        contactMailTitle.setFont(Font.font("", 14));
        contactMailTitle.setTextFill(Color.RED);
        contactMailTitle.setWrapText(true);
        grid.add(contactMailTitle, 1, 5, 1, 1);

        Label contactMailAdd = new Label();
        contactMailAdd.setText("1001 Aderhold Lane");
        contactMailAdd.setFont(Font.font("", 12));
        contactMailAdd.setWrapText(true);
        grid.add(contactMailAdd, 1, 6, 1, 1);

        Label contactMailZip = new Label();
        contactMailZip.setText("30303");
        contactMailZip.setFont(Font.font("", 12));
        contactMailZip.setWrapText(true);
        grid.add(contactMailZip, 1, 7, 1, 1);

        Label contactMailCS = new Label();
        contactMailCS.setText("Atlanta, GA");
        contactMailCS.setFont(Font.font("", 12));
        contactMailCS.setWrapText(true);
        grid.add(contactMailCS, 1, 8, 1, 1);

    }
    public void FAQ(GridPane grid) {
        Label FAQ_Label = new Label();
        FAQ_Label.setText("FAQ");
        FAQ_Label.setFont(Font.font("", FontWeight.EXTRA_BOLD, 16));
        FAQ_Label.setTextFill(Color.RED);
        FAQ_Label.setAlignment(Pos.CENTER);
        grid.add(FAQ_Label, 1, 10, 1, 1);

        Label FAQ_Q1_Label = new Label();
        FAQ_Q1_Label.setText("I recently moved to a different address. How can I change my mailing address?");
        FAQ_Q1_Label.setFont(Font.font("", FontWeight.BOLD, 12));
        FAQ_Q1_Label.setAlignment(Pos.CENTER);
        grid.add(FAQ_Q1_Label, 1, 11, 1, 1);

        Label FAQ_A1_Label = new Label();
        FAQ_A1_Label.setText("Under the profile option in the menu, you can view and change your address.");
        FAQ_A1_Label.setFont(Font.font("", FontWeight.NORMAL, 12));
        FAQ_A1_Label.setWrapText(true);
        FAQ_A1_Label.setAlignment(Pos.CENTER);
        FAQ_Label.setTextFill(Color.RED);
        grid.add(FAQ_A1_Label, 1, 12, 1, 1);

        Label FAQ_Q2_Label = new Label();
        FAQ_Q2_Label.setText("What happens if I forgot my password?");
        FAQ_Q2_Label.setFont(Font.font("", FontWeight.BOLD, 12));
        FAQ_Q2_Label.setWrapText(true);
        FAQ_Q2_Label.setAlignment(Pos.CENTER);
        grid.add(FAQ_Q2_Label, 1, 13, 1, 1);

        Label FAQ_A2_Label = new Label();
        FAQ_A2_Label.setText("Using the Forgot Password option, the user can see their current password. It will request the username and Social Security Number associated with the account.");
        FAQ_A2_Label.setFont(Font.font("", FontWeight.NORMAL, 12));
        FAQ_A2_Label.setWrapText(true);
        FAQ_A2_Label.setAlignment(Pos.CENTER);
        FAQ_Label.setTextFill(Color.RED);
        grid.add(FAQ_A2_Label, 1, 14, 1, 1);

        Label FAQ_Q3_Label = new Label();
        FAQ_Q3_Label.setText("Somebody else knows my password. How can I change it?");
        FAQ_Q3_Label.setFont(Font.font("", FontWeight.BOLD, 12));
        FAQ_Q3_Label.setWrapText(true);
        FAQ_Q3_Label.setAlignment(Pos.CENTER);
        grid.add(FAQ_Q3_Label, 1, 15, 1, 1);

        Label FAQ_A3_Label = new Label();
        FAQ_A3_Label.setText("Under the profile option in the menu, you can change your password by inputting a new password and then confirming the password in a separate box.");
        FAQ_A3_Label.setFont(Font.font("", FontWeight.NORMAL, 12));
        FAQ_A3_Label.setWrapText(true);
        FAQ_A3_Label.setAlignment(Pos.CENTER);
        FAQ_Label.setTextFill(Color.RED);
        grid.add(FAQ_A3_Label, 1, 16, 1, 1);

        Label FAQ_Q4_Label = new Label();
        FAQ_Q4_Label.setText("Will my password expire?");
        FAQ_Q4_Label.setFont(Font.font("", FontWeight.BOLD, 12));
        FAQ_Q4_Label.setWrapText(true);
        FAQ_Q4_Label.setAlignment(Pos.CENTER);
        grid.add(FAQ_Q4_Label, 1, 17, 1, 1);

        Label FAQ_A4_Label = new Label();
        FAQ_A4_Label.setText("No. User set passwords don't expire, but for security purposes, we suggest changing your password periodically.");
        FAQ_A4_Label.setFont(Font.font("", FontWeight.NORMAL, 12));
        FAQ_A4_Label.setWrapText(true);
        FAQ_A4_Label.setAlignment(Pos.CENTER);
        FAQ_Label.setTextFill(Color.RED);
        grid.add(FAQ_A4_Label, 1, 18, 1, 1);
    }


    public void privacy(GridPane grid){

        Hyperlink privacy = new Hyperlink();
        privacy.setText("Privacy Policy");
        privacy.setFont(Font.font("",FontWeight.NORMAL, 11));
        privacy.setTextFill(Color.BLUE);
        privacy.setBorder(Border.EMPTY);
        grid.add(privacy, 1, 20, 1, 1);
        privacy.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                privacy.setFont(Font.font("",FontWeight.BOLD,11));
            }
        });
        privacy.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                privacy.setFont(Font.font("",FontWeight.NORMAL, 11));
            }
        });
        privacy.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        Desktop desktop = Desktop.getDesktop();
        File f = new File("Users/lorensmith/ABIC/privacy.pdf");
        if(f.exists()){
            try {
                desktop.open(f);
            }catch (IOException e){

            }
        }


    }

}
