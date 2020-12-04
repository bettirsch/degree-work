package service.impl.formServiceDelegate;

import javax.ejb.Stateless;
import javax.inject.Inject;

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
			Integer serialNumber = generateSerialNumber();
			formToSave.setSerialNumber(serialNumber);
			String formNr = FormNumberProvider.generateFormNumberThisYear(formType, serialNumber);
			formToSave.setFormNr(formNr);
			Form savedEntity = repo.create(formToSave);
			return savedEntity.getId();
		} catch (Exception e) {
			throw new RuntimeException("Nem sikerült a formot létrehozni!" + e);
		}
	}

	private Integer generateSerialNumber() {
		Integer lastSerialNumberInThisYear = repo.getLastSerialNumberByCurrentYear();
		if (lastSerialNumberInThisYear == null) {
			return 1;
		} else {
			return lastSerialNumberInThisYear + 1;
		}
	}
}
