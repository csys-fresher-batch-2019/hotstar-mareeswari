package hotstarApp;

import java.util.HashMap;
import java.util.List;

public interface ShowEpisodesDao {
    public List<NameEpisode> allShowNameAndEpisodes() throws Exception;
    public  int episodesCountByShowName(String showName) throws Exception;
    public HashMap<String, Integer> allShowNameAndEpisodesCount()throws Exception;
    public List<ShowEpisodes> showEpisodess(int showId)throws Exception;

}
