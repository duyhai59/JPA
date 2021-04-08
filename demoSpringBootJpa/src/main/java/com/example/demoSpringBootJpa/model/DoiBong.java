package com.example.demoSpringBootJpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "DoiBong")
@Entity
public class DoiBong {
	
	@Id
	long id;
	
	@Column
	String ten;
	
	@Column
	String sanBong;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getSanBong() {
		return sanBong;
	}

	public void setSanBong(String sanBong) {
		this.sanBong = sanBong;
	}
	
}
