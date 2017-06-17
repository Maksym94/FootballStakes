package tournamentPlay;

import java.util.List;

import models.TournamentStageModelImpl;

public interface TournamentStage {
	public boolean createStage(TournamentStageModelImpl tournamentStage);
	public boolean editStage(TournamentStageModelImpl tournamentStage);
	public TournamentStageModelImpl getStage(int id);
	public List<TournamentStageModelImpl> getAllStages();
    public void deleteStage(TournamentStageModelImpl tournamentStage);
}
