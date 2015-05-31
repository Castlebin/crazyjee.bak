package ch05.se07.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person_inf")
public class Person {
	
	private Integer id;
	private int age;
	
	private Name name;
	
	@Id
	@Column(name = "person_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Embedded
	@AttributeOverrides(
			{@AttributeOverride(name="first", column=@Column(name="first_name")),
				@AttributeOverride(name="last", column=@Column(name="last_name"))})
	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

}
