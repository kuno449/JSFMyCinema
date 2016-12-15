package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import annotation.JsonProperty;

public class Movie implements Serializable {

    private static final long serialVersionUID = 100L;

    @JsonProperty("_id")
    private String mediaId;
    @JsonProperty("original_title")
    private String originalTitle;
    @JsonProperty("release_date")
    private String releaseDate;
    @JsonProperty("title")
    private String title;
    @JsonProperty("video")
    private Boolean video = null;
    @JsonProperty("rating")
    private float userRating = -1f;
    @JsonProperty("genre_ids")
    private List<String> genres;
    @JsonProperty("original_language")
    private String originalLanguage;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("revenue")
    private long revenue = 0L;
    
    private String posterPath;
    
	ArrayList<Movie> movieList = new ArrayList<>();
	
	
	public Movie() {
		super();
	}

	public Movie(String mediaId, String title) {
		super();
		this.mediaId = mediaId;
		this.title = title;
	}
    
    public Movie(String mediaId, String title, String posterPath) {
		super();
		this.mediaId = mediaId;
		this.title = title;
		this.posterPath = posterPath;
	}

	public ArrayList<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(ArrayList<Movie> movieList) {
		this.movieList = movieList;
	}
	
	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}
 
	public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public float getUserRating() {
        return userRating;
    }

    public void setUserRating(float userRating) {
        this.userRating = userRating;
    }


    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public long getRevenue() {
        return revenue;
    }

    public void setRevenue(long revenue) {
        this.revenue = revenue;
    }

	public void setMovieList(MovieList createMovieList) {
		// TODO Auto-generated method stub
		
	}

	public String getPosterPath() {
		return posterPath;
	}

	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}
	
}