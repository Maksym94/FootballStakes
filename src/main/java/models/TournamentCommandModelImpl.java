package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tournament_commands")
public class TournamentCommandModelImpl implements CommandModel{
	
	@Id
	@Column(name="id_tournament_command")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idTournamentCommand;
	
	@Column(name="command_name")
	private String commandName;
	
	private String history;
	
	@Column(name="trainer")
	private String trainerName;
	
	@Column(name="year_foundation")
	private int yearFoundation;
	
	@Column(name="photo_path")
	private String photoPath;
	
	@Column(name="won_games")
	private int wonGames;
	
	@Column(name="lose_games")
	private int loseGames;
	
	@Column(name="goals_scored")
	private int goalsScored;
	
	@Column(name="winning_cups")
	private int winningCups;
	
	public int getIdTournamentCommand() {
		return idTournamentCommand;
	}
	public void setIdTournamentCommand(int idTournamentCommand) {
		this.idTournamentCommand = idTournamentCommand;
	}
	public String getCommandName() {
		return commandName;
	}
	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public int getYearFoundation() {
		return yearFoundation;
	}
	public void setYearFoundation(int yearFoundation) {
		this.yearFoundation = yearFoundation;
	}
	
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	public int getWonGames() {
		return wonGames;
	}
	public void setWonGames(int wonGames) {
		this.wonGames = wonGames;
	}
	public int getLoseGames() {
		return loseGames;
	}
	public void setLoseGames(int loseGames) {
		this.loseGames = loseGames;
	}
	public int getGoalsScored() {
		return goalsScored;
	}
	public void setGoalsScored(int goalsScored) {
		this.goalsScored = goalsScored;
	}
	public int getWinningCups() {
		return winningCups;
	}
	public void setWinningCups(int winningCups) {
		this.winningCups = winningCups;
	}

}
