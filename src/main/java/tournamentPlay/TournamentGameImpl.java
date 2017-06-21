package tournamentPlay;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate4.HibernateTemplate;

import models.TournamentGameModelImpl;

public class TournamentGameImpl implements TournamentGame{
	private HibernateTemplate template;

	public TournamentGameImpl(HibernateTemplate template) {
		this.template = template;
	}
    @Transactional
	@Override
	public boolean createGame(TournamentGameModelImpl tournamentGame) {
		if(tournamentGame.getTournamentCommand1().getIdTournamentCommand()== 
				tournamentGame.getTournamentCommand2().getIdTournamentCommand()){
			return false;
		}
		if(tournamentGame.getCoefficientFirstCommand()==0 ||
				tournamentGame.getCoefficientSecondCommand()==0){
			return false;
		}
		//This is not finished logic, the main idea is to add dependence from stage and id 
		//of tournament
		@SuppressWarnings("unchecked")
		List<Object[]> twoCommandsIndexes= template.getSessionFactory().openSession()
				.createQuery("select tournamentCommand1.idTournamentCommand, "
						+ "tournamentCommand2.idTournamentCommand from TournamentGameModelImpl"
						+ " order by idTournamentGame").list();
		
		if(twoCommandsIndexes!=null){
			for (Object[] twoId : twoCommandsIndexes) {
				int firstCommandId= (int) twoId[0];
				int secondCommandId= (int) twoId[1];
				
				if(firstCommandId==tournamentGame.getTournamentCommand1().getIdTournamentCommand()
						&&secondCommandId==tournamentGame.getTournamentCommand2()
						.getIdTournamentCommand()|| secondCommandId==tournamentGame
						.getTournamentCommand1().getIdTournamentCommand()
						&&firstCommandId==tournamentGame.getTournamentCommand2()
						.getIdTournamentCommand()){
					return false;
				}
			}
		}
		template.save(tournamentGame);
		return true;
	}

    @Transactional
	@Override
	public void updateGame(TournamentGameModelImpl tournamentGame) {
		template.update(tournamentGame);
	}

    @Transactional
	@Override
	public void deleteGame(TournamentGameModelImpl tournamentGame) {
		template.delete(tournamentGame);
	}

	@Override
	public List<TournamentGameModelImpl> getAllGames() {
		@SuppressWarnings("unchecked")
		List<TournamentGameModelImpl> games= (List<TournamentGameModelImpl>) 
				template.findByCriteria(DetachedCriteria.forClass(TournamentGameModelImpl.class)
						.addOrder(Order.asc("idTournamentGame")));
		if(games==null){
			games= new ArrayList<>();
		}
		return games;
	}

	@Override
	public TournamentGameModelImpl getGame(int id) {
		
		return template.get(TournamentGameModelImpl.class, id);
	}

}
