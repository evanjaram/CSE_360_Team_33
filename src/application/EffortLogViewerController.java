package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

// Author: Joseph Cohen

public class EffortLogViewerController {
	
	// This aligns with the design because it allows the users to see a list of all the features
	// Also, if they want to look at a particular feature in detail and potentially edit it, they can
	@FXML
	private AnchorPane anchor;
	
	private VBox vbox;
	
	@FXML
	private ScrollPane scrollPane;
	
	
	@FXML
	private TextField tagsField;
	
	
	// have a list of all the features that have been previously implemented
	private static ArrayList<FeatureInfo> allFeatures = generateExampleFeatures();
	
	private ArrayList<Button> allBtns;
	
	// when the user clicks on a button, I need a reference to the feature it corresponds to
	private HashMap<Button, FeatureInfo> map;
	
	private static ArrayList<FeatureInfo> generateExampleFeatures(){
		String[] exampleTags = {
				"database", "gui", "http", "security", "privacy", "planning poker"
		};
		ArrayList<String> exTags = new ArrayList<String>(Arrays.asList(exampleTags));
		ArrayList<FeatureInfo> result = new ArrayList<>();
		for(int i = 0; i < 100; i++) {
			Collections.shuffle(exTags);
			result.add(new FeatureInfo("Example Feature " + i, exTags.get(0) + ", " + exTags.get(1)));
		}
		return result;
	}
	
	
	
	
	// set up the scene so that the user is able to see previous features, view them, and edit them
	@FXML
	private void initialize() {
		this.vbox = new VBox();
		this.scrollPane.setContent(vbox);
		this.allBtns = new ArrayList<>();
		
		vbox.setPrefWidth(this.scrollPane.getPrefWidth() - 20);
		
		map = new HashMap<>();
		for(int i = 0; i < allFeatures.size(); i++) {
			FeatureInfo item = allFeatures.get(i);
			Button button = new Button(item.name + " --- (tags: " + item.tags + ")");
		    button.setMaxWidth(Double.MAX_VALUE);
		    button.setAlignment(Pos.CENTER_LEFT);
		    vbox.getChildren().add(button);
		    this.allBtns.add(button);
		    map.put(button, item);
		}
		
		for(Button btn : this.allBtns) {
			btn.setOnMouseClicked(event -> {
				if(event.getClickCount() == 2) {
					EffortLogEditorController.currFeature = map.get(btn);
		        	Main.setScene("/EffortLogEditor.fxml");
				}
			});
		}
	}
	
	@FXML
	private void filter() {
		if(this.tagsField.getText().equals("")) {
			this.initialize();
		} else {
			this.vbox.getChildren().clear();
			String[] tagsToSearchFor = this.tagsField.getText().split(",");
			ArrayList<String> tagsCleaned = new ArrayList<>();
			for(String s : tagsToSearchFor) {
				tagsCleaned.add(s.strip());
			}
			ArrayList<Button> toDisplay = new ArrayList<>();
			for(int i = 0; i < allBtns.size(); i++) {
				Button currBtn = allBtns.get(i);
				FeatureInfo currFeature = this.map.get(currBtn);
				String currTags = currFeature.tags;
				for(String tag : tagsCleaned) {
					if(currTags.contains(tag)) {
						toDisplay.add(currBtn);
						break;
					}
				}
			}
			toDisplay.sort((Button b1, Button b2) -> {
				FeatureInfo f1 = this.map.get(b1);
				FeatureInfo f2 = this.map.get(b2);
				int count1 = 0;
				int count2 = 0;
				for(String tag : tagsCleaned) {
					if(f1.tags.contains(tag)) {
						count1++;
					}
					if(f2.tags.contains(tag)) {
						count2++;
					}
				}
				return count2 - count1;
			});
			for(Button btn : toDisplay) {
				this.vbox.getChildren().add(btn);
			}
		}
	}
	
	// Transition back to the Home scene
	@FXML
	private void goHome() {
		Main.setScene("/Home.fxml");
	}
	
}
