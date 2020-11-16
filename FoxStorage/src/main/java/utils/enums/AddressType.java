package utils.enums;

public enum AddressType {
	BILLING("számlázási"),
	SHIPPING("szállítási"),
	BOTH("számlázási és szállítási");
	
	private String addressType;
	
	AddressType(String addressType){
		this.addressType = addressType;
	}
	
	public String getAddressType() {
		return this.addressType;
	}

}
