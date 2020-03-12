package hotstarApp.service;

import java.util.HashMap;
import java.util.List;

import hotstarApp.dao.ShowEpisodesDao;
import hotstarApp.daofactory.DAOFactory;
import hotstarApp.dto.NameEpisode;
import hotstarApp.model.ShowEpisodes;
import hotstarApp.validation.DbException;

public class ShowEpisodesService {
	
	ShowEpisodesDao showEpisodesDao=DAOFactory.getShowEpisodesDao();
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

	public List<ShowEpisodes> showEpisodess(int showId) throws DbException
	{
		return(showEpisodesDao.showEpisodess(showId));
	}

}
