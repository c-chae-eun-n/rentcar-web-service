package rentcarServer.car.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import rentcarServer.reservate.model.ReservationResponseDto;
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
			String sql = "SELECT car_code, model, price, car_class, car_number, reservation, fuel, location, seater FROM cars";
			
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
				String location = rs.getString(8);
				String seater = rs.getString(9);
				
				CarResponseDto car = new CarResponseDto(code, model, price, carClass, carNumber, reservation, fuel, location, seater);
				carList.add(car);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		System.out.println("all carList size: " + carList.size());
		return carList;
	}
	
	public List<CarResponseDto> readSearchCar(List<ReservationResponseDto> reservationList, String loca) {
		List<CarResponseDto> carList = readAllCar();
		
		for(int i=0; i<reservationList.size(); i++) {
			for(int j=0; j<carList.size(); j++) {
				if(reservationList.get(i).getCarCode().equals(carList.get(j).getCarCode())) {
					carList.remove(j);
					j --;
					System.out.println("remove carList size: " + carList.size());
				}
			}
		}
		if(loca.equals("all")) {
			System.out.println("loca is all");
			return carList;
		}
		System.out.println("loca: " + loca);
		for(int i=0; i<carList.size(); i++) {
			System.out.println("carList.get(i).getLocation(): " + carList.get(i).getLocation());
			
			if(!carList.get(i).getLocation().equals(loca)) {
				System.out.println("equals Location: " + carList.get(i).getLocation());
				carList.remove(i);
				i--;
			}
		}
		
		return carList;
	}
	
	public List<CarResponseDto> searchCarByModel(String carModel){
		List<CarResponseDto> carList = new ArrayList<CarResponseDto>();
		
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM cars WHERE model LIKE ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+carModel+"%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String code = rs.getString(1);
				String model = rs.getString(2);
				String price = rs.getString(3);
				String carClass = rs.getString(4);
				String carNumber = rs.getString(5);
				boolean reservation = rs.getBoolean(6);
				String fuel = rs.getString(7);
				String location = rs.getString(8);
				String seater = rs.getString(9);
				
				CarResponseDto car = new CarResponseDto(code, model, price, carClass, carNumber, reservation, fuel, location, seater);
				carList.add(car);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return carList;
	}
	
	public List<CarResponseDto> searchCarByClass(String carClassTemp){
		List<CarResponseDto> carList = new ArrayList<CarResponseDto>();
		
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM cars WHERE car_class LIKE ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+carClassTemp+"%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String code = rs.getString(1);
				String model = rs.getString(2);
				String price = rs.getString(3);
				String carClass = rs.getString(4);
				String carNumber = rs.getString(5);
				boolean reservation = rs.getBoolean(6);
				String fuel = rs.getString(7);
				String location = rs.getString(8);
				String seater = rs.getString(9);
				
				CarResponseDto car = new CarResponseDto(code, model, price, carClass, carNumber, reservation, fuel, location, seater);
				carList.add(car);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return carList;
	}
	
	public List<CarResponseDto> searchCarByFuel(String carFuel){
		List<CarResponseDto> carList = new ArrayList<CarResponseDto>();
		
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM cars WHERE fuel LIKE ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+carFuel+"%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String code = rs.getString(1);
				String model = rs.getString(2);
				String price = rs.getString(3);
				String carClass = rs.getString(4);
				String carNumber = rs.getString(5);
				boolean reservation = rs.getBoolean(6);
				String fuel = rs.getString(7);
				String location = rs.getString(8);
				String seater = rs.getString(9);
				
				CarResponseDto car = new CarResponseDto(code, model, price, carClass, carNumber, reservation, fuel, location, seater);
				carList.add(car);
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
			
			String sql = "SELECT car_code, model, price, car_class, car_number, reservation, fuel, location, seater FROM cars WHERE car_code=?";
			
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
				String location = rs.getString(8);
				String seater = rs.getString(9);
				
				if(carCode.equals(code)) {
					car = new CarResponseDto(code, model, price, carClass, carNumber, reservation, fuel, location, seater);
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
