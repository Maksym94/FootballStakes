package tournamentPlay;

import models.TournamentCommandModelImpl;

public interface TournamentCommand {
	
	public void createCommand(TournamentCommandModelImpl command, String resourcePath);

	public void updateCommand(TournamentCommandModelImpl command);

	public void deleteCommand(TournamentCommandModelImpl command);
	
}
