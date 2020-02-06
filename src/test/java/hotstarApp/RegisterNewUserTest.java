package hotstarApp;



import java.util.Scanner;

import hotstarApp.Users;
import hotstarApp.UsersDaoImpl;




public class RegisterNewUserTest {
		public static void main(String[] args) throws Exception {
			UsersDaoImpl u=new UsersDaoImpl() ;
			
			Scanner sc=new Scanner(System.in);
			
			
				Users u1=new Users();
				System.out.println("Enter user name :\n");
				u1.userName=sc.nextLine();
				System.out.println("Enter user email:\n");
				u1.email=sc.nextLine();
				System.out.println("Enter user phone number :\n");
				u1.phoneNumber=Long.parseLong(sc.nextLine());
				System.out.println("Enter user preferred language :\n");
				
				u1.preLanguage=sc.nextLine();
				u.registerNewUser(u1);
				
			     sc.close();
		}
}
