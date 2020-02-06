package hotstarApp;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UsersDaoImpl implements UsersDao{

	
	public void registerNewUser(Users u) throws Exception {
		Connection con=DBConnection.dbConnect(); 
        String str="insert into users(user_id,user_name,email,phone_no,pre_language) values(user_id_sq.nextval,lower(?),lower(?),?,lower(?))" ;
        
		PreparedStatement stmt= con.prepareStatement(str);
		stmt.setString(1, u.userName);
		stmt.setString(2, u.email);
		stmt.setLong(3, u.phoneNumber);
		stmt.setString(4, u.preLanguage);
	    int rows =stmt.executeUpdate();  
		
		String str1="select user_id,pre_language from users where email=?";
		PreparedStatement stmt1= con.prepareStatement(str1);
		stmt1.setString(1, u.email);
		ResultSet rs=stmt1.executeQuery();
		int uId=0;
		String preLanguage = null;
		if(rs.next())
		{
			uId=rs.getInt(1);
			System.out.println(uId);
			preLanguage=rs.getString(2);
			System.out.println(preLanguage);
		}
		Path p=Paths.get("register.txt");
		String content=u.email+","+uId+"";
		Files.write(p,content.getBytes());
		
		String str2="select movie_id from movies where movie_language=?";
		PreparedStatement stmt2= con.prepareStatement(str2);
		stmt2.setString(1, preLanguage);
		ResultSet rs1=stmt2.executeQuery();
		int mId=0;
		if(rs1.next())
		{
			mId=rs1.getInt(1);
			System.out.println(mId);
		}
		
		
		
		String str3="insert into users_watching_details_movies(watching_id,last_watching_id,user_id)values (watching_id_sq.nextval,?,?)";
		PreparedStatement stmt3= con.prepareStatement(str3);
		stmt3.setInt(1, mId);
		stmt3.setInt(2,uId);
		int rows1 =stmt3.executeUpdate();  
	     
        
		
	}

}
