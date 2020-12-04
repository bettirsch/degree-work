package dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import utils.enums.MeasuringUnit;

public class FormItemReadDto extends BaseDto{
	
	@NotNull
	@DecimalMin(value = "0.01")
	private Double quantity;
	
	@NotNull
	private MeasuringUnit measuringUnit;
	
	@NotNull
	private Double netUnitPrice;

	@NotNull
	private Double netPrice;

	@NotNull
	private Double grossUnitPrice;

	@NotNull
	private Double grossPrice;
	
	@NotNull
	private Double vatRate;

	@NotNull
	private Double vatPrice;
	
	private String comment;
	
	@NotNull
	private Integer productId;
	
	private String productEan;

	private String itemNr;

	@NotNull
	private String productName;

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
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

	public Double getNetPrice() {
		return netPrice;
	}

	public void setNetPrice(Double netPrice) {
		this.netPrice = netPrice;
	}

	public Double getGrossUnitPrice() {
		return grossUnitPrice;
	}

	public void setGrossUnitPrice(Double grossUnitPrice) {
		this.grossUnitPrice = grossUnitPrice;
	}

	public Double getGrossPrice() {
		return grossPrice;
	}

	public void setGrossPrice(Double grossPrice) {
		this.grossPrice = grossPrice;
	}

	public Double getVatRate() {
		return vatRate;
	}

	public void setVatRate(Double vatRate) {
		this.vatRate = vatRate;
	}

	public Double getVatPrice() {
		return vatPrice;
	}

	public void setVatPrice(Double vatPrice) {
		this.vatPrice = vatPrice;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
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

	public void setItemNr(String itemNr) {
		this.itemNr = itemNr;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "FormItemDto [quantity=" + quantity + ", netUnitPrice=" + netUnitPrice + ", netPrice=" + netPrice
				+ ", grossUnitPrice=" + grossUnitPrice + ", grossPrice=" + grossPrice + ", vatRate=" + vatRate
				+ ", vatPrice=" + vatPrice + ", comment=" + comment + ", productId=" + productId + "]";
	}
	
}
