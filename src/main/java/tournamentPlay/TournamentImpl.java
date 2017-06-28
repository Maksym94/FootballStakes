package tournamentPlay;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate4.HibernateTemplate;

import models.TournamentModelImpl;

public class TournamentImpl implements Tournament{
	
	private HibernateTemplate template;

	public TournamentImpl(HibernateTemplate template) {
		this.template = template;
	}

	@Transactional
	@Override
	public boolean createTournament(TournamentModelImpl tournament) {
		@SuppressWarnings("unchecked")
		List<Object[]> idAndNameTournaments = template.getSessionFactory().openSession()
				.createQuery("select idTournament, tournamentName from TournamentModelImpl "
						+ " order by idTournament").list();
		if(idAndNameTournaments!=null&&!idAndNameTournaments.isEmpty()){
			for (Object[] idAndNameTournament : idAndNameTournaments) {
				int id = (int) idAndNameTournament[0];
				String name = (String) idAndNameTournament[1];
				if(id==tournament.getIdTournament()||name.equals(tournament.getTournamentName())){
					return false;
				}
			}
		}
		tournament.setMaxAmountOfStages(getNumberOfStages(tournament.getMaxAmountOfCommands()));
		template.save(tournament);
		return true;
	}
	
	@Transactional
	@Override
	public boolean editTournament(TournamentModelImpl tournament, boolean rebuilt) {
		if(rebuilt){
			tournament.setMaxAmountOfStages(getNumberOfStages(tournament
					.getMaxAmountOfCommands()));
		}
		template.update(tournament);
		return true;
	}

	@Transactional
	@Override
	public void deleteTournament(TournamentModelImpl tournament) {
		template.delete(tournament);
	}

	@Override
	public List<TournamentModelImpl> getTournaments() {
		@SuppressWarnings("unchecked")
		List<TournamentModelImpl> tournaments = (List<TournamentModelImpl>) 
				template.findByCriteria(DetachedCriteria.forClass(TournamentModelImpl.class)
				.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY));
		if(tournaments==null){
			tournaments= new ArrayList<>();
		}
		return tournaments;
	}

	@Override
	public TournamentModelImpl getTournament(int id) {
		return template.get(TournamentModelImpl.class,id);
	}

	private static final int getNumberOfStages(int maxNumberOfCommands){
		int count =0;
		while(maxNumberOfCommands>1){
			maxNumberOfCommands/=2;
			count++;
		}
		return count;
	}

	@Override
	public TournamentModelImpl getLastTournament() {
		@SuppressWarnings("unchecked")
		List<TournamentModelImpl> tournamentResult = (List<TournamentModelImpl>) 
				template.findByCriteria(
				DetachedCriteria.forClass(TournamentModelImpl.class).addOrder(
						Order.desc("idTournament")));
		if(tournamentResult.size()>0){
			return tournamentResult.get(0);
		}
		return new TournamentModelImpl();
	}
}
