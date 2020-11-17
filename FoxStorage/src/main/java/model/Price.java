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
@Table(name = "price")
@XmlRootElement
public class Price extends BaseModel implements Serializable {

	private static final long serialVersionUID = 5778518566350209179L;

	@Column(name = "net_unit_price",
			columnDefinition = "Decimal(10,2) NOT NULL default '0.00'")
	private Double netUnitPrice;
	
	@Column(name = "vat_rate",
			columnDefinition = "Decimal(10,2) NOT NULL default '27.00'")
	@NotNull
	private Double vatRate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "packaging_ID")
	private Packaging packaging;

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

	public Packaging getPackaging() {
		return packaging;
	}

	public void setPackaging(Packaging packaging) {
		this.packaging = packaging;
	}
	
}
