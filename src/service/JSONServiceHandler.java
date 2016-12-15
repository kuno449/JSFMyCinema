package service;

import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;

import json.MovieListSerializer;
import json.MovieSerializer;
import model.Movie;
import model.MovieList;

public final class JSONServiceHandler {

	public static final String API_KEY = "9f49026fbebdfa535ae5c94f28c740ac";
	private static JSONServiceHandler instance = null;

	private JSONServiceHandler() {
		System.setProperty("java.net.useSystemProxies", "true");
	}

	public synchronized static JSONServiceHandler getInstance() {
		if (instance == null) {
			instance = new JSONServiceHandler();
		}
		return instance;
	}
	
	public Movie createMovie(String id){
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Movie.class, new MovieSerializer());
		
		Gson gson = gsonBuilder.create();
		String json= showMovieJSON(id).replace("json(", "");
		json = json.substring(0, json.length()-1);
		Movie movie = gson.fromJson(json, Movie.class);
		
		return movie;
	}
	
	public String showMovieJSON(String filmId){
		WebResource wr = Client.create().resource("https://api.themoviedb.org/3/movie/" + filmId);
		
		Builder b = wr.queryParam("api_key", API_KEY)
				.queryParam("callback", "json")
				.accept(MediaType.APPLICATION_JSON);
		
		return b.get(String.class);
	}

	
	public MovieList createMovieList(String genre, int i) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(MovieList.class, new MovieListSerializer());
		
		Gson gson = gsonBuilder.create();
		String json= findByGenreJSON(genre, i).replace("json(", "");
		json = json.substring(0, json.length()-1);
		MovieList movieList = gson.fromJson(json, MovieList.class);
		
		return movieList;
	}
	
	public String findByGenreJSON(String genre, int i){
		WebResource wr = Client.create().resource("https://api.themoviedb.org/3/genre/" + genre + "/movies?api_key=" + API_KEY + "&page=" + i);
		
		Builder b = wr.queryParam("callback", "json")
				.accept(MediaType.APPLICATION_JSON);
			
		return b.get(String.class);
	}
	
	public MovieList createSearchList(String key, int i){
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(MovieList.class, new MovieListSerializer());		

		Gson gson = gsonBuilder.create();
		String json= findByKeyJSON(key, i).replace("json(", "");
		json = json.substring(0, json.length()-1);
		MovieList movieList = gson.fromJson(json, MovieList.class);

		return movieList;
	}
	
	public String findByKeyJSON(String key, int i){
		WebResource wr = Client.create().resource("http://api.themoviedb.org/3/search/keyword?api_key=" + API_KEY + "&page=" + i);
	
		Builder b = wr.queryParam("callback", "json")
				.queryParam("keyword", "fight")
				.accept(MediaType.APPLICATION_JSON);
			
		return b.get(String.class);
	}
	
	public static void main(String[] args) {
		//JSONServiceHandler service = new JSONServiceHandler();
	}

}
