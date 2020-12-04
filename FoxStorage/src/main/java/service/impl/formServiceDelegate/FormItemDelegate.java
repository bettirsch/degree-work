package service.impl.formServiceDelegate;

import javax.ejb.Stateless;
import javax.inject.Inject;

import model.Form;
import model.FormItem;
import repository.FormItemRepository;
import utils.logger.Loggable;

@Loggable
@Stateless
public class FormItemDelegate {

	@Inject
	private FormItemRepository formItemRepo;

	@Inject
	private InventoryItemDelegate inventoryItemDelegate;

	public Integer addFormItemToForm(Form form, FormItem formItemToSaving) throws RuntimeException {
		boolean newFormItem = true;
		for (FormItem formItem : form.getFormItems()) {
			if (formItem.getProduct().getId() == formItemToSaving.getProduct().getId()
					&& formItem.getMeasuringUnit().equals(formItemToSaving.getMeasuringUnit())) {
				formItemToSaving.setId(formItem.getId());
				newFormItem = false;
				break;
			}
		}

		FormItem formItemToSavingWithPrice = calculatePrice(formItemToSaving);
		if (newFormItem) {
			createFormItem(form, formItemToSavingWithPrice);
		} else {
			updateFormItem(form, formItemToSavingWithPrice);
		}
		return null;
	}

	private FormItem calculatePrice(FormItem formItem) {
		Double netUnitPrice = formItem.getNetUnitPrice();
		Double vatRate = formItem.getVatRate();
		Double netPrice = netUnitPrice * formItem.getQuantity();
		Double grossUnitPrice = netUnitPrice * (vatRate / 100 + 1);
		Double grossPrice = grossUnitPrice * formItem.getQuantity();
		Double vatPrice = grossPrice - netPrice;
		formItem.setNetPrice(netPrice);
		formItem.setGrossUnitPrice(grossUnitPrice);
		formItem.setGrossPrice(grossPrice);
		formItem.setVatPrice(vatPrice);
		return formItem;
	}

	private Integer createFormItem(Form form, FormItem formItem) throws RuntimeException {
		FormItem savedFormItem = null;
		inventoryItemDelegate.reserveQuantity(form.getFacility(), formItem.getProduct(), formItem.getQuantity());
		try {
			formItem.setForm(form);
			savedFormItem = formItemRepo.create(formItem);
		} catch (Exception e) {
			throw new RuntimeException("Nem sikerült a formItem-et adatbázisba menteni!");
		}
		return savedFormItem.getId();
	}

	private Integer updateFormItem(Form form, FormItem formItem) throws RuntimeException {
		FormItem findedFormItem = formItemRepo.find(formItem.getId());
		Double quantityDifference = formItem.getQuantity() - findedFormItem.getQuantity();
		inventoryItemDelegate.reserveQuantity(form.getFacility(), formItem.getProduct(), quantityDifference);
		try {
			findedFormItem.setQuantity(formItem.getQuantity());
			findedFormItem.setProduct(formItem.getProduct());
			findedFormItem.setComment(formItem.getComment());
			findedFormItem.setGrossPrice(formItem.getGrossPrice());
			findedFormItem.setGrossUnitPrice(formItem.getGrossUnitPrice());
			findedFormItem.setNetPrice(formItem.getNetPrice());
			findedFormItem.setNetUnitPrice(formItem.getNetUnitPrice());
			findedFormItem.setVatPrice(formItem.getVatPrice());
			findedFormItem.setVatRate(formItem.getVatRate());
			formItemRepo.update(findedFormItem);
		} catch (Exception e) {
			throw new RuntimeException("Nem sikerült a formItem-et frissíteni!");
		}
		return null;
	}

	public void removeFormItem(Form form, Integer formItemId) throws RuntimeException {
		FormItem findedFormItem = formItemRepo.find(formItemId);
		inventoryItemDelegate.unReserveQuantity(form.getFacility(), findedFormItem.getProduct(),
				findedFormItem.getQuantity());
		try {
			formItemRepo.delete(findedFormItem);
		} catch (Exception e) {
			throw new RuntimeException("Nem sikerült a formItem-et törölni!");
		}
	}
}
