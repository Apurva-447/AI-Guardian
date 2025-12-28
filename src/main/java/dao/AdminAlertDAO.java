package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBConnection;

public class AdminAlertDAO {

	public List<String[]> getAllAlerts() {
	    List<String[]> list = new ArrayList<>();

	    try {
	        Connection con = DBConnection.getConnection();

	        String sql =
	            "SELECT u.email, a.input_text, a.risk_level, a.score, a.created_at " +
	            "FROM alerts a " +
	            "JOIN users u ON a.user_id = u.user_id " +
	            "ORDER BY a.created_at DESC";

	        PreparedStatement ps = con.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            String[] row = new String[5];
	            row[0] = rs.getString("email");
	            row[1] = rs.getString("input_text");
	            row[2] = rs.getString("risk_level");
	            row[3] = String.valueOf(rs.getInt("score"));
	            row[4] = rs.getString("created_at");

	            list.add(row);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return list;
	}
}