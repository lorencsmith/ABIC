import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Created by lorensmith on 4/20/17.
 */
public class BillPay {
 public void pay(GridPane grid){
     Label payTitle = new Label();
     payTitle.setText("Pay Schedule");
     payTitle.setFont(Font.font("", FontWeight.EXTRA_BOLD, 16));
     payTitle.setTextFill(Color.DARKCYAN);
     payTitle.setAlignment(Pos.CENTER);
     grid.add(payTitle, 5, 10, 1, 1);
 }
}
