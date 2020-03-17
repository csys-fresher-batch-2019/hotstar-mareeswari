package hotstarapp.model;

import java.time.LocalDate;

public class Movie {

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	private int movieId;
	private String movieName;
	private String movieType;
	private String movieLanguage;
	private int movieRatings;
	private String movieDirector;
	private LocalDate movieReleasedDate;
	private LocalDate dateLaunchingIntoHotstar;
	private String videoUrl;
	private String poster;

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

	public LocalDate getMovieReleasedDate() {
		return movieReleasedDate;
	}

	public void setMovieReleasedDate(LocalDate movieReleasedDate) {
		this.movieReleasedDate = movieReleasedDate;
	}

	public LocalDate getDateLaunchingIntoHotstar() {
		return dateLaunchingIntoHotstar;
	}

	public void setDateLaunchingIntoHotstar(LocalDate dateLaunchingIntoHotstar) {
		this.dateLaunchingIntoHotstar = dateLaunchingIntoHotstar;
	}

	@Override
	public String toString() {
		return "Movies [movieId=" + movieId + ", movieName=" + movieName + ", movieType=" + movieType
				+ ", movieLanguage=" + movieLanguage + ", movieRatings=" + movieRatings + ", movieDirector="
				+ movieDirector + ", movieReleasedDate=" + movieReleasedDate + ", dateLaunchingIntoHotstar="
				+ dateLaunchingIntoHotstar + ", videoUrl=" + videoUrl + ", poster=" + poster + "]";
	}

}
