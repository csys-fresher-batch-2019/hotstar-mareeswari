package hotstarApp;

import java.util.ArrayList;
import java.util.List;

import hotstarApp.Movies;
import hotstarApp.MoviesDaoImpl;


public class MovieByMovieNameTest {
public static void main(String[] args) throws Exception {


	MoviesDaoImpl ml=new MoviesDaoImpl();

	System.out.println("********************");
	List<Movies> l=new ArrayList<Movies>();
	l=ml.movieByName("pat");
	for(Movies mo:l)
		System.out.println(mo.toString());
}
}
