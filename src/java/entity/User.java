/*
 * User
 * Created By: Foo Yee Cheng & Seol Hye Ri (Pair Programming)
 * 13/09/2013 Saturday
 */
package entity;

/**
 *
 * @author Foo Yee Cheng & Seol Hye Ri
 */
public class User {

    private String macAdd;
    private String name;
    private String password;
    private String email;
    private char gender;

    /**
     * Create a User object with the specified email and password
     *
     * @param email the email ID of this user
     * @param password the password of this user
     */
    /*public User(String email, String password) {
        this.email = email;
        this.password = password;
    }*/

    /**
     * Create a User object with the specified macAdd, name, password, email and
     * gender
     *
     * @param macAdd the MAC address of this user
     * @param name the name of this user
     * @param password the password of this user
     * @param email the emailID of this user
     * @param gender the gender of this user
     *
     */
    public User(String macAdd, String email, String name, String password, char gender) {

        this.macAdd = macAdd;
        this.email = email;
        this.name = name;
        this.password = password;
        this.gender = gender;
    }

    /**
     * Get MAC address of the user
     *
     * @return macAdd
     */
    public String getMacAdd() {
        return macAdd;
    }

    /**
     * Get name of the user
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Get password of the user
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Get email of the user
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Get gender of the user
     *
     * @return gender
     */
    public char getGender() {
        return gender;
    }

    /**
     *Authenticate password of the user
     * 
     * @param password
     * @return
     */
    public boolean authenticate(String passWord) {
        return passWord.equals(this.password);
    }
}
