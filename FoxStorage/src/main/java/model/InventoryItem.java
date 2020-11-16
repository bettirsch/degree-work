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
@Table(name = "inventory_item")
@XmlRootElement
public class InventoryItem extends BaseModel implements Serializable{

	private static final long serialVersionUID = -7267115789362192642L;

	@Column(name = "quantity",
			columnDefinition = "Decimal(10,2) NOT NULL default '0.00'")
	@NotNull
	private Double quantity;

	@Column(name = "quantity_reserved",
			columnDefinition = "Decimal(10,2) NOT NULL default '0.00'")
	@NotNull
	private Double quantityReserved;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "inventory_ID")
	private Site inventory;

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
	
}
