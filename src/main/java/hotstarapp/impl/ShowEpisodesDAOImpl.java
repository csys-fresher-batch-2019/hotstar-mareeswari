package hotstarApp.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import hotstarApp.dao.ShowEpisodesDao;
import hotstarApp.dto.NameEpisode;
import hotstarApp.model.ShowEpisodes;
import hotstarApp.util.ConnectionUtil;
import hotstarApp.validation.DbException;

public class ShowEpisodesImpl implements ShowEpisodesDao {

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
				throw new DbException("Invalid Select");
			}
			con.close();
		} catch (SQLException e) {
			throw new DbException("DB Connection Error");
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
				throw new DbException("Invalid Select");
			}
			con.close();
		} catch (SQLException e) {

			throw new DbException("DB Connection Error");
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
				throw new DbException("Invalid Select");
			}
		} catch (SQLException e) {
			throw new DbException("DB Connection Error");
		}

		return (l);

	}

	@Override
	public List<ShowEpisodes> showEpisodess(int showId) throws DbException {
		List<ShowEpisodes> l = new ArrayList<ShowEpisodes>();

		try (Connection con = ConnectionUtil.dbConnect();

				PreparedStatement stmt = con.prepareStatement("select * from show_episodes where show_id =?  ")) {
			stmt.setInt(1, showId);

			try (ResultSet rs = stmt.executeQuery()) {

				while (rs.next()) {
					ShowEpisodes se = new ShowEpisodes();
					se.setShowId(rs.getInt(2));

					se.setEpisodeId(rs.getInt(1));
					se.setEpisodeNo(rs.getInt(3));
					se.setEpisodeDate(rs.getDate(4));
					se.setVideoUrl(rs.getString(5));
					l.add(se);
				}
			} catch (SQLException e) {
				throw new DbException("Invalid Select");
			}
			con.close();
		} catch (SQLException e) {
			throw new DbException("DB Connection Error");
		}
		return (l);
	}

}
