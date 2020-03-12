package hotstarApp.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import hotstarApp.dao.LastWatchingDao;
import hotstarApp.model.Movies;
import hotstarApp.util.ConnectionUtil;
import hotstarApp.validation.DbException;

public class LastWatchingImpl implements LastWatchingDao {

	public Movies lastWatchedMovie(String email) throws DbException {
		Movies mo = new Movies();
		String str = "select * from movies where movie_id=(select last_watching_id from users_watching_details_movies where user_id=(select user_id from users where email=?)) ";

		try (Connection con = ConnectionUtil.dbConnect(); PreparedStatement stmt = con.prepareStatement(str)) {

			stmt.setString(1, email);
			try (ResultSet rs = stmt.executeQuery()) {

				if (rs.next()) {

					mo.setMovieId(rs.getInt(1));
					mo.setMovieName (rs.getString(2));
					mo.setMovieType ( rs.getString(3));
					mo.setMovieLanguage ( rs.getString(4));
					mo.setMovieRatings (rs.getInt(5));
					mo.setMovieDirector (rs.getString(6));
					mo.setMovieReleasedDate (LocalDate.parse(rs.getDate(7)+""));
					mo.setDateLaunchingIntoHotstar ( LocalDate.parse(rs.getDate(8)+""));
					mo.setVideoUrl( rs.getString(9));
					mo.setPoster ( rs.getString(10));

				}

			}
			catch (SQLException e) {
				// TODO: handle exception
				throw new DbException("Invalid Select");
			}
			con.close();
		}

		catch (Exception e) {
			// TODO: handle exception
			throw new DbException("DB Connection Error");
		}
		return (mo);

	}

}
