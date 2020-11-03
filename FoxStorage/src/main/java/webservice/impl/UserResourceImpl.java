package webservice.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import dto.LoginDto;
import dto.UserDto;
import dto.UserDtoRegister;
import service.UserService;
import webservice.UserResource;

@Stateless
public class UserResourceImpl implements UserResource{
	
	@Inject
	private UserService userService;
	
	@Override
	public Response registerUser(UserDtoRegister userDto) {
		try {
			String token = userService.registerUser(userDto);
			return Response.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + token).build();
		} catch (Exception e) {
			return Response.status(Status.UNAUTHORIZED).entity(e.getMessage()).build();
		}
	}

	@Override
	public Response loginUser(LoginDto loginDto) {
		try {
			String token = userService.validateUser(loginDto.getEmail(), loginDto.getPassword());
			return Response.ok().header("AUTHORIZATION", "Bearer " + token).build();
		} catch (Exception e) {
			return Response.status(Status.UNAUTHORIZED).entity(e.getMessage()).build();
		}
	}

	@Override
	public Response allUser() {
		try {
			List<UserDto> users = userService.getAllUser();
			return Response.ok().entity(users).build();
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}
	
	
}
