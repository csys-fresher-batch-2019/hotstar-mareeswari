package hotstarApp.dao;

import java.util.List;

import hotstarApp.model.TvShows;
import hotstarApp.validation.DbException;

public interface TvShowsDao {
	public List<TvShows> allTvShowsList() throws DbException;

}
