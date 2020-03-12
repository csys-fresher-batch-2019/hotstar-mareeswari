package hotstarApp.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import hotstarApp.dao.TvShowsDao;
import hotstarApp.model.TvShows;
import hotstarApp.util.ConnectionUtil;
import hotstarApp.validation.DbException;

public class TvShowsImpl implements TvShowsDao {

	public List<TvShows> allTvShowsList() throws DbException {
		List<TvShows> l = new ArrayList<TvShows>();

		try (Connection con = ConnectionUtil.dbConnect();

				PreparedStatement stmt = con.prepareStatement("select * from tv_shows")) {
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					TvShows ts = new TvShows();
					ts.setShowId(rs.getInt(1));
					ts.setShowName(rs.getString(2));
					ts.setDateLaunchingIntoHotstar(LocalDate.parse(rs.getDate(3)+""));
					ts.setShowLanguage(rs.getString(4));
					ts.setShowType(rs.getString(5));
					ts.setShowRatings(rs.getInt(6));
					ts.setPoster(rs.getString(7));
					l.add(ts);
				}
			}
			catch (SQLException e) {
				// TODO: handle exception
				throw new DbException("Invalid Select");
			}
			con.close();
		} catch (SQLException e) {
			// TODO: handle exception
			throw new DbException("DB Connection Error");
		}
		return (l);

	}

}
