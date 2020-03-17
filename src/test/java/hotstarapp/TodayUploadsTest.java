package hotstarapp;

import java.util.ArrayList;
import java.util.List;

import hotstarapp.model.Movie;
import hotstarapp.service.MovieService;
import hotstarapp.util.LoggerUtil;

public class TodayUploadsTest {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public static void main(String[] args) throws Exception {
		MovieService mi = new MovieService();
		List<Movie> l = new ArrayList<Movie>();
		l = mi.todayUploads();
		for (Movie movie : l) {
			logger.debug(movie);}

	}
}
