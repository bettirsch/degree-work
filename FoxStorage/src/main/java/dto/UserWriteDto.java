package dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import model.Role;
import utils.enums.UserRoles;

public class UserWriteDto extends BaseDto {

	private String firstName;
	private String middleName;
	private String lastName;
	@NotNull
	private List<UserRoles> roles;

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
		return "UserDto [firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", roles=" + roles + "]";
	}
	
}
