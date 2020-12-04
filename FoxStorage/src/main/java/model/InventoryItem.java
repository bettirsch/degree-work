package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "inventory_item")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = InventoryItem.GET_BY_FACILITY_AND_PRODUCT,
				query = "SELECT i FROM InventoryItem i WHERE i.facility = :facility AND i.product = :product") })
public class InventoryItem extends BaseModel implements Serializable {

	private static final long serialVersionUID = -7267115789362192642L;

	public static final String GET_BY_FACILITY_AND_PRODUCT = "InventoryItem.getByFacilityAndProduct";

	@Column(name = "quantity", columnDefinition = "Decimal(10,2) NOT NULL default '0.00'")
	@NotNull
	private Double quantity;

	@Column(name = "quantity_reserved", columnDefinition = "Decimal(10,2) NOT NULL default '0.00'")
	@NotNull
	private Double quantityReserved;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_ID")
	private Product product;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "facility_ID")
	private Facility facility;

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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

}
