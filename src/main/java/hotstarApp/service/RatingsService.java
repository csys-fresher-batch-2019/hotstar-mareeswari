package hotstarApp.service;

import hotstarApp.dao.RatingsDao;
import hotstarApp.daofactory.DAOFactory;
import hotstarApp.validation.DbException;

public class RatingsService {
	RatingsDao ratingsDao=DAOFactory.getRatingsDao();
	public int putRatings(int userId, int movieId, int rating) throws DbException
	{
		return(ratingsDao.putRatings(userId, movieId, rating));
	}
}
