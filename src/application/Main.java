package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.*;


public class Main extends Application {
	private static Stage globalStage;
	public static Project businessProject = new Project();
	public static Project developmentProject = new Project();
	
	public static void setScene(String fxmlFilename){
		try {
		    Parent root = FXMLLoader.load(Main.class.getResource(fxmlFilename));
		    Scene scene = new Scene(root);
		    globalStage.setScene(scene);
		    globalStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void start(Stage primaryStage) {
		globalStage = primaryStage;
    		setScene("/Home.fxml");
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
