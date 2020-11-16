package utils.enums;

public enum TypeOfStreet {
	STREET("utca"),
	ROAD("út"),
	SQUARE("tér"),
	WALKWAY("sétány"),
	INTERVAL("köz");
	
	private String typeOfStreet;
	
	TypeOfStreet(String typeOfString) {
		this.typeOfStreet = typeOfString;
	}
	
	public String getTypeOfString() {
		return this.typeOfStreet;
	}

}
