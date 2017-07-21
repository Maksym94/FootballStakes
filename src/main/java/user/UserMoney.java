package user;

import models.UserModelImpl;
import models.UserOperationModelImpl;

public interface UserMoney {
	
	public boolean addMoney(UserModelImpl user, UserOperationModelImpl userOperation);
	public boolean getMoney(UserModelImpl user, UserOperationModelImpl userOperation);
	public void deleteOperation(UserModelImpl user, UserOperationModelImpl userOperation);
	public UserOperationModelImpl getOperationById(int index);

}
