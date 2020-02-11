package hotstarApp;

import java.util.ArrayList;
import java.util.List;

import hotstarApp.Movies;
import hotstarApp.MoviesDaoImpl;


public class AllMoviesListTest {
	public static final LoggerUtil logger=LoggerUtil.getInstance();

	public static void main(String args[]) throws Exception
	{
		MoviesDao ml=DAOFactory.getMoviesDao();
		List<Movies> l=new ArrayList<Movies>();
		l=ml.allMoviesList();
		for(Movies m:l)
		{
			logger.debug(m.toString());
		}
		
		
		
		
		
		
		
		
		
		
	}

}
