package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name="User.findByEmailAndPassword", query="SELECT u FROM User u WHERE u.email = :email AND u.password = :password"),
	@NamedQuery(name="User.countByEmail", query = "SELECT COUNT(u) FROM User u WHERE u.email = :email")})
public class User extends BaseModel implements Serializable {

	private static final long serialVersionUID = -7351729135012380019L;

	@Column(name = "username", columnDefinition = "VARCHAR(10) NOT NULL")
	private String username;

	@Column(name = "first_name", columnDefinition = "VARCHAR(20) DEFAULT NULL")
	private String firstName;

	@Column(name = "middle_name", columnDefinition = "VARCHAR(20) DEFAULT NULL")
	private String middleName;

	@Column(name = "last_name", columnDefinition = "VARCHAR(20) DEFAULT NULL")
	private String lastName;
	
	@Column(name = "email", columnDefinition = "VARCHAR(250) NOT NULL")
	private String email;
	
	@Column(name = "password", columnDefinition = "CHAR(32) NOT NULL")
	private String password;

	@ManyToMany(mappedBy = "users")
	private List<Role> roles;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}
