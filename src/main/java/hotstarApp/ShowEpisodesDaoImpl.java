package hotstarApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import hotstarApp.DBConnection;



public class ShowEpisodesDaoImpl implements ShowEpisodesDao {

	public List<NameEpisode> allShowNameAndEpisodes() throws Exception {
		
	    List<NameEpisode> l=new ArrayList<NameEpisode>();

         try( Connection con=DBConnection.dbConnect(); 
		
		PreparedStatement stmt=con.prepareStatement("select t.show_name,s.episode_no,s.episode_date from tv_shows t,show_episodes s where t.show_id=s.show_id "))
         {
        	 
         
		try(ResultSet rs=stmt.executeQuery())
		{

	    while(rs.next())  
	    {
	    	NameEpisode nm=new NameEpisode();
	    	nm.showName=rs.getString(1);
	    	nm.episodeNo=rs.getInt(2);
	    	nm.episodeDate=rs.getDate(3);
	    	
	    	l.add(nm);
	    }
		}
		con.close();
         }catch (Exception e) {
			// TODO: handle exception
        	 e.printStackTrace();
		}
		return(l);

		
	}

	public int episodesCountByShowName(String showName) throws Exception {
        String str="select count(episode_no) from tv_shows t,show_episodes s where t.show_id=s.show_id and t.show_name=lower(?)";
        int count = 0;

		try(Connection con=DBConnection.dbConnect(); 

		PreparedStatement stmt= con.prepareStatement(str))
		{
		stmt.setString(1, showName);
		
		try(ResultSet rs=stmt.executeQuery())
		{
         if(rs.next())
         {
        	 count=rs.getInt(1);
         }
	   
		}
		con.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return count;
	}

	public HashMap<String, Integer> allShowNameAndEpisodesCount() throws Exception {
	    HashMap<String, Integer> l=new HashMap<String, Integer>();

	  try(Connection con=DBConnection.dbConnect(); 
	
			PreparedStatement stmt=con.prepareStatement(" select t.show_name,(select  count(episode_no)  from show_episodes where t.show_id=show_id) as epi_count from tv_shows t "))
		  {
			  
			try(ResultSet rs=stmt.executeQuery())
			{

		    while(rs.next())  
		    {
		    	String showName=rs.getString(1);
		    	int count=rs.getInt(2);
		    	l.put(showName, count);
		    }
			}
		  }catch (Exception e) {
			// TODO: handle exception
			  e.printStackTrace();
		}
		    return(l);
		
		
		
		
		
		}

	@Override
	public List<ShowEpisodes> showEpisodess(int showId) throws Exception {
		 List<ShowEpisodes> l=new ArrayList<ShowEpisodes>();

         try( Connection con=DBConnection.dbConnect(); 
		
		PreparedStatement stmt=con.prepareStatement("select * from show_episodes where show_id =?  "))
         {
        	 stmt.setInt(1, showId);
         
		try(ResultSet rs=stmt.executeQuery())
		{

	    while(rs.next())  
	    {
	    	ShowEpisodes se=new ShowEpisodes();
	    	se.showId=rs.getInt(2);
	    	
	    	se.episodeId=rs.getInt(1);
	    	se.episodeNo=rs.getInt(3);
	    	se.episodeDate=rs.getDate(4);
	    	se.videoUrl=rs.getString(5);
	    	l.add(se);
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
