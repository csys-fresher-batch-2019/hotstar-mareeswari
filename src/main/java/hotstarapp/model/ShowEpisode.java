package hotstarapp.model;

import java.util.Date;

public class ShowEpisode {

	private int episodeId;
	private int showId;
	public int getEpisodeId() {
		return episodeId;
	}

	public void setEpisodeId(int episodeId) {
		this.episodeId = episodeId;
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

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

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	private String showName;
	private int episodeNo;
	private Date episodeDate;
	private String videoUrl;

	@Override
	public String toString() {
		return "ShowEpisodes [episodeId=" + episodeId + ", showId=" + showId + ", showName=" + showName + ", episodeNo="
				+ episodeNo + ", episodeDate=" + episodeDate + ", videoUrl=" + videoUrl + "]";
	}

}
