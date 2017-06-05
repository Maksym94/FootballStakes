package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="regular_goals_scored")
public class RegularGoalsScoredModelImpl {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_regular_goals_scored")
	private int idRegularGoalsScored;
	
	@Column(name="id_regular_game")
	private int idRegularGame;
	
	@Column(name="regular_id_command")
	private int regularIdCommand;
	
	@Column(name="minute_goal_scored")
	private int minuteOfGoalScored;
	
	@ManyToOne
	@JoinColumn(name="id_regular_command")
	private RegularCommandModelImpl regularCommandScored;
	
	@ManyToOne
	@JoinColumn(name="id_regular_game", insertable=false, updatable=false)
	private RegularGameModelImpl regularGameScored;
	
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idRegularGame;
		result = prime * result + idRegularGoalsScored;
		result = prime * result + minuteOfGoalScored;
		result = prime * result + regularIdCommand;
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
		RegularGoalsScoredModelImpl other = (RegularGoalsScoredModelImpl) obj;
		if (idRegularGame != other.idRegularGame)
			return false;
		if (idRegularGoalsScored != other.idRegularGoalsScored)
			return false;
		if (minuteOfGoalScored != other.minuteOfGoalScored)
			return false;
		if (regularIdCommand != other.regularIdCommand)
			return false;
		return true;
	}
	
	

}
