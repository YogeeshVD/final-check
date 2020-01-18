package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.Movie;
import com.cognizant.truyum.util.DateUtil;

public class MovieDaoSqlImplTest {

	public static void main(String[] args) {
		try {
			System.out.println("----------* * ADMIN * *------------------");
			testGetMovieListAdmin();

			System.out.println("-----------* * CUSTOMER * *----------------");
			testGetMovieListCustomer();

			System.out.println("----------- * * MODIFIED * *----------------");
			testModifyMovie();
			testGetMovieListAdmin();
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void testGetMovieListAdmin() throws ParseException {
		MovieDao movieDao = new MovieDaoSqlImpl();

		List<Movie> movie = movieDao.getMovieListAdmin();
		for (Movie x : movie) {
			System.out.println(x);
		}
	}
	
	public static void testGetMovieListCustomer() throws ParseException {
		MovieDao movieDao = new MovieDaoSqlImpl();

		List<Movie> movie = movieDao.getMovieListCustomer();
		for (Movie y : movie) {
			System.out.println(y);
		}
	}

	public static void testModifyMovie() throws ParseException {
		Movie mov = new Movie(2, "Jumanji", 125645251l, true, DateUtil.converTodate("23/11/2018"), "Superhero", true);
		MovieDao movieDao = new MovieDaoSqlImpl();
		movieDao.modifyMovie(mov);
	}


}
