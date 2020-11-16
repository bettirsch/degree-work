package utils.enums;

public enum FormStatus {
	 NEW("Új"),
	 PROGRESS("Folyamatban"),
	 FINISHED("Lezárt");
	
	 private String formStatus;
	   
	 FormStatus(String formStatus) {
	    this.formStatus = formStatus;
	 }
	 public String getFormStatus() {
	    return this.formStatus;
	 }
}
