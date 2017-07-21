package user;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateTemplate;

import models.UserModelImpl;
import models.UserOperationModelImpl;

public class UserMoneyImpl implements UserMoney{
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
	
	private HibernateTemplate template;

	public UserMoneyImpl(HibernateTemplate template) {
		this.template = template;
	}

	@Transactional
	@Override
	public boolean addMoney(UserModelImpl user, UserOperationModelImpl userOperation) {
		if(userOperation.getAmount().doubleValue()>1000||userOperation.getAmount()
				.doubleValue()<=0){
			return false;
		}
		if(user.getBalance()!=null){
		user.setBalance(user.getBalance().add(userOperation.getAmount()));
		}
		else{
			user.setBalance(userOperation.getAmount());
		}
		userOperation.setIdUser(user.getIdUser());
		userOperation.setCurrentBalance(user.getBalance());
		userOperation.setDate(sdf.format(new Date()));
		
		template.save(userOperation);
		template.update(user);
		
		//List<User>
		return true;
	}

	@Transactional
	@Override
	public boolean getMoney(UserModelImpl user, UserOperationModelImpl userOperation) {
		if(user.getBalance()==null||userOperation.getAmount().doubleValue()<=0){
			return false;
		}
		if(userOperation.getAmount().compareTo(user.getBalance())==1){
			return false;
		}
		user.setBalance(user.getBalance().subtract(userOperation.getAmount()));
		userOperation.setIdUser(user.getIdUser());
		userOperation.setAmount(userOperation.getAmount().negate());
		userOperation.setCurrentBalance(user.getBalance());
		userOperation.setDate(sdf.format(new Date()));
		
		template.save(userOperation);
		template.update(user);
		return true;
	}

	@Transactional
	@Override
	public void deleteOperation(UserModelImpl user, UserOperationModelImpl userOperation) {
		//if(userOperation.getAmount().doubleValue()>0){
			user.getBalance().subtract(userOperation.getAmount());
		//}
		//else{	
		//}
			template.delete(userOperation);
			template.update(user);
		
	}

	@Override
	public UserOperationModelImpl getOperationById(int index) {
		@SuppressWarnings("unchecked")
		List<UserOperationModelImpl> listOperation = (List<UserOperationModelImpl>) 
				template.findByCriteria(DetachedCriteria.forClass(UserOperationModelImpl.class)
						.add(Restrictions.eq("idOperation", index)));
		if(listOperation!=null&& !listOperation.isEmpty()){
			return listOperation.get(0);
		}
		return new UserOperationModelImpl();
	}

}
