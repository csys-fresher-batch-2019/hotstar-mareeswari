package hotstarApp;

import java.util.ArrayList;
import java.util.List;

import hotstarApp.NameEpisode;
import hotstarApp.ShowEpisodesDaoImpl;



public class ShowEpisodesTest {
public static void main(String[] args) throws Exception {
	ShowEpisodesDaoImpl tl=new ShowEpisodesDaoImpl();
	List<NameEpisode> l=new ArrayList<NameEpisode>();
	l=tl.allShowNameAndEpisodes();
	for(NameEpisode m:l)
	{
		System.out.println(m.toString());
	}
	
	
	
	
	
}
}
