package rentcarServer.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import rentcarServer.util.DBManager;

public class BoardDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private BoardDao() {
		
	}
	
	private static BoardDao instance = new BoardDao();
	
	public static BoardDao getInstance() {
		return instance;
	}
	
	private boolean findPostCode(String code) {
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "SELECT code FROM boards WHERE code=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			
			rs = pstmt.executeQuery();
			
			System.out.println("코드 검사 시작");
			if(rs.next()) {
				System.out.println("코드 검사 끝");
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return true;
	}
	
	public String createPostCode() {
		String code = "";
		while(true) {
			Random random = new Random();
			
			int rNum1 = random.nextInt(900000)+100000;
			int rNum2 = random.nextInt(900000)+100000;
			code = rNum1 + "-" + rNum2;
			System.out.println("createCode: "+code);
			if(findPostCode(code))
				break;
		}
		
		return code;
	}
	

}
