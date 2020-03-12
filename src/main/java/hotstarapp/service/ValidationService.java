package hotstarApp.service;

import hotstarApp.dao.ValidationDao;
import hotstarApp.daofactory.DAOFactory;
import hotstarApp.validation.ValidationException;

public class ValidationService {
	ValidationDao validationDao=DAOFactory.getValidationDao();
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
