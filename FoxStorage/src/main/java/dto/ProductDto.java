package dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import utils.enums.MeasuringUnit;

public class ProductDto extends BaseDto {
	
    private String productEan;
    
    private String itemNr;

    @NotNull
    private String productName;

    @NotNull
    private MeasuringUnit baseMeasuringUnit;
    
    @NotNull
    @DecimalMin(value = "0.01")
    private Double baseNetUnitPrice;

    @NotNull
    @DecimalMin(value = "0.00")
    private Double baseVatRate;

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

	public MeasuringUnit getBaseMeasuringUnit() {
		return baseMeasuringUnit;
	}

	public void setBaseMeasuringUnit(MeasuringUnit baseMeasuringUnit) {
		this.baseMeasuringUnit = baseMeasuringUnit;
	}

	public Double getBaseNetUnitPrice() {
		return baseNetUnitPrice;
	}

	public void setBaseNetUnitPrice(Double baseNetUnitPrice) {
		this.baseNetUnitPrice = baseNetUnitPrice;
	}

	public Double getBaseVatRate() {
		return baseVatRate;
	}

	public void setBaseVatRate(Double baseVatRate) {
		this.baseVatRate = baseVatRate;
	}

	public void setItemNr(String itemNr) {
		this.itemNr = itemNr;
	}

	@Override
	public String toString() {
		return "ProductDto [productEan=" + productEan + ", itemNr=" + itemNr + ", productName=" + productName
				+ ", baseMeasuringUnit=" + baseMeasuringUnit + ", baseNetUnitPrice=" + baseNetUnitPrice
				+ ", baseVatRate=" + baseVatRate + "]";
	}
    
}
