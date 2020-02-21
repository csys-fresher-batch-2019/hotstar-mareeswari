package hotstarApp;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class UsersDaoImpl implements UsersDao{

	
	public void registerNewUser(Users u) throws Exception {
		Connection con=DBConnection.dbConnect(); 
        String str="insert into users(user_id,user_name,email,phone_no,pre_language,password) values(user_id_sq.nextval,lower(?),lower(?),?,lower(?),?)" ;
        
		PreparedStatement stmt= con.prepareStatement(str);
		stmt.setString(1, u.userName);
		stmt.setString(2, u.email);
		stmt.setLong(3, u.phoneNumber);
		stmt.setString(4, u.preLanguage);
		stmt.setString(5, u.password);
	    int rows =stmt.executeUpdate();  
		
		con.close();
        
		
	}

	public Users getUserDetails(String email) throws Exception {
		 String str="select * from users where email=? " ;
		  Connection con=DBConnection.dbConnect();
		  Users u=new Users();
		try
		(

		PreparedStatement stmt= con.prepareStatement(str))
		{
		stmt.setString(1,email);
		
		try(ResultSet rs =stmt.executeQuery())
		{
		
		if( rs.next())
		{
			u.userId=rs.getInt(1);
			u.userName=rs.getString(2);
			u.email=rs.getString(3);
			u.phoneNumber=rs.getLong(4);
			u.preLanguage=rs.getString(5);
		}
		
		}
		con.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return u;
	}
	public String login(String email,String password) throws Exception
	{
		
		String s=null;
        String str="select * from users where email=? and  password=?" ;
		  Connection con=DBConnection.dbConnect(); 
		try
		(

		PreparedStatement stmt= con.prepareStatement(str))
		{
		stmt.setString(1,email);
		stmt.setString(2, password);
		try(ResultSet rs =stmt.executeQuery())
		{
		
		if( rs.next())
		{
			s="success";
		}
		else
		{
			s="failure";
		}
		}
		con.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//get preferable language
	
		con.close();
		return(s);
	}
	public String toUpp(String word)throws Exception
	{
		 String first=word.substring(0,1);
		   String f_after=word.substring(1);
		   String res=first.toUpperCase()+f_after;
		
		return(res);
	}

}
