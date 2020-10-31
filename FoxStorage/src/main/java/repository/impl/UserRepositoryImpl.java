package repository.impl;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.TypedQuery;
import javax.ws.rs.NotAuthorizedException;

import model.User;
import repository.UserRepository;
import repository.util.BaseRepositoryImpl;

public class UserRepositoryImpl extends BaseRepositoryImpl<User> implements UserRepository {

	public UserRepositoryImpl() {
		super(User.class);
	}

	@Override
	public User create(User entity) {
		return super.create(entity);
	}

	@Override
	public User findByEmail(String email) throws NotAuthorizedException {
		Map<String, String> queryParamMap = new HashMap<>();
		queryParamMap.put("email", email);
		User findedUser = createTypedQuerySingleResult("User.findByEmail", queryParamMap);
		return findedUser;
	}

	@Override
	public Long getCountByEmail(String email) {
		TypedQuery<Long> query = getEntityManager().createNamedQuery("User.countByEmail", Long.class);
		query.setParameter("email", email);
		return query.getSingleResult();
	}

}
