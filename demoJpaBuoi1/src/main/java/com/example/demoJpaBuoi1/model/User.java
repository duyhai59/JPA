package com.example.demoJpaBuoi1.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name = "user")
@Entity
public class User {
	
	@Id
	private int id;
	
	@Column
	String username;
	
	@Column
	String password;
	
	@ManyToMany(fetch = FetchType.LAZY)
	
	@JoinTable(
			name = "user_roles",
			joinColumns = {@JoinColumn(name = "user_id" , nullable=false)},
			inverseJoinColumns = {@JoinColumn(name = "role_id" , nullable=false)}
			)
	
	List<Role> roles;
	
}
