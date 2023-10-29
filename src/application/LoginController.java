package application;


import java.io.IOException;
import java.util.EventObject;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginController {
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
}
