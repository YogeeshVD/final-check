package com.cognizant.truyum.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.MovieDao;
import com.cognizant.truyum.dao.MovieDaoCollectionImpl;
import com.cognizant.truyum.model.Movie;
import com.cognizant.truyum.util.DateUtil;

@WebServlet({ "/EditMovieServlet", "/EditMovie" })
public class EditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditMovieServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("movieId"));
		String title = request.getParameter("title");
		long boxOffice = Long.parseLong(request.getParameter("boxOffice"));
		boolean active = Boolean.parseBoolean(request.getParameter("active"));
		String dateOfLaunch = request.getParameter("dateOfLaunch");
		String genre = request.getParameter("genre");
		boolean hasTeaser = Boolean.parseBoolean(request.getParameter("hasTeaser"));

		try {
			Movie movieItem = new Movie(id, title, boxOffice, active, convertToDate(dateOfLaunch), genre, hasTeaser);
			MovieDao movieDao = new MovieDaoCollectionImpl();
			movieDao.modifyMovie(movieItem);
			request.setAttribute("msg", "Movie detials saved successfully");
			RequestDispatcher rd = request.getRequestDispatcher("edit-movie-status.jsp");
			rd.forward(request, response);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private Date convertToDate(String dateOfLaunch) {
		// TODO Auto-generated method stub
		return null;
	}

}
