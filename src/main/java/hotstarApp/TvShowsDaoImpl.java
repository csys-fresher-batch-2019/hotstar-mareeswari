package hotstarApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class TvShowsDaoImpl implements TvShowsDao{

	
	public List<TvShows> allTvShowsList() throws Exception {
	    List<TvShows> l=new ArrayList<TvShows>();

try(Connection con=DBConnection.dbConnect(); 
		
		PreparedStatement stmt=con.prepareStatement("select * from tv_shows"))  
{  
		try(ResultSet rs=stmt.executeQuery()) 
		{
	    while(rs.next())  
	    {
	    	TvShows ts=new TvShows();
	    	ts.showId=rs.getInt(1);
	    	ts.showName=rs.getString(2);
	    	ts.dateLaunchingIntoHotstar=rs.getDate(3);
	    	ts.showLanguage=rs.getString(4);
	    	ts.showType=rs.getString(5);
	    	ts.showRatings=rs.getInt(6);
	    	ts.poster=rs.getString(7);
	    	l.add(ts);
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
