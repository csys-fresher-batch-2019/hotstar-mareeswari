package hotstarApp;

import java.util.Date;

public class ShowEpisodes {
	
	public int episodeId;
	public int showId;
	public String showName;
	public int episodeNo;
	public Date episodeDate;
	public String videoUrl;
	@Override
	public String toString() {
		return "ShowEpisodes [episodeId=" + episodeId + ", showId=" + showId + ", showName=" + showName + ", episodeNo="
				+ episodeNo + ", episodeDate=" + episodeDate + ", videoUrl=" + videoUrl + "]";
	}

}
