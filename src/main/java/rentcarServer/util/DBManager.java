package rentcarServer.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {

	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Context init = new InitialContext();
			DataSource source = (DataSource) init.lookup("java:comp/env/jdbc/rantcarServerDB");
		
			conn = source.getConnection();
			
			System.out.println("[DB ���� ����]");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[DB ���� ����]");
		}
		
		return conn;
	}
	
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			rs.close();
			pstmt.close();
			conn.close();
			
			System.out.println("[DB ���� ����]");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("[DB ���� ���� ����]");
		}
	}
	
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			pstmt.close();
			conn.close();
			
			System.out.println("[DB ���� ����]");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("[DB ���� ���� ����]");
		}
	}
}
