/*
 * LocationDAO
 * Created By: Samantha Ng & Mok Yao Kun (Pair Programming)
 * 13/09/2013 Saturday
 */
package dao;

import au.com.bytecode.opencsv.CSVReader;
import entity.Location;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;

/**
 *
 * @author Samantha Ng & Mok Yao Kun
 */
public class LocationDAO {

    ArrayList<Location> locations = new ArrayList<Location>();

    /**
     * This method reads from an location CSV file and inserts the data into
     * mysql.
     *
     * @param filePath
     * @return status
     * @throws FileNotFoundException
     * @throws IOException
     */
    public boolean initialize(String filePath) throws FileNotFoundException, IOException {
        boolean status = false;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        CSVReader reader = new CSVReader(new FileReader(filePath), ',', '\'', 1);
        String[] nextLine;

        while ((nextLine = reader.readNext()) != null) {
            // nextLine[] is an array of values from the line

            try {
                conn = ConnectionManager.getConnection();
                pstmt = conn.prepareStatement("INSERT INTO location (locationID, semanticPlace) VALUES (?, ?)");

                pstmt.setInt(1, Integer.parseInt(nextLine[0]));
                pstmt.setString(2, nextLine[1]);
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
     * This method retrieve the location data from mysql and store in an array
     * list.
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void load() throws FileNotFoundException, IOException {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM location");

            rs = stmt.executeQuery();

            while (rs.next()) {
                int locationID = rs.getInt("locationID");
                String semanticPlace = rs.getString("semanticPlace");

                locations.add(new Location(locationID, semanticPlace));
            }

        } catch (SQLException e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.WARNING,
                    "Unable to load");
        } finally {
            ConnectionManager.close(conn, stmt, rs);
        }
    }

    /**
     * This method returns an array list of locations.
     *
     * @return locations
     */
    public ArrayList<Location> getLocations() {
        return locations;
    }
}
