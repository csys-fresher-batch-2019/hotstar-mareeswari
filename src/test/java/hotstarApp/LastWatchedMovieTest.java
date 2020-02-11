package hotstarApp;

import java.util.Scanner;

import hotstarApp.LastWatchingDaoImpl;
import hotstarApp.Movies;


public class LastWatchedMovieTest {
	public static final LoggerUtil logger=LoggerUtil.getInstance();

public static void main(String[] args) throws Exception {
	LastWatchingDao li=DAOFactory.getLastWatchingDao();
	UsersDaoImpl ui=new UsersDaoImpl();
	Movies mo=new Movies();
	Scanner sc=new Scanner(System.in);
	
	String user[]=ui.getUserDetails();
	
	mo=li.lastWatchedMovie(user[0]);
     logger.debug(mo.toString());
	sc.close();
	
	
	
	
}
}
