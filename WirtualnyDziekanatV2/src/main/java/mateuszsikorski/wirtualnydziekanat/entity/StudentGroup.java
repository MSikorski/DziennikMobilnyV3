package mateuszsikorski.wirtualnydziekanat.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student_group")
public class StudentGroup {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy="studentGroup",
			fetch=FetchType.LAZY,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	private List <StudentDetail> studentDetailList;
	
	@OneToOne(mappedBy="studentGroup",
			cascade= {CascadeType.DETACH, CascadeType.MERGE,
					CascadeType.PERSIST, CascadeType.REFRESH})
	private TimeTable timeTable;

	public StudentGroup() { 
	}
	
	public StudentGroup(String name){
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<StudentDetail> getStudentDetailList() {
		return studentDetailList;
	}

	public void setStudentDetailList(List<StudentDetail> studentDetailList) {
		this.studentDetailList = studentDetailList;
	}

	public TimeTable getTimeTable() {
		return timeTable;
	}

	public void setTimeTable(TimeTable timeTable) {
		this.timeTable = timeTable;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "StudentGroup [id=" + id + ", name=" + name + ", studentDetailList=" + studentDetailList
				+ ", timeTable=" + timeTable + "]";
	}
	
	public void addStudent(StudentDetail tempStudentDetail) {
		if (studentDetailList == null) {
			studentDetailList = new ArrayList<>();
		}

		studentDetailList.add(tempStudentDetail);

		tempStudentDetail.setStudentGroup(this);
	}
	
}
