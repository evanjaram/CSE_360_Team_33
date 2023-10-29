package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class RegistrationScreen implements Initializable {
	@FXML
	public AnchorPane registrationScene;
	@FXML
	public Circle circleLogo;
	@FXML
	public Line checkLogo1, checkLogo2;
	@FXML
	public Label nameLogo, sceneLabel, usernameLabel, emailLabel, passwordLabel1, passwordLabel2;
	@FXML
	public TextField usernameField, emailField, passwordField1, passwordField2;
	@FXML
	public Button registerButton, leaveSceneButton;
	
	@Override
	//initializes GUI components
	public void initialize(URL firstArg, ResourceBundle rb) {
		//Registration GUI Components
		registerButton.setOnAction(this::registerButtonHandler);
		leaveSceneButton.setOnAction(this::leaveSceneButtonHandler);
	}
	
	//username field handler for inputting username registration info
	public void usernameFieldHandler(ActionEvent event) {
		
	}
	
	//email field handler for inputting email registration info
	public void emailFieldHandler(ActionEvent event) {
		
	}
	
	//first password field handler for inputting password for first time
	public void passwordField1Handler(ActionEvent event) {
		
	}
	
	//second password field handler to verify first password field matches second field
	public void passwordField2Handler(ActionEvent event) {
		
	}
	
	//confirms info is correctly entered and displays registration confirmation pop-up
	public void registerButtonHandler(ActionEvent event) {
		
	}
	
	//return user to login screen with or without registration
	public void leaveSceneButtonHandler(ActionEvent event) {
		Main.setScene("LoginScreen.fxml");
	}

}
