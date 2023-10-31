package application;

import javafx.scene.control.Alert;
import javafx.scene.layout.Region;


//Making a test comment to see if command line github can work for me
public class JoeUtils {
	public static void showError(String message) {
		new Alert(Alert.AlertType.ERROR, message).show();
	}
	
	public static boolean isNumber(String input) {
	    try {
	        Double.parseDouble(input);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	
	public static void setDimensions(Region thing, double x, double y, double width, double height) {
	    thing.setLayoutX(x);
	    thing.setLayoutY(y);
	    thing.setPrefWidth(width);
	    thing.setPrefHeight(height);
	}
}
