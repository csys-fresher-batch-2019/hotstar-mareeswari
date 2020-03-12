package hotstarApp;

import hotstarApp.dao.UsersDao;
import hotstarApp.daofactory.DAOFactory;
import hotstarApp.model.Users;
import hotstarApp.service.RatingsService;

public class RatingsTest {
	public static void main(String[] args) throws Exception {
		RatingsService ri = new RatingsService();
		UsersDao ui = DAOFactory.getUsersDao();
		Users u = ui.getUserDetails("maha@gmail.com");
		int uId = u.getUserId();

		ri.putRatings(uId, 36, 5);
	}

}
