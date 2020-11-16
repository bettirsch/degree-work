package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import utils.enums.UserRoles;

@Entity(name = "Role")
@Table(name = "role")
@XmlRootElement
@NamedQueries(
		@NamedQuery(name = "Role.findByRoleName", query = "SELECT r FROM Role r WHERE r.roleName =:roleName"))
public class Role extends BaseModel implements Serializable{

	private static final long serialVersionUID = 4995712236937229725L;

	@Column(name = "role_name",
			columnDefinition = "VARCHAR(30) NOT NULL")
	@Enumerated(EnumType.STRING)
	private UserRoles roleName;
	
	@Column(name = "description",
			columnDefinition = "VARCHAR(200) DEFAULT NULL")
	private String description;
    
    @ManyToMany
    @JoinTable(name = "role_user", joinColumns = @JoinColumn(name = "role_ID"), inverseJoinColumns = @JoinColumn(name = "user_ID"))
	private List<User> users;

	public UserRoles getRoleName() {
		return roleName;
	}

	public void setRoleName(UserRoles roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public void addUser(User user) {
		if (this.users == null) {
			this.users = new ArrayList<>();
		}
		this.users.add(user);
	}
}
