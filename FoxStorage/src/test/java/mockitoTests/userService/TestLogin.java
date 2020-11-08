package mockitoTests.userService;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import model.User;

public class TestLogin extends UserServiceTest {

	@Test
	public void validateUserSuccess() {
		String returnedToken =
				validateUser(EMAIL, PASSWORD, userEntity);
		assertEquals(false, returnedToken.isEmpty());
	}

	@Test(expected = RuntimeException.class)
	public void validateUserWrongEmailFormat() {
		validateUser(INVALID_EMAIL, PASSWORD, userEntity);
	}
	
	@Test(expected = RuntimeException.class)
	public void validateUserUserNotFound() {
		validateUser(EMAIL, PASSWORD, null);
	}

	private String validateUser(String email, String password, User resultEntity) {
		when(userRepository.findByEmail(email)).thenReturn(resultEntity);
		when(mapper.convert(userDtoRegister)).thenReturn(resultEntity);
		String returnedToken = userService.validateUser(email, password);
		verify(userRepository).findByEmail(email);
		return returnedToken;
	}
	

	
}
