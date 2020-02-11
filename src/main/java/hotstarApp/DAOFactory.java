package hotstarApp;

public class DAOFactory {
public static MoviesDao getMoviesDao()
{
	return(new MoviesDaoImpl());
}
public static LastWatchingDao getLastWatchingDao()
{
	return(new LastWatchingDaoImpl());
}
public static RatingsDao getRatingsDao()
{
	return(new RatingsDaoImpl());
}
public static ShowEpisodesDao getShowEpisodesDao()
{
	return(new ShowEpisodesDaoImpl());
}
public static TvShowsDao getTvShowsDao()
{
	return(new TvShowsDaoImpl());
}
public static UsersDao getUsersDao()
{
	return(new UsersDaoImpl());
}

}
