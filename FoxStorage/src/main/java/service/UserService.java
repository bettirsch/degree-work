package service;

import dto.UserDto;
import exception.NotAuthException;

public interface UserService {

	String validateUser(String email, String password) throws NotAuthException;
	
	String registerUser(UserDto userDto) throws NotAuthException;
	
}
