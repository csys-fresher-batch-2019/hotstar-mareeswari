package hotstarApp;

import java.sql.Date;


public class Movies {
	
	
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public int movieId;
	public String movieName;
	public String movieType;
	public String movieLanguage;
	public int movieRatings;
	public String movieDirector;
	public Date movieReleasedDate;
	public Date dateLaunchingIntoHotstar;
	public String videoUrl;
	
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieType() {
		return movieType;
	}
	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}
	public String getMovieLanguage() {
		return movieLanguage;
	}
	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}
	public int getMovieRatings() {
		return movieRatings;
	}
	public void setMovieRatings(int movieRatings) {
		this.movieRatings = movieRatings;
	}
	public String getMovieDirector() {
		return movieDirector;
	}
	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}
	public Date getMovieReleasedDate() {
		return movieReleasedDate;
	}
	public void setMovieReleasedDate(Date movieReleasedDate) {
		this.movieReleasedDate = movieReleasedDate;
	}
	public Date getDateLaunchingIntoHotstar() {
		return dateLaunchingIntoHotstar;
	}
	public void setDateLaunchingIntoHotstar(Date dateLaunchingIntoHotstar) {
		this.dateLaunchingIntoHotstar = dateLaunchingIntoHotstar;
	}
	@Override
	public String toString() {
		return "Movies [movieId=" + movieId + ", movieName=" + movieName + ", movieType=" + movieType
				+ ", movieLanguage=" + movieLanguage + ", movieRatings=" + movieRatings + ", movieDirector="
				+ movieDirector + ", movieReleasedDate=" + movieReleasedDate + ", dateLaunchingIntoHotstar="
				+ dateLaunchingIntoHotstar + ", videoUrl=" + videoUrl + "]";
	}

}
