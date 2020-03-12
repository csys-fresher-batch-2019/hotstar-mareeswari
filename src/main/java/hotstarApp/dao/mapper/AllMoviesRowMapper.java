package hotstarApp.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import hotstarApp.model.Movies;

public class AllMoviesRowMapper implements RowMapper<Movies>{

	@Override
	public Movies map(ResultSet rs, StatementContext ctx) throws SQLException {
		Movies mo = new Movies();
		mo.setMovieId(rs.getInt(1));
		mo.setMovieName (rs.getString(2));
		mo.setMovieType ( rs.getString(3));
		mo.setMovieLanguage ( rs.getString(4));
		mo.setMovieRatings (rs.getInt(5));
		mo.setMovieDirector (rs.getString(6));
		mo.setMovieReleasedDate (LocalDate.parse(rs.getDate(7)+""));
		mo.setDateLaunchingIntoHotstar (LocalDate.parse(rs.getDate(8)+""));
		mo.setVideoUrl( rs.getString(9));
		mo.setPoster ( rs.getString(10));
		return(mo);
	}

}
