package hotstarapp.dao;

import java.util.HashMap;
import java.util.List;

import hotstarapp.dto.NameEpisode;
import hotstarapp.exception.DbException;
import hotstarapp.model.ShowEpisode;

public interface ShowEpisodeDAO {
	public List<NameEpisode> allShowNameAndEpisodes() throws DbException;

	public int episodesCountByShowName(String showName) throws DbException;

	public HashMap<String, Integer> allShowNameAndEpisodesCount() throws DbException;

	public List<ShowEpisode> showEpisodess(int showId) throws DbException;

}
