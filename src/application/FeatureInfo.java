package application;

// Author: Joseph Cohen

// Defines the information that will be associated with each feature.

public class FeatureInfo {
	public String name;
	public String tags;
	public String notes;
	public double esimatedStoryPoints;
	public double hoursSpent;
	
	
	public FeatureInfo(String name, String tags, String notes, double estStoryPoints, double hrsSpent) {
		this.name = name;
		this.tags = tags;
		this.notes = notes;
		this.esimatedStoryPoints = estStoryPoints;
		this.hoursSpent = hrsSpent;
	}
	
	public FeatureInfo(String name, String tags) {
		this.name = name;
		this.tags = tags;
		this.notes = "";
		this.esimatedStoryPoints = -1.0;
		this.hoursSpent = -1.0;
	}
	
	public FeatureInfo(String name) {
		this.name = name;
		this.tags = "";
		this.notes = "";
		this.esimatedStoryPoints = -1.0;
		this.hoursSpent = -1.0;
	}
}
