package ch06.se01.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "person_inf")
public class Person {
	
	private Integer id;
	private String name;
	private int age;
	
	private Address address;

	@Id
	@Column(name = "person_id")
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinTable(name="person_address",
			joinColumns=@JoinColumn(name="person_id", referencedColumnName="person_id", unique=true),
			inverseJoinColumns=@JoinColumn(name="address_id", referencedColumnName="address_id", unique=true))
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}
