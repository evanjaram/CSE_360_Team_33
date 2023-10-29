package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class PublicLogsController implements Initializable{
	
	
	@FXML
	private ChoiceBox<String> myChoiceBox;
	
	private String[] role = {"Enginer 1","Enginer 2","Developer 1", "Developer 2", "Supervisor 1", "Supervisor 2", "Project Manager 1", "Project Manager 2"};

	
    
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		myChoiceBox.getItems().addAll(role);
		myChoiceBox.setOnAction(this::getRole);	
	}
	
	public void getRole(ActionEvent event) {
		
		String myRole = myChoiceBox.getValue();
	}	
		
	private Stage stage;
	private Scene scene;
	private Parent root;
	

	public void switchToPublicLogs(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/PublicLogs.fxml")); 
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
 
        stage.show();
	}
	
	public void switchToHome(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/Home.fxml")); 
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	}	
	
	public void switchToNext(ActionEvent event) throws IOException {		
		Parent root = FXMLLoader.load(getClass().getResource("/Next.fxml")); 
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	}
}
