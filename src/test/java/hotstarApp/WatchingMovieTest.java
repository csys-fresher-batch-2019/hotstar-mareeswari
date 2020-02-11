package hotstarApp;

import java.util.Scanner;

import hotstarApp.Movies;
import hotstarApp.MoviesDaoImpl;



public class WatchingMovieTest {
	public static final LoggerUtil logger=LoggerUtil.getInstance();

public static void main(String[] args) throws Exception {
	MoviesDao li=DAOFactory.getMoviesDao();
	Scanner sc=new Scanner(System.in);
	Movies m=new Movies();
	m=li.watchingMovie(sc.nextLine());
	logger.debug(m);
}
}
