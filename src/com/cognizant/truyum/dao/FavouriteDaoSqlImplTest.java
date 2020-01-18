package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.Movie;

public class FavouriteDaoSqlImplTest {

	public static void main(String[] args) throws FavouriteEmptyException {

		try {

			testGetAllfavouriteItems();
			System.out.println("--------------* * Add to Favourite * *--------------");
			testAddFavouriteItem();

			System.out.println("--------------* * All Favourite Items * *--------------");
			testGetAllfavouriteItems();
			
			System.out.println("-----------* * Favourite Items After Remove * *------------");
			testRemoveFavouriteItem();
			testGetAllfavouriteItems();


		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		testGetAllfavouriteItems();

	}

	public static void testAddFavouriteItem() throws ParseException {
		FavouriteDaoCollectionImpl favouriteDao = new FavouriteDaoCollectionImpl();
		favouriteDao.addfavouriteItem(1, 2);
		favouriteDao.addfavouriteItem(1, 3);
		favouriteDao.addfavouriteItem(1, 4);

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

	public static void testRemoveFavouriteItem() throws FavouriteEmptyException {
		FavouriteDaoCollectionImpl favouriteDao = new FavouriteDaoCollectionImpl();
		favouriteDao.removeFavouriteItem(1, 4);
	}
}
