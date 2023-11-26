package application;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class LogsController implements Initializable {
	
	@FXML
	private ChoiceBox<String> projectChoiceBox, logTypeChoiceBox;
	
	@FXML
	private Button goButton, homeButton;
	
	//arrays for choiceboxes
	private static final String[] projectsList = {"Business Project", "Development Project"};
	private static final String[] typesList = {"Effort Logs", "Defect Logs"};
	
	private String projectType, logType;
	
	private Boolean set1 = false, set2 = false;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//set up projects choice box
		projectChoiceBox.getItems().addAll(projectsList);
		projectChoiceBox.valueProperty().addListener((observable, oldValue, newValue) -> {
			projectType = newValue;
			set1 = true;
			
			logTypeChoiceBox.getSelectionModel().clearSelection();
			set2 = false;
			
			if ((set1 == true) && (set2 == true)) {
				goButton.setVisible(true);
			}
			else {
				goButton.setVisible(false);
			}
		});
		
		//set up logs type choice box
		logTypeChoiceBox.getItems().addAll(typesList);
		logTypeChoiceBox.valueProperty().addListener((observable, oldValue, newValue) -> {
			logType = newValue;
			set2 = true;
			
			if ((set1 == true) && (set2 == true)) {
				goButton.setVisible(true);
			}
			else {
				goButton.setVisible(false);
			}
		});
		
		//next button
		goButton.setOnAction(this::goButtonEventHandler);
		
		//home button
		homeButton.setOnAction(this::homeButtonEventHandler);
	}
	
	//handle actions for go button
	public void goButtonEventHandler(ActionEvent event) {
		if ((projectType.equals(projectsList[0])) && (logType.equals(typesList[0]))) {
			Main.setScene("/BusinessEfforts.fxml");
		}
		else if ((projectType.equals(projectsList[0])) && (logType.equals(typesList[1]))) {
			Main.setScene("/BusinessDefects.fxml");
		}
		else if ((projectType.equals(projectsList[1])) && (logType.equals(typesList[0]))) {
			Main.setScene("/DevelopmentEfforts.fxml");
		}
		else {
			Main.setScene("/DevelopmentDefects.fxml");
		}
	}
	
	//handle events for back button
	public void homeButtonEventHandler(ActionEvent event) {
		Main.setScene("/Home.fxml");
	}
}
