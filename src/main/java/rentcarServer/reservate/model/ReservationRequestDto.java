package rentcarServer.reservate.model;

import java.sql.Timestamp;

public class ReservationRequestDto {
	private String number;
	private String userId;
	private String carCode;
	private Timestamp renDate;
	private Timestamp returnDate;
	private String insurance;
	private boolean paymentStatus;
	private String payment;
	
	public ReservationRequestDto() {
		super();
	}

	public ReservationRequestDto(String number, String userId, String carCode, Timestamp renDate, Timestamp returnDate,
			String insurance, boolean paymentStatus, String payment) {
		super();
		this.number = number;
		this.userId = userId;
		this.carCode = carCode;
		this.renDate = renDate;
		this.returnDate = returnDate;
		this.insurance = insurance;
		this.paymentStatus = paymentStatus;
		this.payment = payment;
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

}
