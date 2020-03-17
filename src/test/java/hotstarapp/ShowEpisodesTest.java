package hotstarapp;

import java.util.ArrayList;
import java.util.List;

import hotstarapp.dto.NameEpisode;
import hotstarapp.model.ShowEpisode;
import hotstarapp.service.ShowEpisodeService;
import hotstarapp.util.LoggerUtil;

public class ShowEpisodesTest {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public static void main(String[] args) throws Exception {
		ShowEpisodeService tl = new ShowEpisodeService();
		List<NameEpisode> l = new ArrayList<NameEpisode>();
		l = tl.allShowNameAndEpisodes();
		for (NameEpisode m : l) {
			logger.debug(m.toString());
		}

		List<ShowEpisode> l1 = new ArrayList<ShowEpisode>();
		l1 = tl.showEpisodess(131);
		for (ShowEpisode m : l1) {
			logger.debug(m.toString());
		}

	}
}
