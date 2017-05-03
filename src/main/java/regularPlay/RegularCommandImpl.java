package regularPlay;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.HibernateTemplate;

import models.RegularCommandModelImpl;

public class RegularCommandImpl implements RegularCommand{
	
	private HibernateTemplate template;
    
	@Transactional
	@Override
	public boolean createCommand(RegularCommandModelImpl command) {
		
		@SuppressWarnings("unchecked")
		List<String> commandNames =template.getSessionFactory().openSession().
		createQuery("select commandName from RegularCommandModelImpl order by id").list();
		for (String commandName : commandNames) {
			if(command.getCommandName().equalsIgnoreCase(commandName)){
				return false;
			}
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
