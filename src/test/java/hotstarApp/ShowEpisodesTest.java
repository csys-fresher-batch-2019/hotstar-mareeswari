package hotstarApp;

import java.util.ArrayList;
import java.util.List;

import hotstarApp.dto.NameEpisode;
import hotstarApp.model.ShowEpisodes;
import hotstarApp.service.ShowEpisodesService;
import hotstarApp.util.LoggerUtil;

public class ShowEpisodesTest {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public static void main(String[] args) throws Exception {
		ShowEpisodesService tl = new ShowEpisodesService();
		List<NameEpisode> l = new ArrayList<NameEpisode>();
		l = tl.allShowNameAndEpisodes();
		for (NameEpisode m : l) {
			logger.debug(m.toString());
		}

		List<ShowEpisodes> l1 = new ArrayList<ShowEpisodes>();
		l1 = tl.showEpisodess(131);
		for (ShowEpisodes m : l1) {
			logger.debug(m.toString());
		}

	}
}
