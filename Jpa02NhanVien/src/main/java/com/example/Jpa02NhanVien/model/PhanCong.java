package com.example.Jpa02NhanVien.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table(name = "PhanCong")
@Entity
public class PhanCong {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column
	@Min(value = 1 , message = "So gio lam la so nguyen duong")
	int soGioLam;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "duAnID", foreignKey = @ForeignKey(name = "fk_phancong_duan"))
	@JsonIgnoreProperties(value = "phanCongs")
	DuAn duAn;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "nhanVienID",foreignKey = @ForeignKey(name = "fk_phancong_nhanvien"))
	@JsonIgnoreProperties(value = "nhanViens")
	NhanVien nhanVien;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSoGioLam() {
		return soGioLam;
	}

	public void setSoGioLam(int soGioLam) {
		this.soGioLam = soGioLam;
	}

	public DuAn getDuAn() {
		return duAn;
	}

	public void setDuAn(DuAn duAn) {
		this.duAn = duAn;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	
}
