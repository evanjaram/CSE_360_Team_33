package application;

import java.util.HashMap;

public class RegistrationEntry {

	public  String username; //username should be public
	public  String  email, password, rePassword;
	public HashMap<String, String> userandpassword;
	

	RegistrationEntry()
	{
		this.userandpassword = new HashMap<String, String>(); //create global variable that creates hashmap
		this.username = null;
		this.email = null;
		this.password = null;
		this.rePassword = null;
		userandpassword.put("Bob", "TheBuilder");
		userandpassword.put("COCO", "Smith41");
		userandpassword.put("Nathan", "Klonaris1238");
		userandpassword.put("James", "Dawson");
		userandpassword.put("Joe", "Cohen33");
		userandpassword.put("Bob", "TheBuilder");
		userandpassword.put("Juju", "Rida");
		userandpassword.put("Nick", "Stathis");
		userandpassword.put("James", "Dawson");
		userandpassword.put("Ghofran", "Alz");
		userandpassword.put("Evan", "Jaramillo");
	}

	//getter
	public String getUsername() {
		return username; 
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getpassword() {
		return password;
	}
	
	public String getrePassword() {
		return rePassword;
	}
	
	public HashMap<String, String> data()
	{
		return userandpassword;
	}

	
	//setter
	public void setUsername(String newUser) {
		this.username = newUser;
		
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setrePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	
	public void addUser(String username, String password)
	{
		this.username = username;
		this.password = password;
		this.userandpassword.put(this.username, this.password);
	}

}
