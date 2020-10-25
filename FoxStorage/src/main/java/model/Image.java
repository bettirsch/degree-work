/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author spdue4cb
 */
@Entity
@Table(name = "image")
public class Image extends BaseModel implements Serializable{
    
	private static final long serialVersionUID = -6086097595120063602L;
    
    @Column(name = "image_name")
    private String imageName;

    @Lob
    @Column(name = "doc")
    @Basic(fetch = FetchType.LAZY)
    private byte[] doc;
    
    @Column(name = "note")
    private String note;
    
    @Column(name = "inactive")
    private Boolean inactive;
    
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_ean", referencedColumnName = "product_ean")
    private Product product;

    public Image() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public byte[] getDoc() {
		return doc;
	}

	public void setDoc(byte[] doc) {
		this.doc = doc;
	}

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getInactive() {
        return inactive;
    }

    public void setInactive(Boolean inactive) {
        this.inactive = inactive;
    }

    @Override
    public String toString() {
        return "Image{" + "imageId=" + super.getId() + ", imageName=" + imageName + ", note=" + note +  ", product=" + product.getProductEan() + '}';
    }
    
}
