package webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import utils.enums.UserRoles;
import utils.security.Secure;

@Path("/inventory")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface InventoryItemResource {
	
	// http://localhost:8080/FoxStorage/inventory/product/{id}
	@GET
	@Path("/product/{id}")
	@Secure(roleNames = {UserRoles.WAREHOUSE_EMPLOYEE,
			UserRoles.OFFICE_MANAGER,
			UserRoles.REGIONAL_REPRESENTATIVE})
	public Response getProductInventories(@PathParam("id") Integer productId);
	
	// http://localhost:8080/FoxStorage/inventory/facility/{id}
	@GET
	@Path("/facility/{id}")
	@Secure(roleNames = {UserRoles.WAREHOUSE_EMPLOYEE,
			UserRoles.OFFICE_MANAGER,
			UserRoles.REGIONAL_REPRESENTATIVE})
	public Response getFacilityInventories(@PathParam("id") Integer facilityId);
}
