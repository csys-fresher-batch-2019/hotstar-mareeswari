package hotstarapp.service;

import java.util.List;

import org.jdbi.v3.core.Jdbi;

import hotstarapp.dao.MovieDAO;
import hotstarapp.model.Movie;
import hotstarapp.util.ConnectionUtil;

public class MovieService {

	private Jdbi jdbi = ConnectionUtil.getJdbi();
	private MovieDAO moviesDao = jdbi.onDemand(MovieDAO.class);

	public List<Movie> allMoviesList() throws Exception {
		return moviesDao.allMoviesList();
	}

	public List<Movie> allMoviesByPreLang(String email) throws Exception {
		return moviesDao.allMoviesByPreLang(email);
	}

	public List<Movie> movieByName(String name) throws Exception {
		return moviesDao.movieByName(name);
	}

	public int addMovies(Movie m) throws Exception {
		return moviesDao.addMovies(m);
	}

	public Movie watchingMovie(String movieName) throws Exception {
		return moviesDao.watchingMovie(movieName);
	}

	public int updateLastWatchingMovie(int userId, int watchingId) throws Exception {
		return moviesDao.updateLastWatchingMovie(userId, watchingId);
	}

	public List<Movie> allMoviesListByType(String movieType) throws Exception {
		return moviesDao.allMoviesListByType(movieType);
	}
	
	public List<String> movieLanguageList() throws Exception {
		return moviesDao.movieLanguageList();
	}
	
	public List<Movie> todayUploads() throws Exception {
		return moviesDao.todayUploads();
	}
	
	public List<Movie> moviesListByLanguage(String lang) throws Exception {
		return moviesDao.moviesListByLanguage(lang);
	}
	
	

}
