package com.entites;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.util.HibernateUtil;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="movie")
public class Movies {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer movieId;
	private String title;
	private String gener;
	private Double rating;
	private Integer ticket;
	
	
	public Movies() {
		super();
	}
	public Movies(String title, String gener, Double rating, Integer ticket) {
		super();
		this.title = title;
		this.gener = gener;
		this.rating = rating;
		this.ticket = ticket;
	}
	public Movies(Integer movieId, String title, String gener, Double rating, Integer ticket) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.gener = gener;
		this.rating = rating;
		this.ticket = ticket;
	}
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGener() {
		return gener;
	}
	public void setGener(String gener) {
		this.gener = gener;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public Integer getTicket() {
		return ticket;
	}
	public void setTicket(Integer ticket) {
		this.ticket = ticket;
	}
	@Override
	public String toString() {
		return "Movies [movieId=" + movieId + ", title=" + title + ", gener=" + gener + ", rating=" + rating
				+ ", ticket=" + ticket + "]";
	}
	
}
