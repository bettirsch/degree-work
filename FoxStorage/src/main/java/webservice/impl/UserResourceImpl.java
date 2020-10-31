package webservice.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import dto.LoginDto;
import dto.UserDto;
import service.UserService;
import webservice.UserResource;

@Stateless
public class UserResourceImpl implements UserResource{
	
	@Inject
	private UserService userService;
	
	@Override
	public Response registerUser(UserDto userDto) {
		try {
			UserDto createdUser = userService.registerUser(userDto);
			return Response.status(Response.Status.OK).entity(createdUser).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@Override
	public Response loginUser(LoginDto loginDto) {
		try {
			UserDto validatedUser = userService.validateUser(loginDto.getEmail(), loginDto.getPassword());
			return Response.status(Response.Status.OK).entity(validatedUser).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}
	
	
}
