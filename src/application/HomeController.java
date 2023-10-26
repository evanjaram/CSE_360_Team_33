package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HomeController {
	private int numClickes;
    @FXML
    private Button testButton;

    @FXML
    private void handleClick(ActionEvent event) {
    	numClickes++;
        testButton.setText("clicked " + numClickes + " times!");
    }
    
    @FXML
    private void onClickNextPage(ActionEvent event) {
    	Main.setScene("/EffortLogEditor.fxml");
    }
}
