package hotstarApp;

import java.util.Scanner;

import hotstarApp.Movies;
import hotstarApp.MoviesDaoImpl;



public class WatchingMovieTest {
public static void main(String[] args) throws Exception {
	MoviesDaoImpl li=new MoviesDaoImpl();
	Scanner sc=new Scanner(System.in);
	Movies m=new Movies();
	m=li.watchingMovie(sc.nextLine());
	System.out.println(m.toString());
}
}
