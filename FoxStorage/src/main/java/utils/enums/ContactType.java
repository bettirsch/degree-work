package utils.enums;

public enum ContactType {
	PHONE("telefon"),
	EMAIL("email"),
	WEBPAGE("weboldal");
	
	private String contactType;
	
	ContactType(String contactType) {
		this.contactType = contactType;
	}
	
	public String getContactType() {
		return this.contactType;
	}
}
