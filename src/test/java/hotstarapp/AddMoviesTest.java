package hotstarapp;

import java.time.LocalDate;
import java.util.Scanner;

import hotstarapp.model.Movie;
import hotstarapp.service.MovieService;
import hotstarapp.util.LoggerUtil;

public class AddMoviesTest {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public static void main(String[] args) throws Exception {
		MovieService mi = new MovieService();
		Scanner sc = new Scanner(System.in);
		Movie m = new Movie();
		logger.debug("Enter movie name:");
		m.setMovieName(sc.nextLine());
		logger.debug("Enter movie type:");
		m.setMovieType(sc.nextLine());
		logger.debug("Enter movie Language:");
		m.setMovieLanguage(sc.nextLine());
		logger.debug("Enter movie Director:");
		m.setMovieDirector(sc.nextLine());
		logger.debug("Enter movie Released Date:");
		m.setMovieReleasedDate(LocalDate.parse(sc.nextLine()));
		logger.debug("Enter movie video url:");
		m.setVideoUrl(sc.nextLine());
		logger.debug("Enter poster url:");
		m.setPoster(sc.nextLine());

		int res = mi.addMovies(m);
		logger.debug(res);
		sc.close();

	}

}
