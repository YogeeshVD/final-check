package com.cognizant.truyum.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.FavouriteDaoCollectionImpl;
import com.cognizant.truyum.dao.FavouriteEmptyException;
import com.cognizant.truyum.model.Movie;

@WebServlet({ "/ShowFavouriteServlet", "/ShowFavourite" })
public class ShowFavouriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowFavouriteServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			FavouriteDaoCollectionImpl favouriteDao = new FavouriteDaoCollectionImpl();
			List<Movie> movieListCustomer = favouriteDao.getAllFavouriteItems(1);
			long count = 0;
			for (Movie movieItem : movieListCustomer) {
				count = movieListCustomer.size();
			}
			request.setAttribute("movieListCustomer", movieListCustomer);
			request.setAttribute("delete", "Movie removed from Favourite successfull");
			request.setAttribute("count", count);
			RequestDispatcher rd = request.getRequestDispatcher("favorites.jsp");
			rd.forward(request, response);

		} catch (FavouriteEmptyException e) {

			RequestDispatcher rd = request.getRequestDispatcher("favorites-empty.jsp");
			rd.forward(request, response);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
