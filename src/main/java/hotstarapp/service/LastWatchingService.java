package hotstarapp.service;

import hotstarapp.dao.LastWatchingDAO;
import hotstarapp.daofactory.DAOFactory;
import hotstarapp.exception.DbException;
import hotstarapp.model.Movie;

public class LastWatchingService {
	 LastWatchingDAO lastWatchingDao =DAOFactory.getLastWatchingDao();
	 public Movie lastWatchedMovie(String email) throws DbException
	 {
		 return(lastWatchingDao.lastWatchedMovie(email));
	 }
}
