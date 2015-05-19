package ch10.hrsystem.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="employee_inf")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@DiscriminatorColumn(name="emp_type", discriminatorType=DiscriminatorType.INTEGER)
@DiscriminatorValue(value="1")
public class Employee implements Serializable {
	private static final long serialVersionUID = 102232666647543355L;
	
	private Integer id;
	private String name;
	private String pass;
	private BigDecimal salary;
	private Manager manager;
	private Set<Attend> attends = new HashSet<>();
	private Set<Payment> payments = new HashSet<>();
	
	@Id
	@Column(name="emp_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="emp_name", nullable=false, unique=true, length=50)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="emp_pass")
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Column(name="emp_salary", nullable=false)
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	
	@ManyToOne(targetEntity=Manager.class)
	@JoinColumn(name="mgr_id")
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	@OneToMany(targetEntity=Attend.class, mappedBy="employee")
	public Set<Attend> getAttends() {
		return attends;
	}
	public void setAttends(Set<Attend> attends) {
		this.attends = attends;
	}
	@OneToMany(targetEntity=Payment.class, mappedBy="employee")
	public Set<Payment> getPayments() {
		return payments;
	}
	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
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
		Employee other = (Employee) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		return true;
	}
	
}
