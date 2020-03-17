package hotstarapp.service;

import java.util.List;

import hotstarapp.dao.TvShowDAO;
import hotstarapp.daofactory.DAOFactory;
import hotstarapp.exception.DbException;
import hotstarapp.model.TvShow;

public class TvShowService {
	private TvShowDAO tvShowsDao = DAOFactory.getTvShowsDao();

	public List<TvShow> allTvShowsList() throws DbException {
		return tvShowsDao.allTvShowsList();
	}
	
	
	
	
	
	
}
