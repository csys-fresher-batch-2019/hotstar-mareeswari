package hotstarapp.service;

import hotstarapp.dao.RatingDAO;
import hotstarapp.daofactory.DAOFactory;
import hotstarapp.exception.DbException;

public class RatingService {
	RatingDAO ratingsDao=DAOFactory.getRatingsDao();
	public int putRatings(int userId, int movieId, int rating) throws DbException
	{
		return(ratingsDao.putRatings(userId, movieId, rating));
	}
}
