package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name="tournament_games")
public class TournamentGameModelImpl {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="id_tournament_game")
private int idTournamentGame;

@Column(name="id_command1")
private int idCommand1;

@Column(name="id_command2")
private int idCommand2;

@Column(name="score_command1")
private int scoreCommand1;

@Column(name="score_command2")
private int scoreCommand2;

@Column(name="coefficient_first_command")
private double coefficientFirstCommand;

@Column(name="coefficient_second_command")
private double coefficientSecondCommand;

@Column(name="start_game_date")
@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
private DateTime startGameDate;

@Column(name="finished_game")
private boolean finishedGame;

@Column(name="result_of_game")
private int resultOfGame;

@Column(name="id_tournament")
private int idTournament;

@ManyToOne
@JoinColumn(name="id_command1", insertable=false, updatable=false)
private TournamentCommandModelImpl tournamentCommand1;

@ManyToOne
@JoinColumn(name="id_command2",insertable=false, updatable=false)
private TournamentCommandModelImpl tournamentCommand2;

public int getIdTournamentGame() {
	return idTournamentGame;
}

public void setIdTournamentGame(int idTournamentGame) {
	this.idTournamentGame = idTournamentGame;
}

public int getIdCommand1() {
	return idCommand1;
}

public void setIdCommand1(int idCommand1) {
	this.idCommand1 = idCommand1;
}

public int getIdCommand2() {
	return idCommand2;
}

public void setIdCommand2(int idCommand2) {
	this.idCommand2 = idCommand2;
}

public int getScoreCommand1() {
	return scoreCommand1;
}

public void setScoreCommand1(int scoreCommand1) {
	this.scoreCommand1 = scoreCommand1;
}

public int getScoreCommand2() {
	return scoreCommand2;
}

public void setScoreCommand2(int scoreCommand2) {
	this.scoreCommand2 = scoreCommand2;
}

public double getCoefficientFirstCommand() {
	return coefficientFirstCommand;
}

public void setCoefficientFirstCommand(double coefficientFirstCommand) {
	this.coefficientFirstCommand = coefficientFirstCommand;
}

public double getCoefficientSecondCommand() {
	return coefficientSecondCommand;
}

public void setCoefficientSecondCommand(double coefficientSecondCommand) {
	this.coefficientSecondCommand = coefficientSecondCommand;
}

public DateTime getStartGameDate() {
	return startGameDate;
}

public void setStartGameDate(DateTime startGameDate) {
	this.startGameDate = startGameDate;
}

public boolean isFinishedGame() {
	return finishedGame;
}

public void setFinishedGame(boolean finishedGame) {
	this.finishedGame = finishedGame;
}

public int getResultOfGame() {
	return resultOfGame;
}

public void setResultOfGame(int resultOfGame) {
	this.resultOfGame = resultOfGame;
}

public int getIdTournament() {
	return idTournament;
}

public void setIdTournament(int idTournament) {
	this.idTournament = idTournament;
}

public TournamentCommandModelImpl getTournamentCommand1() {
	return tournamentCommand1;
}

public void setTournamentCommand1(TournamentCommandModelImpl tournamentCommand1) {
	this.tournamentCommand1 = tournamentCommand1;
}

public TournamentCommandModelImpl getTournamentCommand2() {
	return tournamentCommand2;
}

public void setTournamentCommand2(TournamentCommandModelImpl tournamentCommand2) {
	this.tournamentCommand2 = tournamentCommand2;
}

}
