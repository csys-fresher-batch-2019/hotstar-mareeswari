package hotstarApp.service;

import hotstarApp.dao.LastWatchingDao;
import hotstarApp.daofactory.DAOFactory;
import hotstarApp.model.Movies;
import hotstarApp.validation.DbException;

public class LastWatchingService {
	 LastWatchingDao lastWatchingDao =DAOFactory.getLastWatchingDao();
	 public Movies lastWatchedMovie(String email) throws DbException
	 {
		 return(lastWatchingDao.lastWatchedMovie(email));
	 }
}
