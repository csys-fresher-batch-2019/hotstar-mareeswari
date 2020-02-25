package hotstarApp;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection  {
	public static Connection dbConnect()throws Exception
	{
	Class.forName("oracle.jdbc.driver.OracleDriver");  
	  //ip,username,password
	Connection con=DriverManager.getConnection(  
	"jdbc:oracle:thin:@13.235.147.120:1521:XE","mareeswari","mareeswari"); 
	
	return(con);
	}
	
}
