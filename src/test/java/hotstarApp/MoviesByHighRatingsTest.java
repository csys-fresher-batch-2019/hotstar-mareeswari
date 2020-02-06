package hotstarApp;

import java.util.ArrayList;
import java.util.List;

import hotstarApp.Movies;
import hotstarApp.MoviesDaoImpl;


public class MoviesByHighRatingsTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		MoviesDaoImpl ml=new MoviesDaoImpl();
		System.out.println("********************");
		List<Movies> l2=new ArrayList<Movies>();
		l2=ml.allMoviesByHighRatings();
		for(Movies m:l2)
		{
			System.out.println(m.toString());
		}
	}

}
