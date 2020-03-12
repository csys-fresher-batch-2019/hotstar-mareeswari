package hotstarApp.model;

import java.time.LocalDate;

public class TvShows {

	private int showId;
	private String showName;
	private String showType;
	private String showLanguage;
	private int showRatings;
	private LocalDate dateLaunchingIntoHotstar;
	private String poster;

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

	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}

	public String getShowLanguage() {
		return showLanguage;
	}

	public void setShowLanguage(String showLanguage) {
		this.showLanguage = showLanguage;
	}

	public int getShowRatings() {
		return showRatings;
	}

	public void setShowRatings(int showRatings) {
		this.showRatings = showRatings;
	}

	public LocalDate getDateLaunchingIntoHotstar() {
		return dateLaunchingIntoHotstar;
	}

	public void setDateLaunchingIntoHotstar(LocalDate dateLaunchingIntoHotstar) {
		this.dateLaunchingIntoHotstar = dateLaunchingIntoHotstar;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	@Override
	public String toString() {
		return "TvShows [showId=" + showId + ", showName=" + showName + ", showType=" + showType + ", showLanguage="
				+ showLanguage + ", showRatings=" + showRatings + ", dateLaunchingIntoHotstar="
				+ dateLaunchingIntoHotstar + ", poster=" + poster + "]";
	}

}
