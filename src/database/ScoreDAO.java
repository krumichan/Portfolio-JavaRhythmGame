package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ScoreDAO extends CommonDAO {
	public boolean insert(ScoreEntity score) {
		boolean result = false;
		
		String sql = 
				" INSERT INTO SCORE "
				+ " VALUES ( ?, ?, ? ) ";
		
		PreparedStatement stmt = null;
		
		try {
			conn.setAutoCommit(false);
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, score.getId());
			stmt.setString(2, score.getSongTitle());
			stmt.setInt(3, score.getScore());
			
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
	
	public ArrayList<ScoreEntity> selectAll() {
		ArrayList<ScoreEntity> scores = new ArrayList<ScoreEntity>();
		
		String sql = 
				" SELECT		* "
				+ " FROM		SCORE "
				+ " ORDER BY 	SCORE DESC ";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				ScoreEntity score = new ScoreEntity();
				score.setId(rs.getString("ID"));
				score.setSongTitle(rs.getString("SONG_TITLE"));
				score.setScore(rs.getInt("SCORE"));
				scores.add(score);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Utils.close(rs);
			Utils.close(stmt);
			Utils.close(conn);
		}
		
		return scores;
	}
	
	public ArrayList<ScoreEntity> select(int precedence) {
		ArrayList<ScoreEntity> scores = new ArrayList<ScoreEntity>();
		
		String sql = 
				" SELECT	* "
				+ " FROM	(	SELECT		SCORE " 
				+ "				FORM		SCORE "
				+ "				ORDER BY  	SCORE DESC ) "
				+ " WHERE	ROWNUM <= ? ";	
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, precedence);
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				ScoreEntity score = new ScoreEntity();
				score.setId(rs.getString("ID"));
				score.setSongTitle(rs.getString("SONG_TITLE"));
				score.setScore(rs.getInt("SCORE"));
				scores.add(score);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Utils.close(rs);
			Utils.close(stmt);
			Utils.close(conn);
		}
		
		return scores;
	}
	
	public ArrayList<ScoreEntity> select(String id) {
		ArrayList<ScoreEntity> scores = new ArrayList<ScoreEntity>();
		
		String sql =
				" SELECT		* "
				+ " FROM		SCORE "
				+ "	WHERE		ID = ?"
				+ " ORDER BY 	SCORE DESC ";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				ScoreEntity score = new ScoreEntity();
				score.setId(rs.getString("ID"));
				score.setSongTitle(rs.getString("SONG_TITLE"));
				score.setScore(rs.getInt("SCORE"));
				scores.add(score);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Utils.close(rs);
			Utils.close(stmt);
			Utils.close(conn);
		}
		
		return scores;
	}
	
	public ArrayList<ScoreEntity> select(String id, int precedence) {
		ArrayList<ScoreEntity> scores = new ArrayList<ScoreEntity>();
		
		String sql = 
				" SELECT	* "
				+ " FROM	(	SELECT		SCORE " 
				+ "				FORM		SCORE "
				+ "				WHERE		ID = ? "
				+ "				ORDER BY  	SCORE DESC "
				+ "			) "
				+ " WHERE	ROWNUM <= ? ";	
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setInt(2, precedence);
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				ScoreEntity score = new ScoreEntity();
				score.setId(rs.getString("ID"));
				score.setSongTitle(rs.getString("SONG_TITLE"));
				score.setScore(rs.getInt("SCORE"));
				scores.add(score);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Utils.close(rs);
			Utils.close(stmt);
			Utils.close(conn);
		}
		
		return scores;
	}
}
