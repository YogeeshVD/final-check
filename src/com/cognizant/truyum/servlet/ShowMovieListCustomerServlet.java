package com.cognizant.truyum.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.MovieDaoCollectionImpl;
import com.cognizant.truyum.model.Movie;

@WebServlet({ "/ShowMovieListCustomerServlet", "/ShowMovieListCustomer" })
public class ShowMovieListCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowMovieListCustomerServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			MovieDaoCollectionImpl movieDao = new MovieDaoCollectionImpl();
			List<Movie> movieList = movieDao.getMovieListCustomer();
			request.setAttribute("movieList", movieList);
			RequestDispatcher rd = request.getRequestDispatcher("movie-list-customer.jsp");
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
