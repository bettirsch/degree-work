package webservice;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dto.UserLoginDto;
import dto.UserRegisterDto;
import dto.UserWriteDto;
import utils.enums.UserRoles;
import utils.security.Secure;

@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface UserResource {
	
	// http://localhost:8080/FoxStorage/user/register
	@POST
	@Path("/register")
	public Response registerUser(@Valid UserRegisterDto userDto);

	// http://localhost:8080/FoxStorage/user/login
	@POST
	@Path("/login")
	public Response loginUser(@Valid UserLoginDto loginDto);
	
	// http://localhost:8080/FoxStorage/user/login
	@GET
	@Secure(roleNames = UserRoles.OFFICE_MANAGER)
	public Response allUser();

	@POST
	@Secure(roleNames = UserRoles.ADMIN)
	public Response updateUser(@Valid UserWriteDto dto);
	
}
