package hotstarApp;

import java.util.ArrayList;
import java.util.List;

import hotstarApp.Movies;
import hotstarApp.MoviesDaoImpl;


public class MoviesByHighRatingsTest {
	public static final LoggerUtil logger=LoggerUtil.getInstance();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		MoviesDao ml=DAOFactory.getMoviesDao();
		logger.debug("********************");
		List<Movies> l2=new ArrayList<Movies>();
		l2=ml.allMoviesByHighRatings();
		for(Movies m:l2)
		{
			logger.debug(m.toString());
		}
	}

}
