package utils.enums;

public enum PartnerType {
	COMPANY("cég"),
	PRIVATE_PERSON("magánszemély");
	
	 private String partnerType;
	   
	 PartnerType(String partnerType) {
	    this.partnerType = partnerType;
	 }
	 public String getPartnerType() {
	    return this.partnerType;
	 }
}
