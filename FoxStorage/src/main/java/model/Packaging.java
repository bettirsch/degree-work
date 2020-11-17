package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import utils.enums.MeasuringUnit;

@Entity
@Table(name = "packaging")
public class Packaging extends BaseModel implements Serializable{

	private static final long serialVersionUID = 7923789667248838762L;
	
	@Column(name = "quantity_of_base_measuring_unit",
			columnDefinition = "Decimal(10,2) NOT NULL default '1.00'")
	private Double quantityOfBaseMeasuringUnit;
	
	@Column(name = "measuring_unit",
			columnDefinition = "VARCHAR(30) NOT NULL")
	@Enumerated(EnumType.STRING)
	private MeasuringUnit measuringUnit;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_ID")
	private Product product;
	
	@OneToMany(mappedBy = "packaging", fetch = FetchType.LAZY)
	private List<Price> prices;

	public Double getQuantityOfBaseMeasuringUnit() {
		return quantityOfBaseMeasuringUnit;
	}

	public void setQuantityOfBaseMeasuringUnit(Double quantityOfBaseMeasuringUnit) {
		this.quantityOfBaseMeasuringUnit = quantityOfBaseMeasuringUnit;
	}

	public MeasuringUnit getMeasuringUnit() {
		return measuringUnit;
	}

	public void setMeasuringUnit(MeasuringUnit measuringUnit) {
		this.measuringUnit = measuringUnit;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Price> getPrices() {
		return prices;
	}

	public void setPrices(List<Price> prices) {
		this.prices = prices;
	}
}
