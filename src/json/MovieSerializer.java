package json;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import model.Movie;

public class MovieSerializer implements JsonDeserializer<Movie>{
	
	ArrayList<String> genreArrayList = new ArrayList<>();

	@Override
	public Movie deserialize(JsonElement jsonElement, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
		
		Movie movie = new Movie();
		//System.out.println("jsonElement: "+jsonElement);
		
		movie.setMediaId(jsonElement.getAsJsonObject().get("id").toString());
		movie.setTitle(jsonElement.getAsJsonObject().get("title").toString().substring(1, jsonElement.getAsJsonObject().get("title").toString().length()-1));
		movie.setOriginalTitle(jsonElement.getAsJsonObject().get("original_title").toString());
		
		JsonArray genreArray = jsonElement.getAsJsonObject().get("genres").getAsJsonArray();
		for (JsonElement genreElement : genreArray) {
				genreArrayList.add(genreElement.getAsJsonObject().get("name").getAsString());
		}
		movie.setGenres(genreArrayList);
				
		movie.setReleaseDate(jsonElement.getAsJsonObject().get("release_date").toString().substring(1, jsonElement.getAsJsonObject().get("release_date").toString().length()-1));
		movie.setOriginalLanguage(jsonElement.getAsJsonObject().get("original_language").toString().substring(1, jsonElement.getAsJsonObject().get("original_language").toString().length()-1));
		movie.setOverview(jsonElement.getAsJsonObject().get("overview").toString().substring(1, jsonElement.getAsJsonObject().get("overview").toString().length()-1));
		movie.setUserRating(jsonElement.getAsJsonObject().get("vote_average").getAsFloat());
		movie.setPosterPath("http://image.tmdb.org/t/p/w500" + jsonElement.getAsJsonObject().get("poster_path").toString().substring(1, jsonElement.getAsJsonObject().get("poster_path").toString().length()-1));
		
		return movie;
	}

}
