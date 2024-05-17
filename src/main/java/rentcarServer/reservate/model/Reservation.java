package rentcarServer.reservate.model;

import java.sql.Timestamp;

public class Reservation {
	private String number;
	private String userId;
	private String carCode;
	private Timestamp renDate;
	private Timestamp returnDate;
	private String insurance;
	private boolean paymentStatus;
	private String payment;
	private String location;
	private String carModel;
	private int price;
	
	public Reservation(String number, String userId, String carCode, Timestamp renDate, Timestamp returnDate,
			String insurance, boolean paymentStatus, String payment, String location, String carModel, int price) {
		super();
		this.number = number;
		this.userId = userId;
		this.carCode = carCode;
		this.renDate = renDate;
		this.returnDate = returnDate;
		this.insurance = insurance;
		this.paymentStatus = paymentStatus;
		this.payment = payment;
		this.location = location;
		this.carModel = carModel;
		this.price = price;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCarCode() {
		return carCode;
	}

	public void setCarCode(String carCode) {
		this.carCode = carCode;
	}

	public Timestamp getRenDate() {
		return renDate;
	}

	public void setRenDate(Timestamp renDate) {
		this.renDate = renDate;
	}

	public Timestamp getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Timestamp returnDate) {
		this.returnDate = returnDate;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public boolean isPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
