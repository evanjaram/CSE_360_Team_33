package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import java.util.HashMap;
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
	private TextField usernameField, emailField;
	@FXML
	private TextField  passwordField1, passwordField2;
	@FXML
	private Button registerButton, leaveSceneButton;
	public  String username, newUser; //username should be public
	protected  String  email, password, rePassword;
	RegistrationEntry entry = new RegistrationEntry();//creates object
	HashMap<String, String> register = entry.data(); //create global variable that creates hashmap
	
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
	

	public HashMap<String, String> registerMap()
	{
		return register;
	}
	
	//username field handler for inputting username registration info
	public String usernameFieldHandler(ActionEvent event) {
		
		username = usernameField.getText();
		if(usernameField.getText() == null ||usernameField.getText().trim().isEmpty())
		{
			username = null;
			return username;
		}
		else
		{
			entry.setUsername(username);
			return username;
		}
	}
	
	//email field handler for inputting email registration info
	public String emailFieldHandler(ActionEvent event) {
		email = emailField.getText();
		entry.setEmail(email);
		return email;
	}
	
	//first password field handler for inputting password for first time
	public String passwordField1Handler(ActionEvent event) {
		password = passwordField1.getText();
		if(passwordField1.getText() == null ||passwordField1.getText().trim().isEmpty())
		{
			password = null;
			return password;
		}
		else
		{
			entry.setPassword(password);
			return password;
		}
	}
	
	
	//reason why the login did accepted any input is because Logan never returned the data the user gave
	//
	//second password field handler to verify first password field matches second field
	public String passwordField2Handler(ActionEvent event) { 
		
		rePassword = passwordField2.getText();
		if(passwordField2.getText() == null ||passwordField2.getText().trim().isEmpty())
		{
			rePassword = null;
			return rePassword;
		}
		else
		{
			entry.setrePassword(rePassword);
			return rePassword;
		}

		
	}
	
	public boolean verifyPasswords(String password, String password2)
	{
		if(password.equals(password2) && password != null && password2 != null)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
//	public void RegisterAccount(String username, String password, boolean checkPassword)
//	{
//		userandpassword.put(username, password);
//	}
	
	public boolean checkCredentials(String storedUser)
	{
		for(HashMap.Entry<String, String> key : entry.userandpassword.entrySet())
		{
			String keys = key.getKey();
			String value = key.getValue();
	
			if (keys.equals(storedUser))
			{
				
				return false;
			}
		}
		
		return true;
	}

	//confirms info is correctly entered and displays registration confirmation pop-up
	public void registerButtonHandler(ActionEvent event) {
//		successLabel.setVisible(true);
		
		//store the variables
		newUser = usernameFieldHandler(event);
		password = passwordField1Handler(event);
		email = emailFieldHandler(event);
		rePassword = passwordField2Handler(event);
//		System.out.println(entry.getUsername());
//		System.out.print(entry.getpassword());
		if(newUser != null && email != null && password != null && rePassword != null) { //checks if all inputs are put in
			boolean check = checkCredentials(newUser);
			if(check == false)
			{
				System.out.println("User is already in database");
				return;
			}
			
			if(verifyPasswords(password, rePassword) == true) {
				successLabel.setVisible(true);
				emptyFieldWarning.setVisible(false);
				diffPasswordWarning.setVisible(false);
				register.put(username, password);
				 
			}
			else {
				diffPasswordWarning.setVisible(true);
				successLabel.setVisible(false);
				emptyFieldWarning.setVisible(false);
			}
			
			
		}else {
			emptyFieldWarning.setVisible(true);
			successLabel.setVisible(false);
			diffPasswordWarning.setVisible(false);
		}
	}
	
	//return user to login screen with or without registration
	public void leaveSceneButtonHandler(ActionEvent event) {
		Main.setScene("/LoginScreen.fxml");
	}

}
