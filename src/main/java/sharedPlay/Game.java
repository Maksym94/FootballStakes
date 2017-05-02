package sharedPlay;

import models.GameModel;

public interface Game {
	public boolean createGame(GameModel gameModel);
	public boolean cancelGame(GameModel gameModel);
	

}
