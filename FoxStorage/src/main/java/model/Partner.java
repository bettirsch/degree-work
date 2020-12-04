package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import utils.enums.PartnerType;

@Entity
@Table(name = "partner")
@XmlRootElement
public class Partner extends BaseModel implements Serializable{

	private static final long serialVersionUID = -3157660901618825435L;

	@Column(name = "name")
	private String name;
	
	@Column(name = "tax_number")
	private String taxNumber;
	
	@Column(name = "bank_account_number")
	private String bankAccountNumber;
	
	@Column(name = "partner_type",
			columnDefinition = "VARCHAR(30) NOT NULL")
	@Enumerated(EnumType.STRING)
	@NotNull
	private PartnerType type;
	
	@OneToMany(mappedBy = "partner")
	private List<Form> forms;

	@OneToMany(mappedBy = "partner")
	private List<Contact> contacts;
	
	@OneToMany(mappedBy = "partner")
	private List<Address> addresses;
	
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

	public PartnerType getType() {
		return type;
	}

	public void setType(PartnerType type) {
		this.type = type;
	}

	public List<Form> getForms() {
		return forms;
	}

	public void setForms(List<Form> forms) {
		this.forms = forms;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
}
