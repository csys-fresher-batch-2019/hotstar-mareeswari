package hotstarApp;

import java.util.Scanner;

import javax.xml.bind.ValidationException;

import hotstarApp.model.Users;
import hotstarApp.service.UsersService;
import hotstarApp.service.ValidationService;
import hotstarApp.util.LoggerUtil;

public class RegisterNewUserTest {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public static void main(String[] args) throws Exception {
		UsersService u = new UsersService();
		ValidationService v = new ValidationService();
		boolean uname = false;
		boolean uemail = false;
		boolean uphoneNo = false;
		boolean upassword = false;

		Scanner sc = new Scanner(System.in);

		Users u1 = new Users();

		logger.debug("Enter user name :(IN SMALL CASE)\n");
		u1.setUserName( sc.next());
		try {
			uname = v.validateName(u1.getUserName());
		} catch (ValidationException e) {
			logger.error(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		logger.debug("Enter user email:\n");
		u1.setEmail(sc.next());
		try {
			uemail = v.validateEmail(u1.getEmail());
		} catch (ValidationException e) {
			logger.error(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		logger.debug("Enter user phone number :\n");
		u1.setPhoneNumber (Long.parseLong(sc.next()));
		try {
			uphoneNo = v.validatePhoneNo(u1.getPhoneNumber());
		} catch (ValidationException e) {
			logger.error(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		logger.debug("Enter user preferred language :\n");
		u1.setPreLanguage(sc.next());

		logger.debug("Enter password:(LENGTH:6-12)");
		u1.setPassword(sc.next());
		try {
			upassword = v.validatePassword(u1.getPassword());
		} catch (ValidationException e) {
			logger.error(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		if (uname == true && uemail == true && uphoneNo == true && upassword == true) {
			try {
				u.registerNewUser(u1);
				logger.info("Inserted Successfully");
			} catch (Exception e) {
				// TODO: handle exception
				logger.error("DBException : " + e.getMessage());
			}
		}

		sc.close();
	}
}
