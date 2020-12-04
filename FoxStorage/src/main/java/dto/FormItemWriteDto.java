package dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import utils.enums.MeasuringUnit;

public class FormItemWriteDto {
	
	@NotNull
	@DecimalMin(value = "0.01")
	private Double quantity;
	
	@NotNull
	private Integer productId;

	@NotNull
	private MeasuringUnit measuringUnit;
	
	@NotNull
	@DecimalMin(value = "0.00", inclusive = true)
	private Double netUnitPrice;
	
	@NotNull
	@DecimalMin(value = "0.00", inclusive = true)
	private Double vatRate;
	
	private String comment;

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public MeasuringUnit getMeasuringUnit() {
		return measuringUnit;
	}

	public void setMeasuringUnit(MeasuringUnit measuringUnit) {
		this.measuringUnit = measuringUnit;
	}

	public Double getNetUnitPrice() {
		return netUnitPrice;
	}

	public void setNetUnitPrice(Double netUnitPrice) {
		this.netUnitPrice = netUnitPrice;
	}

	public Double getVatRate() {
		return vatRate;
	}

	public void setVatRate(Double vatRate) {
		this.vatRate = vatRate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "FormItemWriteDto [quantity=" + quantity + ", productId=" + productId + ", measuringUnit="
				+ measuringUnit + ", netUnitPrice=" + netUnitPrice + ", vatRate=" + vatRate + "]";
	}
	
	
}
