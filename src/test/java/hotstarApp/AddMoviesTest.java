package hotstarApp;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import hotstarApp.Movies;
import hotstarApp.MoviesDaoImpl;


public class AddMoviesTest {
public static void main(String[] args) throws Exception {
	MoviesDaoImpl mi=new MoviesDaoImpl();
	List<String> l=new ArrayList<String>();
	l=Files.readAllLines(Paths.get("project.txt"));
	
	for(String s:l)
	{
		
		String[] row=s.split(",");
		Movies m=new Movies();
		m.setMovieName(row[0]);
		m.setMovieType(row[1]);
		m.setMovieLanguage(row[2]);
		m.setMovieDirector(row[3]);
		m.setMovieReleasedDate(Date.valueOf(row[4]));
		m.setVideoUrl(row[5]);
		mi.addMovies(m);
		
	}

}
}
