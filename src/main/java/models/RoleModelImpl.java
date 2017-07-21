package models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class RoleModelImpl {
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int id;
		
		@Column(name="role_name")
		private String roleName;
		
		@ManyToMany(mappedBy="roles")
		private Set<LoginModelImpl> users;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getRoleName() {
			return roleName;
		}

		public void setRoleName(String roleName) {
			this.roleName = roleName;
		}

		public Set<LoginModelImpl> getUsers() {
			return users;
		}

		public void setUsers(Set<LoginModelImpl> users) {
			this.users = users;
		}
		
		
		
}

