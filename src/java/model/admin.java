
package model;


public class admin {
    private String adminEmail;
    private String adminFullName;
    private String adminImg;
    private String adminPass;

    public admin() {
    }

    public admin(String adminEmail, String adminFullName, String adminImg, String adminPass) {
        this.adminEmail = adminEmail;
        this.adminFullName = adminFullName;
        this.adminImg = adminImg;
        this.adminPass = adminPass;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminFullName() {
        return adminFullName;
    }

    public void setAdminFullName(String adminFullName) {
        this.adminFullName = adminFullName;
    }

    public String getAdminImg() {
        return adminImg;
    }

    public void setAdminImg(String adminImg) {
        this.adminImg = adminImg;
    }

    public String getAdminPass() {
        return adminPass;
    }

    public void setAdminPass(String adminPass) {
        this.adminPass = adminPass;
    }
    
    
    
    
}
