package hotstarApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hotstarApp.DBConnection;


public class MoviesDaoImpl  implements MoviesDao {
	
	public List<Movies> allMoviesList() throws Exception
	{
		List<Movies> l=new ArrayList<Movies>();
	   try( Connection con=DBConnection.dbConnect(); 
		
		PreparedStatement stmt=con.prepareStatement("select * from movies"))
	   {  
		try(ResultSet rs=stmt.executeQuery())
		{

	    
	    while(rs.next())  
	    {
	    	Movies mo=new Movies();
	    	mo.movieId=rs.getInt(1);
	    	mo.movieName=rs.getString(2);
	    	mo.movieType=rs.getString(3);
	    	mo.movieLanguage=rs.getString(4);
	    	mo.movieRatings=rs.getInt(5);
	    	mo.movieDirector=rs.getString(6);
	    	mo.movieReleasedDate=rs.getDate(7);
	    	mo.dateLaunchingIntoHotstar=rs.getDate(8);
	    	mo.videoUrl=rs.getString(9);
	    	l.add(mo);
	    }
		}
	   }catch (Exception e) {
		// TODO: handle exception
		   e.printStackTrace();
	}
		
		return(l);
	}

	public List<Movies> allMoviesByPreLang(int userId) throws Exception {
		// TODO Auto-generated method stub
        String str="select * from movies where movie_language=(select pre_language from users where user_id=?)";
	    List<Movies> l=new ArrayList<Movies>();

       try( Connection con=DBConnection.dbConnect(); 

		PreparedStatement stmt= con.prepareStatement(str))
       {
		stmt.setInt(1, userId);
		
		try(ResultSet rs=stmt.executeQuery()) 

		{
	    while(rs.next())  
	    {
	    	Movies mo=new Movies();
	    	mo.movieId=rs.getInt(1);
	    	mo.movieName=rs.getString(2);
	    	mo.movieType=rs.getString(3);
	    	mo.movieLanguage=rs.getString(4);
	    	mo.movieRatings=rs.getInt(5);
	    	mo.movieDirector=rs.getString(6);
	    	mo.movieReleasedDate=rs.getDate(7);
	    	mo.dateLaunchingIntoHotstar=rs.getDate(8);
	    	mo.videoUrl=rs.getString(9);
	    	l.add(mo);
	    }
		}
       }catch (Exception e) {
		// TODO: handle exception
    	   e.printStackTrace();
	}
		return(l);
		
		
		
	
	}

	public List<Movies> allMoviesByHighRatings() throws Exception {
		// TODO Auto-generated method stub
        String str="select * from movies order by movie_ratings DESC" ;
	    List<Movies> l=new ArrayList<Movies>();

		try(Connection con=DBConnection.dbConnect(); 

		PreparedStatement stmt= con.prepareStatement(str))
		{
		
		
		try(ResultSet rs=stmt.executeQuery()) 

		{
	    while(rs.next())  
	    {
	    	Movies mo=new Movies();
	    	mo.movieId=rs.getInt(1);
	    	mo.movieName=rs.getString(2);
	    	mo.movieType=rs.getString(3);
	    	mo.movieLanguage=rs.getString(4);
	    	mo.movieRatings=rs.getInt(5);
	    	mo.movieDirector=rs.getString(6);
	    	mo.movieReleasedDate=rs.getDate(7);
	    	mo.dateLaunchingIntoHotstar=rs.getDate(8);
	    	mo.videoUrl=rs.getString(9);
	    	l.add(mo);
	    }
		}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return(l);

		
	}

	public List<Movies> movieByName(String movieName) throws Exception {
        String str="select * from movies where movie_name LIKE ? " ;
		List<Movies> l=new ArrayList<Movies>();

		try(Connection con=DBConnection.dbConnect(); 

		PreparedStatement stmt= con.prepareStatement(str))
		{
		stmt.setString(1, movieName+"%");
		
		try(ResultSet rs=stmt.executeQuery())
		{
		
		while(rs.next())  
		    {
			Movies mo=new Movies();
		    	mo.movieId=rs.getInt(1);
		    	mo.movieName=rs.getString(2);
		    	mo.movieType=rs.getString(3);
		    	mo.movieLanguage=rs.getString(4);
		    	mo.movieRatings=rs.getInt(5);
		    	mo.movieDirector=rs.getString(6);
		    	mo.movieReleasedDate=rs.getDate(7);
		    	mo.dateLaunchingIntoHotstar=rs.getDate(8);
		    	mo.videoUrl=rs.getString(9);
		    	l.add(mo);
		    }
		}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return(l);
	}

	public void addMovies(Movies m) throws Exception {
		// TODO Auto-generated method stub
		String str="insert into movies (movie_id,movie_name,movie_type,movie_language,movie_director,movie_released_date,video_url)" + 
        		"            values(movie_id_sq.nextval,lower(?),lower(?),lower(?),lower(?),?,?) " ;
        
		try(Connection con=DBConnection.dbConnect(); 
        
		PreparedStatement stmt= con.prepareStatement(str))
		{
		stmt.setString(1, m.getMovieName());
		stmt.setString(2, m.getMovieType());
		stmt.setString(3, m.getMovieLanguage());
		stmt.setString(4, m.getMovieDirector());
		stmt.setDate(5, m.getMovieReleasedDate());
		stmt.setString(6, m.getVideoUrl());
		int rows =stmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	    
		
	}
	public void updateLastWatchingMovie(int userId,int lastWatchingId) throws Exception {
		// TODO Auto-generated method stub
		String sql="update users_watching_details_movies set last_viewing_date=sysdate, last_watching_id=? where user_id=?";

		try(Connection con=DBConnection.dbConnect();
		PreparedStatement stmt= con.prepareStatement(sql))
		{
		stmt.setInt(1, lastWatchingId);
		stmt.setInt(2, userId);
		int rows=stmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		
	}

	public Movies watchingMovie(String movieName) throws Exception {
		UsersDaoImpl ui=new UsersDaoImpl();
		Movies mo=new Movies();
		String sql="select * from movies where movie_name=?";
		try(Connection con=DBConnection.dbConnect();
		
		PreparedStatement stmt= con.prepareStatement(sql))
		{
		stmt.setString(1, movieName);
		try(ResultSet rs=stmt.executeQuery())
		{
				
		
		int lastWatchingId=0;
		if(rs.next())
		{
			mo.movieId=rs.getInt(1);
			lastWatchingId=mo.movieId;
    	mo.movieName=rs.getString(2);
    	mo.movieType=rs.getString(3);
    	mo.movieLanguage=rs.getString(4);
    	mo.movieRatings=rs.getInt(5);
    	mo.movieDirector=rs.getString(6);
    	mo.movieReleasedDate=rs.getDate(7);
    	mo.dateLaunchingIntoHotstar=rs.getDate(8);
    	mo.videoUrl=rs.getString(9);
		}
		String s[]=ui.getUserDetails();
		updateLastWatchingMovie(Integer.parseInt(s[1]),lastWatchingId);
		}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mo;
	
	}

	
	
}
