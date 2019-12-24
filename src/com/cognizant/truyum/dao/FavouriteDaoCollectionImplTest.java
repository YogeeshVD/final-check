package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.Movie;

public class FavouriteDaoCollectionImplTest {
	public static void main(String[] args) throws FavouriteEmptyException, ParseException {

		testGetAllfavouriteItems();
		System.out.println("----------------Add to Favourite--------------");
		testAddFavouriteItem();
		testGetAllfavouriteItems();

		System.out.println("----------------All Favourite Items--------------");
		testGetAllfavouriteItems();

		System.out.println("-----------Favourite Items After Remove------------");
		testRemoveFavouriteItem();
		testGetAllfavouriteItems();

	}

	public static void testAddFavouriteItem() throws ParseException {
		FavouriteDaoCollectionImpl favouriteDao = new FavouriteDaoCollectionImpl();
		favouriteDao.addFavouriteItem(1, 2);
		favouriteDao.addFavouriteItem(1, 3);
		favouriteDao.addFavouriteItem(1, 4);


	}

	public static void testGetAllfavouriteItems() {
		FavouriteDaoCollectionImpl favouriteDao = new FavouriteDaoCollectionImpl();
		try {
			List<Movie> movieListCustomer = favouriteDao.getAllFavouriteItems(1);
			for (Movie movie : movieListCustomer) {
				System.out.println(movie);
			}
			System.out.println("Number Of favourite items : " + movieListCustomer.size());
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void testRemoveFavouriteItem() {
		FavouriteDaoCollectionImpl favouriteDao = new FavouriteDaoCollectionImpl();
		favouriteDao.removeFavouriteItem(1, 4);
	}
}
