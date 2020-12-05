package mockitoTests.userService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dto.UserRegisterDto;
import utils.enums.UserRoles;

public class TestRegister extends UserServiceTest {

	@Test
	@DisplayName("Should generate a token after successfully register new user.")
	public void registerUserSuccess() {
		String returnedToken = registerUser(0, super.userDtoRegister);
		assertEquals(false, returnedToken.isEmpty());
	}
	
	@Test
	@DisplayName("Should throw exception during user registration, because of email already in use.")
	public void registerUserEmailAlreadyInUse() {
		assertThrows(RuntimeException.class, ()->{
			registerUser(1, super.userDtoRegister);		
		});
	}
	
	@Test
	@DisplayName("Should throw exception during user validation, because of email already in use.")
	public void registerUserInvalidEmail() {
		assertThrows(RuntimeException.class, ()->{
			registerUser(0, super.userDtoRegisterWithInvalidEmail);
		});
	}

	private String registerUser(int countedEmails, UserRegisterDto userDtoRegister) {
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
