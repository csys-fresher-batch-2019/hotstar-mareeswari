package hotstarApp;

import java.util.Scanner;

import hotstarApp.LastWatchingDaoImpl;
import hotstarApp.Movies;


public class LastWatchedMovieTest {
public static void main(String[] args) throws Exception {
	LastWatchingDaoImpl li=new LastWatchingDaoImpl();
	Movies mo=new Movies();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the user email :\n");
	mo=li.lastWatchedMovie(sc.nextLine());
	System.out.println(mo.toString());
	sc.close();
	
	
	
	
}
}
