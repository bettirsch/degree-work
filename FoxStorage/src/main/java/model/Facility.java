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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import utils.enums.FacilityType;

@Entity
@Table(name = "facility")
@XmlRootElement
public class Facility extends BaseModel implements Serializable{

	private static final long serialVersionUID = 1965552310769134178L;

	@Column(name = "name")
	@NotNull
	private String name;
	
	@Column(name = "facility_type",
			columnDefinition = "VARCHAR(30) NOT NULL DEFAULT 'SITE'")
	@Enumerated(EnumType.STRING)
	@NotNull
	private FacilityType facilityType;
	
	@OneToOne
	@JoinColumn(name = "address_ID")
	private Address address;
	
	@OneToMany(mappedBy = "facility", fetch = FetchType.LAZY)
	private List<InventoryItem> inventoryItems;
	
	@OneToMany(mappedBy = "facility", fetch = FetchType.LAZY)
	private List<Form> forms;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_info_ID")
    private CompanyInfo companyInfo;
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<InventoryItem> getInventoryItems() {
		return inventoryItems;
	}

	public void setInventoryItems(List<InventoryItem> inventoryItems) {
		this.inventoryItems = inventoryItems;
	}

	public List<Form> getForms() {
		return forms;
	}

	public void setForms(List<Form> forms) {
		this.forms = forms;
	}

	public FacilityType getFacilityType() {
		return facilityType;
	}

	public void setFacilityType(FacilityType facilityType) {
		this.facilityType = facilityType;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public CompanyInfo getCompanyInfo() {
		return companyInfo;
	}

	public void setCompanyInfo(CompanyInfo companyInfo) {
		this.companyInfo = companyInfo;
	}
	
}
