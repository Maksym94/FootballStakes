package models;

import org.joda.time.DateTime;

public interface GameModel {
	
	public void setIdCommand1(int idCommand1);
	public void setIdCommand2(int idCommand2);
	public void setScoreCommand1(int scoreCommand1);
	public void setScoreCommand2(int scoreCommand2);
	public void setFinishedGame(boolean isFinished);
	public void setStartGameDate(DateTime startDate);
	public int getIdCommand1();
	public int getIdCommand2();
	public int getScoreCommand1();
	public int getScoreCommand2();
	public boolean isFinishedGame();
	public DateTime getStartGameDate();
}
