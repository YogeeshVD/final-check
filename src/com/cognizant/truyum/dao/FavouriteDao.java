package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.Movie;

public interface FavouriteDao {
	public void addfavouriteItem(long userId, long movieId) throws ParseException;

	public List<Movie> getAllFavouriteItems(long userId) throws FavouriteEmptyException;

	public void removeFavouriteItem(long userId, long movieId) throws FavouriteEmptyException;

}
