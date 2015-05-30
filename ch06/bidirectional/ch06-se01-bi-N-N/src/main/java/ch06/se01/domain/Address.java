package ch06.se01.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "address_inf")
public class Address {
	
	private int addressId;
	private String addressDetail;
	
	private Set<Person> persons = new HashSet<>();
	
	@Id
	@Column(name = "address_id")
	@GeneratedValue
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	
	@Column(name = "address_detail")
	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	
	@ManyToMany
	@JoinTable(name="person_address",
		joinColumns=@JoinColumn(name="address_id", referencedColumnName="address_id"),
		inverseJoinColumns=@JoinColumn(name="person_id", referencedColumnName="person_id"))
	public Set<Person> getPersons() {
		return persons;
	}
	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}
	
}
