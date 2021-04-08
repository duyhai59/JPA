package com.example.demoSpringBootJpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "CauThu")
@Entity
public class CauThu {
	
	@Id
	long id;
	
	@Column
	String ten;
	
	@Column
	int so;
	
	@ManyToOne
	@JoinColumn(name = "doiBongId")
	DoiBong doiBong;

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

	public int getSo() {
		return so;
	}

	public void setSo(int so) {
		this.so = so;
	}

	public DoiBong getDoiBong() {
		return doiBong;
	}

	public void setDoiBong(DoiBong doiBong) {
		this.doiBong = doiBong;
	}
	
	
}
