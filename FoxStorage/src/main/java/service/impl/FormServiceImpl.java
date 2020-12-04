package service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import dto.FormDto;
import dto.FormHeadReadDto;
import dto.FormHeadWriteDto;
import dto.FormItemReadDto;
import dto.FormItemWriteDto;
import model.Form;
import model.FormItem;
import repository.FormRepository;
import service.FormService;
import service.impl.formServiceDelegate.FormCreateDelegate;
import service.impl.formServiceDelegate.FormItemDelegate;
import service.util.BaseServiceImpl;
import utils.enums.FormStatus;
import utils.enums.FormType;
import utils.logger.Loggable;

@Transactional
@Loggable
public class FormServiceImpl extends BaseServiceImpl implements FormService {

	@Inject
	private FormRepository formRepository;

	@Inject
	private FormItemDelegate formItemDelegate;
	
	@Inject
	private FormCreateDelegate formCreateDelegate;

	@Override
	public Integer createForm(FormHeadWriteDto dto, FormType formType) throws RuntimeException {
		try {
			Form formToSave = getMapper().convert(dto);
			return formCreateDelegate.createForm(formToSave, formType);
		} catch (Exception e) {
			throw new RuntimeException("Nem sikerült a formot létrehozni!");
		}
	}

	@Override
	public Integer addFormItemToForm(Integer formId, FormItemWriteDto formItemDto) throws RuntimeException {
		Form form = formRepository.find(formId);
		if (form == null) {
			throw new RuntimeException("A form nem található az adatbázisban ezzel az id-val:" + formId);
		}
		if (FormStatus.FINISHED.equals(form.getFormStatus())) {
			throw new RuntimeException("Befejezett form-ot nem lehet módosítani!");
		}

		FormItem formItemToSaving = getMapper().convert(formItemDto);
		if (formItemToSaving.getProduct() == null) {
			throw new RuntimeException("A termék nem található az adatbázisban!" + formId);
		}
		return formItemDelegate.addFormItemToForm(form, formItemToSaving);
	}

	@Override
	public void removeFormItemFromForm(Integer formId, Integer formItemId) throws RuntimeException {
		Form form = formRepository.find(formId);
		if (form == null) {
			throw new RuntimeException("A form nem található az adatbázisban ezzel az id-val:" + formId);
		}
		if (FormStatus.FINISHED.equals(form.getFormStatus())) {
			throw new RuntimeException("Befejezett form-ot nem lehet módosítani!");
		}
		formItemDelegate.removeFormItem(form, formItemId);
	}

	@Override
	public FormDto getForm(Integer formId) throws RuntimeException {
		Form form = formRepository.find(formId);
		if (form == null) {
			throw new RuntimeException("A form nem található az adatbázisban ezzel az id-val:" + formId);
		}
		FormHeadReadDto formHead = getMapper().convert(form);
		List<FormItemReadDto> formItemDtos = new ArrayList<>();
		form.getFormItems().stream().forEach(formItemEntity -> {
			formItemDtos.add(getMapper().convert(formItemEntity));
		});
		return new FormDto(formHead, formItemDtos);
	}

	@Override
	public List<FormHeadReadDto> getAllOrders() {
		return getAllByFormType(FormType.ORDER);
	}

	@Override
	public List<FormHeadReadDto> getAllShipmentsForms() {
		return getAllByFormType(FormType.SHIPMENT);
	}

	@Override
	public List<FormHeadReadDto> getAllInvoiceForms() {
		return getAllByFormType(FormType.INVOICE);
	}

	@Override
	public List<FormHeadReadDto> getAllInventoryMovementForms() {
		return getAllByFormType(FormType.INVENTORY_MOVEMENT);
	}

	private List<FormHeadReadDto> getAllByFormType(FormType formType) {
		List<Form> entityList = formRepository.getAllFormByType(formType);
		List<FormHeadReadDto> dtoList = new ArrayList<>();
		entityList.stream().forEach(entity -> {
			dtoList.add(getMapper().convert(entity));
		});
		return dtoList;
	}

}
