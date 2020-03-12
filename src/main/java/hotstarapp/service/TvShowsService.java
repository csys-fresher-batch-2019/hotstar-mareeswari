package hotstarApp.service;

import java.util.List;

import hotstarApp.dao.TvShowsDao;
import hotstarApp.daofactory.DAOFactory;
import hotstarApp.model.TvShows;
import hotstarApp.validation.DbException;

public class TvShowsService {
	private TvShowsDao tvShowsDao = DAOFactory.getTvShowsDao();

	public List<TvShows> allTvShowsList() throws DbException {
		return tvShowsDao.allTvShowsList();
	}
	
	
	
	
	
	
}
