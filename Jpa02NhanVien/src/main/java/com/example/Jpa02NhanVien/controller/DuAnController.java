package com.example.Jpa02NhanVien.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Jpa02NhanVien.model.DuAn;
import com.example.Jpa02NhanVien.repository.DuAnRepository;
import com.google.gson.Gson;

@RestController
public class DuAnController {

	@Autowired
	DuAnRepository duAnRepository;
	
	@GetMapping(value = "/duan")
	public List<DuAn> Get(){
		return duAnRepository.findAll();
	}
	
	@PutMapping(value = "/duan/sua" , produces = MediaType.APPLICATION_JSON_VALUE)
	public void SuaDuAn(@RequestBody String duAn) {
		Gson gson = new Gson();
		DuAn duAnMoi = gson.fromJson(duAn, DuAn.class);
		DuAn duAnCurrent = duAnRepository.findById(duAnMoi.getId()).get();
		duAnCurrent.setTenDuAn(duAnMoi.getTenDuAn());
		duAnCurrent.setGhiChu(duAnMoi.getGhiChu());
		duAnCurrent.setMoTa(duAnMoi.getMoTa());
		duAnCurrent.setPhanCongs(duAnMoi.getPhanCongs());
		duAnRepository.save(duAnCurrent);
	}
}
