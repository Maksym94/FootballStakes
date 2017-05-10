package tournamentPlay;

import java.util.List;

import models.TournamentCommandModelImpl;

public interface TournamentCommand {
	
	public boolean createCommand(TournamentCommandModelImpl command, String resourcePath);

	public void updateCommand(TournamentCommandModelImpl command);

	public void deleteCommand(TournamentCommandModelImpl command);
	
	List<TournamentCommandModelImpl> getAllCommands();
	
}
