package webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dto.LoginDto;
import dto.UserDto;

@Path("/user")
public interface UserResource {
	
	// http://localhost:8080/FoxStorage/user/register
	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registerUser(UserDto userDto);

	// http://localhost:8080/FoxStorage/user/login
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response loginUser(LoginDto loginDto);
}
