/*
 * UserDAO
 * Created By: Foo Yee Cheng & Seol Hye Ri (Pair Programming)
 * 13/09/2013 Saturday
 */
package dao;

import entity.*;
import au.com.bytecode.opencsv.CSVReader;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;

/**
 *
 * @author Foo Yee Cheng & Seol Hye Ri
 */
public class UserDAO {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private ArrayList<User> userList;

    /**
     * Retrieve the user with the specified email id and password
     *
     * @param userName the user id of the user that is searching for
     * @return the User object
     */
    public User retrieveUser(String userName) {
        User user = null;

        try {
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("SELECT * FROM user WHERE email LIKE '%"+userName+"%'");
            //This will set the column 1 as the username
            //pstmt.setString(1, userName);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                String macAdd = rs.getString(1);
                String email = rs.getString(2);
                String name = rs.getString(3);
                String password = rs.getString(4);
                char gender = rs.getString(5).charAt(0);
                user = new User(macAdd, email, name, password, gender);
                //System.out.println(name);
                //System.out.println(password);
                //System.out.println(email);
                
                
                
                //String userID = email.substring(startIndex, symbolIndex);
                //System.out.println(email.substring(startIndex,symbolIndex));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.WARNING,
                    "Unable to retrieve username = '" + userName + "'", ex);
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }
        return user;
    }

    /**
     * Get list of user from MySQL database
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void load() throws FileNotFoundException, IOException {
        try {
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("SELECT * FROM user");

            rs = pstmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString(1);
                String email = rs.getString(2);
                String password = rs.getString(3);
                String macAdd = rs.getString(4);
                char gender = rs.getString(5).charAt(0);
                userList.add(new User(name, email, password, macAdd, gender));
            }

        } catch (SQLException e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.WARNING,
                    "Unable to load");
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }
    }

    /**
     * Push data from CSV file into MySQL Database
     * @param filePath
     * @return status
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
                pstmt = conn.prepareStatement("INSERT INTO user (name, userID, email,password,macAdd,gender) VALUES (?, ?, ?, ?,?,?)");

                pstmt.setString(1, nextLine[0]);
                pstmt.setString(2, nextLine[1]);
                pstmt.setString(3, nextLine[2]);
                pstmt.setString(4, nextLine[3]);
                pstmt.setString(5, nextLine[4]);
                pstmt.setString(6, nextLine[4]);
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
}