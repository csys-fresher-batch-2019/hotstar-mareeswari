package hotstarapp.dao;

import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import hotstarapp.dao.mapper.AllMoviesLanguageListRowMapper;
import hotstarapp.dao.mapper.AllMoviesRowMapper;
import hotstarapp.model.Movie;

public interface MovieDAO {

	@SqlQuery("select * from Movies")
	@RegisterRowMapper(AllMoviesRowMapper.class)
	public List<Movie> allMoviesList() throws Exception;
	
	@SqlQuery("select * from movies where movie_language=(select pre_language from users where email=?)")
	@RegisterRowMapper(AllMoviesRowMapper.class)
	public List<Movie> allMoviesByPreLang(String email) throws Exception;

//	public List<Movies> allMoviesByHighRatings() throws Exception;
	
	@SqlQuery("select * from movies where movie_name LIKE :name ")
	@RegisterRowMapper(AllMoviesRowMapper.class)
	public List<Movie> movieByName(@Bind("name")String movieName) throws Exception;
	
	@SqlUpdate("insert into movies (movie_id,movie_name,movie_type,movie_language,movie_director,movie_released_date,video_url,poster) values(movie_id_sq.nextval,lower(:movieName),lower(:movieType),lower(:movieLanguage),lower(:movieDirector),:movieReleasedDate,:videoUrl,:poster) ")
    public int addMovies(@BindBean Movie m) throws Exception;

	@SqlQuery("select * from movies where movie_name=?")
	@RegisterRowMapper(AllMoviesRowMapper.class)
	 public Movie watchingMovie(String movieName) throws Exception;

	@SqlUpdate("insert into users_watching_details_movies(watching_id,last_watching_id,user_id)values (watching_id_sq.nextval,:watchingid,:userid) ")
	public int updateLastWatchingMovie(@Bind("userid")int userId, @Bind("watchingid")int watchingId) throws Exception;

	@SqlQuery("select * from movies where movie_type=?")
	@RegisterRowMapper(AllMoviesRowMapper.class)
	public List<Movie> allMoviesListByType(String type) throws Exception;

	@SqlQuery("select * from movies where trunc(date_launching_into_hotstar)=trunc(sysdate)")
	@RegisterRowMapper(AllMoviesRowMapper.class)
	public List<Movie> todayUploads() throws Exception;

    @SqlQuery("select movie_language from movies group by movie_language")
	@RegisterRowMapper(AllMoviesLanguageListRowMapper.class)
	public List<String> movieLanguageList() throws Exception;

    @SqlQuery("select * from movies where movie_language=?")
   	@RegisterRowMapper(AllMoviesRowMapper.class)
	public List<Movie> moviesListByLanguage(String lang) throws Exception;
}
