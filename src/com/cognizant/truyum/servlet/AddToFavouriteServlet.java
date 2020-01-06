package com.cognizant.truyum.servlet;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.FavouriteDao;
import com.cognizant.truyum.dao.FavouriteDaoCollectionImpl;

@WebServlet({ "/AddToFavouriteServlet", "/AddToFavourite" })
public class AddToFavouriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddToFavouriteServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FavouriteDao favouriteDao = new FavouriteDaoCollectionImpl();
		long movieId = Long.parseLong(request.getParameter("movieId"));
		try {
			favouriteDao.addfavouriteItem(1, movieId);
			request.setAttribute("addfav", "Movie added to Favourite successfully");
			RequestDispatcher rd = request.getRequestDispatcher("ShowMovieListCustomer");
			rd.forward(request, response);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
