package application;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class BusinessEffortsController implements Initializable {
	
	@FXML
	private Button backButton;
	
	@FXML
	private TableView<EffortLogEntry> effortTable;
	
	@FXML
	private TableColumn<EffortLogEntry, String> column1, column2, column3, column4, column5, column6, column8;
	@FXML
	private TableColumn<EffortLogEntry, Double> column7;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//set up the columns
		column1.setCellValueFactory(new PropertyValueFactory<EffortLogEntry, String>("lifeCycleStep"));
		column2.setCellValueFactory(new PropertyValueFactory<EffortLogEntry, String>("categoryName"));
		column3.setCellValueFactory(new PropertyValueFactory<EffortLogEntry, String>("effortName"));
		column4.setCellValueFactory(new PropertyValueFactory<EffortLogEntry, String>("date"));
		column5.setCellValueFactory(new PropertyValueFactory<EffortLogEntry, String>("startTime"));
		column6.setCellValueFactory(new PropertyValueFactory<EffortLogEntry, String>("stopTime"));
		column7.setCellValueFactory(new PropertyValueFactory<EffortLogEntry, Double>("duration"));
		column8.setCellValueFactory(new PropertyValueFactory<EffortLogEntry, String>("otherDescription"));
		
		effortTable.setItems(getEfforts());
		
		backButton.setOnAction(this::backButtonEventHandler);
	}
	
	//handle events for back button
	public void backButtonEventHandler(ActionEvent event) {
		Main.setScene("/Logs.fxml");
	}
	
	//array list to observable list
	public ObservableList<EffortLogEntry> getEfforts() {
		ObservableList<EffortLogEntry> result = FXCollections.observableArrayList();
		for (int i = 0; i < Main.businessProject.effortLogs.size(); i++) {
			result.add(Main.businessProject.effortLogs.get(i));
		}
		return result;
	}
}


