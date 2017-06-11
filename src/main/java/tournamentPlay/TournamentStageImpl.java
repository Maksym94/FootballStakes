package tournamentPlay;

import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;

public class TournamentStageImpl implements TournamentStage{
	
	private HibernateTemplate template;

	public TournamentStageImpl(HibernateTemplate template) {
		this.template = template;
	}

	@Override
	public boolean createStage(TournamentStageImpl tournamentStage) {
		
		return false;
	}

	@Override
	public boolean editStage(TournamentStageImpl tournamentStage) {
		
		return false;
	}

	@Override
	public TournamentStageImpl getStage(int id) {
		
		return null;
	}

	@Override
	public List<TournamentStageImpl> getAllStages() {
		
		return null;
	}

	@Override
	public void deleteStage(TournamentStageImpl tournamentStage) {
	}

}
