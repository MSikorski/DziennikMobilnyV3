package mateuszsikorski.wirtualnydziekanat.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


public class StudentDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="index_number")
	private String indexNumber;
	
	@Column(name="specialization")
	private String specialization;
	
	@OneToOne(mappedBy="studentDetail",
			cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
					CascadeType.REFRESH})
	private User user;
	
	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	private List <Mark> marks;

	public StudentDetail(String indexNumber, User user) {
		this.indexNumber = indexNumber;
		this.user = user;
	}
	
	public StudentDetail(String indexNumber, String specialization, User user, List<Mark> marks) {
		this.indexNumber = indexNumber;
		this.specialization = specialization;
		this.user = user;
		this.marks = marks;
	}
	
	public StudentDetail() {}

	public String getIndexNumber() {
		return indexNumber;
	}

	public void setIndexNumber(String indexNumber) {
		this.indexNumber = indexNumber;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Mark> getMarks() {
		return marks;
	}

	public void setMarks(List<Mark> marks) {
		this.marks = marks;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "StudentDetail [id=" + id + ", indexNumber=" + indexNumber + ", specialization=" + specialization
				+ ", user=" + user + ", marks=" + marks + "]";
	}
	
}
