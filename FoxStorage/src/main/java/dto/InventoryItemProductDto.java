package dto;

public class InventoryItemProductDto extends BaseDto {

	private String facilityName;
	
	private Double quantity;
	
	private Double quantityReserved;

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getQuantityReserved() {
		return quantityReserved;
	}

	public void setQuantityReserved(Double quantityReserved) {
		this.quantityReserved = quantityReserved;
	}

	@Override
	public String toString() {
		return "InventoryItemProductDto [facilityName=" + facilityName + ", quantity=" + quantity
				+ ", quantityReserved=" + quantityReserved + "]";
	}
	
}
