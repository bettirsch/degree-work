package webservice.impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import dto.FormDto;
import dto.FormHeadReadDto;
import dto.FormHeadWriteDto;
import dto.FormItemWriteDto;
import service.FormService;
import utils.enums.FormType;
import webservice.FormResource;

@Transactional
public class FormResourceImpl implements FormResource{

	@Inject
	private FormService formService;

	@Override
	public Response addFormItemToForm(Integer formId, FormItemWriteDto formItemDto) {
		try {
			Integer formItemId = formService.addFormItemToForm(formId, formItemDto);
			return Response.status(Response.Status.OK).entity(formItemId).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@Override
	public Response removeFormItemFromForm(Integer formId, Integer formItemId) {
		try {
			formService.removeFormItemFromForm(formId, formItemId);
			return Response.status(Response.Status.OK).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}
	
	@Override
	public Response getForm(Integer id) {
		try {
			FormDto form = formService.getForm(id);
			return Response.status(Response.Status.OK).entity(form).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@Override
	public Response getAllOrderForms() {
		try {
			List<FormHeadReadDto> forms = formService.getAllOrders();
			return Response.status(Response.Status.OK).entity(forms).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@Override
	public Response getAllShipmentForms() {
		try {
			List<FormHeadReadDto> forms = formService.getAllShipmentsForms();
			return Response.status(Response.Status.OK).entity(forms).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@Override
	public Response getAllInvoiceForms() {
		try {
			List<FormHeadReadDto> forms = formService.getAllInvoiceForms();
			return Response.status(Response.Status.OK).entity(forms).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@Override
	public Response getAllInventoryMovementForms() {
		try {
			List<FormHeadReadDto> forms = formService.getAllInventoryMovementForms();
			return Response.status(Response.Status.OK).entity(forms).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@Override
	public Response createOrderForm(FormHeadWriteDto formHeadDto) {
		return createForm(formHeadDto, FormType.ORDER);
	}

	@Override
	public Response createShipmentForm(FormHeadWriteDto formHeadDto) {
		return createForm(formHeadDto, FormType.SHIPMENT);
	}

	@Override
	public Response createInvoiceForm(FormHeadWriteDto formHeadDto) {
		return createForm(formHeadDto, FormType.SHIPMENT);
	}

	@Override
	public Response createInventoryMovementForm(FormHeadWriteDto formHeadDto) {
		return createForm(formHeadDto, FormType.SHIPMENT);
	}
	
	private Response createForm(FormHeadWriteDto formHeadDto, FormType formType) {
		try {
			Integer formID = formService.createForm(formHeadDto, formType);
			return Response.status(Response.Status.OK).entity(formID).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@Override
	public Response formToShipment(Integer id) {
		return createFormFromForm(id, FormType.SHIPMENT);
	}

	@Override
	public Response formToInvoice(Integer id) {
		return createFormFromForm(id, FormType.INVOICE);
	}
	private Response createFormFromForm(Integer id, FormType formType) {
		try {
			Integer formId = formService.createFormFromForm(id, formType);
			return Response.status(Response.Status.OK).entity(formId).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}
	@Override
	public Response finishForm(Integer id) {
		try {
			formService.finishForm(id);
			return Response.status(Response.Status.OK).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}
}
