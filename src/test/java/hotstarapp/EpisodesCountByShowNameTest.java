package hotstarapp;

import hotstarapp.service.ShowEpisodeService;
import hotstarapp.util.LoggerUtil;

public class EpisodesCountByShowNameTest {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ShowEpisodeService tl = new ShowEpisodeService();
		logger.debug("\n***************************\n");

		int count = tl.episodesCountByShowName("Get set go");
		logger.debug("count: " + count);
	}

}
