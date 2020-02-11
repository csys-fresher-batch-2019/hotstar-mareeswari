package hotstarApp;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import hotstarApp.Movies;
import hotstarApp.MoviesDaoImpl;


public class AddMoviesTest {
	public static final LoggerUtil logger=LoggerUtil.getInstance();
public static void main(String[] args) throws Exception {
	MoviesDao mi=DAOFactory.getMoviesDao();
	Scanner sc=new Scanner(System.in);
		Movies m=new Movies();
	    logger.debug("Enter movie name:");
		m.setMovieName(sc.nextLine());
		logger.debug("Enter movie type:");
		m.setMovieType(sc.nextLine());
		logger.debug("Enter movie Language:");
		m.setMovieLanguage(sc.nextLine());
		logger.debug("Enter movie Director:");
		m.setMovieDirector(sc.nextLine());
		logger.debug("Enter movie Released Date:");
		m.setMovieReleasedDate(Date.valueOf(sc.nextLine()));
	    logger.debug("Enter movie video url:");
		m.setVideoUrl(sc.nextLine());
		mi.addMovies(m);
		
	}


}
