package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="regular_goals_scored")
public class RegularGoalsScoredModelImpl {
	
	@Column(name="id_regular_goals_scored")
	private int idRegularGoalsScored;
	
	@Column(name="id_regular_game")
	private int idRegularGame;
	
	@Column(name="regular_id_command")
	private int regularIdCommand;
	
	@Column(name="minute_goal_scored")
	private int minuteOfGoalScored;
	
	public int getIdRegularGoalsScored() {
		return idRegularGoalsScored;
	}
	public void setIdRegularGoalsScored(int idRegularGoalsScored) {
		this.idRegularGoalsScored = idRegularGoalsScored;
	}
	public int getIdRegularGame() {
		return idRegularGame;
	}
	public void setIdRegularGame(int idRegularGame) {
		this.idRegularGame = idRegularGame;
	}
	public int getRegularIdCommand() {
		return regularIdCommand;
	}
	public void setRegularIdCommand(int regularIdCommand) {
		this.regularIdCommand = regularIdCommand;
	}
	public int getMinuteOfGoalScored() {
		return minuteOfGoalScored;
	}
	public void setMinuteOfGoalScored(int minuteOfGoalScored) {
		this.minuteOfGoalScored = minuteOfGoalScored;
	}
	
	

}
