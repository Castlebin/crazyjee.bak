package ch10.hrsystem.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@DiscriminatorValue(value="2")
public class Manager extends Employee {
	private static final long serialVersionUID = -6060469944826621185L;
	
	private String dept;
	private Set<Employee> employees = new HashSet<>();
	private Set<CheckBack> checks = new HashSet<>();
	
	@Column(name="dept_name", length=50, unique=true)
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@OneToMany(targetEntity=Employee.class, mappedBy="manager")
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	@OneToMany(targetEntity=CheckBack.class, mappedBy="manager")
	public Set<CheckBack> getChecks() {
		return checks;
	}
	public void setChecks(Set<CheckBack> checks) {
		this.checks = checks;
	}
}
