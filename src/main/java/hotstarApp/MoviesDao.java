package hotstarApp;

import java.util.List;

public interface MoviesDao {
	public List<Movies> allMoviesList() throws Exception;
	public List<Movies> allMoviesByPreLang(String email)throws Exception;
    public List<Movies> allMoviesByHighRatings()throws Exception;
    public List<Movies> movieByName(String movieName)throws Exception;
    public void addMovies(Movies m)throws Exception; 
    public Movies watchingMovie(String movieName)throws Exception;
    public void updateLastWatchingMovie(int userId,int watchingId)throws Exception;
    public List<Movies> allMoviesListByType(String type) throws Exception;
    public List<Movies> todayUploads() throws Exception;
    public List<String> movieLanguageList()throws Exception;
    public List<Movies> moviesListByLanguage(String lang)throws Exception;
}
