package webservice;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
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
public interface ProductResource {

	// http://localhost:8080/FoxStorage/product/products
	@GET
	@Path("/products")
	@Secure(roleNames = {UserRoles.WAREHOUSE_EMPLOYEE,
			UserRoles.OFFICE_MANAGER,
			UserRoles.REGIONAL_REPRESENTATIVE})
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllProducts();

	// http://localhost:8080/FoxStorage/product/create
	@POST
	@Path("/create")
	@Secure(roleNames = {UserRoles.WAREHOUSE_EMPLOYEE,
			UserRoles.OFFICE_MANAGER})
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createProduct(ProductDto dto);

	// http://localhost:8080/FoxStorage/product/{id}
	@GET
	@Path("/{id}")
	@Secure(roleNames = {UserRoles.WAREHOUSE_EMPLOYEE,
			UserRoles.OFFICE_MANAGER,
			UserRoles.REGIONAL_REPRESENTATIVE})
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProduct(@PathParam("id") Integer id);
}
