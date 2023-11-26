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

public class DevelopmentDefectsController implements Initializable {
	
	@FXML
	private TableView<DefectLogEntry> defectTable;
	
	@FXML
	private Button backButton;
	
	@FXML
	private TableColumn<DefectLogEntry, Integer> column1;
	@FXML
	private TableColumn<DefectLogEntry, String> column2, column3, column4, column5, column6, column7;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		column1.setCellValueFactory(new PropertyValueFactory<DefectLogEntry, Integer>("number"));
		column2.setCellValueFactory(new PropertyValueFactory<DefectLogEntry, String>("name"));
		column3.setCellValueFactory(new PropertyValueFactory<DefectLogEntry, String>("status"));
		column4.setCellValueFactory(new PropertyValueFactory<DefectLogEntry, String>("injected"));
		column5.setCellValueFactory(new PropertyValueFactory<DefectLogEntry, String>("removed"));
		column6.setCellValueFactory(new PropertyValueFactory<DefectLogEntry, String>("category"));
		column7.setCellValueFactory(new PropertyValueFactory<DefectLogEntry, String>("details"));
		
		defectTable.setItems(getDefects());
		
		backButton.setOnAction(this::backButtonEventHandler);
	}
	
	//handle events for back button
	public void backButtonEventHandler(ActionEvent event) {
		Main.setScene("/Logs.fxml");
	}
	
	//array list to observable list
	public ObservableList<DefectLogEntry> getDefects() {
		ObservableList<DefectLogEntry> result = FXCollections.observableArrayList();
		for (int i = 0; i < Main.developmentProject.defectLogs.size(); i++) {
			result.add(Main.developmentProject.defectLogs.get(i));
		}
		return result;
	}
}
