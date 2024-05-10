package rentcarServer.reservate.model;

public class ReservationDao {
	private ReservationDao() {
		
	}
	
	private static ReservationDao instance = new ReservationDao();
	
	public static ReservationDao getInstance() {
		return instance;
	}
}
