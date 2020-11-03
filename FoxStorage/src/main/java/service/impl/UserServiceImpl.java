package service.impl;

import java.security.Key;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.mindrot.jbcrypt.BCrypt;

import dto.UserDto;
import dto.UserDtoRegister;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import model.Role;
import model.User;
import repository.RoleRepository;
import repository.UserRepository;
import service.UserService;
import service.util.BaseServiceImpl;
import utils.enums.UserRoles;
import utils.security.KeyGen;

@Transactional
public class UserServiceImpl extends BaseServiceImpl implements UserService {

	@Inject
	private UserRepository userRepository;

	@Inject
	private RoleRepository roleRepository;
	
	@Override
	public List<UserDto> getAllUser() {
        List<User> entityList = userRepository.findAll();
        List<UserDto> dtoList = new ArrayList<>();
        for (User entity: entityList) {
            dtoList.add(getMapper().convert(entity));
        }
        return dtoList;
    }

	@Override
	public String validateUser(String email, String password) throws RuntimeException {
		String lowerCaseEmail = validateAndLowerCaseEmail(email);
		User findedUser = userRepository.findByEmail(lowerCaseEmail);
		if (findedUser == null || !BCrypt.checkpw(password, findedUser.getPassword())) {
			throw new RuntimeException("Invalid email/password");
		}
		return generateJWTToken(concatUserRoles(findedUser));
	}

	@Override
	public String registerUser(UserDtoRegister userDto) throws RuntimeException {
		userDto.setEmail(validateAndLowerCaseEmail(userDto.getEmail()));
		String hashedPassword = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt(10));
		userDto.setPassword(hashedPassword);
		Long count = userRepository.getCountByEmail(userDto.getEmail());
		if (count > 0) {
			throw new RuntimeException("Email already in use");
		}
		User convertedUser = getMapper().convert(userDto);
		Role role = roleRepository.findByRoleName(UserRoles.VISITOR);
		User createdUser = userRepository.create(convertedUser);
		role.addUser(createdUser);
		roleRepository.update(role);
		return generateJWTToken(UserRoles.VISITOR.toString());
	}

	private String validateAndLowerCaseEmail(String email) {
		Pattern pattern = Pattern.compile("^(.+)@(.+)$");
		if (email == null || !pattern.matcher(email).matches()) {
			throw new RuntimeException("Invalid email format");
		}
		return email.toLowerCase();
	}

	private String generateJWTToken(String userRoles) {
		Calendar cal = Calendar.getInstance(Locale.GERMANY);
        Calendar cal1 = Calendar.getInstance(Locale.GERMANY);
        cal1.setTime(cal.getTime());
        cal1.add(Calendar.MINUTE, 10);
		Key secretKey = KeyGen.getKey();
		String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, secretKey).setIssuedAt(cal.getTime())
				.setExpiration(cal1.getTime()).claim("userRoles", userRoles).compact();
		return token;

	}

	private String concatUserRoles(User user){
		String roles = "";
		for (Role role : user.getRoles()) {
			roles += role.getRoleName() + ";";
		}
		return roles;
	}
}
