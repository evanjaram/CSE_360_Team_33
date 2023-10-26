package application;

public class EffortLogEntry {
	private String projectType, lifeCycleStep, categoryName, effortName, otherDescription;
	private String date, startTime, stopTime;
	private String employeeRank;
	private double duration;
	
	//default constructor
	EffortLogEntry() {
		this.projectType = null;
		this.lifeCycleStep = null;
		this.categoryName = null;
		this.effortName = null;
		this.otherDescription = null;
		this.date = null;
		this.startTime = null;
		this.stopTime = null;
		this.employeeRank = null;
		this.duration = 0.0;
	}
	
	//overloaded constructor
	EffortLogEntry(String projectType, String lifeCycleStep, String categoryName, String effortName, 
					String otherDescription, String date, String startTime, String stopTime, 
					String employeeRank, double duration) {
		this.projectType = projectType;
		this.lifeCycleStep = lifeCycleStep;
		this.categoryName = categoryName;
		this.effortName = effortName;
		this.otherDescription = otherDescription;
		this.date = date;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.employeeRank = employeeRank;
		this.duration = duration;
	}
	
	//accessor methods
	
	//accessor for project type
	public String getProjectType() {
		return projectType;
	}
	
	//accessor for life cycle step
	public String getLifeCycleStep() {
		return lifeCycleStep;
	}
	
	//accessor for category name
	public String getCategoryName() {
		return categoryName;
	}
	
	//accessor for effort name
	public String getEffortName() {
		return effortName;
	}
	
	//accessor for other description
	public String getOtherDescription() {
		return otherDescription;
	}
	
	//accessor for date
	public String getDate() {
		return date;
	}
	
	//accessor for start time
	public String getStartTime() {
		return startTime;
	}
	
	//accessor for stop time
	public String getStopTime() {
		return stopTime;
	}
	
	//accessor for employee rank
	public String getEmployeeRank() {
		return employeeRank;
	}
	
	//accessor for duration
	public double getDuration() {
		return duration;
	}
	
	//mutator methods
	
	//mutator for project type
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	
	//mutator for life cycle step
	public void setLifeCycleStep(String lifeCycleStep) {
		this.lifeCycleStep = lifeCycleStep;
	}
	
	//mutator for category name
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	//mutator for effort name
	public void setEffortName(String effortName) {
		this.effortName = effortName;
	}
	
	//mutator for other description
	public void setOtherdescription(String otherDescription) {
		this.otherDescription = otherDescription;
	}
	
	//mutator for date
	public void setDate(String date) {
		this.date = date;
	}
	
	//mutator for start time
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	//mutator for stop time
	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}
	
	//mutator for employee rank
	public void setEmployeeRank(String employeeRank) {
		this.employeeRank = employeeRank;
	}
	
	//mutator for duration
	public void setDuration(double duration) {
		this.duration = duration;
	}
}