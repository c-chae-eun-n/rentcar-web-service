package rentcarServer.reservate.model;

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

public class ReservationDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private ReservationDao() {
		
	}
	
	private static ReservationDao instance = new ReservationDao();
	
	public static ReservationDao getInstance() {
		return instance;
	}
	
	
	public List<ReservationResponseDto> createReservationList(ReservationRequestDto resevDto) {
		List<ReservationResponseDto> reservationList = new ArrayList<ReservationResponseDto>();

		try {
			conn = DBManager.getConnection();

			Timestamp renDateTime = resevDto.getRenDate();
			Timestamp returnDateTime = resevDto.getReturnDate();
			
			// 예약 불가 차량
			String sql = "SELECT * FROM reservations WHERE (ren_date<=? AND return_date>=?) OR (ren_date BETWEEN ? AND ?) OR (return_date BETWEEN ? AND ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setTimestamp(1, renDateTime);
			pstmt.setTimestamp(2, returnDateTime);
			pstmt.setTimestamp(3, renDateTime);
			pstmt.setTimestamp(4, returnDateTime);
			pstmt.setTimestamp(5, renDateTime);
			pstmt.setTimestamp(6, returnDateTime);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String number = rs.getString(1);
				String userId = rs.getString(2);
				String carCode = rs.getString(3);
				Timestamp renDate = rs.getTimestamp(4);
				Timestamp returnDate = rs.getTimestamp(5);
				String insurance = rs.getString(6);
				boolean paymentStatus = rs.getBoolean(7);
				String payment = rs.getString(8);
				ReservationResponseDto reservation = new ReservationResponseDto(number, userId, carCode, renDate, returnDate, insurance, paymentStatus, payment);
				reservationList.add(reservation);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return reservationList;
	}
	
	public ReservationResponseDto createReservation(ReservationRequestDto reservationDto) {
		try {
			conn = DBManager.getConnection();
			
			String sql = "INSERT INTO reservations(number, user_id, car_code, ren_date, return_date, insurance, payment_status, payment) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, reservationDto.getNumber());
			pstmt.setString(2, reservationDto.getUserId());
			pstmt.setString(3, reservationDto.getCarCode());
			pstmt.setTimestamp(4, reservationDto.getRenDate());
			pstmt.setTimestamp(5, reservationDto.getReturnDate());
			pstmt.setString(6, reservationDto.getInsurance());
			pstmt.setBoolean(7, reservationDto.isPaymentStatus());
			pstmt.setString(8, reservationDto.getPayment());
			
			pstmt.execute();
			
			return findReserveByNumber(reservationDto.getNumber());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		return null;
	}
	
	public ReservationResponseDto findReserveByNumber(String number) {
		ReservationResponseDto reservation = null;
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "SELECT * FROM reservations WHERE number=?";
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  number);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String userId = rs.getString(2);
				String carCode = rs.getString(3);
				Timestamp renDate = rs.getTimestamp(4);
				Timestamp returnDate = rs.getTimestamp(5);
				String insurance = rs.getString(6);
				boolean paymentStatus = rs.getBoolean(7);
				String payment = rs.getString(8);
				
				reservation = new ReservationResponseDto(number, userId, carCode, renDate, returnDate, insurance, paymentStatus, payment);
				return reservation;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return null;
	}
	
	
	public boolean findNumber(String number) {
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "SELECT number FROM reservations WHERE number=?";
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  number);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return true;
	}
	

	
	public String createNumber() {
		String number = "";
		while(true) {
			LocalDate now = LocalDate.now();         
			// 포맷 정의        
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");         
			// 포맷 적용        
			String formatedNow = now.format(formatter);
			Random random = new Random();
			
			int rNum = random.nextInt(900000)+100000;
			number = formatedNow + "-" + rNum;
			System.out.println("createCode: "+number);
			if(findNumber(number))
				break;
		}
		
		return number;
	}
}
