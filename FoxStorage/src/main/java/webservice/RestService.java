package webservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dto.ProductDto;
import dto.UserDto;
import service.ProductService;
import service.UserService;

@Path("/api")
@ApplicationPath("/resources")
@Stateless
public class RestService extends Application {

	@Inject
	private ProductService productService;
	
	@Inject
	private UserService userService;

	// http://localhost:8080/FoxStorage/resources/api/sayHello
	@GET
	@Path("/sayHello")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHelloMsg() {
		try {
			List<ProductDto> productDtos = productService.getAllProduct();
			return Response.status(Response.Status.OK).entity(productDtos).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Err").build();
		}
	}
	
	// http://localhost:8080/FoxStorage/resources/api/register
	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registerUser(UserDto userDto) {
		try {
			UserDto createdUser = userService.registerUser(userDto);
			return Response.status(Response.Status.OK).entity(createdUser).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}
	
	
}
