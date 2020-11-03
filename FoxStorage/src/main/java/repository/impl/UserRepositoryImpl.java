package repository.impl;

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
	public User findByEmail(String email) throws NotAuthorizedException {
		return createTypedQuerySingleResult("User.findByEmail", "email", email);
	}

	@Override
	public Long getCountByEmail(String email) {
		TypedQuery<Long> query = getEntityManager().createNamedQuery("User.countByEmail", Long.class);
		query.setParameter("email", email);
		return query.getSingleResult();
	}

}
