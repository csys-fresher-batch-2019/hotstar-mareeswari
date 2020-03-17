package hotstarapp.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import hotstarapp.dao.RatingDAO;
import hotstarapp.exception.DbException;
import hotstarapp.exception.ExceptionMessages;
import hotstarapp.util.ConnectionUtil;

public class RatingDAOImpl implements RatingDAO {

	public int putRatings(int userId, int movieId, int rating) throws DbException {
		// TODO Auto-generated method stub
		String str = "insert into movie_ratings (ratings_id,user_id,movie_id,ratings) values(movie_ratings_id.nextval,?,?,?)";
int rows=0;
		try (Connection con = ConnectionUtil.dbConnect();

				PreparedStatement stmt = con.prepareStatement(str)) {
			stmt.setInt(1, userId);
			stmt.setInt(2, movieId);

			stmt.setInt(3, rating);
			rows=stmt.executeUpdate();

			String str1 = "update movies set movie_ratings =find_min_ratings(?) where movie_id=?";
			try (PreparedStatement stmt1 = con.prepareStatement(str1)) {
				stmt1.setInt(1, movieId);
				stmt1.setInt(2, movieId);

				stmt1.executeUpdate();
			}
			catch (SQLException e) {
				// TODO: handle exception
				throw new DbException("update failure");
			}
			con.close();
		} catch (SQLException e) {
			// TODO: handle exception
			throw new DbException(ExceptionMessages.CONNECTION_ERROR);
		}
		return(rows);

	}

}
