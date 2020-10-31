package repository;

import javax.ws.rs.NotAuthorizedException;

import model.User;
import repository.util.BaseRepository;

public interface UserRepository extends BaseRepository<User> {
	
	User findByEmailAndPassword(String email, String password) throws NotAuthorizedException;

	Long getCountByEmail(String email);  
}
