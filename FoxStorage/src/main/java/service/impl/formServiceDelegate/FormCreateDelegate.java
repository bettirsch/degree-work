package service.impl.formServiceDelegate;

import java.util.Calendar;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dto.FormHeadWriteDto;
import model.Form;
import repository.FormRepository;
import utils.enums.FormStatus;
import utils.enums.FormType;
import utils.logger.Loggable;

@Loggable
@Stateless
public class FormCreateDelegate {

	@Inject
	private FormRepository repo;
	
	public Integer createForm(Form formToSave, FormType formType) throws RuntimeException {
		try {
			formToSave.setFormType(formType);
			formToSave.setFormStatus(FormStatus.UNDER_EDITING);
			formToSave.setFormNr(generateFormNr(formType));
			Form savedEntity = repo.create(formToSave);
			return savedEntity.getId();
		} catch (Exception e) {
			throw new RuntimeException("Nem sikerült a formot létrehozni!" + e);
		}
	}
	
	private String generateFormNr(FormType formType) {
		Integer thisYear = Calendar.getInstance().get(Calendar.YEAR);
		String postfix = "/" + thisYear;

		String lastFormNr = repo.getLastFormNrByFormType(formType);
		if (lastFormNr == null) {
			return getPrefix(formType) + String.format("%05d", 1) + postfix;
		} else {
			String[] splitLastFormNr = lastFormNr.split("-|\\/");
			Integer lastFormYear = Integer.valueOf(splitLastFormNr[2]);
			Integer lastSerialNumber = Integer.valueOf(splitLastFormNr[1]);
			String newSerialNumber;
			if (thisYear > lastFormYear) {
				newSerialNumber = String.format("%05d", 1);
			} else {
				newSerialNumber = String.format("%05d", (lastSerialNumber + 1));
			}
			return getPrefix(formType) + newSerialNumber + postfix;
		}
	}

	private String getPrefix(FormType formType) {
		String prefix;
		switch (formType) {
		case ORDER:
			prefix = "MEGR-";
			break;
		case SHIPMENT:
			prefix = "SzL-";
			break;
		case INVOICE:
			prefix = "Sz-";
			break;
		case INVENTORY_MOVEMENT:
			prefix = "RAKT-";
			break;
		default:
			prefix = "BIZ-";
			break;
		}
		return prefix;
	}
}
