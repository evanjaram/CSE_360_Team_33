package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class HomeController {
	
	@FXML
	private void goToEffortLogConsole() {
		Main.setScene("EffortLoggerGUI.fxml");
	}
	
	@FXML
	private void goToEffortLogViewer() {
		Main.setScene("/EffortLogViewer.fxml");
	}
	
	@FXML
	private void goToPublicLogs() {
		Main.setScene("/PublicLogs.fxml");
	}
	
	@FXML
	private void goToDefectLogEditor() {
		System.out.println("That scene is not yet implemented");
	}
	
	@FXML
	private void goToDefinitions() {
		System.out.println("That scene is not yet implemented");
	}
	
}
