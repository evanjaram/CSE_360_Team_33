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
		globalStage = stage;
    		setScene("EffortLoggerGUI.fxml");
		// try {
		// 	//will change to login screen eventually
		// 	Parent root = FXMLLoader.load(getClass().getResource("EffortLoggerGUI.fxml"));
		// 	Scene scene = new Scene(root);
		// 	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		// 	primaryStage.setScene(scene);
		// 	primaryStage.show();
		// } catch(Exception e) {
		// 	e.printStackTrace();
		// }
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
