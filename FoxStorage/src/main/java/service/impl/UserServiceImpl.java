package service.impl;

import java.security.Key;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.mindrot.jbcrypt.BCrypt;

import dto.UserDto;
import exception.NotAuthException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import model.User;
import repository.UserRepository;
import security.KeyGen;
import service.UserService;
import service.util.BaseServiceImpl;

@Transactional
public class UserServiceImpl extends BaseServiceImpl implements UserService {

	@Inject
	private UserRepository repository;

	@Override
	public String validateUser(String email, String password) throws NotAuthException {
		String lowerCaseEmail = validateAndLowerCaseEmail(email);
		User findedUser = repository.findByEmail(lowerCaseEmail);
		if (findedUser == null || !BCrypt.checkpw(password, findedUser.getPassword())) {
			throw new NotAuthException("Invalid email/password");
		}
		return generateJWTToken(findedUser);
	}

	@Override
	public String registerUser(UserDto userDto) throws NotAuthException {
		userDto.setEmail(validateAndLowerCaseEmail(userDto.getEmail()));
		String hashedPassword = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt(10));
		userDto.setPassword(hashedPassword);
		Long count = repository.getCountByEmail(userDto.getEmail());
		if (count > 0) {
			throw new NotAuthException("Email already in use");
		}
		User convertedUser = getMapper().convert(userDto);
		User createdUser = repository.create(convertedUser);
		return generateJWTToken(createdUser);
	}

	private String validateAndLowerCaseEmail(String email) {
		Pattern pattern = Pattern.compile("^(.+)@(.+)$");
		if (email == null || !pattern.matcher(email).matches()) {
			throw new NotAuthException("Invalid email format");
		}
		return email.toLowerCase();
	}

	private String generateJWTToken(User user) {
		Calendar cal = Calendar.getInstance(Locale.GERMANY);
        Calendar cal1 = Calendar.getInstance(Locale.GERMANY);
        cal1.setTime(cal.getTime());
        cal1.add(Calendar.MINUTE, 10);
		Key secretKey = KeyGen.getKey();
		String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, secretKey).setIssuedAt(cal.getTime())
				.setExpiration(cal1.getTime()).claim("userId", user.getId()).compact();
		return token;

	}

}
