package rentcarServer.car.model;

public class CarResponseDto {

	private String carCode;
	private String model;
	private String price;
	private String carClass;
	private String carNumber;
	private boolean reservation;
	private String fuel;
	
	public CarResponseDto(String carCode, String model, String price, String carClass, String carNumber,
			boolean reservation, String fuel) {
		super();
		this.carCode = carCode;
		this.model = model;
		this.price = price;
		this.carClass = carClass;
		this.carNumber = carNumber;
		this.reservation = reservation;
		this.fuel = fuel;
	}

	public String getCarCode() {
		return carCode;
	}

	public String getModel() {
		return model;
	}

	public String getPrice() {
		return price;
	}

	public String getCarClass() {
		return carClass;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public boolean isReservation() {
		return reservation;
	}

	public String getFuel() {
		return fuel;
	}
	
}
