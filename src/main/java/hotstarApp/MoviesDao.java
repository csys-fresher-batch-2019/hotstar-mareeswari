package hotstarApp;

import java.util.List;

public interface MoviesDao {
	public List<Movies> allMoviesList() throws Exception;
	public List<Movies> allMoviesByPreLang(int userId)throws Exception;
    public List<Movies> allMoviesByHighRatings()throws Exception;
    public List<Movies> movieByName(String movieName)throws Exception;
    public void addMovies(Movies m)throws Exception; 
    public Movies watchingMovie(String movieName)throws Exception;
    public void updateLastWatchingMovie(int userId,int watchingId)throws Exception;
}
