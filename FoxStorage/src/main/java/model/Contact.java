package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import utils.enums.ContactType;

@Entity
@Table(name = "contact")
@XmlRootElement
public class Contact extends BaseModel implements Serializable{

	private static final long serialVersionUID = 7515377691200269342L;

	@Column(name = "form_type",
			columnDefinition = "VARCHAR(30) NOT NULL")
	@Enumerated(EnumType.STRING)
	@NotNull
	private ContactType type;
	
    @Column(name = "item_nr",
    		columnDefinition = "VARCHAR(50) NOT NULL")
    private String value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "partner_ID")
    private Partner partner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_info_ID")
    private CompanyInfo companyInfo;
    
	public ContactType getType() {
		return type;
	}

	public void setType(ContactType type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	public CompanyInfo getCompanyInfo() {
		return companyInfo;
	}

	public void setCompanyInfo(CompanyInfo companyInfo) {
		this.companyInfo = companyInfo;
	}

}
