package tournamentPlay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.HibernateTemplate;

import models.TournamentGameModelImpl;
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
	
	private static double getFirstStageFromMaxAmountCommands(int maxCommands){
		return 1d/ (maxCommands/2);
	}
	
	
	@Transactional
	@Override
	public boolean createStage(TournamentStageModelImpl tournamentStage) {
		if(tournamentStage.getTournament()==null||tournamentStage.getTournament()
				.getIdTournament()==0){
			System.out.println("Tournament null or id tournament = 0");
			return false;
		}
		//@SuppressWarnings("unchecked")
		List<TournamentStageModelImpl> existStagesInTournament= /*(List<TournamentStageModelImpl>) 
				template.getSessionFactory().openSession().createQuery
				("from TournamentStageModelImpl where id_tournament=:idTournament")
				.setParameter("idTournament", tournamentStage.getTournament().getIdTournament())
				.list()*/tournamentStage.getTournament().getTournamentStages();
		
		double stage = tournamentStage.getStage();
		if(existStagesInTournament!=null && existStagesInTournament.size()>0){
			if(tournamentStage.getTournament().getMaxAmountOfStages()==existStagesInTournament
					.size()){
				return false;
			}
			if(existStagesInTournament.get(existStagesInTournament.size()-1).getStage()*2
					!=tournamentStage.getStage()){
				return false;
			}
			for (TournamentStageModelImpl tournamentStageModelImpl : existStagesInTournament) {
				if(tournamentStageModelImpl.getStage()==stage){
					System.out.println("the stage is already appeared in tournament");
					return false;
				}
			}
		}
		else{
			if(getFirstStageFromMaxAmountCommands(tournamentStage.getTournament()
					.getMaxAmountOfCommands())!=tournamentStage.getStage()){
				return false;
			}
		}
		if(tournamentStage.getTournamentGames().size()!= numberOfGames.get(stage)){
			System.out.println("numbers of games at this stage is incorrect");
			return false;
		}
		if(isTwoCommandsRepeat(tournamentStage.getTournamentGames())){
			System.out.println("Repeat commands");
			return false;
		}
		template.save(tournamentStage);
		return true;
	}

	private boolean isTwoCommandsRepeat(List<TournamentGameModelImpl> games) {
		if(games!=null){
		for (int i = 0; i <games.size(); i++) {
			
			int idCommand1= games.get(i).getTournamentCommand1().getIdTournamentCommand();
			int idCommand2= games.get(i).getTournamentCommand2().getIdTournamentCommand();
			for (int j = i+1; j < games.size(); j++) {
				
			int nextIdCommand1 = games.get(j).getTournamentCommand1().getIdTournamentCommand();
			int nextIdCommand2 = games.get(j).getTournamentCommand2().getIdTournamentCommand();
			if(idCommand1==nextIdCommand1||idCommand1==nextIdCommand2||
					idCommand2 ==nextIdCommand1||idCommand2 == nextIdCommand2){
				return true;
			}
		  }
		}
	}
		else{
			return true;
		}
		return false;
	}
	
	@Transactional
	@Override
	public boolean editStage(TournamentStageModelImpl tournamentStage) {
		if(tournamentStage.getTournament()==null||tournamentStage.getTournament()
				.getIdTournament()==0){
			return false;
		}
		 if(!tournamentStage.isActive()&& tournamentStage.isFinishedStage()){
			 return false;
		 }
		 if(tournamentStage.getTournamentGames().size()!= numberOfGames.get(tournamentStage
				 .getStage())){
				System.out.println("numbers of games at this stage is incorrect");
				return false;
			}
		 if(isTwoCommandsRepeat(tournamentStage.getTournamentGames())){
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
				template.findByCriteria(DetachedCriteria.forClass(TournamentStageModelImpl.class)
						.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY));
		if(stages==null){
			stages = new ArrayList<>();
		}
		return stages;
	}

	@Transactional
	@Override
	public void deleteStage(TournamentStageModelImpl tournamentStage) {
		@SuppressWarnings("unchecked")
		List<Double> maxStageInTournament = template.getSessionFactory().openSession()
				.createQuery("select MAX(stage) from TournamentStageModelImpl "
						+ "where id_tournament=:id").setParameter("id", tournamentStage
								.getTournament().getIdTournament()).list();
		if(maxStageInTournament!=null){
			double firstStageToDelete = maxStageInTournament.get(0);
			if(firstStageToDelete==tournamentStage.getStage()){
				template.delete(tournamentStage);
			}
		}
		
	}

}
