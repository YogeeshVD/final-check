package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.Movie;

public interface FavouriteDao {
	public void addfavouriteItem(long userId, long movieId);

	public List<Movie> getAllFavouriteItems(long userId);

	public void removefavouriteItem(long userId, long movieId);

}
