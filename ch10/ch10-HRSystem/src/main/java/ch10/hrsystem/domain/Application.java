package ch10.hrsystem.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "application_inf")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Application implements Serializable {
	private static final long serialVersionUID = -8555089803084349744L;
	
	private Integer id;
	private String reason;
	private boolean result;
	private Attend attend;
	private AttendType type;
	private CheckBack check;
	
	@Id
	@Column(name="app_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="app_reason", length=500)
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Column(name="app_result")
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	@ManyToOne(targetEntity=Attend.class)
	@JoinColumn(name="attend_id", nullable=false)
	public Attend getAttend() {
		return attend;
	}
	public void setAttend(Attend attend) {
		this.attend = attend;
	}
	@ManyToOne(targetEntity=AttendType.class)
	public AttendType getType() {
		return type;
	}
	public void setType(AttendType type) {
		this.type = type;
	}
	@OneToOne(targetEntity=CheckBack.class, mappedBy="app")
	public CheckBack getCheck() {
		return check;
	}
	public void setCheck(CheckBack check) {
		this.check = check;
	}
}
