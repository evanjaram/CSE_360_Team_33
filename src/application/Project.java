//Author: Evan Jaramillo
//Description: This class is for the individual business and development projects. It consists of 
//			   DefectLogs and EffortLogs

package application;

import java.util.ArrayList;

public class Project {
	public ArrayList<EffortLogEntry> effortLogs;
	public ArrayList<DefectLogEntry> defectLogs;
	
	//constructor
	Project() {
		this.effortLogs = new ArrayList<EffortLogEntry>();
		this.defectLogs = new ArrayList<DefectLogEntry>();
	}
	
	//search for an effort
	public int findEffort(EffortLogEntry effort) {
		for (int i = 0; i < effortLogs.size(); i++) {
			if (effortLogs.get(i).equals(effort)) {
				return i;
			}
		}
		return -1;
	}
	
	//search for a defect
	public int findDefect(String name) {
		for (int i = 0; i < defectLogs.size(); i++) {
			if (defectLogs.get(i).getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	
	//return list of defect numbers and names
	public ArrayList<String> getNames() {
		ArrayList<String> names = new ArrayList<String>();
		for (int i = 0; i < defectLogs.size(); i++) {
			String s = defectLogs.get(i).getNumber() + ". " + defectLogs.get(i).getName();
			names.add(s);
		}
		return names;
	}
	
	//print the defect log
	public String printDefectLogs(Project project) {
		String result = "";
		for (int i = 0; i < project.defectLogs.size(); i++) {
			result += project.defectLogs.get(i).getProjectType();
			result += project.defectLogs.get(i).getNumber();
			result += project.defectLogs.get(i).getName();
			result += "\n\n";
		}
		return result;
	}
}
