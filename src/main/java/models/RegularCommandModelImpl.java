package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="regular_commands")
public class RegularCommandModelImpl implements CommandModel{
	
	@Id
	@Column(name="id_regular_command")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idRegularCommand;
	
	@Column(name="command_name")
	private String commandName;
	
	@Column(name="history")
	private String history;
	
	@Column(name="trainer_name")
	private String trainerName;
	
	@Column(name="won_games")
	private int wonGames;
	
	@Column(name="lose_games")
	private int loseGames;
	
	@Column(name="draw_games")
	private int drawGames;
	
	@Column(name="photo_path")
	private String photoPath;
	
	@Column(name="year_foundation")
	private int yearFoundation;
	
	public int getYearFoundation() {
		return yearFoundation;
	}

	public void setYearFoundation(int yearFoundation) {
		this.yearFoundation = yearFoundation;
	}

	public int getIdRegularCommand() {
		return idRegularCommand;
	}

	public void setIdRegularCommand(int idRegularCommand) {
		this.idRegularCommand = idRegularCommand;
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
	
	public int getDrawGames() {
		return drawGames;
	}
	
	public void setDrawGames(int drawGames) {
		this.drawGames = drawGames;
	}
	
	public String getPhotoPath() {
		return photoPath;
	}
	
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	

	
}
