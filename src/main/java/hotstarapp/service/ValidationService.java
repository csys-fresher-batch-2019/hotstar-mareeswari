package hotstarapp.service;

import hotstarapp.dao.ValidationDAO;
import hotstarapp.daofactory.DAOFactory;
import hotstarapp.exception.ValidationException;

public class ValidationService {
	ValidationDAO validationDao=DAOFactory.getValidationDao();
	public boolean validateName(String uname) throws ValidationException, Exception
	{
		return(validationDao.validateName(uname));
	}
	public boolean validateEmail(String email) throws Exception, ValidationException
	{
		return(validationDao.validateEmail(email));
	}
	public boolean validatePhoneNo(long phoneNumber) throws ValidationException, Exception
	{
		return(validationDao.validatePhoneNo(phoneNumber));
	}
	public boolean validatePassword(String password) throws ValidationException, Exception
	{
		return(validationDao.validatePassword(password));
	}
	public String login(String email, String password) throws Exception, ValidationException
	{
		return(validationDao.login(email, password));
	}

}
