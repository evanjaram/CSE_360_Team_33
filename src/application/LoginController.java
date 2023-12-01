package application;


import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.EventObject;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController extends RegistrationScreen implements Initializable{
	@FXML
	public TextField userID;
	@FXML
	private PasswordField userPassword;
	@FXML
	private Label granted, passwordEmpty, usernameEmpty, denied;
	@FXML
	private Button loginButton;
	
	
	String username, password, storedUser, storedPassword;
	RegistrationScreen screen = new RegistrationScreen();
	RegistrationEntry entry = new RegistrationEntry();//creates object
	HashMap<String, String> fromRegistration = screen.registerMap();
	
public void printValues()
{
	for (String key : fromRegistration.keySet()) {
        System.out.println(key);
    }
}
	
	public String usernameFieldHandler(ActionEvent event) {	
		username = userID.getText();
		if(userID.getText() == null ||userID.getText().trim().isEmpty())
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
	
	public String passwordFieldHandler(ActionEvent event) {	
		password = userPassword.getText();
		if(userPassword.getText() == null ||userPassword.getText().trim().isEmpty())
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
	
	public boolean checkCredentials(String storedUser, String storedPassword)
	{
		for(HashMap.Entry<String, String> key : fromRegistration.entrySet())
		{
			String keys = key.getKey();
			String value = key.getValue();
	
			if (keys.equals(storedUser) && value.equals(storedPassword))
			{
				System.out.println("Access Granted");
				return true;
			}
		}
		return false;
	}
	public void loginButtonHandler(ActionEvent event)
	{
		storedUser = usernameFieldHandler(event);
		storedPassword = passwordFieldHandler(event);
		
		 	if(storedUser == null && storedPassword == null)
	 		{
		 		passwordEmpty.setVisible(false);
				usernameEmpty.setVisible(false);
				denied.setVisible(true);
	 		}
		 	else if(storedUser == null)
		 	{
				passwordEmpty.setVisible(false);
				usernameEmpty.setVisible(true);
				denied.setVisible(false);
		 	}
		 	else if(storedPassword == null)
			{
				passwordEmpty.setVisible(true);
				usernameEmpty.setVisible(false);
				denied.setVisible(false);
			}
		 	
		 	else if(storedUser != null && storedPassword != null)
			{
				boolean check = checkCredentials(storedUser, storedPassword);
				if(check == true)
				{
					printValues();
					Main.setScene("/Home.fxml");
				}
				else if(check == false)
				{
					passwordEmpty.setVisible(false);
					usernameEmpty.setVisible(false);
					denied.setVisible(true);
				}
			}
//				else
//				{
//					System.out.println("No username and " + "no password");
//					passwordEmpty.setVisible(false);
//					usernameEmpty.setVisible(false);
//					denied.setVisible(true);
//				}
//	
//		System.out.println("user: "+storedUser);
//		System.out.println("password" + storedPassword);
	}
	
	public void switchtoLoginScreen(ActionEvent event) throws IOException
	{
		Main.setScene("/LoginScreen.fxml");
	}
	
	public void switchtoCreateAccount(ActionEvent event) throws IOException
	{
		Main.setScene("/RegistrationScreen.fxml");
	}
	
	public void switchtoSignUpScreen(ActionEvent event) throws IOException //really is the sign in button bad naming oops
	{
		Main.setScene("/signUpScreen.fxml");
	}
	public void switchtoRegistrationScreen(ActionEvent event) throws IOException
	{
		Main.setScene("/RegistrationScreen.fxml");
	}
	
	public void switchtoEffortLogEditor(ActionEvent event) throws IOException
	{
		Main.setScene("/EffortLogEditor.fxml");
	}
	
	public void switchtoTwoFactorAuthentication(ActionEvent event) throws IOException
	{
		Main.setScene("/TwoFactorAuthentication.fxml");
	}
	
	public void switchtoTwoHome(ActionEvent event) throws IOException
	{
		Main.setScene("/Home.fxml");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
//		passwordEmpty.setVisible(false);
//		usernameEmpty.setVisible(false);
//		denied.setVisible(false);
//		loginButton.setOnAction(this::loginButtonHandler);
		
	}
}
