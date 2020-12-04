package service.impl.formServiceDelegate;

import java.util.Calendar;

import utils.enums.FormNumberPrefix;
import utils.enums.FormType;

public class FormNumberProvider {

	public static String generateFormNumberThisYear(FormType formType, Integer serialNumber) {
		Integer thisYear = Calendar.getInstance().get(Calendar.YEAR);
		return generateFormNumber(formType, serialNumber, thisYear);
	}
	
	public static String generateFormNumber(FormType formType, Integer serialNumber, Integer year) {
		FormNumberPrefix prefix = getPrefix(formType);
		return prefix + "-" + String.format("%05d", serialNumber) + "/" + year;
	}

	private static FormNumberPrefix getPrefix(FormType formType) {
		switch (formType) {
		case ORDER:
			return FormNumberPrefix.MEGR;
		case SHIPMENT:
			return FormNumberPrefix.SzL;
		case INVOICE:
			return FormNumberPrefix.SZ;
		case INVENTORY_MOVEMENT:
			return FormNumberPrefix.RAKT;
		default:
			return null;
		}
	}

}
