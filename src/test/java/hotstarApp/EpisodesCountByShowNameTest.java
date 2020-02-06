package hotstarApp;

import hotstarApp.ShowEpisodesDaoImpl;

public class EpisodesCountByShowNameTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ShowEpisodesDaoImpl tl=new ShowEpisodesDaoImpl();
		System.out.println("\n***************************\n");
		
		int count=tl.episodesCountByShowName("Get set go");
		System.out.println("count: "+count);
	}

}
