package hotstarapp.daofactory;

import hotstarapp.dao.LastWatchingDAO;
import hotstarapp.dao.MovieDAO;
import hotstarapp.dao.RatingDAO;
import hotstarapp.dao.ShowEpisodeDAO;
import hotstarapp.dao.TvShowDAO;
import hotstarapp.dao.UserDAO;
import hotstarapp.dao.ValidationDAO;
import hotstarapp.impl.LastWatchingDAOImpl;
import hotstarapp.impl.MovieDAOImpl;
import hotstarapp.impl.RatingDAOImpl;
import hotstarapp.impl.ShowEpisodeDAOImpl;
import hotstarapp.impl.TvShowDAOImpl;
import hotstarapp.impl.UserDAOImpl;
import hotstarapp.impl.ValidationDAOImpl;

public class DAOFactory {
	public static MovieDAO getMoviesDao() {
		return (new MovieDAOImpl());
	}

	public static LastWatchingDAO getLastWatchingDao() {
		return (new LastWatchingDAOImpl());
	}

	public static RatingDAO getRatingsDao() {
		return (new RatingDAOImpl());
	}

	public static ShowEpisodeDAO getShowEpisodesDao() {
		return (new ShowEpisodeDAOImpl());
	}

	public static TvShowDAO getTvShowsDao() {
		return (new TvShowDAOImpl());
	}

	public static UserDAO getUsersDao() {
		return (new UserDAOImpl());
	}

	public static ValidationDAO getValidationDao() {
		return (new ValidationDAOImpl());
	}

}
