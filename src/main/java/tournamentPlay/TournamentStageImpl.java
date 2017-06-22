package tournamentPlay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

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
	
	@Transactional
	@Override
	public boolean createStage(TournamentStageModelImpl tournamentStage) {
		if(tournamentStage.getTournament()==null||tournamentStage.getTournament()
				.getIdTournament()==0){
			System.out.println("Tournament null or id tournament = 0");
			return false;
		}
		@SuppressWarnings("unchecked")
		List<TournamentStageModelImpl> existStagesInTournament= (List<TournamentStageModelImpl>) 
				template.getSessionFactory().openSession().createQuery
				("from TournamentStageModelImpl where id_tournament=:idTournament")
				.setParameter("idTournament", tournamentStage.getTournament().getIdTournament())
				.list();
		double stage = tournamentStage.getStage();
		if(existStagesInTournament!=null && existStagesInTournament.size()>0){
			for (TournamentStageModelImpl tournamentStageModelImpl : existStagesInTournament) {
				if(tournamentStageModelImpl.getStage()==stage){
					System.out.println("the stage is already appeared in tournament");
					return false;
				}
			}
		}
		if(tournamentStage.getTournamentGames().size()!= numberOfGames.get(stage)){
			System.out.println("numbers of games at this stage is not correct");
			return false;
		}
		template.save(tournamentStage);
		return true;
	}
	
	@Transactional
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
				template.findByCriteria(DetachedCriteria.forClass(TournamentStageModelImpl.class).
						setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY));
		if(stages==null){
			stages = new ArrayList<>();
		}
		return stages;
	}

	@Transactional
	@Override
	public void deleteStage(TournamentStageModelImpl tournamentStage) {
		template.delete(tournamentStage);
	}

}
