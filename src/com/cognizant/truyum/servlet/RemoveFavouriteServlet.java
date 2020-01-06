package com.cognizant.truyum.servlet;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.FavouriteDaoCollectionImpl;
import com.cognizant.truyum.dao.FavouriteEmptyException;
import com.cognizant.truyum.dao.FavouriteEmptyException;
import com.cognizant.truyum.dao.MovieDaoCollectionImpl;

@WebServlet({ "/RemoveFavouriteServlet", "/RemoveFavourite" })
public class RemoveFavouriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RemoveFavouriteServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FavouriteDaoCollectionImpl favouriteDao = new FavouriteDaoCollectionImpl();
		long movieId = Long.parseLong(request.getParameter("movieId"));
		try {
			favouriteDao.removeFavouriteItem(1, movieId);
			request.setAttribute("remove", "Movie removed from Favorites successfully");
			RequestDispatcher rd = request.getRequestDispatcher("ShowFavourite");
			rd.forward(request, response);

		} catch (FavouriteEmptyException e) {
			RequestDispatcher rd = request.getRequestDispatcher("favorites-empty.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
