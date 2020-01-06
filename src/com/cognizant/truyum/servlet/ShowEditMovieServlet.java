package com.cognizant.truyum.servlet;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.MovieDao;
import com.cognizant.truyum.dao.MovieDaoCollectionImpl;
import com.cognizant.truyum.model.Movie;

@WebServlet({ "/ShowEditMovieServlet", "/ShowEditMovie" })
public class ShowEditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowEditMovieServlet() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			MovieDao movieDao = new MovieDaoCollectionImpl();
			long id = Long.parseLong(request.getParameter("movieId"));
			Movie movieItem = movieDao.getMovie(id);
			request.setAttribute("movieItem", movieItem);
			RequestDispatcher rd = request.getRequestDispatcher("edit-movie.jsp");
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
