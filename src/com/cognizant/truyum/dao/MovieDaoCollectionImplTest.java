package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.Movie;
import com.cognizant.truyum.util.DateUtil;

public class MovieDaoCollectionImplTest {
	public static void main(String[] args) {
		try {
			System.out.println("--------------ADMIN------------------");
			testGetMovieListAdmin();

			System.out.println("-------------CUSTOMER----------------");
			testGetMovieListCustomer();

			System.out.println("-------------MODIFIED----------------");
			testModifyMovie();
			testGetMovieListAdmin();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void testGetMovieListAdmin() throws ParseException {
		MovieDao movieDao = new MovieDaoCollectionImpl();

		List<Movie> movie = movieDao.getMovieListAdmin();
		for (Movie x : movie) {
			System.out.println(x);
		}
	}

	public static void testGetMovieListCustomer() throws ParseException {
		MovieDaoCollectionImpl movieDao = new MovieDaoCollectionImpl();

		List<Movie> movie = movieDao.getMovieListCustomer();
		for (Movie y : movie) {
			System.out.println(y);
		}
	}

	public static void testModifyMovie() throws ParseException {
		Movie mov = new Movie(2, "Jumanji", 125645251l, true, DateUtil.converTodate("23/11/2018"), "Superhero", true);
		MovieDaoCollectionImpl movieDao = new MovieDaoCollectionImpl();
		movieDao.modifyMovie(mov);
	}

}
