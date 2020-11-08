package mockitoTests.userService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;

import dto.UserDtoRegister;
import utils.enums.UserRoles;

public class TestRegister extends UserServiceTest {

	@Test
	public void registerUserSuccess() {
		String returnedToken = registerUser(0, super.userDtoRegister);
		assertEquals(false, returnedToken.isEmpty());
	}
	
	@Test(expected = RuntimeException.class)
	public void registerUserEmailAlreadyInUse() {
		registerUser(1, super.userDtoRegister);
	}
	
	@Test(expected = RuntimeException.class)
	public void registerUserInvalidEmail() {
		registerUser(0, super.userDtoRegisterWithInvalidEmail);
	}

	private String registerUser(int countedEmails, UserDtoRegister userDtoRegister) {
		when(userRepository.getCountByEmail(EMAIL)).thenReturn(new Long(countedEmails));
		when(mapper.convert(userDtoRegister)).thenReturn(userEntity);
		when(userRepository.create(userEntity)).thenReturn(userEntity);
		when(roleRepository.findByRoleName(UserRoles.VISITOR)).thenReturn(visitorRole);
		String returnedToken = userService.registerUser(userDtoRegister);
		verify(userRepository).getCountByEmail(EMAIL);
		verify(mapper).convert(userDtoRegister);
		verify(userRepository).create(userEntity);
		verify(roleRepository).findByRoleName(UserRoles.VISITOR);
		return returnedToken;
	}
}
