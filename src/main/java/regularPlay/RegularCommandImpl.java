package regularPlay;

import java.io.File;
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
	
	private final File resourcePath = new File("/src/main/resources/");
	@Autowired
	private ResizePicture resize;

	
	public RegularCommandImpl(HibernateTemplate template) {
		this.template=template;
	}
    
	@Transactional
	@Override
	public boolean createCommand(RegularCommandModelImpl command) {
		
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
		if(regularCommandIdName!=null&&!regularCommandIdName.isEmpty()){
			int lastId=(int) regularCommandIdName.get(regularCommandIdName.size()-1)[0];
			command.setPhotoPath(resize.getNewImageLocation(command.getPhotoPath(),
					resourcePath.getAbsolutePath() , ++lastId));
		}
		else{
			command.setPhotoPath(resize.getNewImageLocation(command.getPhotoPath(),
					resourcePath.getAbsolutePath(),1));
		}
		template.save(command);
		return true;
	}
	@Transactional
	@Override
	public void updateCommand(RegularCommandModelImpl command) {
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

}
