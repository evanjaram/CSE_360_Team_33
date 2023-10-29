package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

public class PublicLogsController implements Initializable {
	
	@FXML
	private ChoiceBox<String> myChoiceBox;
	
	private String[] role = {"Engineer 1","Engineer 2","Developer 1", "Developer 2", "Supervisor 1", "Supervisor 2", "Project Manager 1", "Project Manager 2"};
    
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		myChoiceBox.getItems().addAll(role);
		myChoiceBox.setOnAction(this::getRole);	
	}
	
	public void getRole(ActionEvent event) {
		
		String myRole = myChoiceBox.getValue();
	}	

	public void switchToPublicLogs(ActionEvent event) {
		Main.setScene("/PublicLogs.fxml");
	}
	
	public void switchToNext(ActionEvent event) {
		Main.setScene("/Next.fxml");
	}
	
	public void switchToHome(ActionEvent event){
		Main.setScene("/Home.fxml");
	}	

}
