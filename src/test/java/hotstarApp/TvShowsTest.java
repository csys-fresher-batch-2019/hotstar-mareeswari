package hotstarApp;

import java.util.ArrayList;
import java.util.List;

import hotstarApp.TvShows;
import hotstarApp.TvShowsDaoImpl;


public class TvShowsTest {
	public static final LoggerUtil logger=LoggerUtil.getInstance();

	public static void main(String[] args) throws Exception {
		TvShowsDao tl=DAOFactory.getTvShowsDao();
		List<TvShows> l=new ArrayList<TvShows>();
		l=tl.allTvShowsList();
		for(TvShows m:l)
		{
			logger.debug(m.toString());
		}
		
		
	}
}
