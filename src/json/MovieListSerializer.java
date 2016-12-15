package json;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import model.Movie;
import model.MovieList;

public class MovieListSerializer implements JsonDeserializer<MovieList>{

	@Override
	public MovieList deserialize(JsonElement jsonElement, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
		MovieList movieList = new MovieList();
		//System.out.println("jsonElement: "+jsonElement);
		
		JsonElement resultsElement = jsonElement.getAsJsonObject().get("results");
		JsonArray titleArray = resultsElement.getAsJsonArray();
		
		for (JsonElement element : titleArray) {

			JsonElement movieId = element.getAsJsonObject().get("id");
			JsonElement movieTitle = element.getAsJsonObject().get("title");
			
			if(movieTitle!=null){
				movieList.addMovie(new Movie(movieId.getAsString(),movieTitle.getAsString()));
			}
		}
		return movieList;
	}
}