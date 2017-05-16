package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name="regular_games")
public class RegularGameModelImpl implements GameModel{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_regular_game")	
	private int idRegularGame;
	
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
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_command1", insertable=false, updatable=false)
	private RegularCommandModelImpl regularCommand1;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_command2", insertable=false, updatable=false)
	private RegularCommandModelImpl regularCommand2;
			
	public int getIdRegularGame() {
		return idRegularGame;
	}
	public void setIdRegularGame(int idRegularGame) {
		this.idRegularGame = idRegularGame;
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
	public RegularCommandModelImpl getRegularCommand1() {
		return regularCommand1;
	}
	public void setRegularCommand1(RegularCommandModelImpl regularCommand1) {
		this.regularCommand1 = regularCommand1;
	}
	public RegularCommandModelImpl getRegularCommand2() {
		return regularCommand2;
	}
	public void setRegularCommand2(RegularCommandModelImpl regularCommand2) {
		this.regularCommand2 = regularCommand2;
	}
	
	
}
