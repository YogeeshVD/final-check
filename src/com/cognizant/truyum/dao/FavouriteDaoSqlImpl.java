package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.Favourite;
import com.cognizant.truyum.model.Movie;

public class FavouriteDaoSqlImpl implements FavouriteDao {

	@Override
	public void addfavouriteItem(long userId, long movieId) throws ParseException {
		Connection con = ConnectionHandler.getConnection();
		MovieDao movieDao = new MovieDaoSqlImpl();
		Movie MovieItem = movieDao.getMovie(movieId);
		String sql = " insert into favorite (fv_us_id, fv_mv_id) values (?,?)" ;
		try {
			PreparedStatement ps  = con.prepareStatement(sql);
			ps.setLong(1, userId);
			ps.setLong(2, movieId);
			int rs = ps.executeUpdate();
			
			
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
	public List<Movie> getAllFavouriteItems(long userId) throws FavouriteEmptyException {
	Connection con = ConnectionHandler.getConnection();
	List<Movie> movie = new ArrayList<>();
	Favourite favourite = new Favourite();
	String sql = " select m.mv_id as Id, m.mv_title as Title, m.mv_box_office as Box_Office, m.mv_active as Active, m.mv_date_of_launch as Date_Of_Launch m.mv_genre as Genre, m.mv_has_teaser as has_Teaser from movie m join favorite f on m.mv_id = f.fv_mv_id where fv_us_id = ?";
	PreparedStatement ps;
	try {
		ps = con.prepareStatement(sql);
		ps.setLong(1, userId);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Movie movieItem = new Movie() ;
			movieItem.setId(rs.getInt("mv_id"));
			movieItem.setTitle(rs.getString("mv_title"));
			movieItem.setBoxOffice(rs.getLong("mv_box_office"));
			movieItem.setActive(rs.getString("mv_genre").equalsIgnoreCase("Yes"));
			movieItem.setDateOfLaunch(rs.getDate("mv_date_of_launch"));
			movieItem.setGenre(rs.getString("mv_genre"));
			movieItem.setHasTeaser(rs.getString("mv_has_teaser").equalsIgnoreCase("Yes"));
			favourite.getMovieList().add(movieItem);
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
	
	
		return favourite.getMovieList();
	}

	@Override
	public void removeFavouriteItem(long userId, long movieId) throws FavouriteEmptyException {
		Connection con = ConnectionHandler.getConnection();
		String sql = "delete from favorite where fv_us_id = ? and fv_mv_id = ? limit 1 ";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, userId);
			ps.setLong(2, movieId);
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

}
