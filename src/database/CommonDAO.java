package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class CommonDAO {
	protected String driver = "oracle.jdbc.driver.OracleDriver";
	protected String url = "jdbc:oracle:thin:@localhost:1521:XE";
	protected String user = "hr";
	protected String pass = "ghtvhzkdhkdl4!A";
	
	protected Connection conn = null;
	
	public CommonDAO() {
		try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, pass);
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
}
