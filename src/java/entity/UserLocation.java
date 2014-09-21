/*
 * UserLocation
 * Created By: Foo Yee Cheng & Seol Hye Ri (Pair Programming)
 * 20/09/2013 Saturday
 */
package entity;

import java.util.*;
import java.text.*;

/**
 *
 * @author Tommy
 */
public class UserLocation {

    String macAdd;
    int locationID;
    String timeStamp;
    // Date rawTimeStamp = new Date();
    // DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //  String timeStamp = df.format(rawTimeStamp);

    /**
     * Create a UserLocation object with the specified timestamp
     *
     * @param macAdd the MAC Address of the user's device
     * @param locationID the ID for the location
     * @param timeStamp the time stamp of the location
     *
     */
    public UserLocation(String macAdd, int locationID, String timeStamp) {
        this.macAdd = macAdd;
        this.locationID = locationID;
        this.timeStamp = timeStamp;
    }

    /**
     * Get the MAC address of the user location
     *
     * @return
     */
    public String getMacAdd() {
        return macAdd;
    }

    /**
     * Get the location ID of the user location
     *
     * @return
     */
    public int getLocationID() {
        return locationID;
    }

    /**
     * Get the time stamp of the user location
     *
     * @return timeStamp
     */
    public String getTimeStamp() {
        return timeStamp;
    }
}