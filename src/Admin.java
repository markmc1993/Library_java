import java.io.Serializable;

public class Admin implements Serializable{
    private String firstName;
    private String lastName;
    private String adminID;
    private String password;
    private String email;

    public Admin(String firstName, String lastName, String adminID, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.adminID = adminID;
        this.password = password;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
