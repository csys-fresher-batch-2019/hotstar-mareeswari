package hotstarApp;

import java.util.ArrayList;
import java.util.List;

import hotstarApp.Movies;
import hotstarApp.MoviesDaoImpl;


public class MovieByMovieNameTest {
	public static final LoggerUtil logger=LoggerUtil.getInstance();

public static void main(String[] args) throws Exception {


	MoviesDao ml=DAOFactory.getMoviesDao();

	logger.debug("********************");
	List<Movies> l=new ArrayList<Movies>();
	l=ml.movieByName("m");
	for(Movies mo:l)
		logger.debug(mo.toString());
}
}
