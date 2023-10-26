package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class EffortLogEditorController {
	@FXML
	private Button goBackButton;
	
	@FXML
	private void goBackClick() {
		Main.setScene("/Home.fxml");
	}
}
