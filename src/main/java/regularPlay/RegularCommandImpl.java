package regularPlay;

/*import java.io.File;
import java.io.IOException;*/
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import models.RegularCommandModelImpl;
import systemServices.ResizePicture;

public class RegularCommandImpl implements RegularCommand{
	
	private HibernateTemplate template;
	
	@Autowired
	private ResizePicture resize;

	
	public RegularCommandImpl(HibernateTemplate template){
		this.template=template;
		
	}
    
	@Transactional
	@Override
	public boolean createCommand(RegularCommandModelImpl command, String resourcePath) {
		
		@SuppressWarnings("unchecked")
		List<Object[]> regularCommandIdName =template.getSessionFactory().openSession().
		createQuery("select r.idRegularCommand, r.commandName from RegularCommandModelImpl r "
				+ "order by idRegularCommand").list();
		if(!command.getCommandName().trim().isEmpty()&&regularCommandIdName!=null){
		for (Object[] commandName : regularCommandIdName) {
			if(command.getCommandName().equalsIgnoreCase((String) commandName[1])){
				return false;
			}
		}
		}
		if(command.getTrainerName().trim().isEmpty()
				||command.getYearFoundation()==0){
			return false;
		}
		if(regularCommandIdName!=null&&!regularCommandIdName.isEmpty()
				&&command.getPhotoPath()!=null){
			int lastId=(int) regularCommandIdName.get(regularCommandIdName.size()-1)[0];
			command.setPhotoPath(resize.getImageShortPath(resize
					.getNewImageLocation(command.getPhotoPath(),
					resourcePath , ++lastId)));
		}
		else if(command.getPhotoPath()!=null){
			command.setPhotoPath(resize.getImageShortPath(resize.getNewImageLocation(command
					.getPhotoPath(),
					resourcePath,1)));
		}
		template.save(command);
		return true;
	}
	@Transactional
	@Override
	public void updateCommand(RegularCommandModelImpl command, String resourcePath) {
		if(!resourcePath.isEmpty()){
			command.setPhotoPath(resize.getImageShortPath(resize.getNewImageLocation(
					command.getPhotoPath(), resourcePath,command.getIdRegularCommand())));
		}
		template.update(command);
	}
	@Transactional
	@Override
	public void deleteCommand(RegularCommandModelImpl command) {
		template.delete(command);
	}

	@Override
	public List<RegularCommandModelImpl> getCommands() {
		@SuppressWarnings("unchecked")
		List<RegularCommandModelImpl> commands = (List<RegularCommandModelImpl>) 
				template.findByCriteria(DetachedCriteria.forClass(RegularCommandModelImpl.class)
						.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY)) // question
				;
		if( commands==null){
			commands = new ArrayList<>();
		}
		return commands;
	}

	@Override
	public RegularCommandModelImpl getCommandById(int idCommand) {
		RegularCommandModelImpl command = template.get(RegularCommandModelImpl.class, idCommand);
		return command;
	}

}
