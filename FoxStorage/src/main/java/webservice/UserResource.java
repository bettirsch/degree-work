package webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dto.LoginDto;
import dto.UserDtoRegister;
import utils.enums.UserRoles;
import utils.security.Secure;

@Path("/user")
public interface UserResource {
	
	// http://localhost:8080/FoxStorage/user/register
	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registerUser(UserDtoRegister userDto);

	// http://localhost:8080/FoxStorage/user/login
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response loginUser(LoginDto loginDto);
	
	// http://localhost:8080/FoxStorage/user/login
	@GET
	@Path("/users")
	@Secure(roleNames = UserRoles.OFFICE_MANAGER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response allUser();

}
