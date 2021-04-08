 package com.example.Jpa01HocSinh.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table
@Entity
public class Lop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column
	@Size(max = 10, message = "Ten lop toi da 10 ky tu")
	String tenLop;
	
	@Column
	@Max(value = 20 , message = "Si so toi da 20 hoc sinh")
	int siSo;
	
	@OneToMany(mappedBy = "lop")
	@JsonIgnoreProperties(value = "lop")
	Set<HocSinh> hocSinhs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public int getSiSo() {
		return siSo;
	}

	public void setSiSo(int siSo) {
		this.siSo = siSo;
	}

	public Set<HocSinh> getHocSinhs() {
		return hocSinhs;
	}

	public void setHocSinhs(Set<HocSinh> hocSinhs) {
		this.hocSinhs = hocSinhs;
	}
	
	
	
}
