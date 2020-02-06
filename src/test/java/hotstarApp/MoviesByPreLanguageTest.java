package hotstarApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hotstarApp.Movies;
import hotstarApp.MoviesDaoImpl;


public class MoviesByPreLanguageTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		MoviesDaoImpl ml=new MoviesDaoImpl();
		System.out.println("********************");
		Scanner sc=new Scanner(System.in);
		List<Movies> l1=new ArrayList<Movies>();
		System.out.println("Enter user id : ");
		l1=ml.allMoviesByPreLang(Integer.parseInt(sc.nextLine()));
		for(Movies m:l1)
		{
			System.out.println(m.toString());
		}
		
	}

}
