package webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/product")
public interface ProductResource {

	// http://localhost:8080/FoxStorage/product/products
	@GET
	@Path("/products")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllProducts();
	
}
