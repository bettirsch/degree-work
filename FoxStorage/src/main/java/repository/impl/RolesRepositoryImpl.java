package repository.impl;

import model.Role;
import repository.RoleRepository;
import repository.util.BaseRepositoryImpl;
import utils.enums.UserRoles;

public class RolesRepositoryImpl extends BaseRepositoryImpl<Role> implements RoleRepository{

	public RolesRepositoryImpl() {
		super(Role.class);
	}

	@Override
	public Role findByRoleName(UserRoles role) {
		return createTypedQuerySingleResult("Role.findByRoleName", "roleName", role);
	}

}
