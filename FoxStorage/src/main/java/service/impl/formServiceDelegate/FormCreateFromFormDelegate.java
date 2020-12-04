package service.impl.formServiceDelegate;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import model.Form;
import model.FormItem;
import repository.FormRepository;
import utils.enums.FormStatus;
import utils.enums.FormType;
import utils.logger.Loggable;

@Loggable
@Stateless
public class FormCreateFromFormDelegate {

	@Inject
	private FormRepository repo;

	public void createFormFromForm(Form form, FormType formType) throws RuntimeException {
		boolean formCreatable = isFormCreateAllowed(form, formType);
		if (!formCreatable) {
			throw new RuntimeException(
					form.getFormType().toString() + " típusú formból nem hozható létre " + formType.getFormType());
		}
		
		String newFormNr = FormNumberProvider.generateFormNumberThisYear(formType, form.getSerialNumber());
		Integer findedForm = repo.countByFormNr(newFormNr);
		if (findedForm != 0) {
			throw new RuntimeException(
					"Ebből a formból már jött létre \"" + formType.getFormType() + "\" típusú form.");
		}
		
		Form formToSave = copyForm(form);
		formToSave.setFormNr(newFormNr);
		formToSave.setFormType(formType);
		if (FormType.INVOICE.equals(formType)) {
			formToSave.setFormStatus(FormStatus.FINISHED);
		} else {
			formToSave.setFormStatus(FormStatus.UNDER_EDITING);
		}
		repo.create(formToSave);
	}

	private boolean isFormCreateAllowed(Form form, FormType formType) {
		if (FormType.SHIPMENT.equals(form.getFormType()) && FormType.SHIPMENT.equals(formType)) {
			return false;
		}else if (FormType.INVOICE.equals(form.getFormType())) {
			return false;
		}else if (FormType.INVENTORY_MOVEMENT.equals(form.getFormType())) {
			return false;
		}
		return true;
	}
	
	private Form copyForm(Form originalForm) {
		Form form = new Form();
		form.setComment(originalForm.getComment());
		form.setDeliveryDate(originalForm.getDeliveryDate());
		form.setFacility(originalForm.getFacility());
		List<FormItem> copiedFormItems = copyFormItems(originalForm.getFormItems());
		form.setFormItems(copiedFormItems);
		form.setPartner(originalForm.getPartner());
		form.setPaymentDate(originalForm.getPaymentDate());
		form.setPaymentType(originalForm.getPaymentType());
		form.setSerialNumber(originalForm.getSerialNumber());
		return form;
	}

	private List<FormItem> copyFormItems(List<FormItem> originalFormItems) {
		List<FormItem> copiedFormItems = new ArrayList<>();
		originalFormItems.stream().forEach(originalFormItem -> {
			FormItem newFormItem = new FormItem();
			newFormItem.setComment(originalFormItem.getComment());
			//newFormItem.setForm(form); TODO?
			newFormItem.setGrossPrice(originalFormItem.getGrossPrice());
			newFormItem.setGrossUnitPrice(originalFormItem.getGrossUnitPrice());
			newFormItem.setNetPrice(originalFormItem.getNetPrice());
			newFormItem.setNetUnitPrice(originalFormItem.getNetUnitPrice());
			newFormItem.setMeasuringUnit(originalFormItem.getMeasuringUnit());
			newFormItem.setProduct(originalFormItem.getProduct());
			newFormItem.setQuantity(originalFormItem.getQuantity());
			newFormItem.setVatRate(originalFormItem.getVatRate());
			newFormItem.setVatPrice(originalFormItem.getVatPrice());
			copiedFormItems.add(newFormItem);
		});
		return copiedFormItems;
	}

}
