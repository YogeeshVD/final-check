package com.cognizant.truyum.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Favourite {
	private List<Movie> movieList;
	private double numOfFav;

	public Favourite() {
		super();
		movieList = new ArrayList<>();
	}

	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	public double getNumOfFav() {
		return numOfFav;
	}

	public void setNumOfFav(double numOfFav) {
		this.numOfFav = numOfFav;
	}

}
