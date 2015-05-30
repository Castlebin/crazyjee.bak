package ch06.se01.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address_inf")
public class Address {
	
	private int addressId;
	private String addressDetail;
	
	private Person person;
	
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
	
	@OneToOne
	@JoinTable(name="person_address",
			inverseJoinColumns=@JoinColumn(name="person_id", referencedColumnName="person_id", unique=true),
			joinColumns=@JoinColumn(name="address_id", referencedColumnName="address_id", unique=true))
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
}
