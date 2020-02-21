package hotstarApp;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection  {
	public static Connection dbConnect()throws Exception
	{
	Class.forName("oracle.jdbc.driver.OracleDriver");  
	  
	Connection con=DriverManager.getConnection(  
	"jdbc:oracle:thin:@192.168.56.234:1521:XE","system","oracle"); 
	
	return(con);
	}
	
}
