package beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.component.datagrid.DataGrid;
import org.primefaces.event.SelectEvent;

import model.Movie;
import model.MovieList;
import service.JSONServiceHandler;

@ManagedBean
@SessionScoped
public class ServiceBean{
	
	private JSONServiceHandler sh;
	private String currentGenre;
	private Movie selectedMovie;
	
	private String keyword;
	private DataGrid datagrid1;
	private DataGrid datagrid2;
	private DataGrid datagrid3;
	
	private boolean addFavButton = true;
	private boolean addToWButton = true;
	private boolean addKEOButton = true;
	
	private boolean delFavButton = false;
	private boolean delToWButton = false;
	private boolean delKEOButton = false;
	
	private List<Movie> movieList = new ArrayList<>();
	
	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	public String getCurrentGenre() {
		return currentGenre;
	}

	public void setCurrentGenre(String currentGenre) {
		this.currentGenre = currentGenre;
	}
		
	public Movie getSelectedMovie() {
		return selectedMovie;
	}

	public void setSelectedMovie(Movie selectedMovie) {
		this.selectedMovie = selectedMovie;
	}
	
	public DataGrid getDatagrid1() {
		return datagrid1;
	}

	public void setDatagrid1(DataGrid datagrid1) {
		this.datagrid1 = datagrid1;
	}

	public DataGrid getDatagrid2() {
		return datagrid2;
	}

	public void setDatagrid2(DataGrid datagrid2) {
		this.datagrid2 = datagrid2;
	}

	public DataGrid getDatagrid3() {
		return datagrid3;
	}

	public void setDatagrid3(DataGrid datagrid3) {
		this.datagrid3 = datagrid3;
	}
		
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public boolean isAddFavButton() {
		return addFavButton;
	}

	public void setAddFavButton(boolean addFavButton) {
		this.addFavButton = addFavButton;
	}

	public boolean isAddToWButton() {
		return addToWButton;
	}

	public void setAddToWButton(boolean addToWButton) {
		this.addToWButton = addToWButton;
	}

	public boolean isAddKEOButton() {
		return addKEOButton;
	}

	public void setAddKEOButton(boolean addKEOButton) {
		this.addKEOButton = addKEOButton;
	}

		public boolean isDelFavButton() {
		return delFavButton;
	}

	public void setDelFavButton(boolean delFavButton) {
		this.delFavButton = delFavButton;
	}

	public boolean isDelToWButton() {
		return delToWButton;
	}

	public void setDelToWButton(boolean delToWButton) {
		this.delToWButton = delToWButton;
	}

	public boolean isDelKEOButton() {
		return delKEOButton;
	}

	public void setDelKEOButton(boolean delKEOButton) {
		this.delKEOButton = delKEOButton;
	}
	
	
	///// Methoden //////

	public void showFavouriteDetail(){
		Movie movie = (Movie) datagrid1.getRowData();
		selectedMovie = sh.createMovie(movie.getMediaId());
		delFavButton=true;
		delToWButton=false;
		delKEOButton=false;
		addFavButton=false;
		addToWButton=false;
		addKEOButton=false;
	}
	
	public void showToWatchDetail(){
		Movie movie = (Movie) datagrid2.getRowData();
		selectedMovie = sh.createMovie(movie.getMediaId());
		delFavButton=false;
		delToWButton=true;
		delKEOButton=false;
		addFavButton=false;
		addToWButton=false;
		addKEOButton=false;
	}
	
	public void showKeepEyeOnDetail(){
		Movie movie = (Movie) datagrid3.getRowData();
		selectedMovie = sh.createMovie(movie.getMediaId());
		delFavButton=false;
		delToWButton=false;
		delKEOButton=true;
		addFavButton=false;
		addToWButton=false;
		addKEOButton=false;
	}
	
	public void keywordSearch(){
		System.out.println(keyword);
	}
		
	public void onRowSelect(SelectEvent event) {
		
		delFavButton=false;
		delToWButton=false;
		delToWButton=false;
		addFavButton=true;
		addToWButton=true;
		addKEOButton=true;
		
		Movie movie = (Movie) event.getObject();
		selectedMovie = sh.createMovie(movie.getMediaId());
	}

	public void showMovieList() {
		
		movieList.clear();
		for (int i = 1; i < 20; i++) {
			MovieList list = sh.createMovieList(currentGenre, i);
			ArrayList<Movie> tempMovieList = list.getMovieList();
			movieList.addAll(tempMovieList);
		}
	}
	
	public void searchByKey() {
		System.out.println(keyword);
//		movieList.clear();
//		for (int i = 1; i < 10; i++) {
//			MovieList list = sh.createSearchList(keyword, i);
//			ArrayList<Movie> tempMovieList = list.getMovieList();
//			movieList.addAll(tempMovieList);
//		}
	}
		
//	Ausgabe für Movie Variable 	
//	System.out.println(movie.getMediaId());
//	System.out.println(movie.getTitle());
//	System.out.println(movie.getGenres());
//	System.out.println(movie.getReleaseDate());
//	System.out.println(movie.getOriginalLanguage());
//	System.out.println(movie.getOverview());
//	System.out.println(movie.getUserRating());
//	System.out.println(movie.getPosterPath());
	
	@PostConstruct
	public void init() {
		sh = JSONServiceHandler.getInstance();
	}
}
