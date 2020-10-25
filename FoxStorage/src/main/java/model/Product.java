/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

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

    @Column(name = "product_name")
    private String productName;
    
    @OneToMany(targetEntity = Image.class, mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Image> images;

    public Product() {
    }
    
    public String getProductEan() {
        return productEan;
    }

    public void setProductEan(String productEan) {
        this.productEan = productEan;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

	@Override
	public String toString() {
		return "Product [id=" + super.getId() + "productEan=" + productEan + ", productName=" + productName + ", images=" + images + "]";
	}

}
