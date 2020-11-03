package model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.eclipse.persistence.annotations.AdditionalCriteria;


@MappedSuperclass
@AdditionalCriteria("this.deleted = 0")
public abstract class BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "CREATED_TS", updatable = false,
			columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTs;

	@Column(name = "MODIFIED_TS",
			columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedTs;

	@Column(name = "MODIFIED_BY",
			columnDefinition = "VARCHAR(45) default 'admin'")
	private String modifiedBy;

	@Column(name = "CREATED_BY", updatable = false,
			columnDefinition = "VARCHAR(45) default 'admin'")
	private String createdBy;

	@Version
	@Column(name = "VERSION", columnDefinition = "INT(11) default '0'")
	private Integer version;

	@Column(name = "DELETED", columnDefinition = "BIT default 0")
	@NotNull
	private boolean deleted;

	public BaseModel() {
		this.createdTs = new Date();
		this.modifiedTs = new Date();
		this.createdBy = "admin";
		this.modifiedBy = "admin";
		this.version = 0;
		this.deleted = false;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Date getCreatedTs() {
		return createdTs;
	}

	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}

	public Date getModifiedTs() {
		return modifiedTs;
	}

	public void setModifiedTs(Date modifiedTs) {
		this.modifiedTs = modifiedTs;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
}
