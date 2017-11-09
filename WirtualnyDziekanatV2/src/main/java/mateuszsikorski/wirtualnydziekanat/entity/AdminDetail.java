package mateuszsikorski.wirtualnydziekanat.entity;

import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="admin_detail")
public class AdminDetail {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="flags")
	private String flags;
	
	@OneToOne(mappedBy="adminDetail", cascade=CascadeType.ALL)
	private UserDetail user;
	
}
