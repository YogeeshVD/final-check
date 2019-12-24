package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.Movie;
import com.cognizant.truyum.util.DateUtil;

public class MovieDaoCollectionImpl {
	private static List<Movie> movieList;

	public MovieDaoCollectionImpl() throws ParseException {
		if (movieList == null) {
			movieList = new ArrayList<>();
			movieList.add(new Movie(1, "Avatar", 2787965087l, true, DateUtil.converTodate("15/03/2017"),
					"Science Fiction", true));
			movieList.add(new Movie(2, "The Avengers", 1518812988l, true, DateUtil.converTodate("23/12/2017"),
					"Superhero", false));
			movieList.add(
					new Movie(3, "Titanic", 2187463944l, true, DateUtil.converTodate("21/08/2017"), "Romance", false));
			movieList.add(new Movie(4, "Jurassic World", 1671713208l, false, DateUtil.converTodate("02/07/2017"),
					"Science Fiction", true));
			movieList.add(new Movie(5, "Avengers:End Game", 2750760348l, true, DateUtil.converTodate("02/11/2022"),
					"Superhero", true));
		}

	}

	List<Movie> getMovieListAdmin() {
		return movieList;

	}

	List<Movie> getMovieListCustomer() {
		List<Movie> movie = new ArrayList<Movie>();
		Date today = new Date();
		for (Movie x : movieList) {
			if (x.isActive() && x.getDateOfLaunch().before(today)) {
				movie.add(x);
			}
		}
		return movie;
	}

	public void modifyMovie(Movie movie) {
		Movie m = getMovie(movie.getId());
		m.setTitle(movie.getTitle());
		m.setBoxOffice(movie.getBoxOffice());
		m.setActive(movie.isActive());
		m.setDateOfLaunch(movie.getDateOfLaunch());
		m.setGenre(movie.getGenre());
		m.setHasTeaser(movie.isHasTeaser());

	}

	Movie getMovie(long id) {
		Movie movie = null;
		for (Movie x : movieList) {
			if (x.getId() == id) {
				movie = x;
			}
		}
		return movie;
	}

}
