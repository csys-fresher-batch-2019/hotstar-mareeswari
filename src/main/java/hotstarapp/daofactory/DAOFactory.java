package hotstarApp.daofactory;

import hotstarApp.dao.LastWatchingDao;
import hotstarApp.dao.MoviesDao;
import hotstarApp.dao.RatingsDao;
import hotstarApp.dao.ShowEpisodesDao;
import hotstarApp.dao.TvShowsDao;
import hotstarApp.dao.UsersDao;
import hotstarApp.dao.ValidationDao;
import hotstarApp.impl.LastWatchingImpl;
import hotstarApp.impl.MoviesImpl;
import hotstarApp.impl.RatingsImpl;
import hotstarApp.impl.ShowEpisodesImpl;
import hotstarApp.impl.TvShowsImpl;
import hotstarApp.impl.UsersImpl;
import hotstarApp.impl.ValidationImpl;

public class DAOFactory {
	public static MoviesDao getMoviesDao() {
		return (new MoviesImpl());
	}

	public static LastWatchingDao getLastWatchingDao() {
		return (new LastWatchingImpl());
	}

	public static RatingsDao getRatingsDao() {
		return (new RatingsImpl());
	}

	public static ShowEpisodesDao getShowEpisodesDao() {
		return (new ShowEpisodesImpl());
	}

	public static TvShowsDao getTvShowsDao() {
		return (new TvShowsImpl());
	}

	public static UsersDao getUsersDao() {
		return (new UsersImpl());
	}

	public static ValidationDao getValidationDao() {
		return (new ValidationImpl());
	}

}
