package rentcarServer.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import rentcarServer.user.model.UserRequestDto;
import rentcarServer.util.DBManager;
import rentcarServer.util.PasswordCrypto;

public class UserDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// UserDao 객체를 단일 인스턴스로 만들기 위해
	// Singleton Pattern 적용
	
	// 1. 생성자를 private으로
	private UserDao() {
//		setConnection();
	}
	
	// 2. 단일 인스턴스를 생성 (클래스 내부에서)
	private static UserDao instance = new UserDao();
	
	// 3. 단일 인스턴스에 대한 getter
	public static UserDao getInstance() {
		return instance;
	}
	
	public UserResponseDto createUser(UserRequestDto userDto) {
		try {
			conn = DBManager.getConnection();
			
			String sql = "INSERT INTO  users(user_id, password, email, name, birth, gender, country, telecom, phone) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userDto.getId());
			pstmt.setString(2, PasswordCrypto.encrypt(userDto.getPassword()));
			
			String email = (userDto.getEmail() == null || userDto.getEmail().equals("")) ? null : userDto.getEmail();
			pstmt.setString(3, email);
			
			pstmt.setString(4, userDto.getName());
			pstmt.setString(5, userDto.getBirth());
			pstmt.setString(6, userDto.getGender());
			pstmt.setString(7, userDto.getCountry());
			pstmt.setString(8, userDto.getTelecom());
			pstmt.setString(9, userDto.getPhone());
			
			pstmt.execute();
			
			return findUserByIdAndPassword(userDto.getId(), userDto.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		return null;
	}
	
	public UserResponseDto findUserByIdAndPassword(String id, String password) {
		UserResponseDto user = null;
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "SELECT user_id, password, email, name, birth, gender, country, telecom, phone FROM users WHERE user_id=?";
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String encryptedPassword = rs.getString(2);
				String email = rs.getString(3);
				String name = rs.getString(4);
				String birth = rs.getString(5);
				String gender = rs.getString(6);
				String country = rs.getString(7);
				String telecom = rs.getString(8);
				String phone = rs.getString(9);
				
				if(PasswordCrypto.decrypt(password, encryptedPassword)) {
					user = new UserResponseDto(id, email, name, birth, gender, country, telecom, phone);
					return user;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return null;
	}
	
	private User findUserById(String id) {
		User user = null;
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "SELECT user_id, email, name, birth, gender, country, telecom, phone, reg_date, mod_date FROM users WHERE user_id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String email = rs.getString(2);
				String name = rs.getString(3);
				String birth = rs.getString(4);
				String gender = rs.getString(5);
				String country = rs.getString(6);
				String telecom = rs.getString(7);
				String phone = rs.getString(8);
				Timestamp regDate = rs.getTimestamp(9);
				Timestamp modDate = rs.getTimestamp(10);
				
				user = new User(id, email, name, birth, gender, country, telecom, phone, regDate, modDate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return user;
	}
	
	public boolean userExists(UserRequestDto userDto) {
		return findUserByIdAndPassword(userDto.getId(), userDto.getPassword()) != null;
	}
	
	public boolean userExists(String id) {
		return findUserById(id) != null;
	}
}
