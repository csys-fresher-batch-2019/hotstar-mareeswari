package hotstarapp;

import java.util.ArrayList;
import java.util.List;

import hotstarapp.model.TvShow;
import hotstarapp.service.TvShowService;
import hotstarapp.util.LoggerUtil;

public class TvShowsTest {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public static void main(String[] args) throws Exception {
		TvShowService tl = new TvShowService();
		List<TvShow> l = new ArrayList<TvShow>();
		l = tl.allTvShowsList();
		for (TvShow m : l) {
			logger.debug(m.toString());
		}

	}
}
