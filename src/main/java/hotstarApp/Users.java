package hotstarApp;

public class Users {
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", preLanguage=" + preLanguage + "]";
	}
	public int userId;
	public String userName;
	public String email;
	public long phoneNumber;
	public String preLanguage;
}
