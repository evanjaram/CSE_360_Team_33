//Author: Evan Jaramillo
//Description: This is the defect logs system from the original EffortLogger application

package application;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class DefectConsoleController implements Initializable {
	//arrays to fill choice boxes
	private static final String[] projectsList = {"Business Project", "Development Project"};
	
	//arraylist of defects
	//public ArrayList<DefectLogEntry> defectEntries = new ArrayList<EffortLogEntry>();
	
	//Javafx components
	@FXML
	private Label topLabel, instructionLabel1, instructionLabel2A, instructionLabel2B, instructionLabel3, instructionLabel4,
			defectCountLabel, defectNumberLabel, defectNameLabel, numLabel, statusTitleLabel, statusLabel, causeResolutionLabel,
			injectedLabel, removedLabel, categoryLabel, savedLabel;
	
	@FXML
	private ChoiceBox<String> projectChoiceBox, defectsListChoiceBox, injectedChoiceBox, removedChoiceBox, categoryChoiceBox;
	
	@FXML
	private Button clearDefectButton, createNewDefectButton, closeButton, openButton, updateButton, deleteButton, homeButton;
	
	@FXML
	private TextField nameTextField;
	
	@FXML
	private TextArea causeResolutionTextArea;
	
	private static final String[] developmentLifeCycleStepsList = {"Problem Understanding", "Conceptual Design Plan", 
			"Requirements", "Conceptual Design", "Conceptual Design Review", "Detailed Design Plan", "Detailed Design/Prototype", 
			"Detailed Design Review", "Implementation Plan", "Test Case Generation", "Solution Specification", 
			"Solution Review", "Solution Implementation", "Unit/System Test", "Reflection", "Repository Update"};
	private static final String[] businessLifeCycleStepsList = {"Planning", "Information Gathering", "Information Understanding", 
			"Verifying", "Outlining", "Drafting", "Finalizing", "Team Meeting", "Coach Meeting", "Stakeholder Meeting"};
	private static final String[] defectCategoryList = { "Not Specified", "10 Documentation", "20 Syntax", "30 Build, Package",
			"40 Assignment", "50 Interface", "60 Checking", "70 Data", "80 Function", "90 System", "100 Environemt" };
	private static final String[] statusList = { "Closed", "Open" };
	
	
	private String projectType = projectsList[0];
	private String currentName, currentInjected, currentRemoved, currentCategory, currentDetails;
	private String currentDefectStatus = statusList[0];
	private DefectLogEntry currentDefect;
	private int currentNumber;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//home button
		homeButton.setOnAction(this::homeButtonHandler);
		
		//top label border
		topLabel.setBorder(new Border(new BorderStroke(
				Color.BLACK,
				BorderStrokeStyle.SOLID,
				CornerRadii.EMPTY,
				BorderWidths.DEFAULT)));
		
		//savedLabel color and non-visible
		savedLabel.setStyle("-fx-background-color: red;");
		savedLabel.setVisible(false);
		
		//handle actions for projectChoiceBox
		projectChoiceBox.getItems().addAll(projectsList);
		projectChoiceBox.valueProperty().addListener((observable, oldValue, newValue) -> {
			projectType = newValue;
			numLabel.setText("");
			nameTextField.clear();
			causeResolutionTextArea.clear();
			savedLabel.setVisible(false);
			defectsListChoiceBox.getItems().clear();
			
			if (projectType.equals(projectsList[0])) {
				ArrayList<String> businessNames = Main.businessProject.getNames();
				defectsListChoiceBox.getItems().addAll(businessNames);
				injectedChoiceBox.getItems().addAll(businessLifeCycleStepsList);
			}
			else {
				ArrayList<String> developmentNames = Main.developmentProject.getNames();
				defectsListChoiceBox.getItems().addAll(developmentNames);
			}
		});
		
		//clear defect log button
		clearDefectButton.setOnAction(this::clearDefectButtonHandler);
		
		//handle events for defectsListChoiceBox
		defectsListChoiceBox.valueProperty().addListener((observable, oldValue, newValue) -> {
			numLabel.setText("");
			nameTextField.clear();
			causeResolutionTextArea.clear();
			savedLabel.setVisible(true);
			
			currentNumber = Integer.parseInt(newValue.substring(0, newValue.indexOf(".")));
			currentName = newValue.substring(newValue.indexOf(" ") + 1, newValue.length());
			if (projectType.equals(projectsList[0])) {
				if (Main.businessProject.findDefect(currentName) >= 0) {
					currentDefect = Main.businessProject.defectLogs.get(Main.businessProject.findDefect(currentName));
				}
				else {
					currentDefect = null;
				}
			}
			else {
				if (Main.developmentProject.findDefect(currentName) >= 0) {
					currentDefect = Main.developmentProject.defectLogs.get(Main.developmentProject.findDefect(currentName));
				}
				else {
					currentDefect = null;
				}
			}
			
			numLabel.setText(Integer.toString(currentNumber));
			nameTextField.setText(currentName);
			
			currentInjected = currentDefect.getInjected();
			currentRemoved = currentDefect.getRemoved();
			currentCategory = currentDefect.getCategory();
			currentDetails = currentDefect.getdetails();
			currentDefectStatus = currentDefect.getStatus();
			
			injectedChoiceBox.setValue(currentInjected);
			removedChoiceBox.setValue(currentRemoved);
			categoryChoiceBox.setValue(currentCategory);
			statusLabel.setText(currentDefectStatus);
			causeResolutionTextArea.setText(currentDetails);
		});
		
		//create new defect button
		createNewDefectButton.setOnAction(this::createNewDefectButtonHandler);
		
		//step injected choice box		
		if (projectType.equals(projectsList[0])) {
			injectedChoiceBox.getItems().addAll(businessLifeCycleStepsList);
		}
		else {
			injectedChoiceBox.getItems().addAll(developmentLifeCycleStepsList);
		}
		
		injectedChoiceBox.valueProperty().addListener((observable, oldValue, newValue) -> {
			currentInjected = newValue;
		});
		
		//step removed choice box
		if (projectType.equals(projectsList[0])) {
			removedChoiceBox.getItems().addAll(businessLifeCycleStepsList);
		}
		else {
			removedChoiceBox.getItems().addAll(developmentLifeCycleStepsList);
		}
		
		removedChoiceBox.valueProperty().addListener((observable, oldValue, newValue) -> {
			currentRemoved = newValue;
		});
		
		//defect category choice box
		categoryChoiceBox.getItems().addAll(defectCategoryList);
		categoryChoiceBox.valueProperty().addListener((observable, oldValue, newValue) -> {
			currentCategory = newValue;
		});
		
		//close button
		closeButton.setOnAction(this::closeButtonHandler);
		
		//open button
		openButton.setOnAction(this::openButtonHandler);
		
		//cause resolution text area
		causeResolutionTextArea.textProperty().addListener((observable, oldValue, newValue) -> {
			currentDetails = newValue;
		});
		
		//update button
		updateButton.setOnAction(this::updateButtonHandler);
		
		//delete button
		deleteButton.setOnAction(this::deleteButtonHandler);
	}
	
	//handle actions for clearDefectButton
	public void clearDefectButtonHandler(ActionEvent event) {
		if (projectType == null) {
			return;
		}
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Clear This Project's Defect Logs");
		alert.setHeaderText("You are about to clear all the defects for this project. This cannot be undone.");
		alert.setContentText("Are you sure you want to do this?");
		
		if (alert.showAndWait().get() == ButtonType.OK) {
			if (projectType.equals(projectsList[0])) {
				Main.businessProject.defectLogs.clear();
				System.out.println("Cleared defects");
			}
			else {
				Main.developmentProject.defectLogs.clear();
				System.out.println("Cleared defects");
			}
		}
		
		projectChoiceBox.getItems().clear();
		projectType = projectsList[0];
		
		defectsListChoiceBox.getItems().clear();
		currentDefect = null;
		
		numLabel.setText("");
		currentNumber = 0;
		
		nameTextField.clear();
		currentName = "";
		
		statusLabel.setText(statusList[0]);
		currentDefectStatus = statusList[0];
		
		causeResolutionTextArea.clear();
		currentDetails = "";
		
		injectedChoiceBox.setValue(null);
		currentInjected = "";
		
		removedChoiceBox.setValue(null);
		currentRemoved = "";
		
		categoryChoiceBox.setValue(null);
		currentCategory = "";
	}
	
	//handle actions for createNewDefectButton
	public void createNewDefectButtonHandler(ActionEvent event) {
		numLabel.setText("");
		nameTextField.clear();
		causeResolutionTextArea.clear();
		savedLabel.setVisible(true);
		
		DefectLogEntry newEntry = new DefectLogEntry();
		newEntry.setProjectType(projectType);
		currentName = "-new defect-";
		newEntry.setName(currentName);
		if (projectType.equals(projectsList[0])) {
			currentNumber = Main.businessProject.defectLogs.size();
			newEntry.setNumber(currentNumber);
			Main.businessProject.defectLogs.add(newEntry);
		}
		else {
			currentNumber = Main.developmentProject.defectLogs.size();
			newEntry.setNumber(currentNumber);
			Main.developmentProject.defectLogs.add(newEntry);
		}
		
		numLabel.setText(Integer.toString(currentNumber));
		nameTextField.setText(currentName);
	}
	
	//handle actions for home button
	public void homeButtonHandler(ActionEvent event) {
		projectType = null;
		currentName = ""; 
		currentInjected = null;
		currentRemoved = null;
		currentCategory = null;
		currentDefectStatus = "Closed";
		currentDefect = null;
		currentNumber = 0;
		
		numLabel.setText("");
		nameTextField.clear();
		causeResolutionTextArea.clear();
		savedLabel.setVisible(false);
		
		Main.setScene("/Home.fxml");
	}
	
	//handle actions for close button
	public void closeButtonHandler(ActionEvent event) {
		currentDefectStatus = statusList[0];
		statusLabel.setText(currentDefectStatus);
	}
	
	//handle actions for open button
	public void openButtonHandler(ActionEvent event) {
		currentDefectStatus = statusList[1];
		statusLabel.setText(currentDefectStatus);
	}
	
	//handle actions for update button
	public void updateButtonHandler(ActionEvent event) {
		if (projectType.equals(projectsList[0])) {
			Main.businessProject.defectLogs.get(currentNumber).setProjectType(projectType);
			Main.businessProject.defectLogs.get(currentNumber).setName(currentName);
			Main.businessProject.defectLogs.get(currentNumber).setDetails(currentDetails);
			Main.businessProject.defectLogs.get(currentNumber).setInjected(currentInjected);
			Main.businessProject.defectLogs.get(currentNumber).setRemoved(currentRemoved);
			Main.businessProject.defectLogs.get(currentNumber).setCategory(currentCategory);
			Main.businessProject.defectLogs.get(currentNumber).setStatus(currentDefectStatus);
			Main.businessProject.defectLogs.get(currentNumber).setNumber(currentNumber);
		}
		else {
			Main.developmentProject.defectLogs.get(currentNumber).setProjectType(projectType);
			Main.developmentProject.defectLogs.get(currentNumber).setName(currentName);
			Main.developmentProject.defectLogs.get(currentNumber).setDetails(currentDetails);
			Main.developmentProject.defectLogs.get(currentNumber).setInjected(currentInjected);
			Main.developmentProject.defectLogs.get(currentNumber).setRemoved(currentRemoved);
			Main.developmentProject.defectLogs.get(currentNumber).setCategory(currentCategory);
			Main.developmentProject.defectLogs.get(currentNumber).setStatus(currentDefectStatus);
			Main.developmentProject.defectLogs.get(currentNumber).setNumber(currentNumber);
		}
		
		savedLabel.setText("This has been saved");
		savedLabel.setStyle("-fx-background-color: green;");
		
		if (projectType.equals(projectsList[0])) {
			Main.businessProject.printDefectLogs(Main.businessProject);
		}
		else {
			Main.developmentProject.printDefectLogs(Main.developmentProject);
		}
	}
	
	//handle actions for delete button
	public void deleteButtonHandler(ActionEvent event) {
		if (projectType.equals(projectsList[0])) {
			Main.businessProject.defectLogs.remove(currentNumber);
		}
		else {
			Main.developmentProject.defectLogs.remove(currentNumber);
		}
		
		savedLabel.setText("This has been saved");
		savedLabel.setStyle("-fx-background-color: green;");
		
		if (projectType.equals(projectsList[0])) {
			Main.businessProject.printDefectLogs(Main.businessProject);
		}
		else {
			Main.developmentProject.printDefectLogs(Main.developmentProject);
		}
		
		projectChoiceBox.getItems().clear();
		projectType = projectsList[0];
		
		defectsListChoiceBox.getItems().clear();
		currentDefect = null;
		
		numLabel.setText("");
		currentNumber = 0;
		
		nameTextField.clear();
		currentName = "";
		
		statusLabel.setText(statusList[0]);
		currentDefectStatus = statusList[0];
		
		causeResolutionTextArea.clear();
		currentDetails = "";
		
		injectedChoiceBox.setValue(null);
		currentInjected = "";
		
		removedChoiceBox.setValue(null);
		currentRemoved = "";
		
		categoryChoiceBox.setValue(null);
		currentCategory = "";
	}
}
