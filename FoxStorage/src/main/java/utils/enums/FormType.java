package utils.enums;

public enum FormType {
	 ORDER("Megrendelés"),
	 SHIPMENT("Szállítólevél"),
	 INVOICE("Számla"),
	 FACILITY("operátor");
	
	 private String formType;
	   
	 FormType(String formType) {
	    this.formType = formType;
	 }
	 public String getFormType() {
	    return this.formType;
	 }
}
