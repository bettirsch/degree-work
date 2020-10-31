package service.impl;

import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.mindrot.jbcrypt.BCrypt;

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
		String lowerCaseEmail = validateAndLowerCaseEmail(email);
		User findedUser = repository.findByEmail(lowerCaseEmail);
		if (findedUser == null || !BCrypt.checkpw(password, findedUser.getPassword())) {
			throw new NotAuthException("Invalid email/password");
		}
		return getMapper().convert(findedUser);
	}

	@Override
	public UserDto registerUser(UserDto userDto) throws NotAuthException {
		userDto.setEmail(validateAndLowerCaseEmail(userDto.getEmail()));
		String hashedPassword = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt(10));
		userDto.setPassword(hashedPassword);
		Long count = repository.getCountByEmail(userDto.getEmail());
		if (count > 0) {
			throw new NotAuthException("Email already in use");
		}
		User convertedUser = getMapper().convert(userDto);
		User createdUser = repository.create(convertedUser);
		return getMapper().convert(createdUser);
	}

	private String validateAndLowerCaseEmail(String email) {
		Pattern pattern = Pattern.compile("^(.+)@(.+)$");
		if (email == null || !pattern.matcher(email).matches()) {
			throw new NotAuthException("Invalid email format");
		}
		return email.toLowerCase();
	}
}
