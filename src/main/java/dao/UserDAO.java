package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;
import util.DBConnection;

public class UserDAO {

    // REGISTER USER
    public boolean registerUser(User user) {
        boolean status = false;
        try {
            Connection con = DBConnection.getConnection();

            String sql =
            		"INSERT INTO users(name,email,password,phone,guardian_email) VALUES (?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getGuardianEmail());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    // LOGIN USER
    public User loginUser(String email, String password) {
        User user = null;  

        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM users WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();  
                user.setUserId(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setRole(rs.getString("role"));
                user.setGuardianEmail(rs.getString("guardian_email"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;  // null if login failed
    }
}