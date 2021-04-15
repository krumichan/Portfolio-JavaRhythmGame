package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO extends CommonDAO {

	public boolean insert(AccountEntity entity) {
		boolean result = false;
		
		String sql = 
				" INSERT INTO	ACCOUNT"
				+ " VALUES		( ?, ? ) ";
		
		PreparedStatement stmt = null;
		
		try {
			conn.setAutoCommit(false);
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, entity.getId());
			stmt.setString(2, entity.getPw());
			
			int count = stmt.executeUpdate();
			
			if (count == 1) {
				result = true;
				conn.commit();
				
			} else {
				conn.rollback();
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			Utils.close(stmt);
			Utils.close(conn);
			
		}
		
		return result;
	}
	
	public boolean duplication(String id) {
		boolean result = false;
		
		String sql = 
				" SELECT COUNT(*)"
				+ " FROM ACCOUNT "
				+ " WHERE ID = ? ";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			
			rs = stmt.executeQuery();
			
			if (rs.next() && rs.getInt(1) == 1) {
				result = true;
		
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			Utils.close(rs);
			Utils.close(stmt);
			Utils.close(conn);
			
		}
		
		return result;
	}
	
	public AccountEntity login(String id, String pw) {
		AccountEntity account = null;
		
		String sql = 
				" SELECT	* "
				+ " FROM	ACCOUNT "
				+ " WHERE	ID = ? "
				+ " AND		PW = ? ";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, pw);
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				account = new AccountEntity();
				account.setId(rs.getString("ID"));
				account.setPw(rs.getString("PW"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			Utils.close(rs);
			Utils.close(stmt);
			Utils.close(conn);
			
		}
		
		return account;
	}
}
