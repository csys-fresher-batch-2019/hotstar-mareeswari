package hotstarApp;

import java.util.HashMap;

import hotstarApp.ShowEpisodesDaoImpl;


public class AllShowsAndEpisodesCountTest {
	public static final LoggerUtil logger=LoggerUtil.getInstance();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ShowEpisodesDao tl=DAOFactory.getShowEpisodesDao();
		logger.debug("\n***************************\n");

		HashMap<String, Integer> h=new HashMap<String, Integer>();
		h=tl.allShowNameAndEpisodesCount();
		for(String s:h.keySet())
		{
			Integer val = h.get(s);
			logger.debug(s+","+val);
		}
	}

}
