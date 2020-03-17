package hotstarapp.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import hotstarapp.dao.LastWatchingDAO;
import hotstarapp.exception.DbException;
import hotstarapp.exception.ExceptionMessages;
import hotstarapp.model.Movie;
import hotstarapp.util.ConnectionUtil;

public class LastWatchingDAOImpl implements LastWatchingDAO {

	public Movie lastWatchedMovie(String email) throws DbException {
		Movie movie = new Movie();
		String str = "select * from movies where movie_id=(select last_watching_id from users_watching_details_movies where user_id=(select user_id from users where email=?)) ";

		try (Connection con = ConnectionUtil.dbConnect(); PreparedStatement stmt = con.prepareStatement(str)) {

			stmt.setString(1, email);
			try (ResultSet rs = stmt.executeQuery()) {

				if (rs.next()) {

					movie.setMovieId(rs.getInt(1));
					movie.setMovieName (rs.getString(2));
					movie.setMovieType ( rs.getString(3));
					movie.setMovieLanguage ( rs.getString(4));
					movie.setMovieRatings (rs.getInt(5));
					movie.setMovieDirector (rs.getString(6));
					movie.setMovieReleasedDate (LocalDate.parse(rs.getDate(7)+""));
					movie.setDateLaunchingIntoHotstar ( LocalDate.parse(rs.getDate(8)+""));
					movie.setVideoUrl( rs.getString(9));
					movie.setPoster ( rs.getString(10));

				}

			}
			catch (SQLException e) {
				throw new DbException(ExceptionMessages.INVALID_SELECT);
			}
		}

		catch (Exception e) {
			throw new DbException(ExceptionMessages.CONNECTION_ERROR);
		}
		return (movie);

	}

}
