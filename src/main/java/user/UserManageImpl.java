package user;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import models.LoginModelImpl;
import models.RoleModelImpl;
import models.UserModelImpl;

public class UserManageImpl implements UserManage{
	
	private HibernateTemplate template;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserManageImpl(HibernateTemplate template) {
		this.template = template;
	}
	
	@Transactional
	@Override
	public boolean createUser(LoginModelImpl credentials) {
		@SuppressWarnings("unchecked")
		List<String> existedLogins = template.getSessionFactory().openSession()
				.createQuery("select username from UserModelImpl").list();
		if(existedLogins!=null){
			for (String login : existedLogins) {
				if(login.equals(credentials.getLogin())){
					return false;
				}
			}
		}
		if(!credentials.getPassword().equals(credentials.getConfirmPassword())){
			return false;
		}
		UserModelImpl user = new UserModelImpl();
		user.setUsername(credentials.getLogin());
		credentials.setPassword(bCryptPasswordEncoder.encode(credentials.getPassword()));
		Set<RoleModelImpl> roles = new HashSet<>();
		RoleModelImpl role = (RoleModelImpl) template.findByCriteria(DetachedCriteria.forClass(RoleModelImpl
				.class).add(Restrictions.eq("roleName", "USER"))).get(0);
		roles.add(role);
		credentials.setRoles(roles);
		template.save(credentials);
		template.save(user);
		return true;
	}

	@Transactional
	@Override
	public boolean updateUser(UserModelImpl user) {
		template.update(user);
		return true;
	}

	@Transactional
	@Override
	public void deleteUser(UserModelImpl user) {
		template.delete(getCredentialsByName(user.getUsername()));
		template.delete(user);
	}

	@Override
	public List<UserModelImpl> getAllUsers() {
		@SuppressWarnings("unchecked")
		List<UserModelImpl> users = (List<UserModelImpl>) template.findByCriteria(DetachedCriteria
				.forClass(UserModelImpl.class).setResultTransformer(DetachedCriteria
						.DISTINCT_ROOT_ENTITY));
		if(users==null){
			users = new ArrayList<>();
		}
		return users;
	}

	@Override
	public LoginModelImpl getCredentialsByName(String login) {
		 @SuppressWarnings("unchecked")
		List<LoginModelImpl> credentials = (List<LoginModelImpl>) template
		.findByCriteria(DetachedCriteria.forClass(LoginModelImpl.class).add(Restrictions
				.like("login", login)));
		 if(credentials!=null&& credentials.size()>0){
			 return credentials.get(0);
		 }
		return new LoginModelImpl();
	}

	@Override
	public UserModelImpl getUserByName(String login) {
	    @SuppressWarnings("unchecked")
		List<UserModelImpl> userList = (List<UserModelImpl>) template.findByCriteria(
	DetachedCriteria.forClass(UserModelImpl.class).add(Restrictions.like("username",login)));
	    if(userList!=null&&userList.size()>0){
	    	return userList.get(0);
	    }
		return new UserModelImpl();
	}

	@Override
	public UserModelImpl getUserById(int index) {
		return template.get(UserModelImpl.class, index);
	}

}
