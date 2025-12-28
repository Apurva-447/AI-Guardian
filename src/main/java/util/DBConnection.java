package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
        "jdbc:mysql://localhost:3306/ai_guardian";
    private static final String USER = "root";      // change if needed
    private static final String PASSWORD = "apurva";  // change if needed

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Database connected successfully");
        } catch (Exception e) {
            System.out.println("❌ Database connection failed");
            e.printStackTrace();
        }
        return con;
    }
}
