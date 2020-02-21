package hotstarApp;

import java.sql.Date;

public class TvShows {
	
	public int showId;
	public String showName;
	public String showType;
	public String showLanguage;
	public int showRatings;
	public Date dateLaunchingIntoHotstar;
	public String poster;
	@Override
	public String toString() {
		return "TvShows [showId=" + showId + ", showName=" + showName + ", showType=" + showType + ", showLanguage="
				+ showLanguage + ", showRatings=" + showRatings + ", dateLaunchingIntoHotstar="
				+ dateLaunchingIntoHotstar + ", poster=" + poster + "]";
	}
	
}
