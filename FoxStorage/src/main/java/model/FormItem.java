package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "form_item")
@XmlRootElement
public class FormItem extends BaseModel implements Serializable {

	private static final long serialVersionUID = 8498056439303015886L;

	@Column(name = "quantity")
	@NotNull
	private Double quantity;
	
	@Column(name = "net_unit_price",
			columnDefinition = "Decimal(10,2) default '27.00'")
	@NotNull
	private Double netUnitPrice;
	
	@Column(name = "net_price",
			columnDefinition = "Decimal(10,2) default '27.00'")
	@NotNull
	private Double netPrice;
	
	@Column(name = "gross_unit_price",
			columnDefinition = "Decimal(10,2) default '27.00'")
	@NotNull
	private Double grossUnitPrice;
	
	@Column(name = "gross_price",
			columnDefinition = "Decimal(10,2) default '27.00'")
	@NotNull
	private Double grossPrice;
	
	@Column(name = "vat_rate",
			columnDefinition = "Decimal(10,2) default '27.00'")
	@NotNull
	private Double vatRate;
	
	@Column(name = "vat_price")
	@NotNull
	private Double vatPrice;
	
	@Column(name = "comment")
	private String comment;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "form_ID")
	private Form form;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_ID")
	private Product product;

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
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

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
