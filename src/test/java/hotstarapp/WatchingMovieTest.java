package hotstarapp;

import java.util.Scanner;

import hotstarapp.model.Movie;
import hotstarapp.service.MovieService;
import hotstarapp.util.LoggerUtil;

public class WatchingMovieTest {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public static void main(String[] args) throws Exception {
		MovieService li = new MovieService();
		Scanner sc = new Scanner(System.in);
		Movie m = new Movie();
		m = li.watchingMovie("majili");
		logger.debug(m);

		/*
		 * List<Movies> l=new ArrayList<Movies>(); l=li.movieByName("ha"+"%");
		 * for(Movies m:l) { logger.debug(m); }
		 */
		sc.close();

	}
}
