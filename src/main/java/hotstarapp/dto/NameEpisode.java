package hotstarapp.dto;

import java.util.Date;

public class NameEpisode {
	@Override
	public String toString() {
		return "NameEpisode [showName : " + showName + " -> episodeNo : " + episodeNo + " -> episodeDate : "
				+ episodeDate + "]";
	}

	private String showName;
	private int episodeNo;
	private Date episodeDate;
	public String getShowName() {
		return showName;
	}
	public void setShowName(String showName) {
		this.showName = showName;
	}
	public int getEpisodeNo() {
		return episodeNo;
	}
	public void setEpisodeNo(int episodeNo) {
		this.episodeNo = episodeNo;
	}
	public Date getEpisodeDate() {
		return episodeDate;
	}
	public void setEpisodeDate(Date episodeDate) {
		this.episodeDate = episodeDate;
	}
}
