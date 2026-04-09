package com.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.SelectionQuery;

import com.entites.Movies;
import com.util.HibernateUtil;

public class MovieAndBookingsHQL {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		//1.fetchAllMovies
		fetchAllMovies(session);
		//2.Fetch Movie which have rating more than 8
		moviesHavingRatingMoreThanEight(session);
		//3.Fetch Only Movie Titles
		titlesOfmovie(session);
		//4.Sort Movies by Ticket Price
		sortMovieByTicketPrice(session);
		//5: Aggregate Functions
		maxAndAvgTicketPrice(session);
		//6: Update Using HQL
		//increaseTicketPrice(session);
		// 7: Delete Using HQL
		deletemovie(session);
	}

	private static void deletemovie(Session session) {
		session.beginTransaction();
		MutationQuery mutationQuery = session.createMutationQuery("Delete from Movies where rating < :rating");
		mutationQuery.setParameter("rating", 7);
		mutationQuery.executeUpdate();
		session.getTransaction().commit();
	}

	private static void increaseTicketPrice(Session session) {
		session.beginTransaction();
		MutationQuery mutationQuery = session.createMutationQuery("Update Movies m set m.ticket = m.ticket * 10 ");
		mutationQuery.executeUpdate();
		session.getTransaction().commit();
	}

	private static void maxAndAvgTicketPrice(Session session) {
		SelectionQuery<Integer> query = session.createSelectionQuery("Select max(m.ticket) from Movies m",Integer.class);
		List<Integer> list = query.list();
		System.out.println("5: Aggregate Functions");
		System.out.println(list);
		SelectionQuery<Double> average = session.createSelectionQuery("Select avg(m.ticket) from Movies m",Double.class);
		System.out.println("Average of price");
		System.out.println(average.list());
	}

	private static void sortMovieByTicketPrice(Session session) {
		SelectionQuery<Movies> query = session.createSelectionQuery("from Movies order by ticket desc",Movies.class);
		List<Movies> list = query.list();
		System.out.println("4.Sort Movies by Ticket Price");
		list.forEach(System.out::println);
	}

	private static void titlesOfmovie(Session session) {
		SelectionQuery<String> query = session.createSelectionQuery("select m.title from Movies m ",String.class);
		List<String> list = query.list();
		System.out.println("3.Only movie titles");
		list.forEach(System.out::println);
	}

	private static void moviesHavingRatingMoreThanEight(Session session) {
		SelectionQuery<Movies> query = session.createSelectionQuery("from Movies  Where rating = ?1",Movies.class);
		query.setParameter(1, 8);
		List<Movies> movieList = query.list();
		System.out.println("2.Movies which are having rating moer than 8");
		System.out.println(movieList);
	}

	private static void fetchAllMovies(Session session) {
		SelectionQuery<Movies> query = session.createSelectionQuery("from Movies m ",Movies.class);
		List<Movies> moviesList = query.list();
		System.out.println("1.All movies");
		moviesList.forEach(System.out::println);
	}
}
