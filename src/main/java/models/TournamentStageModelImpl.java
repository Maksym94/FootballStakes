package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tournament_stages")
public class TournamentStageModelImpl {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_tournament_stage")
	private int idTournamentStage;
	
	private double stage;
	
	@Column(name="active")
	private boolean active; 
	
	@Column(name="finished_stage")
	private boolean finishedStage;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="id_tournament_stage", referencedColumnName="id_tournament_stage")
	private List<TournamentGameModelImpl> tournamentGames;
	
	@ManyToOne
	@JoinColumn(name="id_tournament", referencedColumnName="id_tournament")
	private TournamentModelImpl tournament;

	public int getIdTournamentStage() {
		return idTournamentStage;
	}

	public void setIdTournamentStage(int idTournamentStage) {
		this.idTournamentStage = idTournamentStage;
	}

	/*public int getIdTournament() {
		return idTournament;
	}

	public void setIdTournament(int idTournament) {
		this.idTournament = idTournament;
	}*/

	public double getStage() {
		return stage;
	}

	public void setStage(double stage) {
		this.stage = stage;
	}

	public List<TournamentGameModelImpl> getTournamentGames() {
		return tournamentGames;
	}

	public void setTournamentGames(List<TournamentGameModelImpl> tournamentGames) {
		this.tournamentGames = tournamentGames;
	}

	public TournamentModelImpl getTournament() {
		return tournament;
	}

	public void setTournament(TournamentModelImpl tournament) {
		this.tournament = tournament;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isFinishedStage() {
		return finishedStage;
	}

	public void setFinishedStage(boolean finishedStage) {
		this.finishedStage = finishedStage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + (finishedStage ? 1231 : 1237);
		//result = prime * result + idTournament;
		result = prime * result + idTournamentStage;
		long temp;
		temp = Double.doubleToLongBits(stage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		TournamentStageModelImpl other = (TournamentStageModelImpl) obj;
		if (active != other.active)
			return false;
		if (finishedStage != other.finishedStage)
			return false;
		/*if (idTournament != other.idTournament)
			return false;*/
		if (idTournamentStage != other.idTournamentStage)
			return false;
		if (Double.doubleToLongBits(stage) != Double.doubleToLongBits(other.stage))
			return false;
		return true;
	}

}