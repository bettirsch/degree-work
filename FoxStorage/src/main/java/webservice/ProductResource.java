package webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import utils.enums.UserRoles;
import utils.security.Secure;

@Path("/product")
public interface ProductResource {

	// http://localhost:8080/FoxStorage/product/products
	@GET
	@Path("/products")
	@Secure(roleNames = UserRoles.WAREHOUSE_EMPLOYEE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllProducts();
	
}
