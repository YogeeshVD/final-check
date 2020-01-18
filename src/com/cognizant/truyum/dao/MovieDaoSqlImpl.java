package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.Movie;

public class MovieDaoSqlImpl implements MovieDao {
	@Override
	public List<Movie> getMovieListAdmin() {
		Connection con = ConnectionHandler.getConnection();
		List<Movie> movieAdminList = new ArrayList<>();
		String sql = "select mv_id as Id, mv_title as Title, mv_box_office as Box_Office, mv_active as Active, mv_date_of_launch as Date_Of_Launch, mv_genre as Genre, mv_has_teaser as Has_Teaser from movie";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Movie movieItem = new Movie();
				movieItem.setId(rs.getInt("mv_id"));
				movieItem.setTitle(rs.getString("mv_title"));
				movieItem.setBoxOffice(rs.getLong("mv_box_office"));
				movieItem.setActive(rs.getString("mv_active").equalsIgnoreCase("Yes"));
				movieItem.setDateOfLaunch(rs.getDate("mv_date_of_launch"));
				movieItem.setGenre(rs.getString("mv_genre"));
				movieItem.setHasTeaser(rs.getString("mv_has_teaser").equalsIgnoreCase("Yes"));
				movieAdminList.add(movieItem);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return movieAdminList;

	}

	@Override
	public List<Movie> getMovieListCustomer() {
		Connection con = ConnectionHandler.getConnection();
		List<Movie> movieCustomerList = new ArrayList<>();
		String sql = " select mv_id as Id, mv_title as Title, mv_box_office as Box_Office, mv_active as Active, mv_date_of_launch as Date_Of_Launch, mv_genre as Genre, mv_has_teaser as Has_Teaser from movie where mv_active = ? and  mv_date_of_launch < ? ";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "Yes");
			ps.setDate(2, java.sql.Date.valueOf(java.time.LocalDate.now()));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Movie movieItem = new Movie();
				movieItem.setId(rs.getInt("mv_id"));
				movieItem.setTitle(rs.getString("mv_title"));
				movieItem.setBoxOffice(rs.getLong("mv_box_office"));
				movieItem.setActive(rs.getString("mv_active").equalsIgnoreCase("Yes"));
				movieItem.setDateOfLaunch(rs.getDate("mv_date_of_launch"));
				movieItem.setGenre(rs.getString("mv_genre"));
				movieItem.setHasTeaser(rs.getString("mv_has_teaser").equalsIgnoreCase("Yes"));
				movieCustomerList.add(movieItem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return movieCustomerList;

	}

	@Override
	public void modifyMovie(Movie movie) {
		Connection con = ConnectionHandler.getConnection();
		String sql = "update movie set mv_title = ? , mv_box_office = ? , mv_active = ? , mv_date_of_launch = ?, mv_genre = ? , mv_has_teaser = ? where mv_id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, movie.getTitle());
			ps.setLong(2, movie.getBoxOffice());
			ps.setString(3, movie.isActive() ? "Yes" : "No");
			ps.setDate(4, new java.sql.Date(movie.getDateOfLaunch().getTime()));
			ps.setString(5, movie.getGenre());
			ps.setString(6, movie.isHasTeaser() ? "Yes" : "No");
			ps.setLong(7, movie.getId());
			int rs = ps.executeUpdate();
			System.out.println(rs);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public Movie getMovie(long movieId) {
		Connection con = ConnectionHandler.getConnection();
		Movie mv = new Movie();
		String sql = "select mv_id as Id, mv_title as Title, mv_box_office as Box_Office, mv_active as Active, mv_date_of_launch as Date_Of_Launch, mv_genre as Genre, mv_has_teaser as Has_Teaser from movie where mv_id = ? ";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, movieId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				mv.setId(rs.getLong("mv_id"));
				mv.setTitle(rs.getString("mv_title"));
				mv.setBoxOffice(rs.getLong("mv_box_office"));
				mv.setActive(rs.getString("mv_active").equalsIgnoreCase("Yes"));
				mv.setDateOfLaunch(rs.getDate("mv_date_of_launch"));
				mv.setGenre(rs.getString("mv_genre"));
				mv.setHasTeaser(rs.getString("mv_has_teaser").equalsIgnoreCase("Yes"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return mv;

	}

}
