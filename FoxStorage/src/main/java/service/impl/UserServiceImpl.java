package service.impl;

import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.transaction.Transactional;

import dto.UserDto;
import exception.NotAuthException;
import model.User;
import repository.UserRepository;
import service.UserService;
import service.util.BaseServiceImpl;

@Transactional
public class UserServiceImpl extends BaseServiceImpl implements UserService {

	@Inject
	private UserRepository repository;

	@Override
	public UserDto validateUser(String email, String password) throws NotAuthException {
		return null;
	}

	@Override
	public UserDto registerUser(UserDto userDto) throws NotAuthException {
		Pattern pattern = Pattern.compile("^(.+)@(.+)$");
		if (userDto.getEmail() != null) {
			userDto.setEmail(userDto.getEmail().toLowerCase());
		}
		if (!pattern.matcher(userDto.getEmail()).matches()) {
			throw new NotAuthException("Invalid email format");
		}
		
		Long count = repository.getCountByEmail(userDto.getEmail());
		if (count > 0) {
			throw new NotAuthException("Email already in use");
		}
		User convertedUser = getMapper().convert(userDto);
		User createdUser = repository.create(convertedUser);
		return getMapper().convert(createdUser);
	}
}
