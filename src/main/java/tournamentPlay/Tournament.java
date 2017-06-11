package tournamentPlay;

import java.util.List;

import models.TournamentModelImpl;

public interface Tournament {
	
	public boolean createTournament(TournamentModelImpl tournament);
	public boolean editTournament(TournamentModelImpl tournament);
    public void deleteTournament(TournamentModelImpl tournament);
    public List<TournamentModelImpl> getTournaments();
    public TournamentModelImpl getTournament(int id);
    public TournamentModelImpl getLastTournament();
    
}
