package application;

//Author: Joseph Cohen

/**
 * Represents information about a feature in the application.
 */
public class FeatureInfo {
    public String name;
    public String tags;
    public String notes;
    public double esimatedStoryPoints;
    public double hoursSpent;

    /**
     * Constructs a FeatureInfo object with full details.
     * @param name The name of the feature.
     * @param tags Tags associated with the feature.
     * @param notes Notes about the feature.
     * @param estStoryPoints Estimated story points for the feature.
     * @param hrsSpent Hours spent on the feature.
     */
    public FeatureInfo(String name, String tags, String notes, double estStoryPoints, double hrsSpent) {
        this.name = name;
        this.tags = tags;
        this.notes = notes;
        this.esimatedStoryPoints = estStoryPoints;
        this.hoursSpent = hrsSpent;
    }

    /**
     * Constructs a FeatureInfo object with name and tags.
     * @param name The name of the feature.
     * @param tags Tags associated with the feature.
     */
    public FeatureInfo(String name, String tags) {
        this(name, tags, "", 0.0, 0.0);
    }

    /**
     * Constructs a FeatureInfo object with only a name.
     * @param name The name of the feature.
     */
    public FeatureInfo(String name) {
        this(name, "", "", 0.0, 0.0);
    }
    
    /**
     * Constructs a FeatureInfo object with no information.
     */
    public FeatureInfo() {
        this("", "", "", 0.0, 0.0);
    }
}
