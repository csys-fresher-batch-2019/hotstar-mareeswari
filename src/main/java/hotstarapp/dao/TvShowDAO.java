package hotstarapp.dao;

import java.util.List;

import hotstarapp.exception.DbException;
import hotstarapp.model.TvShow;

public interface TvShowDAO {
	public List<TvShow> allTvShowsList() throws DbException;

}
