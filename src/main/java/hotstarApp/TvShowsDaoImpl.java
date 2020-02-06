package hotstarApp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hotstarApp.DBConnection;


public class TvShowsDaoImpl implements TvShowsDao{

	
	public List<TvShows> allTvShowsList() throws Exception {
		
Connection con=DBConnection.dbConnect(); 
		
		Statement stmt=con.createStatement();  
		  
		ResultSet rs=stmt.executeQuery("select * from tv_shows");  

	    List<TvShows> l=new ArrayList<TvShows>();
	    while(rs.next())  
	    {
	    	TvShows ts=new TvShows();
	    	ts.showId=rs.getInt(1);
	    	ts.showName=rs.getString(2);
	    	ts.dateLaunchingIntoHotstar=rs.getDate(3);
	    	ts.showLanguage=rs.getString(4);
	    	ts.showType=rs.getString(5);
	    	ts.showRatings=rs.getInt(6);
	    	
	    	l.add(ts);
	    }
		
		return(l);
	
	}

}
