package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

public class PublicLogsController {
	
	@FXML
	private ChoiceBox<String> nameChoiceBox;
	
	@FXML
	private Button goToEffortDefectLogsButton;
	
	private String[] names = {"Engineer 1","Engineer 2","Developer 1", "Developer 2", "Supervisor 1", "Supervisor 2", "Project Manager 1", "Project Manager 2"};
	
	private String[] sampleData = {
       "Effort Logs:\n     Project: Business Project.\n     Life Cycle Step: Planning.\n     Effort Catagory: Plans.\n     Plan: Project Plan.\n\n\nDefect Logs:\n     Project: Business Project.\n     Defect Category: Not specified.\n",
       "Effort Logs:\n     Project: Development Project.\n     Life Cycle Step: Requirements.\n     Effort Catagory: Plans.\n     Plan: Project Plan.\n\n\nDefect Logs:\n     Project: Development Project.\n     Defect Category: 30 Build, Package.\n",
       "Effort Logs:\n     Project: Business Project.\n     Life Cycle Step: Verifying.\n     Effort Catagory: Deliverables.\n     Deliverable: Conceptual Design.\n\n\nDefect Logs:\n     Project: Business Project.\n     Defect Category: 20 Syntax.\n",
       "Effort Logs:\n     Project: Development Project.\n     Life Cycle Step: Repository Update.\n     Effort Catagory: Deliverables.\n     Deliverable: Solution.\n\n\nDefect Logs:\n     Project: Development Project.\n     Defect Category: 50Interface.\n",
       "Effort Logs:\n     Project: Business Project.\n     Life Cycle Step: Outlining.\n     Effort Catagory: Interruptions.\n     Interruption: Visitor.\n\n\nDefect Logs:\n     Project: Business Project.\n     Defect Category: 40 Assignment.\n",
       "Effort Logs:\n     Project: Development Project.\n     Life Cycle Step: Problem Understanding.\n     Effort Catagory: Plans.\n     Plan: Risk Management Plan.\n\n\nDefect Logs:\n     Project: Development Project.\n     Defect Category: 70 Data.\n",
       "Effort Logs:\n     Project: Business Project.\n     Life Cycle Step: Information Gathering.\n     Effort Catagory: Plans.\n     Plan: Implementation Plan.\n\n\nDefect Logs:\n     Project: Business Project.\n     Defect Category: 10 Documentation.\n",
       "Effort Logs:\n     Project: Development Project.\n     Life Cycle Step: Test Case Generation.\n     Effort Catagory: Deliverables.\n     Deliverable: Test Cases.\n\n\nDefect Logs:\n     Project: Development Project.\n     Defect Category: 60 Checking.\n",
	};
	
	@FXML
	private void initialize() {
		nameChoiceBox.getItems().addAll(names);
	}
	
	@FXML
	private void goToHome() {
		Main.setScene("/Home.fxml");
	}
	
	@FXML
	private void goToEffortDefectLogs() {
		int selectedIndex = nameChoiceBox.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0 && selectedIndex < sampleData.length) {
			// Pass the selected name and data to EffortDefectLogsController
			EffortDefectLogsController.setData(names[selectedIndex], sampleData[selectedIndex]);
			Main.setScene("/EffortDefectLogs.fxml");
		}
	}
}
