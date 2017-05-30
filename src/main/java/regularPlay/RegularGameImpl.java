package regularPlay;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate4.HibernateTemplate;

import models.RegularGameModelImpl;

public class RegularGameImpl implements RegularGame{
	
	private HibernateTemplate template;
	
	public RegularGameImpl(HibernateTemplate template) {
		this.template = template;
	}

    @Transactional
	@Override
	public boolean createGame(RegularGameModelImpl regularGame) {
		if(regularGame.getIdCommand1()==regularGame.getIdCommand2()){
			return false;
		}
		if(regularGame.getCoefficientFirstCommand()==0
				||regularGame.getCoefficientSecondCommand()==0){
			return false;
		}
		if(regularGame.isFinishedGame()){
			return false;
		}
		@SuppressWarnings("unchecked")
		List<Object[]> twoCommands= template.getSessionFactory().openSession()
				.createQuery("select idCommand1,idCommand2,finishedGame from RegularGameModelImpl"
						+ " order by idRegularGame").list();
		if(twoCommands!=null){
			for (Object[] twoId : twoCommands) {
				int firstId = (int) twoId[0];
				int secondId= (int) twoId[1];
				boolean isFinishedGame= (boolean) twoId[2];
				if(regularGame.getIdCommand1()==firstId&& regularGame.getIdCommand2()==secondId
				  &&!isFinishedGame 
				  ||regularGame.getIdCommand1()==secondId&& regularGame.getIdCommand2()==firstId
				  &&!isFinishedGame){
					return false;
				}
			}
		}
		template.save(regularGame);
		return true;
	}
    
    
    @Transactional
	@Override
	public void deleteGame(RegularGameModelImpl regularGame) {
    	template.delete(regularGame);
	}

	@Override
	public List<RegularGameModelImpl> getAllGames() {
		@SuppressWarnings("unchecked")
		List<RegularGameModelImpl> games = (List<RegularGameModelImpl>) template.findByCriteria(
				DetachedCriteria.forClass(RegularGameModelImpl.class)
				.addOrder(Order.asc("idRegularGame"))
				.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY));
		if(games==null){
			games = new ArrayList<>();
		}
		return games;
	}

	@Override
	public RegularGameModelImpl getGame(int id) {
		RegularGameModelImpl game= template.get(RegularGameModelImpl.class, id);
		return game;
	}

	@Transactional
	@Override
	public void updateGame(RegularGameModelImpl regularGame) {
		template.update(regularGame);
	}

}
