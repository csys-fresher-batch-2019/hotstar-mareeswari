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
	    	mo.poster=rs.getString(10);
	    	l.add(mo);
	    }
		}
		con.close();
	   }catch (Exception e) {
		// TODO: handle exception
		   e.printStackTrace();
	}
		
		return(l);
	}
	public List<Movies> allMoviesListByType(String type) throws Exception
	{
		List<Movies> l=new ArrayList<Movies>();
	   try( Connection con=DBConnection.dbConnect(); 
		
		PreparedStatement stmt=con.prepareStatement("select * from movies where movie_type=?"))
	   {  
		   stmt.setString(1, type);
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
	    	mo.poster=rs.getString(10);
	    	l.add(mo);
	    }
		}
		con.close();
	   }catch (Exception e) {
		// TODO: handle exception
		   e.printStackTrace();
	}
		
		return(l);
	}

	public List<Movies> allMoviesByPreLang(String email) throws Exception {
		// TODO Auto-generated method stub
        String str="select * from movies where movie_language=(select pre_language from users where email=?)";
	    List<Movies> l=new ArrayList<Movies>();

       try( Connection con=DBConnection.dbConnect(); 

		PreparedStatement stmt= con.prepareStatement(str))
       {
		stmt.setString(1, email);
		
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
	    	mo.poster=rs.getString(10);
	    	l.add(mo);
	    }
		}
		con.close();
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
	    	mo.poster=rs.getString(10);
	    	l.add(mo);
	    }
		}
		con.close();
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
		    	mo.poster=rs.getString(10);
		    	l.add(mo);
		    }
		}
		con.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return(l);
	}

	public void addMovies(Movies m) throws Exception {
		// TODO Auto-generated method stub
		String str="insert into movies (movie_id,movie_name,movie_type,movie_language,movie_director,movie_released_date,video_url,poster)" + 
        		"            values(movie_id_sq.nextval,lower(?),lower(?),lower(?),lower(?),?,?,?) " ;
        
		try(Connection con=DBConnection.dbConnect(); 
        
		PreparedStatement stmt= con.prepareStatement(str))
		{
		stmt.setString(1, m.getMovieName());
		stmt.setString(2, m.getMovieType());
		stmt.setString(3, m.getMovieLanguage());
		stmt.setString(4, m.getMovieDirector());
		stmt.setDate(5, m.getMovieReleasedDate());
		stmt.setString(6, m.getVideoUrl());
		stmt.setString(7, m.getPoster());
		int rows =stmt.executeUpdate();
		con.close();
		}
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	    
		
	}
	public void updateLastWatchingMovie(int userId,int lastWatchingId) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into users_watching_details_movies(watching_id,last_watching_id,user_id)values (watching_id_sq.nextval,?,?)";

		try(Connection con=DBConnection.dbConnect();
		PreparedStatement stmt= con.prepareStatement(sql))
		{
		stmt.setInt(1, lastWatchingId);
		stmt.setInt(2, userId);
		int rows=stmt.executeUpdate();
		con.close();
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
		Users u=ui.getUserDetails("maha@gmail.com");
		updateLastWatchingMovie(u.userId,lastWatchingId);
		}
		con.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mo;
	
	}
	@Override
	public List<Movies> todayUploads() throws Exception {
		// TODO Auto-generated method stub
		 String str="select * from movies where date_launching_into_hotstar= " ;
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
			    	mo.poster=rs.getString(10);
			    	l.add(mo);
			    }
			}
			con.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return(l);
	}
	@Override
	public List<String> movieLanguageList() throws Exception {
		List<String> typeList=new ArrayList<String>();
		String sql="select movie_language from movies group by movie_language ";
		try(Connection con=DBConnection.dbConnect();
		
		PreparedStatement stmt= con.prepareStatement(sql))
		{
		
		try(ResultSet rs=stmt.executeQuery())
		{
				
		
		
		while(rs.next())
		{
			 String lang=rs.getString(1);
			 typeList.add(lang);
		}
		
			}
		con.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
		return typeList;
	}
	@Override
	public List<Movies> moviesListByLanguage(String lang) throws Exception {
		 String str="select * from movies where movie_language=?";
		    List<Movies> l=new ArrayList<Movies>();

	       try( Connection con=DBConnection.dbConnect(); 

			PreparedStatement stmt= con.prepareStatement(str))
	       {
			stmt.setString(1, lang);
			
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
		    	mo.poster=rs.getString(10);
		    	l.add(mo);
		    }
			}
			con.close();
	       }catch (Exception e) {
			// TODO: handle exception
	    	   e.printStackTrace();
		}
			return(l);
	}
	

	
	
}
