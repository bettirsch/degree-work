package utils.enums;

public enum SiteType {
	SITE("telephely"),
	HEADQUARTERS("székhely");
	
	private String siteType;
	
	SiteType(String siteType){
		this.siteType = siteType;
	}
	
	public String getSiteType() {
		return this.siteType;
	}

}
