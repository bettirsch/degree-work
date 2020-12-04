package webservice;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dto.FormHeadWriteDto;
import dto.FormItemWriteDto;
import utils.enums.UserRoles;
import utils.security.Secure;

@Path("/form")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface FormResource {

	// http://localhost:8080/FoxStorage/form/{id}/form-item
	@POST
	@Path("/{id}/form-item")
	@Secure(roleNames = {UserRoles.REGIONAL_REPRESENTATIVE})
	public Response addFormItemToForm(@PathParam("id") Integer formId, @Valid FormItemWriteDto formItemDto);
	
	// http://localhost:8080/FoxStorage/form/{id}/form-item/{formItemId}
	@DELETE
	@Path("/{id}/form-item/{formItemId}")
	@Secure(roleNames = {UserRoles.REGIONAL_REPRESENTATIVE})
	public Response removeFormItemFromForm(@PathParam("id") Integer formId, @PathParam("formItemId") Integer formItemId);
	
	// http://localhost:8080/FoxStorage/form/{id}
	@GET
	@Path("/{id}")
	@Secure(roleNames = {UserRoles.WAREHOUSE_EMPLOYEE,
		UserRoles.OFFICE_MANAGER,
		UserRoles.REGIONAL_REPRESENTATIVE})
	public Response getForm(@PathParam("id") Integer id);
	
	// http://localhost:8080/FoxStorage/form/{id}/toShipment
	@POST
	@Path("/{id}/to-shipment")
	@Secure(roleNames = {UserRoles.WAREHOUSE_EMPLOYEE,
		UserRoles.OFFICE_MANAGER,
		UserRoles.REGIONAL_REPRESENTATIVE})
	public Response formToShipment(@PathParam("id") Integer id);
	
	// http://localhost:8080/FoxStorage/form/{id}/toInvoice
	@POST
	@Path("/{id}/to-invoice")
	@Secure(roleNames = {UserRoles.WAREHOUSE_EMPLOYEE,
		UserRoles.OFFICE_MANAGER,
		UserRoles.REGIONAL_REPRESENTATIVE})
	public Response formToInvoice(@PathParam("id") Integer id);
	
	// http://localhost:8080/FoxStorage/form/{id}/finish
	@POST
	@Path("/{id}/finish")
	@Secure(roleNames = {UserRoles.WAREHOUSE_EMPLOYEE,
		UserRoles.OFFICE_MANAGER,
		UserRoles.REGIONAL_REPRESENTATIVE})
	public Response finishForm(@PathParam("id") Integer id);
	
	// http://localhost:8080/FoxStorage/form/orders
	@GET
	@Path("/orders")
	@Secure(roleNames = {UserRoles.WAREHOUSE_EMPLOYEE,
		UserRoles.OFFICE_MANAGER,
		UserRoles.REGIONAL_REPRESENTATIVE})
	public Response getAllOrderForms();
	
	// http://localhost:8080/FoxStorage/form/orders
	@POST
	@Path("/orders")
	@Secure(roleNames = {UserRoles.REGIONAL_REPRESENTATIVE})
	public Response createOrderForm(@Valid FormHeadWriteDto formHeadDto);

	// http://localhost:8080/FoxStorage/form/shipments
	@GET
	@Path("/shipments")
	@Secure(roleNames = {UserRoles.WAREHOUSE_EMPLOYEE,
		UserRoles.OFFICE_MANAGER,
		UserRoles.REGIONAL_REPRESENTATIVE})
	public Response getAllShipmentForms();
	
	// http://localhost:8080/FoxStorage/form/shipments
	@POST
	@Path("/shipments")
	@Secure(roleNames = {UserRoles.REGIONAL_REPRESENTATIVE})
	public Response createShipmentForm(@Valid FormHeadWriteDto formHeadDto);

	// http://localhost:8080/FoxStorage/form/invoices
	@GET
	@Path("/invoices")
	@Secure(roleNames = {UserRoles.WAREHOUSE_EMPLOYEE,
		UserRoles.OFFICE_MANAGER,
		UserRoles.REGIONAL_REPRESENTATIVE})
	public Response getAllInvoiceForms();

	// http://localhost:8080/FoxStorage/form/invoices
	@POST
	@Path("/invoices")
	@Secure(roleNames = {UserRoles.REGIONAL_REPRESENTATIVE})
	public Response createInvoiceForm(@Valid FormHeadWriteDto formHeadDto);
	
	// http://localhost:8080/FoxStorage/form/inventory-movements
	@GET
	@Path("/inventory-movements")
	@Secure(roleNames = {UserRoles.WAREHOUSE_EMPLOYEE,
		UserRoles.OFFICE_MANAGER,
		UserRoles.REGIONAL_REPRESENTATIVE})
	public Response getAllInventoryMovementForms();
	
	// http://localhost:8080/FoxStorage/form/inventory-movements
	@POST
	@Path("/inventory-movements")
	@Secure(roleNames = {UserRoles.REGIONAL_REPRESENTATIVE})
	public Response createInventoryMovementForm(@Valid FormHeadWriteDto formHeadDto);
}
