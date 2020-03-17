package hotstarapp;

import hotstarapp.dao.UserDAO;
import hotstarapp.daofactory.DAOFactory;
import hotstarapp.model.User;
import hotstarapp.service.RatingService;

public class RatingsTest {
	public static void main(String[] args) throws Exception {
		RatingService ri = new RatingService();
		UserDAO ui = DAOFactory.getUsersDao();
		User u = ui.getUserDetails("maha@gmail.com");
		int uId = u.getUserId();

		ri.putRatings(uId, 36, 5);
	}

}
