package hotstarApp;

import hotstarApp.ShowEpisodesDaoImpl;

public class EpisodesCountByShowNameTest {
	public static final LoggerUtil logger=LoggerUtil.getInstance();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ShowEpisodesDao tl=DAOFactory.getShowEpisodesDao();
		logger.debug("\n***************************\n");
		
		int count=tl.episodesCountByShowName("Get set go");
		logger.debug("count: "+count);
	}

}
