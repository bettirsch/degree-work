package repository.impl;

import javax.persistence.TypedQuery;

import model.User;
import repository.UserRepository;
import repository.util.BaseRepositoryImpl;

public class UserRepositoryImpl extends BaseRepositoryImpl<User> implements UserRepository {

	public UserRepositoryImpl() {
		super(User.class);
	}

	@Override
	public User findByEmail(String email){
		return createTypedQuerySingleResult(User.FIND_BY_EMAIL, "email", email);
	}

	@Override
	public Long getCountByEmail(String email) {
		TypedQuery<Long> query = getEntityManager().createNamedQuery(User.COUNT_BY_EMAIL, Long.class);
		query.setParameter("email", email);
		return query.getSingleResult();
	}

}
