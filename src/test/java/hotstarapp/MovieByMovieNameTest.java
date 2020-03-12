package hotstarApp;

import java.util.ArrayList;
import java.util.List;

import hotstarApp.model.Movies;
import hotstarApp.service.MoviesService;
import hotstarApp.util.LoggerUtil;

public class MovieByMovieNameTest {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public static void main(String[] args) throws Exception {

		MoviesService ml = new MoviesService();

		logger.debug("********************");
		List<Movies> l = new ArrayList<Movies>();
		l = ml.allMoviesListByType("drama");
		for (Movies mo : l)
			logger.debug(mo.toString());
	}
}
