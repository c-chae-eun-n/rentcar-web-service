package rentcarServer.reservate.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
			String sql = "SELECT * FROM reservations " + "WHERE (ren_date<=? AND return_date>=?) " + "OR (ren_date BETWEEN ? AND ?) " + "OR (return_date BETWEEN ? AND ?)";
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
}
