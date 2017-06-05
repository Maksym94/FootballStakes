package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tournament")
public class TournamentModelImpl {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_tournament")
	private int idTournament;
	
	@Column(name="tournament_name")
	private String tournamentName;
	
	@Column(name="year_of_playing")
	private int yearOfPlaying;
	
	@Column(name="max_amount_stages")
	private int maxAmountOfStages;
	
	@Column(name="max_amount_commands")
	private int maxAmountOfCommands;
	
	@Column(name="active")
	private boolean active;
	
	@Column(name="finished_tournament")
	private boolean finishedTournament;
	
	@OneToMany
	@JoinColumn(name="id_tournament", referencedColumnName="id_tournament")
	private List<TournamentStageImpl> tournamentStages;

	public int getIdTournament() {
		return idTournament;
	}

	public void setIdTournament(int idTournament) {
		this.idTournament = idTournament;
	}

	public String getTournamentName() {
		return tournamentName;
	}

	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}

	public int getYearOfPlaying() {
		return yearOfPlaying;
	}

	public void setYearOfPlaying(int yearOfPlaying) {
		this.yearOfPlaying = yearOfPlaying;
	}

	public List<TournamentStageImpl> getTournamentStages() {
		return tournamentStages;
	}

	public void setTournamentStages(List<TournamentStageImpl> tournamentStages) {
		this.tournamentStages = tournamentStages;
	}

	
	public int getMaxAmountOfStages() {
		return maxAmountOfStages;
	}

	public void setMaxAmountOfStages(int maxAmountOfStages) {
		this.maxAmountOfStages = maxAmountOfStages;
	}

	public int getMaxAmountOfCommands() {
		return maxAmountOfCommands;
	}

	public void setMaxAmountOfCommands(int maxAmountOfCommands) {
		this.maxAmountOfCommands = maxAmountOfCommands;
	}
	
	public boolean isFinishedTournament() {
		return finishedTournament;
	}

	public void setFinishedTournament(boolean finishedTournament) {
		this.finishedTournament = finishedTournament;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (finishedTournament ? 1231 : 1237);
		result = prime * result + idTournament;
		result = prime * result + maxAmountOfCommands;
		result = prime * result + maxAmountOfStages;
		result = prime * result + ((tournamentName == null) ? 0 : tournamentName.hashCode());
		result = prime * result + yearOfPlaying;
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
		TournamentModelImpl other = (TournamentModelImpl) obj;
		if (finishedTournament != other.finishedTournament)
			return false;
		if (idTournament != other.idTournament)
			return false;
		if (maxAmountOfCommands != other.maxAmountOfCommands)
			return false;
		if (maxAmountOfStages != other.maxAmountOfStages)
			return false;
		if (tournamentName == null) {
			if (other.tournamentName != null)
				return false;
		} else if (!tournamentName.equals(other.tournamentName))
			return false;
		if (yearOfPlaying != other.yearOfPlaying)
			return false;
		return true;
	}


}
