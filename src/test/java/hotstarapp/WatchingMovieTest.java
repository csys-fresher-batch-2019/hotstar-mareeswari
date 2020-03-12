package hotstarApp;

import java.util.Scanner;

import hotstarApp.model.Movies;
import hotstarApp.service.MoviesService;
import hotstarApp.util.LoggerUtil;

public class WatchingMovieTest {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public static void main(String[] args) throws Exception {
		MoviesService li = new MoviesService();
		Scanner sc = new Scanner(System.in);
		Movies m = new Movies();
		m = li.watchingMovie("majili");
		logger.debug(m);

		/*
		 * List<Movies> l=new ArrayList<Movies>(); l=li.movieByName("ha"+"%");
		 * for(Movies m:l) { logger.debug(m); }
		 */
		sc.close();

	}
}
