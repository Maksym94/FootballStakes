package tournamentPlay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.HibernateTemplate;

import models.TournamentStageModelImpl;

public class TournamentStageImpl implements TournamentStage{
	private static final Map<Double, Integer> numberOfGames = new HashMap<>();
	
	private HibernateTemplate template;

	public TournamentStageImpl(HibernateTemplate template) {
		this.template = template;
        numberOfGames.put(1.0, 1);
        numberOfGames.put(0.5, 2);
        numberOfGames.put(0.25, 4);
        numberOfGames.put(0.125, 8);
        numberOfGames.put(0.0625, 16);
	}

	@Override
	public boolean createStage(TournamentStageModelImpl tournamentStage) {
		if(tournamentStage.getTournament().getIdTournament()==0){
			return false;
		}
		@SuppressWarnings("unchecked")
		List<TournamentStageModelImpl> existStagesInTournament= (List<TournamentStageModelImpl>) 
				template.getSessionFactory().openSession().createQuery
				("from TournamentStageModelImpl where id_tournament=:idTournament")
				.setParameter("idTournament", tournamentStage.getTournament().getIdTournament());
		double stage = tournamentStage.getStage();
		if(existStagesInTournament!=null && existStagesInTournament.size()>0){
			for (TournamentStageModelImpl tournamentStageModelImpl : existStagesInTournament) {
				if(tournamentStageModelImpl.getStage()==stage){
					return false;
				}
			}
		}
		if(tournamentStage.getTournamentGames().size()!= numberOfGames.get(stage)){
			return false;
		}
		template.save(tournamentStage);
		return true;
	}

	@Override
	public boolean editStage(TournamentStageModelImpl tournamentStage) {
		 if(!tournamentStage.isActive()&& tournamentStage.isFinishedStage()){
			 return false;
		 }
		 template.update(tournamentStage);
		return true;
	}

	@Override
	public TournamentStageModelImpl getStage(int id) {
		TournamentStageModelImpl stage = template.get(TournamentStageModelImpl.class, id);
		return stage;
	}

	@Override
	public List<TournamentStageModelImpl> getAllStages() {
		@SuppressWarnings("unchecked")
		List<TournamentStageModelImpl> stages = (List<TournamentStageModelImpl>) 
				template.findByCriteria(DetachedCriteria.forClass(TournamentStageModelImpl.class));
		if(stages==null){
			stages = new ArrayList<>();
		}
		return stages;
	}

	@Override
	public void deleteStage(TournamentStageModelImpl tournamentStage) {
		template.delete(tournamentStage);
	}

}
