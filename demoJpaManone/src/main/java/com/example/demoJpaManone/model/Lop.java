package com.example.demoJpaManone.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Table(name = "Lop")
@Entity
public class Lop {
	
	@Id
	int lopId;
	
	@Column
	String ten;
	
	@OneToMany(mappedBy = "lop" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JsonManagedReference
	Set<HocSinh> hocSinhs;

	public int getLopId() {
		return lopId;
	}

	public void setLopId(int lopId) {
		this.lopId = lopId;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public Set<HocSinh> getHocSinhs() {
		return hocSinhs;
	}

	public void setHocSinhs(Set<HocSinh> hocSinhs) {
		this.hocSinhs = hocSinhs;
	}
	
	
}
