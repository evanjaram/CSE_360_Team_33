//Author: Evan Jaramillo
//Description: this is the controller class for the EffortLog Console GUI

package application;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.time.LocalDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

public class EffortLogConsoleGUI implements Initializable {
	//GUI components
	@FXML
	private AnchorPane backgroundPane;
	@FXML
	private Label topLabel, clockLabel, instructionLabel1, instructionLabel2, instructionLabel3, 
			instructionLabel4, projectLabel, lifeCycleLabel, effortCategoryLabel, effortNameLabel, 
			otherDetailsLabel, alreadyRunningLabel, notRunningLabel;
		
	@FXML
	private Button startActivityButton, stopActivityButton, backButton;
	@FXML
	private ChoiceBox<String> projectChoiceBox, lifeCycleChoiceBox, effortCategoryChoiceBox, effortNameChoiceBox;
	@FXML
	private TextField otherDetailsTextField;
	
	//Dropdown contents arrays
	private static final String[] projectsList = {"Business Project", "Development Project"};
	private static final String[] developmentLifeCycleStepsList = {"Problem Understanding", "Conceptual Design Plan", 
			"Requirements", "Conceptual Design", "Conceptual Design Review", "Detailed Design Plan", "Detailed Design/Prototype", 
			"Detailed Design Review", "Implementation Plan", "Test Case Generation", "Solution Specification", 
			"Solution Review", "Solution Implementation", "Unit/System Test", "Reflection", "Repository Update"};
	private static final String[] businessLifeCycleStepsList = {"Planning", "Information Gathering", "Information Understanding", 
			"Verifying", "Outlining", "Drafting", "Finalizing", "Team Meeting", "Coach Meeting", "Stakeholder Meeting"};
	private static final String[] effortCategoryList = {"Plans", "Deliverables", "Interruptions", "Defects", "Others"};
	private static final String[] plansTypeList = {"Project Plan", "Risk Management Plan", "Conceptual Design Plan", 
			"Detailed Design Plan", "Implementation Plan"};
	private static final String[] deliverablesTypeList = {"Conceptual Design", "Detailed Design", "Test Cases", 
			"Solution", "Reflection", "Outline", "Draft", "Report", "User Defined", "Other"};
	private static final String[] interruptionsTypeList = {"Break", "Phone", "Teammate", "Visitor", "Other"};
	
	//effortlog fields
	private String projectType, lifeCycleStep, categoryName, effortName, otherDescription;
	private boolean isRunning = false;
	
	//clock variables
	private LocalDateTime startTimeObject, stopTimeObject, stopDateObject, startDateObject;
	
	private String startTime, startDate, stopTime, stopDate;
	private double minutes;
	private String employeeRank;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//top label border
		topLabel.setBorder(new Border(new BorderStroke(
				Color.BLACK,
				BorderStrokeStyle.SOLID,
				CornerRadii.EMPTY,
				BorderWidths.DEFAULT)));
		
		//clock label colors
		//set to red and text to white
		clockLabel.setStyle("-fx-background-color: red;");
		
		//handle actions for start activity button
		startActivityButton.setOnAction(this::startActivityButtonHandler);
		
		//handle actions for stop activity button
		stopActivityButton.setOnAction(this::stopActivityButtonHandler);
		
		//handle actions for the back to home button
		backButton.setOnAction(this::backButtonEventHandler);
		
		//fill dropdowns with accompanying array and handle actions
		projectChoiceBox.getItems().addAll(projectsList);
		projectChoiceBox.valueProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue.equals(projectsList[0])) {
				lifeCycleChoiceBox.getItems().clear();
				projectType = projectsList[0];
				lifeCycleChoiceBox.getItems().addAll(businessLifeCycleStepsList);
			}
			else {
				lifeCycleChoiceBox.getItems().clear();
				projectType = projectsList[1];
				lifeCycleChoiceBox.getItems().addAll(developmentLifeCycleStepsList);
			}
		});
		
		lifeCycleChoiceBox.valueProperty().addListener((observable, oldValue, newValue) -> {
			lifeCycleStep = newValue;
		});
		
		effortCategoryChoiceBox.getItems().addAll(effortCategoryList);
		effortCategoryChoiceBox.valueProperty().addListener((observable, oldValue, newValue) -> {
			//plan
			if (newValue.equals(effortCategoryList[0])) {
				otherDetailsLabel.setVisible(false);
				otherDetailsTextField.setVisible(false);
				otherDetailsTextField.clear();
				effortNameChoiceBox.getItems().clear();
				categoryName = effortCategoryList[0];
				effortNameChoiceBox.getItems().addAll(plansTypeList);
				effortNameLabel.setVisible(true);
				effortNameLabel.setText(effortCategoryList[0]);
			}
			else if (newValue.equals(effortCategoryList[1])) {
				otherDetailsLabel.setVisible(false);
				otherDetailsTextField.setVisible(false);
				otherDetailsTextField.clear();
				effortNameChoiceBox.getItems().clear();
				categoryName = effortCategoryList[1];
				effortNameChoiceBox.getItems().addAll(deliverablesTypeList);
				effortNameLabel.setVisible(true);
				effortNameLabel.setText(effortCategoryList[1]);
			}
			else if (newValue.equals(effortCategoryList[2])) {
				otherDetailsLabel.setVisible(false);
				otherDetailsTextField.setVisible(false);
				otherDetailsTextField.clear();
				effortNameChoiceBox.getItems().clear();
				categoryName = effortCategoryList[2];
				effortNameChoiceBox.getItems().addAll(interruptionsTypeList);
				effortNameLabel.setVisible(true);
				effortNameLabel.setText(effortCategoryList[2]);
			}
			else if (newValue.equals(effortCategoryList[3])) {
				otherDetailsLabel.setVisible(false);
				otherDetailsTextField.setVisible(false);
				otherDetailsTextField.clear();
				effortNameChoiceBox.getItems().clear();
				categoryName = effortCategoryList[3];
				//edit this to be the defects
				effortNameChoiceBox.getItems().add("Defects");
				effortNameLabel.setVisible(true);
				effortNameLabel.setText(effortCategoryList[3]);
			}
			else {
				effortNameChoiceBox.getItems().clear();
				categoryName = effortCategoryList[4];
				otherDetailsLabel.setVisible(true);
				otherDetailsTextField.setVisible(true);
			}
		});
		
		//exception thrown for newValue == NULL here potentially
		//but the program still works
		effortNameChoiceBox.valueProperty().addListener((observable, oldValue, newValue) -> {
			otherDetailsLabel.setVisible(false);
			otherDetailsTextField.setVisible(false);
			otherDetailsTextField.clear();
			effortName = newValue;
			if (newValue.equals("Other")) {
				otherDetailsLabel.setVisible(true);
				otherDetailsTextField.setVisible(true);
			}
		});
		
		
	}
	
	//event handler for start activity button
	public void startActivityButtonHandler(ActionEvent event) {
		notRunningLabel.setVisible(false);
		//if running change clockLabel message and color
		//update isRunning variable
		if (isRunning == false) {
			alreadyRunningLabel.setVisible(false);
			
			//start the clock and record the date and time
			startDateObject = LocalDateTime.now();
			startTimeObject = LocalDateTime.now();
			startDate = formatDate(startDateObject);
			startTime = formatTime(startTimeObject);
			
			//change the clockLabel
			clockLabel.setText("Clock is Running");
			clockLabel.setStyle("-fx-background-color: green;");
			isRunning = true;
		}
		else {
			//display message that clock is already running
			alreadyRunningLabel.setVisible(true);
		}
	}
	
	//event handler for stop activity button
	public void stopActivityButtonHandler(ActionEvent event) {
		alreadyRunningLabel.setVisible(false);
		if (isRunning == true) {
			notRunningLabel.setVisible(false);
			
			//stop the clock and record the date and time and time elapsed
			stopDateObject = LocalDateTime.now();
			stopTimeObject = LocalDateTime.now();
			stopDate = formatDate(stopDateObject);
			stopTime = formatTime(stopTimeObject);
			
			Duration duration = Duration.between(startTimeObject, stopDateObject);
			double seconds = duration.toMillis() / 1000.0;
			minutes = seconds / 60.0;

			//clock test to be deleted later
			//test passed
			System.out.print("Duration:" + String.format("%.2f",  minutes) + "\n");
			System.out.print("Start Date: " + startDate + "\n");
			System.out.print("Start Time: " + startTime + "\n");
			System.out.print("Stop Date: " + stopDate + "\n");
			System.out.print("Stop Time: " + stopTime + "\n");
			
			//change clockLabel
			clockLabel.setText("Clock is Stopped");
			clockLabel.setStyle("-fx-background-color: red;");
			isRunning = false;
			
			//new EffortLogEntry object
			//for now employee rank will just be empty
			//once connected to registration somehow will add to this
			//will also be added through some method once connected to logs system
			EffortLogEntry logEntry = new EffortLogEntry(projectType, lifeCycleStep, categoryName, effortName, otherDescription,
										startDate, startTime, stopTime, employeeRank, minutes);
			//test to be deleted later
			//test passed
			System.out.println(logEntry.getProjectType());
			System.out.println(logEntry.getLifeCycleStep());
			System.out.println(logEntry.getCategoryName());
			System.out.println(logEntry.getEffortName());
			System.out.println(logEntry.getOtherDescription());
			System.out.println(logEntry.getDate());
			System.out.println(logEntry.getStartTime());
			System.out.println(logEntry.getStopTime());
			System.out.println(logEntry.getEmployeeRank());
			System.out.println(String.format("%.2f", logEntry.getDuration()));
		}
		else {
			//display message that clock is not running
			notRunningLabel.setVisible(true);
		}
	}
	
	//format the date
	private String formatDate(LocalDateTime dateTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return dateTime.format(formatter);
	}
	
	//format the time
	private String formatTime(LocalDateTime dateTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return dateTime.format(formatter);
	}
	
	//event handler for the back to home button
	public void backButtonEventHandler(ActionEvent event) {
		//move scene to home screen
	}
}