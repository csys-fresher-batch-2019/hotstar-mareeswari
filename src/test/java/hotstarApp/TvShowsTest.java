package hotstarApp;

import java.util.ArrayList;
import java.util.List;

import hotstarApp.model.TvShows;
import hotstarApp.service.TvShowsService;
import hotstarApp.util.LoggerUtil;

public class TvShowsTest {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public static void main(String[] args) throws Exception {
		TvShowsService tl = new TvShowsService();
		List<TvShows> l = new ArrayList<TvShows>();
		l = tl.allTvShowsList();
		for (TvShows m : l) {
			logger.debug(m.toString());
		}

	}
}
