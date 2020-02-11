package hotstarApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hotstarApp.Movies;
import hotstarApp.MoviesDaoImpl;


public class MoviesByPreLanguageTest {
	public static final LoggerUtil logger=LoggerUtil.getInstance();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		MoviesDao ml=DAOFactory.getMoviesDao();
		logger.debug("********************");
		UsersDao ui=DAOFactory.getUsersDao();
		List<Movies> l1=new ArrayList<Movies>();
		String user[]=ui.getUserDetails();
		l1=ml.allMoviesByPreLang(Integer.parseInt(user[1]));
		for(Movies m:l1)
		{
			logger.debug(m.toString());
		}
		
	}

}
