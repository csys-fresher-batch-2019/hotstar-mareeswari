package hotstarApp;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import hotstarApp.RatingsDaoImpl;

public class RatingsTest {
	public static void main(String[] args) throws Exception {
		RatingsDao ri=DAOFactory.getRatingsDao();
		UsersDao ui=DAOFactory.getUsersDao();
		String user[]=ui.getUserDetails();
		int uId =Integer.parseInt(user[1]);

		ri.putRatings(uId,36, 5);
	}

}
