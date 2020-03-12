package hotstarApp.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hotstarApp.dao.UsersDao;
import hotstarApp.dao.ValidationDao;
import hotstarApp.daofactory.DAOFactory;
import hotstarApp.model.Users;
import hotstarApp.util.ConnectionUtil;
import hotstarApp.validation.ValidationException;

public class ValidationImpl implements ValidationDao {
	public  boolean validateName(String uname) throws ValidationException, Exception

	{
		boolean userNameCheck1 = false;

		if (uname.matches("^[A-Za-z_-]{6,14}$")) {
			userNameCheck1 = true;
		} else {
			throw new ValidationException("invalid username");
		}
		if (userNameCheck1 == true) {
			return true;
		} else {
			return false;
		}

	}

	public boolean validateEmail(String email) throws Exception, ValidationException {
		boolean userNameCheck1 = false;
		boolean userNameCheck2 = false;
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		if (email.matches(regex)) {
			userNameCheck1 = true;
		} else {
			throw new ValidationException("Invalid Email");
		}

		UsersDao ml = DAOFactory.getUsersDao();
		List<Users> l = new ArrayList<Users>();
		l = ml.getAllUserDetails();
		List<String> ls = new ArrayList<String>();
		for (Users u : l) {
			ls.add(u.getEmail());
		}

		if (ls.contains(email)) {
			throw new ValidationException("username already exist");

		} else {

			userNameCheck2 = true;
		}

		if (userNameCheck1 == true && userNameCheck2 == true)
			return true;
		else
			return false;
	}

	public boolean validatePhoneNo(long phoneNumber) throws ValidationException, Exception {
		// TODO Auto-generated method stub
		boolean userNameCheck1 = false;
		if (String.valueOf(phoneNumber).length() > 10) {
			throw new ValidationException("Invalid Phone Number");
		} else {
			userNameCheck1 = true;
		}

		if (userNameCheck1 == true) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validatePassword(String password) throws ValidationException, Exception {
		// TODO Auto-generated method stub
		boolean userNameCheck1 = false;
		if (password.length() >= 6 && password.length() <= 12) {
			userNameCheck1 = true;
		} else {

			throw new ValidationException("Invalid Password");
		}

		if (userNameCheck1 == true) {
			return true;
		} else {
			return false;
		}
	}
	public String login(String email, String password) throws Exception, ValidationException {

		String s = null;
		String str = "select * from users where email=? and  password=?";
		Connection con = ConnectionUtil.dbConnect();
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
			e.printStackTrace();
		}

		con.close();
		return (s);
	}

}
