package com.example.demoJpaBuoi1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Table(name = "cauthu")
@Entity
public class CauThu {
	
	@Id
	int id;
	
	@Column
	@NotNull
	String ten;
	
	@Column
	@Min(value = 1)
	@Max(value = 99)
	int soAo;// 0-99
	
	@Column
	String viTri;
	
	@Column
	int namSinh;
	
	@Column
	@Min(value = 0)
	double chieuCao;// >0

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getSoAo() {
		return soAo;
	}

	public void setSoAo(int soAo) {
		this.soAo = soAo;
	}

	public String getViTri() {
		return viTri;
	}

	public void setViTri(String viTri) {
		this.viTri = viTri;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public double getChieuCao() {
		return chieuCao;
	}

	public void setChieuCao(double d) {
		this.chieuCao = d;
	}
}
