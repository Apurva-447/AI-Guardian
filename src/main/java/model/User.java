package model;

public class User {

    private int userId;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String guardianEmail;
    // No-argument constructor
    public User() {}

    // Parameterized constructor
    public User(String name, String email, String password, String phone,String guardianEmail) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.guardianEmail=guardianEmail;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    private String role;

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getGuardianEmail() {
        return guardianEmail;
    }

    public void setGuardianEmail(String guardianEmail) {
        this.guardianEmail = guardianEmail;
    }
}
