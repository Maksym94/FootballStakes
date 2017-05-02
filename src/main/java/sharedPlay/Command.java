package sharedPlay;

import models.CommandModel;

public interface Command {
	
	public void createCommand(CommandModel command);
    public void deleteCommand(CommandModel command);
    public void updateCommand(CommandModel command);
}
