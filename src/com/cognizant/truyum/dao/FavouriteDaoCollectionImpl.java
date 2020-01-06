package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cognizant.truyum.model.Favourite;
import com.cognizant.truyum.model.Movie;

public class FavouriteDaoCollectionImpl implements FavouriteDao {

	private static HashMap<Long, Favourite> userFavourite;

	public FavouriteDaoCollectionImpl() {

		if (userFavourite == null) {
			userFavourite = new HashMap<>();
			userFavourite.put(1l, new Favourite());

		}

	}
	@Override
	public void addfavouriteItem(long userId, long movieId) throws ParseException  {
		MovieDaoCollectionImpl movieDao;
			try {
				movieDao = new MovieDaoCollectionImpl();
				Movie movie = movieDao.getMovie(movieId);
				if (userFavourite.containsKey(userId)) {
					Favourite favourite = userFavourite.get(userId);
					favourite.getMovieList().add(movie);
				} else {
					Favourite favourite = new Favourite();
					favourite.getMovieList().add(movie);
					userFavourite.put(userId, favourite);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			
	

	}
@Override
	public List<Movie> getAllFavouriteItems(long userId) throws FavouriteEmptyException {
		List<Movie> movieList = userFavourite.get(userId).getMovieList();
		Favourite favourite = userFavourite.get(userId);
		double numOfFav = 0;
		if (favourite == null || movieList == null || movieList.isEmpty()) {
				throw new FavouriteEmptyException();
		}
		return movieList;

	}
@Override
	public void removeFavouriteItem(long userId, long movieId) throws FavouriteEmptyException {
		List<Movie> movieList = userFavourite.get(userId).getMovieList();
		for (Movie movie : movieList) {
			if (movie.getId() == movieId) {
				movieList.remove(movie);
				break;
			}

		}

	}

}
