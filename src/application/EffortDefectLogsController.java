package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class EffortDefectLogsController {
	
	@FXML
	private Label nameLabel;
	
	@FXML
	private Label dataLabel;
	
	@FXML
	private Button goToPublicLogsButton;
	
	private static String selectedName;
	private static String selectedData;
	
	public static void setData(String name, String data) {
		selectedName = name;
		selectedData = data;
	}
	
	@FXML
	private void initialize() {
		nameLabel.setText(selectedName);
		dataLabel.setText(selectedData);
	}
	
	@FXML
	private void goToPublicLogs() {
		Main.setScene("/PublicLogs.fxml");
	}
}
