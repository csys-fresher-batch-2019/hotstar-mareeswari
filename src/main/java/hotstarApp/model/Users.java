package hotstarApp.model;

public class Users {
	

	private int userId;
	private String userName;
	private String email;
	private long phoneNumber;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", preLanguage=" + preLanguage + ", password=" + password + "]";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPreLanguage() {
		return preLanguage;
	}
	public void setPreLanguage(String preLanguage) {
		this.preLanguage = preLanguage;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String preLanguage;
	private String password;
}
