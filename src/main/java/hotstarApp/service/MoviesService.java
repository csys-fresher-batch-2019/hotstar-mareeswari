package hotstarApp.service;

import java.util.List;

import org.jdbi.v3.core.Jdbi;

import hotstarApp.dao.MoviesDao;
import hotstarApp.model.Movies;
import hotstarApp.util.ConnectionUtil;

public class MoviesService {

	private Jdbi jdbi = ConnectionUtil.getJdbi();
	private MoviesDao moviesDao = jdbi.onDemand(MoviesDao.class);

	public List<Movies> allMoviesList() throws Exception {
		return moviesDao.allMoviesList();
	}

	public List<Movies> allMoviesByPreLang(String email) throws Exception {
		return moviesDao.allMoviesByPreLang(email);
	}

	public List<Movies> movieByName(String name) throws Exception {
		return moviesDao.movieByName(name);
	}

	public int addMovies(Movies m) throws Exception {
		return moviesDao.addMovies(m);
	}

	public Movies watchingMovie(String movieName) throws Exception {
		return moviesDao.watchingMovie(movieName);
	}

	public int updateLastWatchingMovie(int userId, int watchingId) throws Exception {
		return moviesDao.updateLastWatchingMovie(userId, watchingId);
	}

	public List<Movies> allMoviesListByType(String movieType) throws Exception {
		return moviesDao.allMoviesListByType(movieType);
	}
	
	public List<String> movieLanguageList() throws Exception {
		return moviesDao.movieLanguageList();
	}
	
	public List<Movies> todayUploads() throws Exception {
		return moviesDao.todayUploads();
	}
	
	public List<Movies> moviesListByLanguage(String lang) throws Exception {
		return moviesDao.moviesListByLanguage(lang);
	}
	
	

}
