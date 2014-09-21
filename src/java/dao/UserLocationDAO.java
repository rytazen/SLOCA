/*
 * UserLocation
 * Created By: Foo Yee Cheng & Seol Hye Ri (Pair Programming)
 * 20/09/2013 Saturday
 */
package dao;

import entity.*;
import java.util.ArrayList;
import au.com.bytecode.opencsv.CSVReader;
import entity.Location;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;

/**
 *
 * @author Tommy & Hye Ri
 */
public class UserLocationDAO {

    private static Connection conn;
    private static PreparedStatement pstmt;
    private static ResultSet rs;
    private ArrayList<User> userList;
    private ArrayList<UserLocation> userLocationList;
    private ArrayList<Location> locationList;

    /**
     * Load data from my sql database
     *
     * @return userLocationList
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public ArrayList<UserLocation> load() throws FileNotFoundException, IOException {
        try {
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("SELECT * FROM UserLocation");

            rs = pstmt.executeQuery();

            while (rs.next()) {
                String macAdd = rs.getString("macAdd");
                int locationID = rs.getInt("locationID");
                String timeStamp = rs.getString("timeStamp");

                userLocationList.add(new UserLocation(macAdd, locationID, timeStamp));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserLocationDAO.class.getName()).log(Level.SEVERE, "Unable to load data", ex);
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }
        return userLocationList;
    }

    /**
     *
     * @param filePath the path of the file that is to be initialized
     * @return status of whether initialization is success or not
     * @throws FileNotFoundException
     * @throws IOException
     */
    public boolean initialize(String filePath) throws FileNotFoundException, IOException {

        boolean status = false;

        CSVReader reader = new CSVReader(new FileReader(filePath), ',', '\'', 1);
        String[] nextLine;

        while ((nextLine = reader.readNext()) != null) {
            // nextLine[] is an array of values from the line

            try {
                conn = ConnectionManager.getConnection();
                pstmt = conn.prepareStatement("INSERT INTO UserLocation (locationID, macAdd, timestamp) VALUES (?, ?, ?)");

                pstmt.setInt(1, Integer.parseInt(nextLine[0]));
                pstmt.setString(2, nextLine[1]);
                pstmt.setString(3, nextLine[2]);
                pstmt.executeUpdate();
                status = true;

            } catch (SQLException e) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.WARNING,
                        "Unable to load");
            } finally {
                ConnectionManager.close(conn, pstmt, rs);
            }
        }
        return status;
    }

    /**
     * Retrieve array list of User Location base on dateTime and k
     *
     * @param dateTime the date time of the intended appearance.
     * @param k a constant of value to select number of rows returned.
     * @return userLocationList
     */
    public ArrayList<UserLocation> retrieveUserlocations(String dateTime, int k) throws FileNotFoundException, IOException {
        try {
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("SELECT TOP " + k + "* FROM UserLocation WHERE timeStamp LIKE " + dateTime);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                String macAdd = rs.getString("macAdd");
                int locationID = rs.getInt("locationID");
                String timeStamp = rs.getString("timeStamp");

                userLocationList.add(new UserLocation(macAdd, locationID, timeStamp));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserLocationDAO.class.getName()).log(Level.SEVERE, "Unable to retrieve user's location", ex);
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }
        return userLocationList;
    }

    /**
     * Retrieve array list of User Location base on dateTime , k and
     * semanticPlace
     *
     * @param dateTime the date time of the intended appearance.
     * @param k a constant of value to select number of rows returned.
     * @param semanticPlace the location to search for.
     * @return userLocationList
     */
    public ArrayList<UserLocation> retrieveUserlocations(String dateTime, int k, String semanticPlace) {
        try {
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("SELECT TOP " + k + "* FROM UserLocation WHERE timeStamp LIKE " + dateTime + " AND (SELECT locationID FROM location WHERE semanticPlace LIKE " + semanticPlace + ")");

            rs = pstmt.executeQuery();

            while (rs.next()) {
                String macAdd = rs.getString("macAdd");
                int locationID = rs.getInt("locationID");
                String timeStamp = rs.getString("timeStamp");

                userLocationList.add(new UserLocation(macAdd, locationID, timeStamp));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserLocationDAO.class.getName()).log(Level.SEVERE, "Unable to retrieve user's location", ex);
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }
        return userLocationList;
    }

    /**
     * Retrieve array list of User Location base on level, dateTime
     *
     * @param level the level to search for
     * @param dateTime the date time of the intended appearance.
     * @return userLocationList
     */
    public ArrayList<UserLocation> retrieveUserlocations(String level, String dateTime) {
        try {
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("SELECT * FROM UserLocation ul, Location loc WHERE timeStamp LIKE " + dateTime + " AND ul.locationID = loc.locationID AND loc.semanticPlace LIKE 'SMUSIS" + level + "%'"); //pending

            rs = pstmt.executeQuery();

            while (rs.next()) {
                String macAdd = rs.getString("macAdd");
                int locationID = rs.getInt("locationID");
                String timeStamp = rs.getString("timeStamp");

                userLocationList.add(new UserLocation(macAdd, locationID, timeStamp));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserLocationDAO.class.getName()).log(Level.SEVERE, "Unable to retrieve user's location", ex);
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }
        return userLocationList;
    }

    /**
     * Retrieve array list of User Location base on year, gender and school
     *
     * @param year the year of the student to search for.
     * @param gender the gender of the student to search for.
     * @param school the school of the student to search for.
     * @return userLocationList
     */
    public ArrayList<UserLocation> retrieveUserlocations(String year, char gender, String school) {
        try {
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("SELECT * FROM UserLocation WHERE timeStamp LIKE "); //pending

            rs = pstmt.executeQuery();

            while (rs.next()) {
                String macAdd = rs.getString("macAdd");
                int locationID = rs.getInt("locationID");
                String timeStamp = rs.getString("timeStamp");

                userLocationList.add(new UserLocation(macAdd, locationID, timeStamp));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserLocationDAO.class.getName()).log(Level.SEVERE, "Unable to retrieve user's location", ex);
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }
        return userLocationList;
    }

    /**
     * Retrieve array list of User base on k, dateTime and user
     *
     * @param k a constant of value to select number of rows returned.
     * @param dateTime the date time of the intended appearance.
     * @param _email the email of the user to search for.
     * @return userList
     */
    public ArrayList<User> retrieveUsers(int k, String dateTime, String _email) {
        try {
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("SELECT * FROM User u, UserLocation ul WHERE u.macAdd = ul.macAdd AND "); //pending

            rs = pstmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString(1);
                String email = rs.getString(2);
                String password = rs.getString(3);
                String macAdd = rs.getString(4);
                char gender = rs.getString(5).charAt(0);
                userList.add(new User(name, email, password, macAdd, gender));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserLocationDAO.class.getName()).log(Level.SEVERE, "Unable to retrieve user's location", ex);
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }
        return userList;
    }

    /**
     * Retrieve array list of User base on dateTime
     *
     * @param dateTime the date time of the intended appearance.
     * @return userList
     */
    public ArrayList<User> retrieveUsers(String dateTime) {
        try {
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("SELECT * FROM UserLocation WHERE timeStamp LIKE "); //pending

            rs = pstmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString(1);
                String email = rs.getString(2);
                String password = rs.getString(3);
                String macAdd = rs.getString(4);
                char gender = rs.getString(5).charAt(0);
                userList.add(new User(name, email, password, macAdd, gender));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserLocationDAO.class.getName()).log(Level.SEVERE, "Unable to retrieve user's location", ex);
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }
        return userList;

    }

    /**
     * Retrieve array list of location on k, dateTime and location
     *
     * @param k a constant of value to select number of rows returned.
     * @param dateTime the date time of the intended appearance.
     * @param semanticPlace the location to search for.
     * @return locationList
     */
    public ArrayList<Location> retrieveLocations(int k, String dateTime, String _semanticPlace) {

        try {
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("SELECT * FROM User u, UserLocation ul WHERE u.macAdd = ul.macAdd AND "); //pending

            rs = pstmt.executeQuery();

            while (rs.next()) {

                int locationID = rs.getInt("locationID");
                String semanticPlace = rs.getString("semanticPlace");
                locationList.add(new Location(locationID, semanticPlace));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserLocationDAO.class.getName()).log(Level.SEVERE, "Unable to retrieve user's location", ex);
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }
        return locationList;
    }
}
