package hotstarapp;

import java.util.HashMap;

import hotstarapp.service.ShowEpisodeService;
import hotstarapp.util.LoggerUtil;

public class AllShowsAndEpisodesCountTest {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ShowEpisodeService tl = new ShowEpisodeService();
		logger.debug("\n***************************\n");

		HashMap<String, Integer> h = new HashMap<String, Integer>();
		h = tl.allShowNameAndEpisodesCount();
		for (String s : h.keySet()) {
			Integer val = h.get(s);
			logger.debug(s + "," + val);
		}
	}

}
