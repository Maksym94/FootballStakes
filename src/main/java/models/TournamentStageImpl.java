package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tournament_stages")
public class TournamentStageImpl {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_tournament_stage")
	private int idTournamentStage;
	
	@Column(name="id_tournament")
	private int idTournament;
	
	private double stage;
	
	@Column(name="active")
	private boolean active;
	
	@Column(name="finished_stage")
	private boolean finishedStage;
	
	@OneToMany
	@JoinColumn(name="id_tournament_stage", referencedColumnName="id_tournament_stage")
	private List<TournamentGameModelImpl> tournamentGames;
	
	@ManyToOne
	@JoinColumn(name="id_tournament")
	private TournamentModelImpl tournament;

	public int getIdTournamentStage() {
		return idTournamentStage;
	}

	public void setIdTournamentStage(int idTournamentStage) {
		this.idTournamentStage = idTournamentStage;
	}

	public int getIdTournament() {
		return idTournament;
	}

	public void setIdTournament(int idTournament) {
		this.idTournament = idTournament;
	}

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

}