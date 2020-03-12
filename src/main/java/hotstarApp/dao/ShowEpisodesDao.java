package hotstarApp.dao;

import java.util.HashMap;
import java.util.List;

import hotstarApp.dto.NameEpisode;
import hotstarApp.model.ShowEpisodes;
import hotstarApp.validation.DbException;

public interface ShowEpisodesDao {
	public List<NameEpisode> allShowNameAndEpisodes() throws DbException;

	public int episodesCountByShowName(String showName) throws DbException;

	public HashMap<String, Integer> allShowNameAndEpisodesCount() throws DbException;

	public List<ShowEpisodes> showEpisodess(int showId) throws DbException;

}
