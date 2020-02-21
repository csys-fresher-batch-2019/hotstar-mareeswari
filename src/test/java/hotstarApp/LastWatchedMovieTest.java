package hotstarApp;

import java.util.Scanner;

import hotstarApp.LastWatchingDaoImpl;
import hotstarApp.Movies;


public class LastWatchedMovieTest {
	public static final LoggerUtil logger=LoggerUtil.getInstance();

public static void main(String[] args) throws Exception {
	LastWatchingDao li=DAOFactory.getLastWatchingDao();
	UsersDao ui=DAOFactory.getUsersDao();
	Movies mo=new Movies();
	Scanner sc=new Scanner(System.in);
	
	Users u=ui.getUserDetails("maha@gmail.com");
	
	mo=li.lastWatchedMovie(u.email);
     logger.debug(mo.toString());
	sc.close();
	
	
	
	
}
}
