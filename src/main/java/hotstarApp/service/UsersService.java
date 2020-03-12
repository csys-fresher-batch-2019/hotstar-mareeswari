package hotstarApp.service;

import java.util.List;

import hotstarApp.dao.UsersDao;
import hotstarApp.daofactory.DAOFactory;
import hotstarApp.model.Users;
import hotstarApp.validation.DbException;

public class UsersService {
	private UsersDao usersDao = DAOFactory.getUsersDao();
	public int registerNewUser(Users u) throws DbException
	{
		return(usersDao.registerNewUser(u));
	}

	public Users getUserDetails(String email) throws DbException
	{
		return(usersDao.getUserDetails(email));
	}

	//public String login(String email, String password) throws Exception;

	public String toUpp(String word) throws DbException
	{
		return(usersDao.toUpp(word));
	}
	
	public List<Users> getAllUserDetails() throws DbException
	{
		return(usersDao.getAllUserDetails());
	}

}
