package hotstarApp;

import hotstarApp.service.ShowEpisodesService;
import hotstarApp.util.LoggerUtil;

public class EpisodesCountByShowNameTest {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ShowEpisodesService tl = new ShowEpisodesService();
		logger.debug("\n***************************\n");

		int count = tl.episodesCountByShowName("Get set go");
		logger.debug("count: " + count);
	}

}
