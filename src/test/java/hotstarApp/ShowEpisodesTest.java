package hotstarApp;

import java.util.ArrayList;
import java.util.List;

import hotstarApp.NameEpisode;
import hotstarApp.ShowEpisodesDaoImpl;



public class ShowEpisodesTest {
	public static final LoggerUtil logger=LoggerUtil.getInstance();

public static void main(String[] args) throws Exception {
	ShowEpisodesDao tl=DAOFactory.getShowEpisodesDao();
	List<NameEpisode> l=new ArrayList<NameEpisode>();
	l=tl.allShowNameAndEpisodes();
	for(NameEpisode m:l)
	{
		logger.debug(m.toString());
	}
	
	
	
	
	
}
}
