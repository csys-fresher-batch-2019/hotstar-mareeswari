package hotstarapp;

import java.util.Scanner;

import hotstarapp.exception.ValidationException;
import hotstarapp.service.ValidationService;
import hotstarapp.util.LoggerUtil;

public class LoginTest {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public static void main(String[] args) throws Exception {

		ValidationService lv = new ValidationService();
		Scanner sc = new Scanner(System.in);
		String email = sc.nextLine();
		String password = sc.nextLine();
		try {
			String s = lv.login(email, password);
			logger.info(s);
		}catch (ValidationException e) {
			// TODO: handle exception
			logger.error(e.getMessage());
		}
		catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());

		}
		sc.close();
	}

}
