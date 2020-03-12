package hotstarApp;

import java.util.Scanner;

import hotstarApp.model.Movies;
import hotstarApp.model.Users;
import hotstarApp.service.LastWatchingService;
import hotstarApp.service.UsersService;
import hotstarApp.util.LoggerUtil;

public class LastWatchedMovieTest {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public static void main(String[] args) throws Exception {
		LastWatchingService li = new LastWatchingService();
		UsersService ui = new UsersService();
		Movies mo = new Movies();
		Scanner sc = new Scanner(System.in);

		Users u = ui.getUserDetails("marees@gmail.com");

		mo = li.lastWatchedMovie(u.getEmail());
		logger.debug(mo.toString());
		sc.close();

		/*
		 * MoviesService mi=new MoviesService(); int row=mi.updateLastWatchingMovie(73,
		 * 43); logger.debug(row);
		 */

	}
}
