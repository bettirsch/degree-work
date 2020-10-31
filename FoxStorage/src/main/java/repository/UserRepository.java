package repository;

import javax.ws.rs.NotAuthorizedException;

import model.User;
import repository.util.BaseRepository;

public interface UserRepository extends BaseRepository<User> {
	
	User findByEmail(String email) throws NotAuthorizedException;

	Long getCountByEmail(String email);  
}
