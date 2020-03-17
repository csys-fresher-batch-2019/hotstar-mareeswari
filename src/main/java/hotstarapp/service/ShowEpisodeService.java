package hotstarapp.service;

import java.util.HashMap;
import java.util.List;

import hotstarapp.dao.ShowEpisodeDAO;
import hotstarapp.daofactory.DAOFactory;
import hotstarapp.dto.NameEpisode;
import hotstarapp.exception.DbException;
import hotstarapp.model.ShowEpisode;

public class ShowEpisodeService {
	
	ShowEpisodeDAO showEpisodesDao=DAOFactory.getShowEpisodesDao();
	public List<NameEpisode> allShowNameAndEpisodes() throws DbException
	{
		return(showEpisodesDao.allShowNameAndEpisodes());
	}

	public int episodesCountByShowName(String showName) throws DbException
	{
		return(showEpisodesDao.episodesCountByShowName(showName));
	}

	public HashMap<String, Integer> allShowNameAndEpisodesCount() throws DbException
	{
		return(showEpisodesDao.allShowNameAndEpisodesCount());
	}

	public List<ShowEpisode> showEpisodess(int showId) throws DbException
	{
		return(showEpisodesDao.showEpisodess(showId));
	}

}
