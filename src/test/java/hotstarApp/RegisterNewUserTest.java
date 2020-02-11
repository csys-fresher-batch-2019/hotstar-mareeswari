package hotstarApp;



import java.util.Scanner;

import hotstarApp.Users;
import hotstarApp.UsersDaoImpl;




public class RegisterNewUserTest {	
	public static final LoggerUtil logger=LoggerUtil.getInstance();

	
		public static void main(String[] args) throws Exception {
			UsersDao u=DAOFactory.getUsersDao();
			
			Scanner sc=new Scanner(System.in);
			
			
				Users u1=new Users();
				logger.debug("Enter user name :\n");
				u1.userName=sc.nextLine();
				logger.debug("Enter user email:\n");
				u1.email=sc.nextLine();
				logger.debug("Enter user phone number :\n");
				u1.phoneNumber=Long.parseLong(sc.nextLine());
				logger.debug("Enter user preferred language :\n");
				
				u1.preLanguage=sc.nextLine();
				logger.debug("Enter password:");
				u1.password=sc.nextLine();
				u.registerNewUser(u1);
				
			     sc.close();
		}
}
