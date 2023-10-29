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
	private Stage stage;
	 private Scene scene;
	 private Parent root;
	public void switchtoLoginScreen(ActionEvent event) throws IOException
	{
		  root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
	}
	
	public void switchtoCreateAccount(ActionEvent event) throws IOException
	{
		  root = FXMLLoader.load(getClass().getResource("/RegistrationScreen.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
	}
	
	public void switchtoSignUpScreen(ActionEvent event) throws IOException //really is the sign in button bad naming oops
	{
		 root = FXMLLoader.load(getClass().getResource("/signUpScreen.fxml"));
		 stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 scene = new Scene(root);
		 stage.setScene(scene);
		 stage.show();
	}
	public void switchtoRegistrationScreen(ActionEvent event) throws IOException
	{
		  root = FXMLLoader.load(getClass().getResource("/RegistrationScreen.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
	}
	
	public void switchtoEffortLogEditor(ActionEvent event) throws IOException
	{
		  root = FXMLLoader.load(getClass().getResource("/EffortLogEditor.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
	}
	
	public void switchtoTwoFactorAuthentication(ActionEvent event) throws IOException
	{
		  root = FXMLLoader.load(getClass().getResource("/TwoFactorAuthentication.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
	}
	
	public void switchtoTwoHome(ActionEvent event) throws IOException
	{
		  root = FXMLLoader.load(getClass().getResource("/Home.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
	}
}
