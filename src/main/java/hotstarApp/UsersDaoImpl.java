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

	public String[] getUserDetails() throws Exception {
		// TODO Auto-generated method stub
		List<String> l=new ArrayList<String>();
		l=Files.readAllLines(Paths.get("register.txt"));
		String row[]=new String[2];
		for(String s:l)
		{
			
			 row=s.split(",");
		
		}
		
		return row;
	}
	public String login(String email,String password) throws Exception
	{
		int uId=0;
		int mId=0;
		String preLanguage = null;
		String s=null;
        String str="select * from users where email=? and  password=?" ;
		String str1="select user_id,pre_language from users where email=?";
		String str2="select movie_id from movies where movie_language=?";
        String str3="insert into users_watching_details_movies(watching_id,last_watching_id,user_id)values (watching_id_sq.nextval,?,?)";
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
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//get preferable language
		try(PreparedStatement stmt1= con.prepareStatement(str1))
		{
		stmt1.setString(1, email);
		try(ResultSet rs1=stmt1.executeQuery())
		{
		
		if(rs1.next())
		{
			uId=rs1.getInt(1);
			System.out.println(uId);
			preLanguage=rs1.getString(2);
			System.out.println(preLanguage);
		}
		//insert user details into a file
		Path p=Paths.get("register.txt");
		String content=email+","+uId+"";
		Files.write(p,content.getBytes());
		}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try(
		PreparedStatement stmt2= con.prepareStatement(str2))
		{
		stmt2.setString(1, preLanguage);
		try(ResultSet rs2=stmt2.executeQuery())
		{
		
		if(rs2.next())
		{
			mId=rs2.getInt(1);
			System.out.println(mId);
		}
		}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//insert a first movie as a last watching for first login
		
		try(PreparedStatement stmt3= con.prepareStatement(str3))
		{
		stmt3.setInt(1, mId);
		stmt3.setInt(2,uId);
		int rows1 =stmt3.executeUpdate();  
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		
		con.close();
		return(s);
	}

}
