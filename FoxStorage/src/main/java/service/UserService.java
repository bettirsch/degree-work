package service;

import java.util.List;

import dto.UserReadDto;
import dto.UserRegisterDto;
import dto.UserWriteDto;

public interface UserService {

	String validateUser(String email, String password) throws RuntimeException;
	
	String registerUser(UserRegisterDto userDto) throws RuntimeException;
	
	List<UserReadDto> getAllUser();

	UserReadDto updateUser(UserWriteDto dto);
	
}
