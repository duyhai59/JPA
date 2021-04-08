package com.example.Jpa02NhanVien.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table(name = "DuAn")
@Entity
public class DuAn {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column
	@Size(max = 10 ,message = "Ten du an khong qua 10 ky tu")
	String tenDuAn;
	
	@Column
	String moTa;
	
	@Column
	String ghiChu;
	
	@OneToMany(mappedBy = "duAn")
	@JsonIgnoreProperties(value = "duAn")
	Set<PhanCong> phanCongs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenDuAn() {
		return tenDuAn;
	}

	public void setTenDuAn(String tenDuAn) {
		this.tenDuAn = tenDuAn;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public Set<PhanCong> getPhanCongs() {
		return phanCongs;
	}

	public void setPhanCongs(Set<PhanCong> phanCongs) {
		this.phanCongs = phanCongs;
	}
	
	
}
