package hotstarApp.dao;

import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import hotstarApp.dao.mapper.AllMoviesLanguageListRowMapper;
import hotstarApp.dao.mapper.AllMoviesRowMapper;
import hotstarApp.model.Movies;

public interface MoviesDao {

	@SqlQuery("select * from Movies")
	@RegisterRowMapper(AllMoviesRowMapper.class)
	public List<Movies> allMoviesList() throws Exception;
	
	@SqlQuery("select * from movies where movie_language=(select pre_language from users where email=?)")
	@RegisterRowMapper(AllMoviesRowMapper.class)
	public List<Movies> allMoviesByPreLang(String email) throws Exception;

//	public List<Movies> allMoviesByHighRatings() throws Exception;
	
	@SqlQuery("select * from movies where movie_name LIKE :name ")
	@RegisterRowMapper(AllMoviesRowMapper.class)
	public List<Movies> movieByName(@Bind("name")String movieName) throws Exception;
	
	@SqlUpdate("insert into movies (movie_id,movie_name,movie_type,movie_language,movie_director,movie_released_date,video_url,poster) values(movie_id_sq.nextval,lower(:movieName),lower(:movieType),lower(:movieLanguage),lower(:movieDirector),:movieReleasedDate,:videoUrl,:poster) ")
    public int addMovies(@BindBean Movies m) throws Exception;

	@SqlQuery("select * from movies where movie_name=?")
	@RegisterRowMapper(AllMoviesRowMapper.class)
	 public Movies watchingMovie(String movieName) throws Exception;

	@SqlUpdate("insert into users_watching_details_movies(watching_id,last_watching_id,user_id)values (watching_id_sq.nextval,:watchingid,:userid) ")
	public int updateLastWatchingMovie(@Bind("userid")int userId, @Bind("watchingid")int watchingId) throws Exception;

	@SqlQuery("select * from movies where movie_type=?")
	@RegisterRowMapper(AllMoviesRowMapper.class)
	public List<Movies> allMoviesListByType(String type) throws Exception;

	@SqlQuery("select * from movies where trunc(date_launching_into_hotstar)=trunc(sysdate)")
	@RegisterRowMapper(AllMoviesRowMapper.class)
	public List<Movies> todayUploads() throws Exception;

    @SqlQuery("select movie_language from movies group by movie_language")
	@RegisterRowMapper(AllMoviesLanguageListRowMapper.class)
	public List<String> movieLanguageList() throws Exception;

    @SqlQuery("select * from movies where movie_language=?")
   	@RegisterRowMapper(AllMoviesRowMapper.class)
	public List<Movies> moviesListByLanguage(String lang) throws Exception;
}
