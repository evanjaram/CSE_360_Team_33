//Author: Evan Jaramillo
//Description: this class is for each individual defect log entry

package application;

public class DefectLogEntry {
	private String projectType, name, details, injected, removed, category, status;
	private int number;
	
	//default constructor
	DefectLogEntry() {
		this.projectType = null;
		this.name = "-new defect-";
		this.details = null;
		this.injected = null;
		this.removed = null;
		this.category = null;
		this.status = null;
		this.number = 0;
	}
	
	//overloaded constructor
	DefectLogEntry(String projectType, String name, String details, String injected, String removed, 
					String category, String status, int number) {
		this.projectType = projectType;
		this.name = name;
		this.details = details;
		this.injected = injected;
		this.removed = removed;
		this.category = category;
		this.status = status;
		this.number = number;
	}
	
	//accessor methods
	public String getProjectType() {
		return projectType; 
	}
	
	public String getName() {
		return name;
	}
	
	public String getdetails() {
		return details;
	}
	
	public String getInjected() {
		return injected;
	}
	
	public String getRemoved() {
		return removed;
	}
	
	public String getCategory() {
		return category;
	}
	
	public String getStatus() {
		return status;
	}
	
	public int getNumber() {
		return number;
	}
	
	//mutator methods
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDetails(String details) {
		this.details = details;
	}
	
	public void setInjected(String injected) {
		this.injected = injected;
	}
	
	public void setRemoved(String removed) {
		this.removed = removed;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
}
