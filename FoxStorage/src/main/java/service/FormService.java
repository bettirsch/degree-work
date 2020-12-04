package service;

import java.util.List;

import dto.FormDto;
import dto.FormHeadReadDto;
import dto.FormHeadWriteDto;
import dto.FormItemWriteDto;
import utils.enums.FormType;

public interface FormService {

	Integer createForm(FormHeadWriteDto formHeadDto, FormType formType) throws RuntimeException;

	Integer addFormItemToForm(Integer formId, FormItemWriteDto formItemDto) throws RuntimeException;

	void removeFormItemFromForm(Integer formId, Integer formItemId) throws RuntimeException;
	
	FormDto getForm(Integer id) throws RuntimeException;
	
	List<FormHeadReadDto> getAllOrders();
	
	List<FormHeadReadDto> getAllShipmentsForms();
	
	List<FormHeadReadDto> getAllInvoiceForms();
	
	List<FormHeadReadDto> getAllInventoryMovementForms();
}
