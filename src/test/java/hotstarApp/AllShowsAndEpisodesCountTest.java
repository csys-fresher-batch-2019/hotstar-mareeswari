package hotstarApp;

import java.util.HashMap;

import hotstarApp.ShowEpisodesDaoImpl;


public class AllShowsAndEpisodesCountTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ShowEpisodesDaoImpl tl=new ShowEpisodesDaoImpl();
		System.out.println("\n***************************\n");

		HashMap<String, Integer> h=new HashMap<String, Integer>();
		h=tl.allShowNameAndEpisodesCount();
		for(String s:h.keySet())
		{
			Integer val = h.get(s);
			System.out.println(s+","+val);
		}
	}

}
