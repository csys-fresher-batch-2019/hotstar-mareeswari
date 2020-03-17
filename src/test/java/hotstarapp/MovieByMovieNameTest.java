package hotstarapp;

import java.util.ArrayList;
import java.util.List;

import hotstarapp.model.Movie;
import hotstarapp.service.MovieService;
import hotstarapp.util.LoggerUtil;

public class MovieByMovieNameTest {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public static void main(String[] args) throws Exception {

		MovieService ml = new MovieService();

		logger.debug("********************");
		List<Movie> l = new ArrayList<Movie>();
		l = ml.allMoviesListByType("drama");
		for (Movie mo : l)
			logger.debug(mo.toString());
	}
}
