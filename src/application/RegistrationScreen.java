package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class RegistrationScreen {
	//Registration GUI Components
	@FXML
	private AnchorPane registrationScene;
	@FXML
	private Circle circleLogo;
	@FXML
	private Line checkLogo1, checkLogo2;
	@FXML
	private Label nameLogo, sceneLabel, usernameLabel, emailLabel, passwordLabel1, passwordLabel2;
	@FXML
	private Label successLabel, emptyFieldWarning, diffPasswordWarning;
	@FXML
	private TextField usernameField, emailField, passwordField1, passwordField2;
	@FXML
	private Button registerButton, leaveSceneButton;
	private static String username, email, password, rePassword;
	
	@FXML
	//initializes GUI components
	public void initialize() {
		//initialize anchorpane
		registrationScene = new AnchorPane();
		
		//attaches buttons to handlers
		registerButton.setOnAction(this::registerButtonHandler);
		leaveSceneButton.setOnAction(this::leaveSceneButtonHandler);
		
		//hide registration notification labels from user initially
		successLabel.setVisible(false);
		emptyFieldWarning.setVisible(false);
		diffPasswordWarning.setVisible(false);
	}
	
	//username field handler for inputting username registration info
	public void usernameFieldHandler(ActionEvent event) {
		username = usernameField.getText();
	}
	
	//email field handler for inputting email registration info
	public void emailFieldHandler(ActionEvent event) {
		email = emailField.getText();
	}
	
	//first password field handler for inputting password for first time
	public void passwordField1Handler(ActionEvent event) {
		password = passwordField1.getText();
	}
	
	//second password field handler to verify first password field matches second field
	public void passwordField2Handler(ActionEvent event) {
		rePassword = passwordField2.getText();
	}
	
	//confirms info is correctly entered and displays registration confirmation pop-up
	public void registerButtonHandler(ActionEvent event) {
		successLabel.setVisible(true);
		/*if(username != null && email != null && password != null && rePassword != null) {
			if(password.equals(rePassword)) {
				successLabel.setVisible(true);
				emptyFieldWarning.setVisible(false);
				diffPasswordWarning.setVisible(false);
			}else {
				diffPasswordWarning.setVisible(true);
				successLabel.setVisible(false);
				emptyFieldWarning.setVisible(false);
			}
		}else {
			emptyFieldWarning.setVisible(true);
			successLabel.setVisible(false);
			diffPasswordWarning.setVisible(false);
		}*/
	}
	
	//return user to login screen with or without registration
	public void leaveSceneButtonHandler(ActionEvent event) {
		Main.setScene("/LoginScreen.fxml");
	}

}
