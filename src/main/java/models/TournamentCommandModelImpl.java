package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="tournament_commands")
public class TournamentCommandModelImpl implements CommandModel{
	
	@Id
	@Column(name = "id_tournament_command")
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="winnerCommand" )
	@Fetch(value = FetchMode.SUBSELECT)
	/*@JoinColumn(referencedColumnName="winner_cup_id_command")*/
	private List<TournamentModelImpl> winnerCupsInTournaments;
	
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
	public List<TournamentModelImpl> getWinnerCupsInTournaments() {
		return winnerCupsInTournaments;
	}
	public void setWinnerCupsInTournaments(List<TournamentModelImpl> winnerCupsInTournaments) {
		this.winnerCupsInTournaments = winnerCupsInTournaments;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commandName == null) ? 0 : commandName.hashCode());
		result = prime * result + goalsScored;
		result = prime * result + ((history == null) ? 0 : history.hashCode());
		result = prime * result + idTournamentCommand;
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
		TournamentCommandModelImpl other = (TournamentCommandModelImpl) obj;
		if (commandName == null) {
			if (other.commandName != null)
				return false;
		} else if (!commandName.equals(other.commandName))
			return false;
		if (goalsScored != other.goalsScored)
			return false;
		if (history == null) {
			if (other.history != null)
				return false;
		} else if (!history.equals(other.history))
			return false;
		if (idTournamentCommand != other.idTournamentCommand)
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
