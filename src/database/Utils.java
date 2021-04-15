package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Utils {
	public static void close(Connection conn) {
		try {
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	public static void close(Statement stmt) {
		try {
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
}
