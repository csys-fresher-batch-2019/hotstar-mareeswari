package hotstarapp.dao;

import java.util.List;

import hotstarapp.exception.DbException;
import hotstarapp.model.User;

public interface UserDAO {
	public int registerNewUser(User u) throws DbException;

	public User getUserDetails(String email) throws DbException;

	//public String login(String email, String password) throws Exception;

	public String toUpp(String word) throws DbException;
	
	public List<User> getAllUserDetails() throws DbException;
}
