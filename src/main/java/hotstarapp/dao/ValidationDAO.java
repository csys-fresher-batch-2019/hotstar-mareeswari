package hotstarapp.dao;

import hotstarapp.exception.ValidationException;

public interface ValidationDAO {
	public boolean validateName(String uname) throws ValidationException, Exception;
	public boolean validateEmail(String email) throws Exception, ValidationException;
	public boolean validatePhoneNo(long phoneNumber) throws ValidationException, Exception;
	public boolean validatePassword(String password) throws ValidationException, Exception;
	public String login(String email, String password) throws Exception, ValidationException;
}
