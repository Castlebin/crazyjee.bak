package ch05.se06.domain;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

@Entity
@Table(name = "person_inf")
public class Person {
	
	private Integer id;
	private String name;
	private int age;
	
	private Map<String, Float> scores = new HashMap<>();

	@Id
	@Column(name = "person_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	@ElementCollection
	@CollectionTable(name = "score_inf",
			joinColumns=@JoinColumn(name="person_id", nullable=false))
	@MapKeyColumn(name="subject_name")
	@Column(name="mark")
	public Map<String, Float> getScores() {
		return scores;
	}

	public void setScores(Map<String, Float> scores) {
		this.scores = scores;
	}

}
