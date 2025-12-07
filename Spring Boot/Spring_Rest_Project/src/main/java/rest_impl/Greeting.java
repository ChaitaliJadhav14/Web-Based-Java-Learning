package rest_impl;

import java.time.LocalDate;

public class Greeting {
	private String message;
	private LocalDate deliveryDate;
	

	public Greeting() {
		// TODO Auto-generated constructor stub
	}


	public Greeting(String message, LocalDate deliveryDate) {
		super();
		this.message = message;
		this.deliveryDate = deliveryDate;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}


	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}


	@Override
	public String toString() {
		return "Greeting [message=" + message + ", deliveryDate=" + deliveryDate + "]";
	}
	

}
