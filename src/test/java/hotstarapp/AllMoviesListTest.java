package hotstarapp;

import java.util.ArrayList;
import java.util.List;

import hotstarapp.model.Movie;
import hotstarapp.service.MovieService;
import hotstarapp.util.LoggerUtil;

public class AllMoviesListTest {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public static void main(String args[]) throws Exception {
		MovieService m1 = new MovieService();
		List<Movie> l = new ArrayList<Movie>();
		// l = m1.allMoviesList();
		l = m1.moviesListByLanguage("tamil");
		for (Movie m : l) {
			logger.debug(m.toString());
		}

	}

}
