package beans;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Movie;
import service.JSONServiceHandler;
import util.JSFHelper;

@SessionScoped
@ManagedBean
public class MyCinemaBean {
	
	private JSONServiceHandler sh;
	
	private ArrayList<Movie> favouriteList = new ArrayList<>();
	private ArrayList<Movie> toWatchList  = new ArrayList<>();
	private ArrayList<Movie> keepEyeOnList = new ArrayList<>();
	
	private Movie addingMovie = new Movie();
	
	public JSONServiceHandler getSh() {
		return sh;
	}

	public void setSh(JSONServiceHandler sh) {
		this.sh = sh;
	}

	public ArrayList<Movie> getFavouriteList() {
		return favouriteList;
	}

	public void setFavouriteList(ArrayList<Movie> favouriteList) {
		this.favouriteList = favouriteList;
	}

	public ArrayList<Movie> getToWatchList() {
		return toWatchList;
	}

	public void setToWatchList(ArrayList<Movie> toWatchList) {
		this.toWatchList = toWatchList;
	}

	public ArrayList<Movie> getKeepEyeOnList() {
		return keepEyeOnList;
	}

	public void setKeepEyeOnList(ArrayList<Movie> keepEyeOnList) {
		this.keepEyeOnList = keepEyeOnList;
	}
	
	public Movie getAddingMovie() {
		return addingMovie;
	}

	public void setAddingMovie(Movie addingMovie) {
		this.addingMovie = addingMovie;
	}
	
	///// Methoden ////
	
	private String takeMediaId() {
		ServiceBean sb = JSFHelper.findBean("serviceBean", ServiceBean.class);
		String mediaId = sb.getSelectedMovie().getMediaId();
		return mediaId;
	}
	
	public void addFavourite(){
		String mediaId = takeMediaId();
		addingMovie = sh.createMovie(mediaId);
		addFavouriteList(addingMovie.getMediaId(), addingMovie.getTitle(), addingMovie.getPosterPath());
	}
	
	public void addFavouriteList(String movieId, String title, String poster_path){
		favouriteList.add(new Movie(movieId, title, poster_path));
	}
	
	public void addToWatch(){
		String mediaId = takeMediaId();
		addingMovie = sh.createMovie(mediaId);
		addToWatchList(addingMovie.getMediaId(), addingMovie.getTitle(), addingMovie.getPosterPath());
	}
	
	public void addToWatchList(String movieId, String title, String poster_path){
		toWatchList.add(new Movie(movieId, title, poster_path));
	}
	
	public void addKeepEyeOn(){
		String mediaId = takeMediaId();
		addingMovie = sh.createMovie(mediaId);
		addKeepEyeOnList(addingMovie.getMediaId(), addingMovie.getTitle(), addingMovie.getPosterPath());
	}
		
	public void addKeepEyeOnList(String movieId, String title, String poster_path){
		keepEyeOnList.add(new Movie(movieId, title, poster_path));
	}
	
	public void delFavourite(){
		String id = takeMediaId();
		for (int i = 0; i < favouriteList.size(); i++) {
			Movie obj = favouriteList.get(i);
			if(obj.getMediaId().equals(id)){
				favouriteList.remove(i); break;
			}
		}
		System.out.println("Favorite Total: " + favouriteList.size());
	}
	
	public void delToWatch(){
		String id = takeMediaId();
		for (int i = 0; i < toWatchList.size(); i++) {
			Movie obj = toWatchList.get(i);
			if(obj.getMediaId().equals(id)){
				toWatchList.remove(i); break;
			}
		}
		System.out.println("To Watch Total: " + toWatchList.size());
	}
	
	public void delKeepEyeOn(){
		String id = takeMediaId();
		for (int i = 0; i < keepEyeOnList.size(); i++) {
			Movie obj = keepEyeOnList.get(i);
			if(obj.getMediaId().equals(id)){
				keepEyeOnList.remove(i); break;
			}
		}
		System.out.println("Keep Eye On Total: " + keepEyeOnList.size());
	}
	
	public void setFirstMovie(){
		Movie movie = favouriteList.get(0);
		ServiceBean sb = JSFHelper.findBean("serviceBean", ServiceBean.class);
		sb.setSelectedMovie(sh.createMovie(movie.getMediaId()));		
	}
	
	@PostConstruct
	public void init() {
		sh = JSONServiceHandler.getInstance();
		
		addFavouriteList("287948", "The Transporter Refueled", "http://image.tmdb.org/t/p/w500/zW7oC3tucYLzu77xNbPbYjXUN4o.jpg");
		addFavouriteList("238", "The Godfather", "http://image.tmdb.org/t/p/w500/d4KNaTrltq6bpkFS01pYtyXa09m.jpg");
		addFavouriteList("161", "Ocean's Eleven", "http://image.tmdb.org/t/p/w500/5gkZ8PL3JZXXgq398xWzaxVB1Sc.jpg");
		addFavouriteList("500", "Reservoir Dogs", "http://image.tmdb.org/t/p/w500/4ctv9pxKpwjTFevWQbvaqXkXbPF.jpg");
		addFavouriteList("27576", "Salt", "http://image.tmdb.org/t/p/w500/956xMjH4sPoqimqoLOP6AI19mjm.jpg");
		addFavouriteList("1725", "West Side Story", "http://image.tmdb.org/t/p/w500/zRQhCSREdR9h4OzEVvwhdlZNZ6m.jpg");
		addFavouriteList("23398", "Alvin and the Chipmunks: The Squeakquel", "http://image.tmdb.org/t/p/w500/dpY7igIBW0Gw8LVLYgbCvjgc2aR.jpg");
		addFavouriteList("86829" , "Inside Llewyn Davis", "http://image.tmdb.org/t/p/w500/mRYOb0fgxj3o03u5y62YPhAunby.jpg");
		addFavouriteList("302429", "Strange Magic", "http://image.tmdb.org/t/p/w500/2hwI8LcrBpAnDvaOZ99h5mTCNdK.jpg");
		addFavouriteList("8818", "Evita", "http://image.tmdb.org/t/p/w500/eqg0XCOvXQ3J62MOoQg6eQmyp3A.jpg");
		addFavouriteList("602", "Independence Day", "http://image.tmdb.org/t/p/w500/cf3cmVa1zrmfQoltnezvsniNnoX.jpg");
		addFavouriteList("2978", "Ghostbusters II", "http://image.tmdb.org/t/p/w500/4nN0EYNbOWHJ9UO39maO5Kvcdfa.jpg");
		addFavouriteList("2164", "Stargate", "http://image.tmdb.org/t/p/w500/39WsfbB5BshvdbPAYRFXdsjC481.jpg");
		addFavouriteList("263472", "Knock Knock", "http://image.tmdb.org/t/p/w500/eynMtjBB1fXsB5vsQylVmsDLmvw.jpg");
		addFavouriteList("238636", "The Purge: Anarchy", "http://image.tmdb.org/t/p/w500/l1DRl40x2OWUoPP42v8fjKdS1Z3.jpg");
		addFavouriteList("1250", "Ghost Rider", "http://image.tmdb.org/t/p/w500/soDF6i4eREQN4JPuSzpAqWDZmU4.jpg");
		addFavouriteList("49018", "Insidious", "http://image.tmdb.org/t/p/w500/urAaOffVaxQzRJ8X5Z0oDqOWAjl.jpg");
		addFavouriteList("201085", "Crimson Peak", "http://image.tmdb.org/t/p/w500/pCj8zem1NDAODdtvha9WFEB6iWR.jpg");
		
		addToWatchList("11596", "New Nightmare", "http://image.tmdb.org/t/p/w500/oLEZibnraixTE68rTaYv4FEmvYd.jpg");
		addToWatchList("975", "Paths of Glory", "http://image.tmdb.org/t/p/w500/6lMXjI1O1N7XyZEjqIo5wkbrgxg.jpg");
		addToWatchList("164184", "Bless Me, Ultima", "http://image.tmdb.org/t/p/w500/kYUcvI4RUzimerSP7cCCPuISVBb.jpg");
		addToWatchList("47904", "Outside the Law", "http://image.tmdb.org/t/p/w500/ofJOJi2tqRFjDw58gkbZf6vqIJS.jpg");
		addToWatchList("8737", "Cast a Giant Shadow", "http://image.tmdb.org/t/p/w500/q92SPdntxXySZQ88zTDe2ZH0NAb.jpg");
		addToWatchList("16638", "El Cid", "http://image.tmdb.org/t/p/w500/lligQ1GAdWEjVxC7HXjzPg5PTuB.jpg");
		addToWatchList("12503", "Under Fire", "http://image.tmdb.org/t/p/w500/mvscM4MPbxTxfi66AwIYHfRY7PF.jpg");
		addToWatchList("8929", "Johnny Mad Dog", "http://image.tmdb.org/t/p/w500/5ra9Ww0FoJpz45hMQ5rpu5TeepX.jpg");
		addToWatchList("10687", "Tigerland", "http://image.tmdb.org/t/p/w500/yyW54WcjMFX4NTRy1NnKIeaWhLS.jpg");
		addToWatchList("335462", "Wolf Warrior", "http://image.tmdb.org/t/p/w500/9YeAALPa3PouhnSG5nzfKvX1u3x.jpg");
		addToWatchList("14097", "9th Company", "http://image.tmdb.org/t/p/w500/8LqqdxD0Ol7PslyRyP6sCqoIxqm.jpg");

		addKeepEyeOnList("2978", "Ghostbusters II", "http://image.tmdb.org/t/p/w500/4nN0EYNbOWHJ9UO39maO5Kvcdfa.jpg");
		addKeepEyeOnList("2164", "Stargate", "http://image.tmdb.org/t/p/w500/39WsfbB5BshvdbPAYRFXdsjC481.jpg");
		addKeepEyeOnList("263472", "Knock Knock", "http://image.tmdb.org/t/p/w500/eynMtjBB1fXsB5vsQylVmsDLmvw.jpg");
		addKeepEyeOnList("238636", "The Purge: Anarchy", "http://image.tmdb.org/t/p/w500/l1DRl40x2OWUoPP42v8fjKdS1Z3.jpg");
		addKeepEyeOnList("1250", "Ghost Rider", "http://image.tmdb.org/t/p/w500/soDF6i4eREQN4JPuSzpAqWDZmU4.jpg");
		addKeepEyeOnList("49018", "Insidious", "http://image.tmdb.org/t/p/w500/urAaOffVaxQzRJ8X5Z0oDqOWAjl.jpg");
		addKeepEyeOnList("201085", "Crimson Peak", "http://image.tmdb.org/t/p/w500/pCj8zem1NDAODdtvha9WFEB6iWR.jpg");
		addKeepEyeOnList("1576", "Resident Evil", "http://image.tmdb.org/t/p/w500/fttmSgLEOdBNwQepW2lC6t0mbOm.jpg");
		addKeepEyeOnList("8413", "Event Horizon", "http://image.tmdb.org/t/p/w500/vo02iJLsem3VCJ2TNvSzRiJMpAE.jpg");
		addKeepEyeOnList("215", "Saw II", "http://image.tmdb.org/t/p/w500/vC7ggR8njwtQOZRmrSvMtHqy9hx.jpg");
		addKeepEyeOnList("9392", "The Descent", "http://image.tmdb.org/t/p/w500/ldzNyitGjBLjjOzLTaQyYDMVDF1.jpg");
		addKeepEyeOnList("10779", "The Frighteners", "http://image.tmdb.org/t/p/w500/cS3QPtMsE1jsEWUww5WsPE275Jb.jpg");
		addKeepEyeOnList("86597", "The Tall Man", "http://image.tmdb.org/t/p/w500/1fc87E3ppCq6xBnZJ63Sa9FKRUd.jpg");
		addKeepEyeOnList("3597", "I Know What You Did Last Summer", "http://image.tmdb.org/t/p/w500/cruOfvjIqMTbOQxld8SpM8OzVnf.jpg");		
		
		setFirstMovie();
	}

}