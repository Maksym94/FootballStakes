package regularPlay;

import java.util.List;

import models.RegularGameModelImpl;

public interface RegularGame {
	int FIRST_COMMAND_WON = -1;
	int DRAW = 2;
	int SECOND_COMMAND_WON = 1;

	boolean createGame(RegularGameModelImpl regularGame);

	void deleteGame(RegularGameModelImpl regularGame);

	List<RegularGameModelImpl> getAllGames();

	RegularGameModelImpl getGame(int id);

}
