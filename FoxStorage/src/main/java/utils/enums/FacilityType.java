package utils.enums;

public enum FacilityType {
	SITE("telephely"),
	HEADQUARTERS("székhely");
	
	private String siteType;
	
	FacilityType(String siteType){
		this.siteType = siteType;
	}
	
	public String getSiteType() {
		return this.siteType;
	}

}
