package utils.enums;

public enum FormType {
	 ORDER("Megrendelés"),
	 SHIPMENT("Szállítólevél"),
	 INVOICE("Számla"),
	 INVENTORY_MOVEMENT("Raktári mozgás");
	
	 private String formType;
	   
	 FormType(String formType) {
	    this.formType = formType;
	 }
	 public String getFormType() {
	    return this.formType;
	 }
}
