package tournamentPlay;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import models.TournamentCommandModelImpl;
import systemServices.ResizePicture;

public class TournamentCommandImpl implements TournamentCommand{
	
	private HibernateTemplate template;
	
	@Autowired
	private ResizePicture resize;

	public TournamentCommandImpl(HibernateTemplate template) {
		this.template = template;
	}
	
    @Transactional
	@Override
	public boolean createCommand(TournamentCommandModelImpl command, String resourcePath) {
	@SuppressWarnings("unchecked")
	List<Object[]> idNameCommands=	template.getSessionFactory().openSession()
			.createQuery("select idTournamentCommand, "
				+ "commandName from TournamentCommandModelImpl").list();
	if(!command.getCommandName().isEmpty()&& idNameCommands!=null){
		for (Object[] idNameCommand : idNameCommands) {
			String commandName= (String) idNameCommand[1];
			if(commandName.equalsIgnoreCase(command.getCommandName())){
				return false;
			}
		}
	}
	if(command.getTrainerName().trim().isEmpty()||command.getYearFoundation()==0){
		return false;
	}
	if(idNameCommands!=null&&!idNameCommands.isEmpty()&&resourcePath!=null){
		int lastId = (int) idNameCommands.get(idNameCommands.size()-1)[0];
		command.setPhotoPath(resize.getImageShortPath(resize.getNewImageLocation(
				command.getPhotoPath(), resourcePath, ++lastId)));
	}
	if(resourcePath!=null){
		command.setPhotoPath(resize.getImageShortPath(resize.getNewImageLocation(
				command.getPhotoPath(), resourcePath, 1)));
	}
	template.save(command);
		return true;
	}
    
    @Transactional
	@Override
	public void updateCommand(TournamentCommandModelImpl command, String resourcePath) {
    	if(!resourcePath.isEmpty()){
    		command.setPhotoPath(resize.getImageShortPath(resize.getNewImageLocation(
    				command.getPhotoPath(), resourcePath, command.getIdTournamentCommand())));
    	}
		template.update(command);
	}
    
    @Transactional
	@Override
	public void deleteCommand(TournamentCommandModelImpl command) {
		template.delete(command);
	}

	@Override
	public List<TournamentCommandModelImpl> getAllCommands() {
		@SuppressWarnings("unchecked")
		List<TournamentCommandModelImpl> commands= (List<TournamentCommandModelImpl>) 
				template.findByCriteria(DetachedCriteria
						.forClass(TournamentCommandModelImpl.class)
						.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY));
		if(commands==null){
			return new ArrayList<>();
		}
		return commands;
	}

	@Override
	public TournamentCommandModelImpl getCommandById(int idCommand) {
		return template.get(TournamentCommandModelImpl.class, idCommand);
	}

}
