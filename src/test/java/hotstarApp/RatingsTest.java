package hotstarApp;

import hotstarApp.RatingsDaoImpl;

public class RatingsTest {
	public static void main(String[] args) throws Exception {
		RatingsDaoImpl ri=new RatingsDaoImpl();
		ri.putRatings(36,32, 5);
	}

}
