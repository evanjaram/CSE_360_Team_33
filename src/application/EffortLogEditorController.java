package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EffortLogEditorController {
	@FXML
	private TextField featureNameField;
	@FXML
	private TextField estimatedStoryPointsField;
	@FXML
	private TextField tagsField;
	@FXML
	private TextField hoursSpentField;
	@FXML
	private TextArea notes;
	
	
	
	@FXML
	private void submitText() {
		String hrs = hoursSpentField.getText();
		if(!hrs.isEmpty() && !JoeUtils.isNumber(hrs)) {
			JoeUtils.showError("hours spent must be a number");
		} else {
			Main.setScene("/EffortLogViewer.fxml");
		}
	}

	

	
}
