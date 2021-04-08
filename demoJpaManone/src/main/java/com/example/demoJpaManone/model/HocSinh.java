package com.example.demoJpaManone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Table(name = "HocSinh")
@Entity
public class HocSinh {
	
	@Id
	int hocSinhId;
	
	@Column
	String ten;
	
	@ManyToOne(fetch = FetchType.LAZY , optional = false)
	@JoinColumn(name = "lopId")
	@JsonBackReference
	Lop lop;

	public int getHocSinhId() {
		return hocSinhId;
	}

	public void setHocSinhId(int hocSinhId) {
		this.hocSinhId = hocSinhId;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public Lop getLop() {
		return lop;
	}

	public void setLop(Lop lop) {
		this.lop = lop;
	}
	
	
}
