package hotstarApp.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class AllMoviesLanguageListRowMapper implements RowMapper<String> {

	@Override
	public String map(ResultSet rs, StatementContext ctx) throws SQLException {
		// TODO Auto-generated method stub
		String language=rs.getString(1);
		return language;
	}

}
