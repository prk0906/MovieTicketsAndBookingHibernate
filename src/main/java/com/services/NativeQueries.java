package com.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.NativeQuery;

import com.entites.Bookings;
import com.util.HibernateUtil;

public class NativeQueries {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
	
		//1: Fetch All Bookings
		fetchAllBookings(session);
		//2: Fetch Bookings by Customer Name 
		fetchBookingByName(session);
		//3: Join Query 
		 joinQuery(session);
		 //4.Delete Records 
		 deleteQuery(session);
	}

	private static void deleteQuery(Session session) {
		session.beginTransaction();
		 MutationQuery nativeMutationQuery = session.createNativeMutationQuery("Delete from booking where numberofTickets < ?1");
		 nativeMutationQuery.setParameter(1, 1);
		 nativeMutationQuery.executeUpdate();
		 session.getTransaction().commit();
	}

	private static void joinQuery(Session session) {
		NativeQuery<Object[]> nativeQuery = session.createNativeQuery("Select b.customername, b.numberOfTickets,m.title"
				+ " from booking b"
				+ " Join movie m on m.movieId = b.movieId");
		System.out.println("3:Join Query");
		 List<Object[]> list = nativeQuery.getResultList();
		 list.forEach(row -> System.out.println(
				    "Customer: " + row[0] +
				    ", Tickets: " + row[1] +
				    ", Movie: " + row[2]
				));
	}

	private static void fetchBookingByName(Session session) {
		NativeQuery<Bookings> nativeQuery = session.createNativeQuery("Select * from booking where customername = :name",Bookings.class);
		nativeQuery.setParameter("name", "ravi");
		List<Bookings> list = nativeQuery.list();
		System.out.println("2:Fetch Bookings by Customer Name ");
		System.out.println(list);
	}

	private static void fetchAllBookings(Session session) {
		NativeQuery<Bookings> nativeQuery = session.createNativeQuery("Select * from booking",Bookings.class);
		List<Bookings> bookingList = nativeQuery.list();
		System.out.println("1:Fetch All Bookings");
		bookingList.forEach(System.out::println);
	}
}
