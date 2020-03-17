package hotstarapp.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import hotstarapp.dao.ShowEpisodeDAO;
import hotstarapp.dto.NameEpisode;
import hotstarapp.exception.DbException;
import hotstarapp.exception.ExceptionMessages;
import hotstarapp.model.ShowEpisode;
import hotstarapp.util.ConnectionUtil;

public class ShowEpisodeDAOImpl implements ShowEpisodeDAO {

	public List<NameEpisode> allShowNameAndEpisodes() throws DbException {

		List<NameEpisode> l = new ArrayList<NameEpisode>();

		try (Connection con = ConnectionUtil.dbConnect();

				PreparedStatement stmt = con.prepareStatement(
						"select t.show_name,s.episode_no,s.episode_date from tv_shows t,show_episodes s where t.show_id=s.show_id ")) {

			try (ResultSet rs = stmt.executeQuery()) {

				while (rs.next()) {
					NameEpisode nm = new NameEpisode();
					nm.setShowName(rs.getString(1));
					nm.setEpisodeNo(rs.getInt(2));
					nm.setEpisodeDate(rs.getDate(3));

					l.add(nm);
				}
			} catch (SQLException e) {
				throw new DbException(ExceptionMessages.INVALID_SELECT);
			}
		} catch (SQLException e) {
			throw new DbException(ExceptionMessages.CONNECTION_ERROR);
		}
		return (l);

	}

	public int episodesCountByShowName(String showName) throws DbException {
		String str = "select count(episode_no) from tv_shows t,show_episodes s where t.show_id=s.show_id and t.show_name=lower(?)";
		int count = 0;

		try (Connection con = ConnectionUtil.dbConnect();

				PreparedStatement stmt = con.prepareStatement(str)) {
			stmt.setString(1, showName);

			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					count = rs.getInt(1);
				}

			} catch (SQLException e) {
				throw new DbException(ExceptionMessages.INVALID_SELECT);
			}
			con.close();
		} catch (SQLException e) {

			throw new DbException(ExceptionMessages.CONNECTION_ERROR);
		}

		return count;
	}

	public HashMap<String, Integer> allShowNameAndEpisodesCount() throws DbException {
		HashMap<String, Integer> l = new HashMap<String, Integer>();

		try (Connection con = ConnectionUtil.dbConnect();

				PreparedStatement stmt = con.prepareStatement(
						" select t.show_name,(select  count(episode_no)  from show_episodes where t.show_id=show_id) as epi_count from tv_shows t ")) {

			try (ResultSet rs = stmt.executeQuery()) {

				while (rs.next()) {
					String showName = rs.getString(1);
					int count = rs.getInt(2);
					l.put(showName, count);
				}
			} catch (SQLException e) {
				throw new DbException(ExceptionMessages.INVALID_SELECT);
			}
		} catch (SQLException e) {
			throw new DbException(ExceptionMessages.CONNECTION_ERROR);
		}

		return (l);

	}

	@Override
	public List<ShowEpisode> showEpisodess(int showId) throws DbException {
		List<ShowEpisode> l = new ArrayList<ShowEpisode>();

		try (Connection con = ConnectionUtil.dbConnect();

				PreparedStatement stmt = con.prepareStatement("select * from show_episodes where show_id =?  ")) {
			stmt.setInt(1, showId);

			try (ResultSet rs = stmt.executeQuery()) {

				while (rs.next()) {
					ShowEpisode se = new ShowEpisode();
					se.setShowId(rs.getInt(2));

					se.setEpisodeId(rs.getInt(1));
					se.setEpisodeNo(rs.getInt(3));
					se.setEpisodeDate(rs.getDate(4));
					se.setVideoUrl(rs.getString(5));
					l.add(se);
				}
			} catch (SQLException e) {
				throw new DbException(ExceptionMessages.INVALID_SELECT);
			}
			con.close();
		} catch (SQLException e) {
			throw new DbException(ExceptionMessages.CONNECTION_ERROR);
		}
		return (l);
	}

}
