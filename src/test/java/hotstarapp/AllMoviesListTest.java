package hotstarApp;

import java.util.ArrayList;
import java.util.List;

import hotstarApp.model.Movies;
import hotstarApp.service.MoviesService;
import hotstarApp.util.LoggerUtil;

public class AllMoviesListTest {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public static void main(String args[]) throws Exception {
		MoviesService m1 = new MoviesService();
		List<Movies> l = new ArrayList<Movies>();
		// l = m1.allMoviesList();
		l = m1.moviesListByLanguage("tamil");
		for (Movies m : l) {
			logger.debug(m.toString());
		}

	}

}
