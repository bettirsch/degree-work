package utils.enums;

public enum PaymentType {
	 CASH("Készpénz"),
	 REMITTANCE("Átutalás"),
	 CARD("Kártya"),
	 COD("Utánvét");
	
	 private String paymentType;
	   
	 PaymentType(String paymentType) {
	    this.paymentType = paymentType;
	 }
	 public String getPaymentType() {
	    return this.paymentType;
	 }
}
