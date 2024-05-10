package rentcarServer.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
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
			LocalDate now = LocalDate.now();         
			// 포맷 정의        
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");         
			// 포맷 적용        
			String formatedNow = now.format(formatter);
			Random random = new Random();
			
			int rNum = random.nextInt(900000)+100000;
			code = formatedNow + "-" + rNum;
			System.out.println("createCode: "+code);
			if(findPostCode(code))
				break;
		}
		
		return code;
	}
	
	public BoardResponseDto createBoard(BoardRequestDto boardDto) {
		try {
			conn = DBManager.getConnection();
			
			String sql = "INSERT INTO boards(code, title, content, user_id, category) VALUES(?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, boardDto.getCode());
			pstmt.setString(2, boardDto.getTitle());
			pstmt.setString(3, boardDto.getContent());
			pstmt.setString(4, boardDto.getUserId());
			pstmt.setString(5, boardDto.getCategory());
			System.out.println("boardDto.getCode: " + boardDto.getCode());
			pstmt.execute();
			
			return findBoardByCode(boardDto.getCode());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		return null;
	}
	
	public BoardResponseDto findBoardByCode(String code) {
		BoardResponseDto board = null;
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "SELECT code, title, content, user_id, category, write_date, mod_date FROM boards WHERE code=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String checkCode = rs.getString(1);
				String title = rs.getString(2);
				String content = rs.getString(3);
				String userId = rs.getString(4);
				String category = rs.getString(5);
				Timestamp write_date = rs.getTimestamp(6);
				Timestamp mod_date = rs.getTimestamp(7);
				
				if(code.equals(checkCode)) {
					board = new BoardResponseDto(code, title, content, userId, category, write_date, mod_date);
					return board;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return null;
	}
	
	public Board findPostByCode(String code) {
		Board board = null;
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "SELECT code, title, content, user_id, category, write_date, mod_date FROM boards WHERE code=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String checkCode = rs.getString(1);
				String title = rs.getString(2);
				String content = rs.getString(3);
				String userId = rs.getString(4);
				String category = rs.getString(5);
				Timestamp write_date = rs.getTimestamp(6);
				Timestamp mod_date = rs.getTimestamp(7);
				
				if(code.equals(checkCode)) {
					board = new Board(code, title, content, userId, category, write_date, mod_date);
					return board;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return null;
	}
	
	public List<BoardResponseDto> readAllBoard() {
		List<BoardResponseDto> boardList = new ArrayList<>();
		
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT code, title, content, user_id, write_date, mod_date FROM boards ORDER BY CASE WHEN category = 'Admin' THEN 1 ELSE 2 END,  write_date ASC";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String code = rs.getString(1);
				String title = rs.getString(2);
				String content = rs.getString(3);
				String user_id = rs.getString(4);
				Timestamp write_date = rs.getTimestamp(5);
				Timestamp mod_date = rs.getTimestamp(6);
				
				BoardResponseDto board = new BoardResponseDto(code, title, content, user_id, write_date, mod_date);
				boardList.add(board);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return boardList;
	}
	
	public BoardResponseDto updatePostTitleAndContent(BoardRequestDto boardDto, String newTitle, String newContent) {
		BoardResponseDto board = null;
		
		if(newTitle == null || newContent == null || newTitle.equals("") || newContent.equals("")) {
			System.out.println("title, content null!!!");
			return board;
		}
		
		if(findBoardByCode(boardDto.getCode()) == null) {
			System.out.println("board null!!!");
			return board;
		}
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "UPDATE boards SET title=?, content=? WHERE code = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newTitle);
			pstmt.setString(2, newContent);
			pstmt.setString(3, boardDto.getCode());
			
			pstmt.execute();
			
			Board boardVo = findPostByCode(board.getCode());
			board = new BoardResponseDto(boardVo);
			
			return board;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
			
		return board;
	}
	
	public boolean deletePost(BoardRequestDto boardDto) {
		if(findBoardByCode(boardDto.getCode()) == null) {
			return false;
		}
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "DELETE FROM boards WHERE code =?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, boardDto.getCode());
			
			pstmt.execute();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		return false;
	}
}
