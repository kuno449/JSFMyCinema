package model;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class MovieList implements Serializable {
	
	ArrayList<Movie> movieList = new ArrayList<>();
	
	public ArrayList<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(ArrayList<Movie> movieList) {
		this.movieList = movieList;
	}
	
	public void addMovie(Movie movie){
		movieList.add(movie);
	}
	
		@Override
	public String toString() {
		return "MovieList [movieList=" + movieList + "]";
	}

}
