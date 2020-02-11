package hotstarApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import hotstarApp.DBConnection;
import hotstarApp.Movies;


public class LastWatchingDaoImpl implements LastWatchingDao {

	public Movies lastWatchedMovie(String email) throws Exception {
		Movies mo=new Movies();
        String str="select * from movies where movie_id=(select last_watching_id from users_watching_details_movies where user_id=(select user_id from users where email=?)) " ;

		try(Connection con=DBConnection.dbConnect();PreparedStatement stmt= con.prepareStatement(str)){
		
		stmt.setString(1,email);
		try(ResultSet rs=stmt.executeQuery()){  
		
		if(rs.next())  
		    {
		    
		    	mo.movieId=rs.getInt(1);
		    	mo.movieName=rs.getString(2);
		    	mo.movieType=rs.getString(3);
		    	mo.movieLanguage=rs.getString(4);
		    	mo.movieRatings=rs.getInt(5);
		    	mo.movieDirector=rs.getString(6);
		    	mo.movieReleasedDate=rs.getDate(7);
		    	mo.dateLaunchingIntoHotstar=rs.getDate(8);
		    	
		    }
		

		}
		
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return(mo);
		
		
	}

}
