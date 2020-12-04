package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "company_info")
@XmlRootElement
public class CompanyInfo extends BaseModel implements Serializable{

	private static final long serialVersionUID = -1164042503683563614L;

	@Column(name = "name")
	private String name;
	
	@Column(name = "tax_number")
	private String taxNumber;
	
	@Column(name = "bank_account_number")
	private String bankAccountNumber;

	@OneToMany(mappedBy = "companyInfo")
	private List<Contact> contacts;

	@OneToMany(mappedBy = "companyInfo")
	private List<Facility> facilities;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTaxNumber() {
		return taxNumber;
	}

	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public List<Facility> getFacilities() {
		return facilities;
	}

	public void setFacilities(List<Facility> facilities) {
		this.facilities = facilities;
	}
	
}
