package utils.enums;

public enum FormStatus {
	 UNDER_EDITING("Szerkesztés alatt"),
	 FINISHED("Lezárt");
	
	 private String formStatus;
	   
	 FormStatus(String formStatus) {
	    this.formStatus = formStatus;
	 }
	 public String getFormStatus() {
	    return this.formStatus;
	 }
}
