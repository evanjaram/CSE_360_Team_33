package application;

import java.util.ArrayList;

import java.util.HashMap;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

// Author: Joseph Cohen

public class EffortLogViewerController {
	
	// This aligns with the design because it allows the users to see a list of all the features
	// Also, if they want to look at a particular feature in detail and potentially edit it, they can
	@FXML
	private AnchorPane anchor;
	
	
	// have a list of all the features that have been previously implemented
	private static ArrayList<FeatureInfo> features = generateFeatures();
	
	// used so that when the user clicks on a button, I know what index in the List "features" it corresponds to
	private HashMap<Button, Integer> map;
	
	private static ArrayList<FeatureInfo> generateFeatures(){
		ArrayList<FeatureInfo> result = new ArrayList<>();
		for(int i = 0; i < 100; i++) {
			result.add(new FeatureInfo("Example Feature " + i));
		}
		return result;
	}
	
	
	
	// set up the scene so that the user is able to see previous features, view them, and edit them
	@FXML
	private void initialize() {
		VBox vbox = new VBox();
		ScrollPane scroll = new ScrollPane(vbox);
		
		JoeUtils.setDimensions(scroll, 22, 121, 560, 200);
		anchor.getChildren().add(scroll);
		vbox.setPrefWidth(scroll.getPrefWidth() - 20);
		
		map = new HashMap<>();
		for(int i = 0; i < features.size(); i++) {
			FeatureInfo item = features.get(i);
			Button button = new Button(item.name);
		    button.setMaxWidth(Double.MAX_VALUE);
		    button.setAlignment(Pos.CENTER_LEFT);
		    vbox.getChildren().add(button);
		    map.put(button, i);
		}
		
		for(Node node : vbox.getChildren()) {
		    node.setOnMouseClicked(event -> {
		        if(event.getClickCount() == 2) {
		        	Button clickedButton = (Button) event.getSource();
		        	EffortLogEditorController.currFeature = features.get(map.get(clickedButton));
		        	Main.setScene("/EffortLogEditor.fxml");
		        }
		    });
		}


	}
	
	// Transition back to the Home scene
	@FXML
	private void goHome() {
		Main.setScene("/Home.fxml");
	}
	
}
