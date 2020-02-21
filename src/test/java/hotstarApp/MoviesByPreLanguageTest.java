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
		Users u=ui.getUserDetails("maha@gmail.com");
		l1=ml.allMoviesByPreLang(u.email);
		for(Movies m:l1)
		{
			logger.debug(m.toString());
		}
		List<String> l2=new ArrayList<String>();
		l2=ml.movieLanguageList();
		for(String language:l2)
		{
			System.out.println(language);
		}
	}

}
