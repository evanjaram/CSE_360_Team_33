package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class HomeController {
	
	@FXML
	private void goToEffortLogEditor() {
		Main.setScene("/EffortLogEditor.fxml");
	}
	
	@FXML
	private void goToEffortLogViewer() {
		Main.setScene("/EffortLogViewer.fxml");
	}
}
