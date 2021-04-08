package com.example.Jpa02NhanVien.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Jpa02NhanVien.model.NhanVien;
import com.example.Jpa02NhanVien.model.PhanCong;
import com.example.Jpa02NhanVien.repository.DuAnRepository;
import com.example.Jpa02NhanVien.repository.NhanVienRepository;
import com.example.Jpa02NhanVien.repository.PhanCongRepository;
import com.google.gson.Gson;

@RestController
public class NhanVienController {

	@Autowired
	NhanVienRepository nhanVienRepository;
	
	@Autowired
	DuAnRepository duAnRepository;
	
	@Autowired
	PhanCongRepository phanCongRepository;
	
	@PostMapping(value = "/nhanvien/them")
	public void ThemNhanVien(@RequestBody String nhanVien) {
		Gson gson = new Gson();
		NhanVien nvMoi = gson.fromJson(nhanVien, NhanVien.class);
		nhanVienRepository.save(nvMoi);
		
		nvMoi.getPhanCongs().forEach(x->{
			x.setNhanVien(nvMoi);
		});
		phanCongRepository.saveAll(nvMoi.getPhanCongs());
	}
	
	@DeleteMapping(value = "/nhanvien/xoa")
	public void XoaNhanVien(@RequestParam int nhanVienID) {
		nhanVienRepository.deleteById(nhanVienID);
	}
	
	public void TinhLuong() {
		List<PhanCong> lstPC = phanCongRepository.findAll();
		List<NhanVien> lstNV = nhanVienRepository.findAll();
		
		lstNV.forEach(x->{
			int tongGio = 0;
			for(int i = 0; i < lstPC.size() ; i++) {
				if(x.getId() == lstPC.get(i).getNhanVien().getId()) {
					tongGio += lstPC.get(i).getSoGioLam();
				}
			}
			int luong = tongGio*15*x.getHeSoLuong();
			System.out.println(x.getHoTen() + " : " + luong);
		});
	}
	
	@GetMapping(value = "/nhanvien")
	public List<NhanVien> Get(){
		TinhLuong();
		return nhanVienRepository.findAll();
	}
	
	
}
