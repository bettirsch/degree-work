package repository.impl;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.TypedQuery;
import javax.ws.rs.NotAuthorizedException;

import exception.NotAuthException;
import model.User;
import repository.UserRepository;
import repository.util.BaseRepositoryImpl;

public class UserRepositoryImpl extends BaseRepositoryImpl<User> implements UserRepository {

	public UserRepositoryImpl() {
		super(User.class);
	}

	@Override
	public User create(User entity) {
		try {
			return super.create(entity);
		} catch (Exception e) {
			throw new NotAuthException("Invalid details. Failed to create account");
		}
	}

	@Override
	public User findByEmailAndPassword(String email, String password) throws NotAuthorizedException {
		Map<String, String> queryParamMap = new HashMap<>();
		queryParamMap.put("email", email);
		queryParamMap.put("password", password);
		User findedUser = createTypedQuerySingleResult("User.findByEmailAndPassword", queryParamMap);
		return findedUser;
	}

	@Override
	public Long getCountByEmail(String email) {
		TypedQuery<Long> query = getEntityManager().createNamedQuery("User.countByEmail", Long.class);
		query.setParameter("email", email);
		return query.getSingleResult();
	}

}
