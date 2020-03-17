package hotstarapp.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import hotstarapp.dao.TvShowDAO;
import hotstarapp.exception.DbException;
import hotstarapp.exception.ExceptionMessages;
import hotstarapp.model.TvShow;
import hotstarapp.util.ConnectionUtil;

public class TvShowDAOImpl implements TvShowDAO {

	public List<TvShow> allTvShowsList() throws DbException {
		List<TvShow> l = new ArrayList<TvShow>();

		try (Connection con = ConnectionUtil.dbConnect();

				PreparedStatement stmt = con.prepareStatement("select * from tv_shows")) {
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					TvShow ts = new TvShow();
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
				throw new DbException(ExceptionMessages.INVALID_SELECT);
			}
			con.close();
		} catch (SQLException e) {
			// TODO: handle exception
			throw new DbException(ExceptionMessages.CONNECTION_ERROR);
		}
		return (l);

	}

}
