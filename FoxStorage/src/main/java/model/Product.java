/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import utils.enums.MeasuringUnit;

/**
 *
 * @author spdue4cb
 */

@Entity
@Table(name = "product")
@XmlRootElement
public class Product extends BaseModel implements Serializable{
    
	private static final long serialVersionUID = 1103355133966318506L;

    @Column(name = "product_ean")
    private String productEan;
    
    @Column(name = "item_nr")
    private String itemNr;

    @Column(name = "product_name")
    @NotNull
    private String productName;
    
	@Column(name = "base_measuring_unit",
			columnDefinition = "VARCHAR(30) NOT NULL")
	@Enumerated(EnumType.STRING)
	private MeasuringUnit baseMeasuringUnit;
	
	@OneToOne
	@JoinColumn(name = "base_price_id")
	private Price basePrice;
	
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Image> images;
    
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<FormItem> formItems;
    
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<FormItem> inventoryItems;
    
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Packaging> packagings;
    
    public Product() {
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

	public MeasuringUnit getBaseMeasuringUnit() {
		return baseMeasuringUnit;
	}

	public void setBaseMeasuringUnit(MeasuringUnit baseMeasuringUnit) {
		this.baseMeasuringUnit = baseMeasuringUnit;
	}

	public Price getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Price basePrice) {
		this.basePrice = basePrice;
	}

	public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

	public List<FormItem> getFormItems() {
		return formItems;
	}

	public void setFormItems(List<FormItem> formItems) {
		this.formItems = formItems;
	}

	public List<FormItem> getInventoryItems() {
		return inventoryItems;
	}

	public void setInventoryItems(List<FormItem> inventoryItems) {
		this.inventoryItems = inventoryItems;
	}

	public List<Packaging> getPackagings() {
		return packagings;
	}

	public void setPackagings(List<Packaging> packagings) {
		this.packagings = packagings;
	}

	@Override
	public String toString() {
		return "Product [productEan=" + productEan + ", itemNr=" + itemNr + ", productName=" + productName
				+ ", baseMeasuringUnit=" + baseMeasuringUnit + ", images=" + images + ", formItems=" + formItems
				+ ", inventoryItems=" + inventoryItems + ", packagings=" + packagings + ", getId()=" + getId() + "]";
	}

}
