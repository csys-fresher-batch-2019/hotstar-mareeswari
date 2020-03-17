package hotstarapp.service;

import java.util.List;

import hotstarapp.dao.UserDAO;
import hotstarapp.daofactory.DAOFactory;
import hotstarapp.exception.DbException;
import hotstarapp.model.User;

public class UserService {
	private UserDAO usersDao = DAOFactory.getUsersDao();
	public int registerNewUser(User u) throws DbException
	{
		return(usersDao.registerNewUser(u));
	}

	public User getUserDetails(String email) throws DbException
	{
		return(usersDao.getUserDetails(email));
	}

	//public String login(String email, String password) throws Exception;

	public String toUpp(String word) throws DbException
	{
		return(usersDao.toUpp(word));
	}
	
	public List<User> getAllUserDetails() throws DbException
	{
		return(usersDao.getAllUserDetails());
	}

}
