package application;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


// Author: Joseph Cohen

// Aligns with the design because it allows the user to see the feature info in detail
// It also allows them to edit it if they want to.
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
	
	public static FeatureInfo currFeature;
	
	
	@FXML
	private void initialize() {
		if(currFeature == null) {
			System.err.println("You must set the clicked button BEFORE you go to EffortLogEditor scene!!!");
		} else {
			featureNameField.setText(currFeature.name);
			notes.setText(currFeature.notes);
			hoursSpentField.setText(currFeature.hoursSpent + "");
			tagsField.setText(currFeature.tags);
			estimatedStoryPointsField.setText(currFeature.esimatedStoryPoints + "");
		}
		
	}
	
	
	@FXML
	private void submitText() {
		String hrs = hoursSpentField.getText();
		if(!hrs.isEmpty() && !Utils.isNumber(hrs)) {
			Utils.showError("hours spent must be a number");
		} else {
			currFeature.name = featureNameField.getText();
			currFeature.esimatedStoryPoints = Double.parseDouble(estimatedStoryPointsField.getText());
			currFeature.tags = tagsField.getText();
			currFeature.hoursSpent = Double.parseDouble(hoursSpentField.getText());
			currFeature.notes = notes.getText();
			Main.setScene("/EffortLogViewer.fxml");
		}
	}

	

	
}
