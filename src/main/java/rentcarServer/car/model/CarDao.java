package rentcarServer.car.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import rentcarServer.util.DBManager;

public class CarDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private CarDao() {
		
	}
	
	private static CarDao instance = new CarDao();
	
	public static CarDao getInstance() {
		return instance;
	}
	
	public List<CarResponseDto> readAllCar() {
		List<CarResponseDto> carList = new ArrayList<CarResponseDto>();
		
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT car_code, model, price, car_class, car_number, reservation, fuel FROM cars";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String code = rs.getString(1);
				String model = rs.getString(2);
				String price = rs.getString(3);
				String carClass = rs.getString(4);
				String carNumber = rs.getString(5);
				boolean reservation = rs.getBoolean(6);
				String fuel = rs.getString(7);
				
				CarResponseDto board = new CarResponseDto(code, model, price, carClass, carNumber, reservation, fuel);
				carList.add(board);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return carList;
	}
	
	public CarResponseDto findCarByCode(String code) {
		CarResponseDto car = null;
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "SELECT car_code, model, price, car_class, car_number, reservation, fuel FROM cars WHERE car_code=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String carCode = rs.getString(1);
				String model = rs.getString(2);
				String price = rs.getString(3);
				String carClass = rs.getString(4);
				String carNumber = rs.getString(5);
				boolean reservation = rs.getBoolean(6);
				String fuel = rs.getString(7);
				
				if(carCode.equals(code)) {
					car = new CarResponseDto(carCode, model, price, carClass, carNumber, reservation, fuel);
					return car;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return car;
	}
}
