package dto;

import utils.enums.MeasuringUnit;

public class ProductDto extends BaseDto {

	private Integer id;
	
    private String productEan;
    
    private String itemNr;

    private String productName;
    
    private MeasuringUnit measuringUnit;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductEan() {
		return productEan;
	}

	public void setProductEan(String productEan) {
		this.productEan = productEan;
	}

	public String getItemNr() {
		return itemNr;
	}

	public void setItem_nr(String itemNr) {
		this.itemNr = itemNr;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public MeasuringUnit getMeasuringUnit() {
		return measuringUnit;
	}

	public void setMeasuringUnit(MeasuringUnit measuringUnit) {
		this.measuringUnit = measuringUnit;
	}

	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", productEan=" + productEan + ", productName=" + productName + "]";
	}
    
}
