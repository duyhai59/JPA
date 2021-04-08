package com.example.demoJpaBuoi1.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name = "role")
@Entity
public class Role {
	
	@Id
	private int id;
	
	@Column
	String username;
	
	@ManyToMany(mappedBy = "roles")
	List<User> user;
}
