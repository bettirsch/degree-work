package dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import model.Role;
import utils.enums.UserRoles;

public class UserDto extends BaseDto {

	@NotNull
	private String username;
	private String firstName;
	private String middleName;
	private String lastName;
	@NotNull
	private String email;
	private List<UserRoles> roles;

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

	public List<UserRoles> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		List<UserRoles> userRoles = new ArrayList<>();
		for (Role role : roles) {
			userRoles.add(role.getRoleName());
		}
		this.roles = userRoles;
	}

	@Override
	public String toString() {
		return "UserDto [username=" + username + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", email=" + email + ", roles=" + roles + "]";
	}
	
}
