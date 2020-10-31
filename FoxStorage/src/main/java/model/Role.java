package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "Role")
@Table(name = "role")
@XmlRootElement
public class Role extends BaseModel implements Serializable{

	private static final long serialVersionUID = 4995712236937229725L;

	@Column(name = "role_name",
			columnDefinition = "VARCHAR(20) NOT NULL")
	private String roleName;
	
	@Column(name = "description",
			columnDefinition = "VARCHAR(200) DEFAULT NULL")
	private String description;
    
    @ManyToMany
    @JoinTable(name = "role_user", joinColumns = @JoinColumn(name = "role_ID"), inverseJoinColumns = @JoinColumn(name = "user_ID"))
	private List<User> users;


	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
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
	
}
