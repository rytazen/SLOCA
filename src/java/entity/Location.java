/*
 * Location
 * Created By: Mok Yao Kun & Samantha Ng (Pair Programming)
 * 13/09/2013 Saturday
 */
package entity;

/**
 *
 * @author Samantha Ng & Mok Yao Kun
 */
public class Location {

    private int locationID;
    private String semanticPlace;

    /**
     * Constructor for location
     *
     * @param locationID
     * @param semanticPlace
     */
    public Location(int locationID, String semanticPlace) {
        this.locationID = locationID;
        this.semanticPlace = semanticPlace;
    }

    /**
     * Getter method for location id of a location
     *
     * @return
     */
    public int getLocationID() {
        return locationID;
    }

    /**
     * Getter method for semantic place of a student
     *
     * @return
     */
    public String getSemanticPlace() {
        return semanticPlace;
    }
}
