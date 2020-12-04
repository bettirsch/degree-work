package dto;

import utils.enums.FormStatus;
import utils.enums.FormType;

public class FormHeadReadDto extends FormHeadWriteDto {
	
	private String formNr;
	
	private FormType formType;
	
	private FormStatus formStatus;
	
	public String getFormNr() {
		return formNr;
	}

	public void setFormNr(String formNr) {
		this.formNr = formNr;
	}

	public FormType getFormType() {
		return formType;
	}

	public void setFormType(FormType formType) {
		this.formType = formType;
	}

	public FormStatus getFormStatus() {
		return formStatus;
	}

	public void setFormStatus(FormStatus formStatus) {
		this.formStatus = formStatus;
	}
	
}
