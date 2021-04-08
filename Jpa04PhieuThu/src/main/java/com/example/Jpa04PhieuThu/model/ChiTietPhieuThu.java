package com.example.Jpa04PhieuThu.model;

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

@Table(name = "ChiTietPhieuThu")
@Entity
public class ChiTietPhieuThu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column
	@Min(value = 1 ,message = "So luong ban can lon hon 0")
	int soLuongBan;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "phieuThuID" , foreignKey = @ForeignKey(name = "fk_chitietphieuthu_phieuthu"))
	@JsonIgnoreProperties(value = "chiTietPhieuThus")
	PhieuThu phieuThu;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "nguyenLieuID" , foreignKey = @ForeignKey(name = "fk_chitietphieuthu_nguyenlieu"))
	@JsonIgnoreProperties(value = "chiTietPhieuThus")
	NguyenLieu nguyenLieu;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSoLuongBan() {
		return soLuongBan;
	}

	public void setSoLuongBan(int soLuongBan) {
		this.soLuongBan = soLuongBan;
	}

	public PhieuThu getPhieuThu() {
		return phieuThu;
	}

	public void setPhieuThu(PhieuThu phieuThu) {
		this.phieuThu = phieuThu;
	}

	public NguyenLieu getNguyenLieu() {
		return nguyenLieu;
	}

	public void setNguyenLieu(NguyenLieu nguyenLieu) {
		this.nguyenLieu = nguyenLieu;
	}
	
}
