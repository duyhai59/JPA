package com.example.Jpa02NhanVien.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table(name = "NhanVien")
@Entity
public class NhanVien {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column
	@Size(max =20 , message = "Ho ten khong duoc qua 20 ky tu")
	String hoTen;
	
	@Column
	String sdt;
	
	@Column
	String diaChi;
	
	@Column
	String email;
	
	@Column
	int heSoLuong;
	
	@OneToMany(mappedBy = "nhanVien")
	@JsonIgnoreProperties(value = "nhanVien")
	Set<PhanCong> phanCongs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(int heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	public Set<PhanCong> getPhanCongs() {
		return phanCongs;
	}

	public void setPhanCongs(Set<PhanCong> phanCongs) {
		this.phanCongs = phanCongs;
	}
	
	
	
}
