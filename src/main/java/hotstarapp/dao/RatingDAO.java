package hotstarapp.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;

import hotstarapp.exception.DbException;

public interface RatingDAO {
    @SqlQuery("insert into movie_ratings (ratings_id,user_id,movie_id,ratings) values(movie_ratings_id.nextval,?,?,?)")
	public int putRatings(int userId, int movieId, int rating) throws DbException;

}
