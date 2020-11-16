package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import utils.enums.AddressType;
import utils.enums.TypeOfStreet;

@Entity
@XmlRootElement
@Table(name = "address")
public class Address extends BaseModel {

	@Column(name = "name")
	private String country;

	@Column(name = "zip_code")
	private String zipCode;

	@Column(name = "city")
	private String city;

	@Column(name = "street")
	private String street;

	@Column(name = "type_of_street",
			columnDefinition = "VARCHAR(30) NOT NULL DEFAULT 'STREET'")
	@Enumerated(EnumType.STRING)
	@NotNull
	private TypeOfStreet typeOfStreet;

	@Column(name = "number")
	private String number;

	@Column(name = "floor")
	private String floor;

	@Column(name = "door")
	private String door;

	@Column(name = "address_type", columnDefinition = "VARCHAR(30) NOT NULL DEFAULT 'BOTH'")
	@Enumerated(EnumType.STRING)
	@NotNull
	private AddressType addressType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "partner_ID")
	private Partner partner;
	
	@OneToOne(mappedBy = "address")
	private Site inventory;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	public TypeOfStreet getTypeOfStreet() {
		return typeOfStreet;
	}

	public void setTypeOfStreet(TypeOfStreet typeOfStreet) {
		this.typeOfStreet = typeOfStreet;
	}
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getDoor() {
		return door;
	}

	public void setDoor(String door) {
		this.door = door;
	}

	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}
}
