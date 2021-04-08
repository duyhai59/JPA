package com.example.Jpa03KhoaHoc.model;

import java.sql.Date;
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

@Table(name  = "KhoaHoc")
@Entity
public class KhoaHoc {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column
	@Size(max = 10 , message = "Ten khoa hoc không vuot qua 10 ky tu")
	String tenKhoaHoc;
	
	@Column
	String moTa;
	
	@Column
	@Max(value = 10000000 , message = "Hoc phi khong dc qua 10tr")
	int hocPhi;
	
	@Column
	Date ngayBatDau;
	
	@Column 
	Date ngayKetThuc;
	
	@OneToMany(mappedBy = "khoaHoc")
	@JsonIgnoreProperties(value = "khoaHoc")
	Set<HocVien> hocViens;
	
	@OneToMany(mappedBy = "khoaHoc")
	@JsonIgnoreProperties(value = "khoaHoc")
	Set<NgayHoc> ngayHocs;

	public Set<NgayHoc> getNgayHocs() {
		return ngayHocs;
	}

	public void setNgayHocs(Set<NgayHoc> ngayHocs) {
		this.ngayHocs = ngayHocs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenKhoaHoc() {
		return tenKhoaHoc;
	}

	public void setTenKhoaHoc(String tenKhoaHoc) {
		this.tenKhoaHoc = tenKhoaHoc;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public int getHocPhi() {
		return hocPhi;
	}

	public void setHocPhi(int hocPhi) {
		this.hocPhi = hocPhi;
	}

	public Date getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public Set<HocVien> getHocViens() {
		return hocViens;
	}

	public void setHocViens(Set<HocVien> hocViens) {
		this.hocViens = hocViens;
	}
	
	
}
