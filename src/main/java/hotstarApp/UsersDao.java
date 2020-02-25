package hotstarApp;

public interface UsersDao {
	public int registerNewUser(Users u)throws Exception;
	public Users getUserDetails(String email)throws Exception;
	public String login(String email,String password) throws Exception;
	public String toUpp(String word)throws Exception;
}
