
package model;


public class Users {
    private int userID;
    private String userFullName;
    private String userEmail;
    private String userPass;

    public Users() {
    }

    public Users(int userID, String userFullName, String userEmail, String userPass) {
        this.userID = userID;
        this.userFullName = userFullName;
        this.userEmail = userEmail;
        this.userPass = userPass;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
    
    

   
    
}
