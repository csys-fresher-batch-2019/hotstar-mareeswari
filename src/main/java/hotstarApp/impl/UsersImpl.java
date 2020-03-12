package hotstarApp.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hotstarApp.dao.UsersDao;
import hotstarApp.model.Users;
import hotstarApp.util.ConnectionUtil;
import hotstarApp.validation.DbException;

public class UsersImpl implements UsersDao {

	public int registerNewUser(Users u) throws DbException {
		int rows=0;
		Connection con=null;
		String str = "insert into users(user_id,user_name,email,phone_no,pre_language,password) values(user_id_sq.nextval,lower(?),lower(?),?,lower(?),?)";

		try {
			con = ConnectionUtil.dbConnect();
		
		PreparedStatement stmt = con.prepareStatement(str);
		stmt.setString(1, u.getUserName());
		stmt.setString(2, u.getEmail());
		stmt.setLong(3, u.getPhoneNumber());
		stmt.setString(4, u.getPreLanguage());
		stmt.setString(5, u.getPassword());
		
		 rows = stmt.executeUpdate();
		 con.close();

		
		}catch (SQLException e) {
			// TODO: handle exception
			throw new DbException("Unable to register");
			
		}catch (Exception e) {
			// TODO: handle exception
			throw new DbException("DB Connection Error");
		}
			
		
		
		return (rows);

	}

	public Users getUserDetails(String email) throws DbException {
		String str = "select * from users where email=? ";
		
		Users u = new Users();
		try (
				Connection con = ConnectionUtil.dbConnect();
				PreparedStatement stmt = con.prepareStatement(str)) {
			stmt.setString(1, email);

			try (ResultSet rs = stmt.executeQuery()) {

				if (rs.next()) {
					u.setUserId(rs.getInt(1));
					u.setUserName(rs.getString(2));
					u.setEmail(rs.getString(3));
					u.setPhoneNumber(rs.getLong(4));
					u.setPreLanguage(rs.getString(5));
					u.setPassword(rs.getString(6));
				}

			}
			catch (SQLException e) {
				// TODO: handle exception
				throw new DbException("Invalid Select");
			}
			con.close();
		} catch (SQLException e) {
			// TODO: handle exception
			throw new DbException("DB Connection Error");
		}
		return u;
	}

/*	public String login(String email, String password) throws Exception, ValidationException {

		String s = null;
		String str = "select * from users where email=? and  password=?";
		Connection con = DBConnection.dbConnect();
		try (

				PreparedStatement stmt = con.prepareStatement(str)) {
			stmt.setString(1, email);
			stmt.setString(2, password);
			try (ResultSet rs = stmt.executeQuery()) {

				if (rs.next()) {
					if (rs.getInt("admin") == 1)
						s = "admin";
					else
						s = "user";
				} else {
					s = "failure";
					throw new ValidationException("Login Failed");
				}
			}
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new DbException("Invalid Select");
		}
		// get preferable language

		con.close();
		return (s);
	}*/

	public String toUpp(String word) throws DbException {
		String first = word.substring(0, 1);
		String f_after = word.substring(1);
		String res = first.toUpperCase() + f_after;

		return (res);
	}

	public List<Users> getAllUserDetails() throws DbException {
		String str = "select * from users ";
		
		List<Users> l = new ArrayList<Users>();
		try (
				Connection con = ConnectionUtil.dbConnect();
				PreparedStatement stmt = con.prepareStatement(str)) {

			try (ResultSet rs = stmt.executeQuery()) {

				while (rs.next()) {
					Users u = new Users();
					u.setUserId(rs.getInt(1));
					u.setUserName(rs.getString(2));
					u.setEmail(rs.getString(3));
					u.setPhoneNumber(rs.getLong(4));
					u.setPreLanguage(rs.getString(5));
					u.setPassword(rs.getString(6));
					l.add(u);
				}

			}
			catch (SQLException e) {
				// TODO: handle exception
				throw new DbException("Invalid Select");
			}
			
			con.close();
		} catch (SQLException e) {
			// TODO: handle exception
			throw new DbException("DB Connection Error");
		}
		return l;
	}

}
