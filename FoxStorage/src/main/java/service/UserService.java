package service;

import java.util.List;

import dto.UserDto;
import dto.UserDtoRegister;

public interface UserService {

	String validateUser(String email, String password) throws RuntimeException;
	
	String registerUser(UserDtoRegister userDto) throws RuntimeException;
	
	List<UserDto> getAllUser();
	
}
