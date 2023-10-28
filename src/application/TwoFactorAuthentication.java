package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class TwoFactorAuthentication implements Initializable {
	//TwoFA GUI Components
	
	@FXML
	private AnchorPane twoFAScene;
	private Timer timer;
	private int timerDelay;
	@FXML
	private Circle circleLogo;
	@FXML
	private Line checkLogo1, checkLogo2;
	@FXML
	private Label nameLogo, sceneLabel, emailNotifLabel, timerLabel;
	@FXML
	private VBox vb;
	@FXML
	private PasswordField passwordField;
	@FXML
	private Button verifyButton;
	
	@Override
	//initializes GUI components
	public void initialize(URL firstArg, ResourceBundle rb) {
		
	}
	
	//key password field event handler for inputting key
	public void keyFieldHandler(ActionEvent event) {
		
	}
	
	//verification button event handler to verify key is correct and move to home scene
	public void verifyButtonHandler(ActionEvent event) {
		
	}
	
	//counts down timer and returns to login screen if reaches 0
	private void timerHandler(Timer timer, int timerDelay) {
		Main.setScene("/TwoFactorAuthentication.fxml");
	}

}
