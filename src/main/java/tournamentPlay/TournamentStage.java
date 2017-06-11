package tournamentPlay;

import java.util.List;

public interface TournamentStage {
	public boolean createStage(TournamentStageImpl tournamentStage);
	public boolean editStage(TournamentStageImpl tournamentStage);
	public TournamentStageImpl getStage(int id);
	public List<TournamentStageImpl> getAllStages();
    public void deleteStage(TournamentStageImpl tournamentStage);
}
