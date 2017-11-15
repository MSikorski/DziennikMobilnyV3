package org.mateuszsikorski.wirtualnydziekanat.entity;

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
@Table(name="teacher_detail")
public class TeacherDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@OneToOne(mappedBy="teacherDetail",
			cascade= {CascadeType.DETACH, CascadeType.MERGE,
					CascadeType.PERSIST, CascadeType.REFRESH})
	private UserDetail userDetail;
	
	@OneToMany(mappedBy="teacherDetail", fetch=FetchType.LAZY,
			cascade = {CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.DETACH, CascadeType.REFRESH})
	private List<Mark> marks;
	
	@ManyToMany(fetch=FetchType.LAZY,
			cascade={CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.DETACH, CascadeType.REFRESH})
	private List<StudentGroup> teacherGroupList;
	
	@ManyToMany(fetch=FetchType.LAZY,
			cascade={CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(name = "subject_teacher", 
				joinColumns = @JoinColumn(name = "teacher_detail_id"), 
				inverseJoinColumns = @JoinColumn(name = "subject_id"))
	private List<Subject> subjectsList;
	

}
