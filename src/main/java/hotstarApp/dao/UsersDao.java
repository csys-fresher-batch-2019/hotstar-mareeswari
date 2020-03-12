package hotstarApp.dao;

import java.util.List;

import hotstarApp.model.Users;
import hotstarApp.validation.DbException;

public interface UsersDao {
	public int registerNewUser(Users u) throws DbException;

	public Users getUserDetails(String email) throws DbException;

	//public String login(String email, String password) throws Exception;

	public String toUpp(String word) throws DbException;
	
	public List<Users> getAllUserDetails() throws DbException;
}
