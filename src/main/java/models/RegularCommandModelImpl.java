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
	
	@Column(name="country_of_origin")
	private String countryOfOrigin;
	
	@Column(name="won_games")
	private int wonGames;
	
	@Column(name="lose_games")
	private int loseGames;
	
	@Column(name="draw_games")
	private int drawGames;
	
	@Column(name="goals_scored")
	private int goalsScored;
	
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
	
	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
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
	
	public int getGoalsScored() {
		return goalsScored;
	}

	public void setGoalsScored(int goalsScored) {
		this.goalsScored = goalsScored;
	}

	public String getPhotoPath() {
		return photoPath;
	}
	
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commandName == null) ? 0 : commandName.hashCode());
		result = prime * result + ((countryOfOrigin == null) ? 0 : countryOfOrigin.hashCode());
		result = prime * result + drawGames;
		result = prime * result + goalsScored;
		result = prime * result + ((history == null) ? 0 : history.hashCode());
		result = prime * result + idRegularCommand;
		result = prime * result + loseGames;
		result = prime * result + ((photoPath == null) ? 0 : photoPath.hashCode());
		result = prime * result + ((trainerName == null) ? 0 : trainerName.hashCode());
		result = prime * result + wonGames;
		result = prime * result + yearFoundation;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegularCommandModelImpl other = (RegularCommandModelImpl) obj;
		if (commandName == null) {
			if (other.commandName != null)
				return false;
		} else if (!commandName.equals(other.commandName))
			return false;
		if (countryOfOrigin == null) {
			if (other.countryOfOrigin != null)
				return false;
		} else if (!countryOfOrigin.equals(other.countryOfOrigin))
			return false;
		if (drawGames != other.drawGames)
			return false;
		if (goalsScored != other.goalsScored)
			return false;
		if (history == null) {
			if (other.history != null)
				return false;
		} else if (!history.equals(other.history))
			return false;
		if (idRegularCommand != other.idRegularCommand)
			return false;
		if (loseGames != other.loseGames)
			return false;
		if (photoPath == null) {
			if (other.photoPath != null)
				return false;
		} else if (!photoPath.equals(other.photoPath))
			return false;
		if (trainerName == null) {
			if (other.trainerName != null)
				return false;
		} else if (!trainerName.equals(other.trainerName))
			return false;
		if (wonGames != other.wonGames)
			return false;
		if (yearFoundation != other.yearFoundation)
			return false;
		return true;
	}
	
}
