package hotstarApp;

import java.util.ArrayList;
import java.util.List;

import hotstarApp.Movies;
import hotstarApp.MoviesDaoImpl;


public class AllMoviesListTest {
	public static void main(String args[]) throws Exception
	{
		MoviesDaoImpl ml=new MoviesDaoImpl();
		List<Movies> l=new ArrayList<Movies>();
		l=ml.allMoviesList();
		for(Movies m:l)
		{
			System.out.println(m.toString());
		}
		
		
		
		
		
		
		
		
		
		
	}

}
