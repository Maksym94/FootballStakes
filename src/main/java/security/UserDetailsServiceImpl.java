package security;

import java.util.HashSet;
import java.util.Set;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import models.LoginModelImpl;
import models.RoleModelImpl;
import user.UserManage;

public class UserDetailsServiceImpl implements UserDetailsService{
	 private static final String NOT_FOUND_USER = "anonymous";
	 
	@Autowired
	private UserManage userManageImpl;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LoginModelImpl user = userManageImpl.getCredentialsByName(username);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		if(user.getRoles()!=null){
			for (RoleModelImpl role : user.getRoles()) {
				if(role!=null){
					System.out.println(user.getLogin()+" has role "+ role.getRoleName());
				grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
				}
			}
		}
		else{
			return new User(NOT_FOUND_USER, NOT_FOUND_USER,grantedAuthorities);
		}
		return new User(user.getLogin(), user.getPassword(), grantedAuthorities);
	}

	

}
