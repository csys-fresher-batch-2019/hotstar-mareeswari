package hotstarApp;

import java.util.Scanner;

public class LoginTest {
	public static final LoggerUtil logger=LoggerUtil.getInstance();

public static void main(String[] args) throws Exception {
UsersDao ui=DAOFactory.getUsersDao();
Scanner sc=new Scanner(System.in);
String email=sc.nextLine();
String password=sc.nextLine();
String s=ui.login(email, password);
logger.info(s);
sc.close();
}

}

