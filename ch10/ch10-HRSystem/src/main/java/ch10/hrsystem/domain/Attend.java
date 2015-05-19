package ch10.hrsystem.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="attend_inf")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Attend implements Serializable {
	private static final long serialVersionUID = -9151127037558911652L;

	private Integer id;
	private String dutyDay;
	private Date punchTime;
	private boolean isCome;
	private AttendType type;
	private Employee employee;
	
	@Id
	@Column(name="attend_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="duty_day", nullable=false)
	public String getDutyDay() {
		return dutyDay;
	}
	public void setDutyDay(String dutyDay) {
		this.dutyDay = dutyDay;
	}
	@Column(name="punch_time")
	public Date getPunchTime() {
		return punchTime;
	}
	public void setPunchTime(Date punchTime) {
		this.punchTime = punchTime;
	}
	@Column(name="is_come")
	public boolean isCome() {
		return isCome;
	}
	public void setCome(boolean isCome) {
		this.isCome = isCome;
	}
	@ManyToOne(targetEntity=AttendType.class)
	@JoinColumn(name="type_id", nullable=false)
	public AttendType getType() {
		return type;
	}
	public void setType(AttendType type) {
		this.type = type;
	}
	@ManyToOne(targetEntity=Employee.class)
	@JoinColumn(name="emp_id", nullable=false)
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dutyDay == null) ? 0 : dutyDay.hashCode());
		result = prime * result
				+ ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + (isCome ? 1231 : 1237);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attend other = (Attend) obj;
		if (dutyDay == null) {
			if (other.dutyDay != null)
				return false;
		} else if (!dutyDay.equals(other.dutyDay))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (isCome != other.isCome)
			return false;
		return true;
	}	
}
