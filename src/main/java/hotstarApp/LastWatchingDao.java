package hotstarApp;

import hotstarApp.Movies;

public interface LastWatchingDao {
      public Movies lastWatchedMovie(String email) throws Exception;
      
}
