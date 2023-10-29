package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


public class HomeController implements Initializable {
	
	private String employeeRank = "Supervisor 1";
	@FXML
	private Label rankLabel, accessDeniedLabel;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		rankLabel.setText(employeeRank);
	}
	
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
		if ((employeeRank.equals("Engineer 1")) || (employeeRank.equals("Engineer 2")) || (employeeRank.equals("Developer 1"))
				|| (employeeRank.equals("Developer 2"))) {
			accessDeniedLabel.setVisible(true);
		}
		else {
			Main.setScene("/PublicLogs.fxml");
		}
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
