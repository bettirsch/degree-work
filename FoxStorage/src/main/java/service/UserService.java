package service;

import dto.UserDto;
import exception.NotAuthException;

public interface UserService {

	UserDto validateUser(String email, String password) throws NotAuthException;
	
	UserDto registerUser(UserDto userDto) throws NotAuthException;
	
}
