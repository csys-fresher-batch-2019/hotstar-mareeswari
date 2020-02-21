package hotstarApp;

import java.sql.Connection;
import java.sql.PreparedStatement;

import hotstarApp.DBConnection;


public class RatingsDaoImpl implements RatingsDao {

	public void putRatings(int userId,int movieId,int rating) throws Exception {
		// TODO Auto-generated method stub
        String str="insert into movie_ratings (ratings_id,user_id,movie_id,ratings) values(movie_ratings_id.nextval,?,?,?)";

		try(Connection con=DBConnection.dbConnect(); 
        
		PreparedStatement stmt= con.prepareStatement(str))
		{
		stmt.setInt(1, userId);
		stmt.setInt(2, movieId);
		
		stmt.setInt(3, rating);
		int rows =stmt.executeUpdate(); 
		
		String str1="update movies set movie_ratings =find_min_ratings(?) where movie_id=?";
		try
		(PreparedStatement stmt1= con.prepareStatement(str1))
		{
		stmt1.setInt(1,movieId);
		stmt1.setInt(2,movieId);
		
		
		int rows1=stmt1.executeUpdate();
		}
		con.close();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
         
}
