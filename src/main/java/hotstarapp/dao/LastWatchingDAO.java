package hotstarapp.dao;

import hotstarapp.exception.DbException;
import hotstarapp.model.Movie;

public interface LastWatchingDAO {
      public Movie lastWatchedMovie(String email) throws DbException;
      
}
