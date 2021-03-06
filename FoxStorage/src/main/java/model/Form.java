package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import utils.enums.FormStatus;
import utils.enums.FormType;
import utils.enums.PaymentType;

@Entity
@Table(name = "form")
@XmlRootElement
@NamedQueries({@NamedQuery(name = Form.GET_ALL_BY_FORMTYPE, query = "SELECT f FROM Form f WHERE f.formType = :formType"),
	@NamedQuery(name = Form.GET_FORMNR_BY_MAX_SERIALNUMBER_AND_CURRENTYEAR, query = "SELECT f.serialNumber FROM Form f WHERE f.id IN (SELECT MAX(f1.serialNumber) FROM Form f1 WHERE FUNCTION('YEAR',f1.createdTs) = FUNCTION('YEAR',CURRENT_TIMESTAMP) GROUP BY f.id)"),
	@NamedQuery(name= Form.COUNT_BY_FORMNR, query = "SELECT COUNT(f) FROM Form f WHERE f.formNr = :formNr")
})
public class Form extends BaseModel implements Serializable{

	private static final long serialVersionUID = 7699188108831968559L;
	public static final String GET_ALL_BY_FORMTYPE = "Form.getAllByFormType";
	public static final String GET_FORMNR_BY_MAX_SERIALNUMBER_AND_CURRENTYEAR = "Form.getFormNrByMaxSerialNumberAndCurrentYear";
	public static final String COUNT_BY_FORMNR = "Form.countByFormNr";
	
	@Column(name = "form_nr", unique = true, updatable = false)
	@NotNull
	private String formNr;
	
	@Column(name = "serial_number", updatable = false)
	@NotNull
	private Integer serialNumber;
	
	@Column(name = "form_type", updatable = false,
			columnDefinition = "VARCHAR(30) NOT NULL")
	@Enumerated(EnumType.STRING)
	@NotNull
	private FormType formType;
	
	@Column(name = "form_status",
			columnDefinition = "VARCHAR(30) NOT NULL")
	@Enumerated(EnumType.STRING)
	@NotNull
	private FormStatus formStatus;
	
	@Column(name = "delivery_date", columnDefinition = "DATE")
	private LocalDate deliveryDate;
	
	@Column(name = "payment_date", columnDefinition = "DATE")
	private LocalDate paymentDate;
	
	@Column(name = "payment_type",
			columnDefinition = "VARCHAR(30) NOT NULL")
	@Enumerated(EnumType.STRING)
	@NotNull
	private PaymentType paymentType;
	
	@Column(name = "comment")
	private String comment;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "form", cascade = CascadeType.ALL)
	private List<FormItem> formItems = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "partner_ID")
	private Partner partner;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "facility_ID")
	private Facility facility;
	
	public String getFormNr() {
		return formNr;
	}

	public void setFormNr(String formNr) {
		this.formNr = formNr;
	}

	public FormType getFormType() {
		return formType;
	}

	public void setFormType(FormType formType) {
		this.formType = formType;
	}

	public FormStatus getFormStatus() {
		return formStatus;
	}

	public void setFormStatus(FormStatus formStatus) {
		this.formStatus = formStatus;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<FormItem> getFormItems() {
		return formItems;
	}

	public void setFormItems(List<FormItem> formItems) {
		this.formItems = formItems;
	}

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Integer getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}

}
