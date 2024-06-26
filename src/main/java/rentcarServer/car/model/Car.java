package rentcarServer.car.model;

public class Car {

	private String carCode;
	private String model;
	private String price;
	private String carClass;
	private String carNumber;
	private boolean reservation;
	private String fuel;
	private String location;
	private String seater;
	
	public Car(String carCode, String model, String price, String carClass, String carNumber, boolean reservation,
			String fuel, String location, String seater) {
		super();
		this.carCode = carCode;
		this.model = model;
		this.price = price;
		this.carClass = carClass;
		this.carNumber = carNumber;
		this.reservation = reservation;
		this.fuel = fuel;
		this.location = location;
		this.seater = seater;
	}

	public String getCarCode() {
		return carCode;
	}

	public void setCarCode(String carCode) {
		this.carCode = carCode;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCarClass() {
		return carClass;
	}

	public void setCarClass(String carClass) {
		this.carClass = carClass;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public boolean isReservation() {
		return reservation;
	}

	public void setReservation(boolean reservation) {
		this.reservation = reservation;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSeater() {
		return seater;
	}

	public void setSeater(String seater) {
		this.seater = seater;
	}
}
