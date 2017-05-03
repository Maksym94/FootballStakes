package regularPlay;

import models.RegularCommandModelImpl;

public interface RegularCommand {

	public void createCommand(RegularCommandModelImpl command);

	public void updateCommand(RegularCommandModelImpl command);

	public void deleteCommand(RegularCommandModelImpl command);

}
