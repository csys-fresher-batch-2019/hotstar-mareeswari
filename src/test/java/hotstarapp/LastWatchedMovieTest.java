package hotstarapp;

import java.util.Scanner;

import hotstarapp.model.Movie;
import hotstarapp.model.User;
import hotstarapp.service.LastWatchingService;
import hotstarapp.service.UserService;
import hotstarapp.util.LoggerUtil;

public class LastWatchedMovieTest {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public static void main(String[] args) throws Exception {
		LastWatchingService li = new LastWatchingService();
		UserService ui = new UserService();
		Movie mo = new Movie();
		Scanner sc = new Scanner(System.in);

		User u = ui.getUserDetails("marees@gmail.com");

		mo = li.lastWatchedMovie(u.getEmail());
		logger.debug(mo.toString());
		sc.close();

		/*
		 * MoviesService mi=new MoviesService(); int row=mi.updateLastWatchingMovie(73,
		 * 43); logger.debug(row);
		 */

	}
}
