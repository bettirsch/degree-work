package mockitoTests.userService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import model.User;

public class TestLogin extends UserServiceTest {

	@Test
	@DisplayName("Should generate a token after successfully validate the user.")
	public void validateUserSuccess() {
		String returnedToken =
				validateUser(EMAIL, PASSWORD, userEntity);
		assertEquals(false, returnedToken.isEmpty());
	}

	@Test
	@DisplayName("Should throw exception during user validation, because of invalid email format.")
	public void validateUserWrongEmailFormat() {
		assertThrows(RuntimeException.class, ()->{
			validateUser(INVALID_EMAIL, PASSWORD, userEntity);
		});
	}
	
	@Test
	@DisplayName("Should throw exception during user validation, because of user not found.")
	public void validateUserUserNotFound() {
		assertThrows(RuntimeException.class, ()->{
			validateUser(EMAIL, PASSWORD, null);		
		});
	}

	private String validateUser(String email, String password, User resultEntity) {
		when(userRepository.findByEmail(email)).thenReturn(resultEntity);
		when(mapper.convert(userDtoRegister)).thenReturn(resultEntity);
		String returnedToken = userService.validateUser(email, password);
		verify(userRepository).findByEmail(email);
		return returnedToken;
	}
	

	
}
