package models;

//Maybe make it's abstract class instead of interface
public interface CommandModel {
	
	public void setCommandName(String name);
	public void setHistory(String history);
	public void setTrainerName(String trainer);
	public void setWonGames(int quantityOfWonGames);
	public void setLoseGames(int quantityOfLoseGames);
	public String getCommandName();
	public String getHistory();
	public String getTrainerName();
	public int getWonGames();
	public int getLoseGames();
}
