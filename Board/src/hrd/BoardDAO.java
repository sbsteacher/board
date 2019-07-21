package hrd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardDAO {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/board";
	private static final String USER = "root";
	private static final String PW = "1212";
	
	private static Connection getCon() throws Exception {
		Class.forName(DRIVER);
		Connection con = DriverManager.getConnection(URL, USER, PW);
		System.out.println("접속 성공!");
		return con;
	}
	
	private static void close(Connection con, PreparedStatement ps, ResultSet rs) {
		if(rs != null) {
			try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		
		if(ps != null) {
			try { ps.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		
		if(con != null) {
			try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
		}		
	}
	
	//입력(글쓰기)
	public static int boardInsert(BoardVO vo) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " INSERT INTO t_board "
			       + " (title, content) "
			       + " VALUES "
			       + " (?, ?) ";
		
		try {
			con = getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getContent());			
			result = ps.executeUpdate();
		} catch (Exception e) {		
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		
		return result;
	}
	
	public static int boardDelete(int i) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " DELETE FROM t_board WHERE i = ? ";
		
		try {
			con = getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, i);
			result = ps.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return result;
	}
}














