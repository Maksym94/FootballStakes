package models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="credentials")
public class LoginModelImpl {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_login")
	private int idLogin;
	
	private String login;
	
	private String password;
	
	@Transient	
	private String confirmPassword;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="credentials_roles", joinColumns={@JoinColumn(name="cr_login", 
	referencedColumnName="id_login")}, inverseJoinColumns={@JoinColumn(name="cr_role", 
	referencedColumnName="id")})
	private Set<RoleModelImpl> roles;

	public int getIdLogin() {
		return idLogin;
	}

	public void setIdLogin(int idLogin) {
		this.idLogin = idLogin;
	}


	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<RoleModelImpl> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleModelImpl> roles) {
		this.roles = roles;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
}
