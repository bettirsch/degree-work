package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import utils.enums.FormStatus;
import utils.enums.FormType;
import utils.enums.PaymentType;

@Entity
@Table(name = "form")
@XmlRootElement
public class Form extends BaseModel implements Serializable{

	private static final long serialVersionUID = 7699188108831968559L;
	
	@Column(name = "form_nr")
	@NotNull
	private String formNr;
	
	@Column(name = "form_type",
			columnDefinition = "VARCHAR(30) NOT NULL")
	@Enumerated(EnumType.STRING)
	@NotNull
	private FormType formType;
	
	@Column(name = "form_status",
			columnDefinition = "VARCHAR(30) NOT NULL")
	@Enumerated(EnumType.STRING)
	@NotNull
	private FormStatus formStatus;
	
	@Column(name = "delivery_date")
	@Temporal(TemporalType.DATE)
	private Date deliveryDate;
	
	@Column(name = "payment_date")
	@Temporal(TemporalType.DATE)
	private Date paymentDate;
	
	@Column(name = "payment_type",
			columnDefinition = "VARCHAR(30) NOT NULL")
	@Enumerated(EnumType.STRING)
	@NotNull
	private PaymentType paymentType;
	
	@Column(name = "comment")
	private String comment;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "form")
	private List<FormItem> formItems;
	
	@ManyToOne
	private Partner partner;
}
