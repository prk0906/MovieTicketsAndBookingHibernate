package com.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="booking")
public class Bookings {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingId;
	private String customerName;
	private Integer numberOftickets;
	private Integer totalAmount;
	private Integer movieId;
	
	public Bookings() {
		super();
	}
	public Bookings(Integer bookingId, String customerName, Integer numberOftickets, Integer totalAmount,
			Integer movieId) {
		super();
		this.bookingId = bookingId;
		this.customerName = customerName;
		this.numberOftickets = numberOftickets;
		this.totalAmount = totalAmount;
		this.movieId = movieId;
	}
	public Bookings(String customerName, Integer numberOftickets, Integer totalAmount, Integer movieId) {
		super();
		this.customerName = customerName;
		this.numberOftickets = numberOftickets;
		this.totalAmount = totalAmount;
		this.movieId = movieId;
	}
	@Override
	public String toString() {
		return "Bookings [bookingId=" + bookingId + ", customerName=" + customerName + ", numberOftickets="
				+ numberOftickets + ", totalAmount=" + totalAmount + ", movieId=" + movieId + "]";
	}
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Integer getNumberOftickets() {
		return numberOftickets;
	}
	public void setNumberOftickets(Integer numberOftickets) {
		this.numberOftickets = numberOftickets;
	}
	public Integer getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	
	
}
