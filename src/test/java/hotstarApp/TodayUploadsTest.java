package hotstarApp;

import java.util.ArrayList;
import java.util.List;

import hotstarApp.model.Movies;
import hotstarApp.service.MoviesService;

public class TodayUploadsTest {
	public static void main(String[] args) throws Exception {
		MoviesService mi = new MoviesService();
		List<Movies> l = new ArrayList<Movies>();
		l = mi.todayUploads();
		for (Movies movies : l) {
			System.out.println(movies);
		}

	}
}
