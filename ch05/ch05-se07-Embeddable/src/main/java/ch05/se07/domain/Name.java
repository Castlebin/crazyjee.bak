package ch05.se07.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.annotations.Parent;

@Embeddable
public class Name {

	private String first;
	private String last;
	
	private Person owner;

	@Column(name = "first_name")
	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	@Column(name = "last_name")
	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	@Parent		// 擦，这个是Hibernate的注解，不学也罢，了解即可
	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}
	
}
