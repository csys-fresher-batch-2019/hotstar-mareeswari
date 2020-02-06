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
          Connection con=DBConnection.dbConnect(); 
		
		Statement stmt=con.createStatement();  
		  
		ResultSet rs=stmt.executeQuery("select t.show_name,s.episode_no,s.episode_date from tv_shows t,show_episodes s where t.show_id=s.show_id ");

	    List<NameEpisode> l=new ArrayList<NameEpisode>();
	    while(rs.next())  
	    {
	    	NameEpisode nm=new NameEpisode();
	    	nm.showName=rs.getString(1);
	    	nm.episodeNo=rs.getInt(2);
	    	nm.episodeDate=rs.getDate(3);
	    	
	    	l.add(nm);
	    }
		
		return(l);

		
	}

	public int episodesCountByShowName(String showName) throws Exception {
		Connection con=DBConnection.dbConnect(); 
        String str="select count(episode_no) from tv_shows t,show_episodes s where t.show_id=s.show_id and t.show_name=lower(?)";

		PreparedStatement stmt= con.prepareStatement(str);
		
		stmt.setString(1, showName);
		
		ResultSet rs=stmt.executeQuery();  
        int count = 0;
         if(rs.next())
         {
        	 count=rs.getInt(1);
         }
	   
		

		return count;
	}

	public HashMap<String, Integer> allShowNameAndEpisodesCount() throws Exception {
		  Connection con=DBConnection.dbConnect(); 
			
			Statement stmt=con.createStatement();  
			  
			ResultSet rs=stmt.executeQuery(" select t.show_name,(select  count(episode_no)  from show_episodes where t.show_id=show_id) as epi_count from tv_shows t ");

		    HashMap<String, Integer> l=new HashMap<String, Integer>();
		    while(rs.next())  
		    {
		    	String showName=rs.getString(1);
		    	int count=rs.getInt(2);
		    	l.put(showName, count);
		    }
			
		    return(l);
		
		
		
		
		
		}

}
