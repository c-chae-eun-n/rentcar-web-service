package rentcarServer.car.model;

public class CarDao {
	private CarDao() {
		
	}
	
	private static CarDao instance = new CarDao();
	
	public static CarDao getInstance() {
		return instance;
	}
}
