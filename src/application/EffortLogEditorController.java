package application;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class EffortLogViewerController {

	@FXML
	private AnchorPane anchor;
	
	@FXML
	private void initialize() {
		VBox vbox = new VBox();
		ScrollPane scroll = new ScrollPane(vbox);
		
		JoeUtils.setDimensions(scroll, 22, 121, 560, 200);
		anchor.getChildren().add(scroll);
		vbox.setPrefWidth(scroll.getPrefWidth() - 20);
		
		ArrayList<String> features = new ArrayList<>();
		for(int i = 1; i < 100; i++) {
			features.add("Item " + i);
		}
		
		for(String item : features) {
			Button button = new Button(item);
		    button.setMaxWidth(Double.MAX_VALUE);
		    button.setAlignment(Pos.CENTER_LEFT);
		    vbox.getChildren().add(button);
		}
		
		for(Node node : vbox.getChildren()) {
		    node.setOnMouseClicked(event -> {
		        if(event.getClickCount() == 2) {
		        	Main.setScene("/EffortLogEditor.fxml");
		        }
		    });
		}


	}
	
	@FXML
	private void goHome() {
		Main.setScene("/Home.fxml");
	}
	
}
