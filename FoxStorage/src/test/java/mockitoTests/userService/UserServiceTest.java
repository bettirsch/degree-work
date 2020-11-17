package mockitoTests.userService;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import dto.UserDtoRegister;
import model.Role;
import model.User;
import repository.RoleRepository;
import repository.UserRepository;
import service.UserService;
import service.impl.UserServiceImpl;
import service.mapper.ModelMapper;
import utils.enums.UserRoles;

public class UserServiceTest {
	protected UserService userService;
	
	protected ModelMapper mapper = Mockito.mock(ModelMapper.class);
	protected UserRepository userRepository = Mockito.mock(UserRepository.class);
	protected RoleRepository roleRepository = Mockito.mock(RoleRepository.class);

	protected User userEntity;
	protected UserDtoRegister userDtoRegister;
	protected UserDtoRegister userDtoRegisterWithInvalidEmail;
	protected Role visitorRole;
	
	protected final static String EMAIL = "email@email.com";
	protected final static String INVALID_EMAIL = "emailemail.com";
	protected final static String PASSWORD = "admin";
	protected final static String HASHED_PASSWORD = "$2a$10$nYprTTsDAIsr/HrK9VJHrOXTqoIJtdDGPNRdDnhbjA9kXIpEq1CGO";
	protected final static String USERNAME = "testUser";

	@BeforeEach
	public void setUp() {
		this.userService = new UserServiceImpl(userRepository, roleRepository, mapper);
		this.userEntity = setUserEntity();
		this.userDtoRegister = setUserDtoRegister(EMAIL);
		this.userDtoRegisterWithInvalidEmail = setUserDtoRegister(INVALID_EMAIL);
		this.visitorRole = setVisitorRole();
	}
	
	private User setUserEntity() {
		List<Role> roles = setRoles();
		User userEntity = new User(
				USERNAME,
				EMAIL,
				HASHED_PASSWORD,
				roles);
		return userEntity;
	}

	private List<Role> setRoles() {
		Role role = new Role();
		role.setRoleName(UserRoles.ADMIN);
		List<Role> roles = new ArrayList<>();
		roles.add(role);
		return roles;
	}
	
	private Role setVisitorRole() {
		Role role = new Role();
		role.setRoleName(UserRoles.VISITOR);
		return role;
	}
	
	private UserDtoRegister setUserDtoRegister(String email) {
		UserDtoRegister userDtoRegister = new UserDtoRegister();
		userDtoRegister.setEmail(email);
		userDtoRegister.setPassword(PASSWORD);
		userDtoRegister.setUsername(USERNAME);
		return userDtoRegister;
	}
}