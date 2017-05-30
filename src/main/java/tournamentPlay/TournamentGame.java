package tournamentPlay;

import java.util.List;

import models.TournamentGameModelImpl;

public interface TournamentGame{
	int FIRST_COMMAND_WON = -1;
	int SECOND_COMMAND_WON = 1;

	boolean createGame(TournamentGameModelImpl tournamentGame);
	
	void updateGame(TournamentGameModelImpl tournamentGame);

	void deleteGame(TournamentGameModelImpl tournamentGame);

	List<TournamentGameModelImpl> getAllGames();

	TournamentGameModelImpl getGame(int id);
}
