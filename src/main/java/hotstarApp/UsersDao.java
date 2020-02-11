package hotstarApp;

public interface UsersDao {
	public void registerNewUser(Users u)throws Exception;
	public String[] getUserDetails()throws Exception;
	public String login(String email,String password) throws Exception;
}
