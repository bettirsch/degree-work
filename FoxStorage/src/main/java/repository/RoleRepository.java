package repository;

import model.Role;
import repository.util.BaseRepository;
import utils.enums.UserRoles;

public interface RoleRepository extends BaseRepository<Role>{

	Role findByRoleName(UserRoles role);
}
