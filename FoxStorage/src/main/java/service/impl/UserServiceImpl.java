package service.impl;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import javax.crypto.SecretKey;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.mindrot.jbcrypt.BCrypt;

import dto.UserReadDto;
import dto.UserRegisterDto;
import dto.UserWriteDto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import model.Role;
import model.User;
import repository.RoleRepository;
import repository.UserRepository;
import service.UserService;
import service.mapper.ModelMapper;
import service.util.BaseServiceImpl;
import utils.enums.UserRoles;
import utils.logger.Loggable;
import utils.security.KeyGen;

@Transactional
@Loggable
public class UserServiceImpl extends BaseServiceImpl implements UserService {

	@Inject
	private UserRepository userRepository;

	@Inject
	private RoleRepository roleRepository;

	public UserServiceImpl() {
		super();
	}

	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, ModelMapper mapper) {
		super(mapper);
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	@Override
	public List<UserReadDto> getAllUser() {
		List<User> entityList = userRepository.findAll();
		List<UserReadDto> dtoList = new ArrayList<>();
		entityList.stream().forEach(entity -> {
			dtoList.add(getMapper().convert(entity));
		});
		return dtoList;
	}

	@Override
	public String validateUser(String email, String password) throws RuntimeException {
		String lowerCaseEmail = validateAndLowerCaseEmail(email);
		User findedUser = userRepository.findByEmail(lowerCaseEmail);
		if (findedUser == null || !BCrypt.checkpw(password, findedUser.getPassword())) {
			throw new RuntimeException("Invalid email/password");
		}
		return generateJWTToken(concatUserRoles(findedUser), findedUser.getUsername());
	}

	@Override
	public String registerUser(UserRegisterDto userDto) throws RuntimeException {
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
		return generateJWTToken(UserRoles.VISITOR.toString(), convertedUser.getUsername());
	}

	private String validateAndLowerCaseEmail(String email) {
		Pattern pattern = Pattern.compile("^(.+)@(.+)$");
		if (email == null || !pattern.matcher(email).matches()) {
			throw new RuntimeException("Invalid email format");
		}
		return email.toLowerCase();
	}

	private String generateJWTToken(String userRoles, String userName) {
		Calendar cal = Calendar.getInstance(Locale.GERMANY);
		Calendar cal1 = Calendar.getInstance(Locale.GERMANY);
		cal1.setTime(cal.getTime());
		cal1.add(Calendar.MINUTE, 10);
		SecretKey secretKey;
		String token = "";
		try {
			secretKey = KeyGen.getSecretKey();
			token = Jwts.builder().signWith(SignatureAlgorithm.HS256, secretKey).setIssuedAt(cal.getTime())
					.setExpiration(cal1.getTime()).claim("userRoles", userRoles).claim("userName", userName).compact();
			if ("".equals(token)) {
				throw new RuntimeException("Token not generated!");
			}
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Token not generated!", e);
		}
		return token;

	}

	private String concatUserRoles(User user) {
		String roles = "";
		for (Role role : user.getRoles()) {
			roles += role.getRoleName() + ";";
		}
		return roles;
	}

	@Override
	public UserReadDto updateUser(UserWriteDto dto) {
		User updatableUser = userRepository.find(dto.getId());
		if (updatableUser == null) {
			throw new RuntimeException("A felhasználó nem található az adatbázisban!");
		}
		updatableUser.setFirstName(dto.getFirstName());
		updatableUser.setMiddleName(dto.getMiddleName());
		updatableUser.setLastName(dto.getLastName());
		List<Role> roles = new ArrayList<>();
		for (UserRoles roleName : dto.getRoles()) {
			Role findedRole = roleRepository.findByRoleName(roleName);
			if (findedRole != null) {
				roles.add(findedRole);
			}
		}
		if (!roles.isEmpty()) {
			updatableUser.setRoles(roles);	
		}
		User updatedUser = userRepository.update(updatableUser);
		return getMapper().convert(updatedUser);
	}
}
