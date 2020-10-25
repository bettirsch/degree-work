package webservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dto.ProductDto;
import service.ProductService;

@Path("/MyRestService")
@ApplicationPath("/resources")
@Stateless
public class RestService extends Application {

	@Inject
	private ProductService productService;

	// http://localhost:8080/FoxStorage/resources/MyRestService/sayHello
	@GET
	@Path("/sayHello")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHelloMsg() {
		try {
			List<ProductDto> productDtos = productService.getAllInstances();
			return Response.status(Response.Status.OK).entity(productDtos).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Err").build();
		}
	}
}
