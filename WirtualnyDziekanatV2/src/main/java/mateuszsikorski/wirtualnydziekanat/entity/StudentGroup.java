package mateuszsikorski.wirtualnydziekanat.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="student_groups")
public class StudentGroup {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@OneToMany(mappedBy="")

}
