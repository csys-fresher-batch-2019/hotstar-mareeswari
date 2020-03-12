package hotstarApp.dao;

import hotstarApp.model.Movies;
import hotstarApp.validation.DbException;

public interface LastWatchingDao {
      public Movies lastWatchedMovie(String email) throws DbException;
      
}
