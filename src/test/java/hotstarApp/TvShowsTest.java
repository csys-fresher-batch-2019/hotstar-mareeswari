package hotstarApp;

import java.util.ArrayList;
import java.util.List;

import hotstarApp.TvShows;
import hotstarApp.TvShowsDaoImpl;


public class TvShowsTest {
	public static void main(String[] args) throws Exception {
		TvShowsDaoImpl tl=new TvShowsDaoImpl();
		List<TvShows> l=new ArrayList<TvShows>();
		l=tl.allTvShowsList();
		for(TvShows m:l)
		{
			System.out.println(m.toString());
		}
	}
}
