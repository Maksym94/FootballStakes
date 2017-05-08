package regularPlay;

import java.util.List;

import models.RegularCommandModelImpl;

public interface RegularCommand {

	public boolean createCommand(RegularCommandModelImpl command, String resourcePath);

	public void updateCommand(RegularCommandModelImpl command);

	public void deleteCommand(RegularCommandModelImpl command);
	
	public List<RegularCommandModelImpl> getCommands();

}
