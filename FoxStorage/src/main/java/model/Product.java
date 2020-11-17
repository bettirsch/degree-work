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
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
    private String productName;
    
	@Column(name = "measuring_unit",
			columnDefinition = "VARCHAR(30) NOT NULL")
	@Enumerated(EnumType.STRING)
	private MeasuringUnit baseMeasuringUnit;
	
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Image> images;
    
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<FormItem> formItems;

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

	@Override
	public String toString() {
		return "Product [id=" + super.getId() + "productEan=" + productEan + ", productName=" + productName + ", images=" + images + "]";
	}

}
