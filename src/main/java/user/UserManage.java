package user;

import java.util.List;

import models.LoginModelImpl;
import models.UserModelImpl;

public interface UserManage {
	
	public boolean createUser(LoginModelImpl credentials);
	public boolean updateUser(UserModelImpl user);
	public void deleteUser(UserModelImpl user);
	public List<UserModelImpl> getAllUsers();
	//public boolean validateUserCredentials(LoginModelImpl credentials);
	public LoginModelImpl getCredentialsByName(String login);
	public UserModelImpl getUserByName(String login);
	public UserModelImpl getUserById(int index);

}
