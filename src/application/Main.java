package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main extends Application {
	private static Stage globalStage;
	//global project objects
	public static Project businessProject = new Project();
	public static Project developmentProject = new Project();
	
	//csv files
	private static final String BE_CSV_FILE_PATH = "BusinessEfforts.csv";
	private static final String DE_CSV_FILE_PATH = "DevelopmentEfforts.csv";
	private static final String BD_CSV_FILE_PATH = "BusinessDefects.csv";
	private static final String DD_CSV_FILE_PATH = "DevelopmentDefects.csv";
	
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
	
	//write to BusinessEfforts.csv file
	private static void writeBusinessEfforts() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(BE_CSV_FILE_PATH))) {
			//write headers
			writer.write("Life Cycle Step, Category, Effort, Date, Start Time, Stop Time, Duration, Other");
			writer.newLine();
			
			for (int i = 0; i < businessProject.effortLogs.size(); i++) {
				String lifeCycle = businessProject.effortLogs.get(i).getLifeCycleStep();
				String category = businessProject.effortLogs.get(i).getCategoryName();
				String effort = businessProject.effortLogs.get(i).getEffortName();
				String date = businessProject.effortLogs.get(i).getDate();
				String startTime = businessProject.effortLogs.get(i).getStartTime();
				String stopTime = businessProject.effortLogs.get(i).getStopTime();
				String duration = businessProject.effortLogs.get(i).getDuration();
				String other = businessProject.effortLogs.get(i).getOtherDescription();
				
				writeEffortRow(writer, lifeCycle, category, effort, date, startTime, stopTime, duration, other);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//write to DevelopmentEfforts.csv file
	private static void writeDevelopmentEfforts() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(DE_CSV_FILE_PATH))) {
			//write headers
			writer.write("Life Cycle Step, Category, Effort, Date, Start Time, Stop Time, Duration, Other");
			writer.newLine();
			
			for (int i = 0; i < developmentProject.effortLogs.size(); i++) {
				String lifeCycle = developmentProject.effortLogs.get(i).getLifeCycleStep();
				String category = developmentProject.effortLogs.get(i).getCategoryName();
				String effort = developmentProject.effortLogs.get(i).getEffortName();
				String date = developmentProject.effortLogs.get(i).getDate();
				String startTime = developmentProject.effortLogs.get(i).getStartTime();
				String stopTime = developmentProject.effortLogs.get(i).getStopTime();
				String duration = developmentProject.effortLogs.get(i).getDuration();
				String other = developmentProject.effortLogs.get(i).getOtherDescription();
				
				writeEffortRow(writer, lifeCycle, category, effort, date, startTime, stopTime, duration, other);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//write possible null data for efforts
	private static void writeEffortRow(BufferedWriter writer, String lifeCycle, String category, String effort, 
			String date, String startTime, String stopTime, String duration, String other) throws IOException {
		//handle null values by converting them to " "
		writer.write((lifeCycle != null ? lifeCycle : " ") + ", " + (category != null ? category : " ") + ", " 
				+ (effort != null ? effort : " ") + ", " + (date != null ? date : " ") + ", " + (startTime != null ? startTime : " ")
				+ ", " + (stopTime != null ? stopTime : " ") + ", " + (duration != null ? duration : " ") + ", " + 
				(other != null ? other : "none"));
		writer.newLine();
	}
	
	//write to BusinessDefects.csv file
	private static void writeBusinessDefects() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(BD_CSV_FILE_PATH))) {
			//write headers
			writer.write("Number, Name, Status, Step Injected, Step Removed, Category, Details");
			writer.newLine();
			
			for (int i = 0; i < businessProject.defectLogs.size(); i++) {
				int number = businessProject.defectLogs.get(i).getNumber();
				String name = businessProject.defectLogs.get(i).getName();
				String status = businessProject.defectLogs.get(i).getStatus();
				String injected = businessProject.defectLogs.get(i).getInjected();
				String removed = businessProject.defectLogs.get(i).getRemoved();
				String category = businessProject.defectLogs.get(i).getCategory();
				String details = businessProject.defectLogs.get(i).getDetails();
				
				writeDefectRow(writer, number, name, status, injected, removed, category, details);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//write to DevelopmentDefects.csv file
	private static void writeDevelopmentDefects() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(DD_CSV_FILE_PATH))) {
			//write headers
			writer.write("Number, Name, Status, Step Injected, Step Removed, Category, Details");
			writer.newLine();
			
			for (int i = 0; i < developmentProject.defectLogs.size(); i++) {
				int number = developmentProject.defectLogs.get(i).getNumber();
				String name = developmentProject.defectLogs.get(i).getName();
				String status = developmentProject.defectLogs.get(i).getStatus();
				String injected = developmentProject.defectLogs.get(i).getInjected();
				String removed = developmentProject.defectLogs.get(i).getRemoved();
				String category = developmentProject.defectLogs.get(i).getCategory();
				String details = developmentProject.defectLogs.get(i).getDetails();
				
				writeDefectRow(writer, number, name, status, injected, removed, category, details);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//write possible null data for defects
	private static void writeDefectRow(BufferedWriter writer, Integer number, String name, String status, String injected, 
			String removed, String category, String details) throws IOException {
		//handle null values by converting them to " "
		writer.write((number != null ? number : -99) + ", " + (name != null ? name : " ") + ", " + (status != null ? status : " ") 
				+ ", " + (injected != null ? injected : " ") + ", " + (removed != null ? removed : " ") + ", " + 
				(category != null ? category : " ") + ", " + (details != null ? details : " "));
		writer.newLine();
	}
	
	//read in from BusinessEfforts.csv file
	private void readBusinessEfforts() {
		try (BufferedReader reader = new BufferedReader(new FileReader(BE_CSV_FILE_PATH))) {
			String line = "";
			
			//read and ignore headers
			reader.readLine();
			
			while ((line  = reader.readLine()) != null) {
				String[] values = line.split(", ");
				
				String lifeCycle = values[0].trim();
				String category = values[1].trim();
				String effort = values[2].trim();
				String date = values[3].trim();
				String startTime = values[4].trim();
				String stopTime = values[5].trim();
				String duration = values[6].trim();
				String other = values[7].trim();
				
				EffortLogEntry newEffort = new EffortLogEntry("Business Project", lifeCycle, category, effort, other, 
						date, startTime, stopTime, duration);
				
				businessProject.effortLogs.add(newEffort);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//read in from DevelopmentEfforts.csv file
	private void readDevelopmentEfforts() {
		try (BufferedReader reader = new BufferedReader(new FileReader(DE_CSV_FILE_PATH))) {
			String line = "";
			
			//read and ignore headers
			reader.readLine();
			
			while ((line  = reader.readLine()) != null) {
				String[] values = line.split(", ");
				
				String lifeCycle = values[0].trim();
				String category = values[1].trim();
				String effort = values[2].trim();
				String date = values[3].trim();
				String startTime = values[4].trim();
				String stopTime = values[5].trim();
				String duration = values[6].trim();
				String other = values[7].trim();
				
				EffortLogEntry newEffort = new EffortLogEntry("Development Project", lifeCycle, category, effort, other, 
						date, startTime, stopTime, duration);
				
				developmentProject.effortLogs.add(newEffort);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//read in from BusinessDefects.csv file
	private static void readBusinessDefects() {
		try (BufferedReader reader = new BufferedReader(new FileReader(BD_CSV_FILE_PATH))) {
			String line = "";
			
			//read and ignore headers
			reader.readLine();
			
			while ((line  = reader.readLine()) != null) {
				String[] values = line.split(", ");
				
				int number = Integer.parseInt(values[0].trim());
				String name = values[1].trim();
				String status = values[2].trim();
				String injected = values[3].trim();
				String removed = values[4].trim();
				String category = values[5].trim();
				String details = values[6].trim();
				
				DefectLogEntry newDefect = new DefectLogEntry("Business Project", name, details, injected, removed, category, 
						status, number);
				
				businessProject.defectLogs.add(newDefect);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//read in from DevelopmetDefects.csv file
	private static void readDevelopmentDefects() {
		try (BufferedReader reader = new BufferedReader(new FileReader(DD_CSV_FILE_PATH))) {
			String line = "";
			
			//read and ignore headers
			reader.readLine();
			
			while ((line  = reader.readLine()) != null) {
				String[] values = line.split(", ");
				
				int number = Integer.parseInt(values[0].trim());
				String name = values[1].trim();
				String status = values[2].trim();
				String injected = values[3].trim();
				String removed = values[4].trim();
				String category = values[5].trim();
				String details = values[6].trim();
				
				DefectLogEntry newDefect = new DefectLogEntry("Development Project", name, details, injected, removed, category, 
						status, number);
				
				developmentProject.defectLogs.add(newDefect);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void start(Stage primaryStage) {
		globalStage = primaryStage;
    	setScene("/Home.fxml");
    	
    	//read in from CSV files defects and efforts on stage start
    	readBusinessEfforts();
    	readDevelopmentEfforts();
    	readBusinessDefects();
    	readDevelopmentDefects();
    	
    	//write to CSV files defects and efforts on stage close
    	globalStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
    		@Override
    		public void handle(WindowEvent event) {
    			System.out.println("Closing");
    			writeBusinessEfforts();
    			writeDevelopmentEfforts();
    			writeBusinessDefects();
    			writeDevelopmentDefects();
    		}
    	});
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
