package webservice;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dto.ProductDto;
import utils.enums.UserRoles;
import utils.security.Secure;

@Path("/product")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface ProductResource {

	// http://localhost:8080/FoxStorage/product
	@GET
	@Secure(roleNames = {UserRoles.WAREHOUSE_EMPLOYEE,
			UserRoles.OFFICE_MANAGER,
			UserRoles.REGIONAL_REPRESENTATIVE})
	public Response getAllProducts();

	// http://localhost:8080/FoxStorage/product
	@POST
	@Secure(roleNames = {UserRoles.WAREHOUSE_EMPLOYEE,
			UserRoles.OFFICE_MANAGER})
	public Response createProduct(@Valid ProductDto dto);

	// http://localhost:8080/FoxStorage/product/{id}
	@GET
	@Path("/{id}")
	@Secure(roleNames = {UserRoles.WAREHOUSE_EMPLOYEE,
			UserRoles.OFFICE_MANAGER,
			UserRoles.REGIONAL_REPRESENTATIVE})
	public Response getProduct(@PathParam("id") Integer id);
	
	// http://localhost:8080/FoxStorage/product/{id}
	@POST
	@Path("/{id}")
	@Secure(roleNames = {UserRoles.WAREHOUSE_EMPLOYEE,
			UserRoles.OFFICE_MANAGER})
	public Response updateProduct(@PathParam("id") Integer id, @Valid ProductDto dto);
	
	// http://localhost:8080/FoxStorage/product/{id}
	@DELETE
	@Path("/{id}")
	@Secure(roleNames = {UserRoles.OFFICE_MANAGER})
	public Response deleteProduct(@PathParam("id") Integer id);
}
