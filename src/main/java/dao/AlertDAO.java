package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import util.DBConnection;   

public class AlertDAO {

	public void saveAlert(int userId, String text, String risk, int score) {
	    try {
	        Connection con = DBConnection.getConnection();
	        String sql = "INSERT INTO alerts (user_id, input_text, risk_level, score) VALUES (?,?,?,?)";
	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setInt(1, userId);
	        ps.setString(2, text);
	        ps.setString(3, risk);
	        ps.setInt(4, score);

	        ps.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
