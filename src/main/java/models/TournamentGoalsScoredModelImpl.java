package models;

public class TournamentGoalsScoredModelImpl {
	
	private int idTournamentGoalsScored;
	private int idTournamentGame;
	private int tournamentIdCommand;
	private int minuteOfGoalScored;
	
	public int getIdTournamentGoalsScored() {
		return idTournamentGoalsScored;
	}
	public void setIdTournamentGoalsScored(int idTournamentGoalsScored) {
		this.idTournamentGoalsScored = idTournamentGoalsScored;
	}
	
	
	public int getIdTournamentGame() {
		return idTournamentGame;
	}
	public void setIdTournamentGame(int idTournamentGame) {
		this.idTournamentGame = idTournamentGame;
	}
	public int getTournamentIdCommand() {
		return tournamentIdCommand;
	}
	public void setTournamentIdCommand(int tournamentIdCommand) {
		this.tournamentIdCommand = tournamentIdCommand;
	}
	public int getMinuteOfGoalScored() {
		return minuteOfGoalScored;
	}
	public void setMinuteOfGoalScored(int minuteOfGoalScored) {
		this.minuteOfGoalScored = minuteOfGoalScored;
	}
	
	
}
