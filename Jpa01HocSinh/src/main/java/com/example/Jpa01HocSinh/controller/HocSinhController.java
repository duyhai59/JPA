package com.example.Jpa01HocSinh.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Jpa01HocSinh.model.HocSinh;
import com.example.Jpa01HocSinh.model.Lop;
import com.example.Jpa01HocSinh.repository.HocSinhRepository;
import com.example.Jpa01HocSinh.repository.LopRepository;
import com.google.gson.Gson;

@RestController
public class HocSinhController {
	
	@Autowired
	LopRepository lopRepository;
	
	@Autowired
	HocSinhRepository hocSinhRepository;
	
	public void CapNhapSiSo(int lopID) {
		Lop lp = lopRepository.findById(lopID).get();
		int siSo = 0;
		for(HocSinh hs : hocSinhRepository.findAll()) {
			if(hs.getLop().getId() == lopID)
				siSo++;
		}
		lp.setSiSo(siSo);
		lopRepository.save(lp);
	}
	
	public boolean KiemTra(int lopID) {
		Lop lp = lopRepository.findById(lopID).get();
		int siSo = lp.getSiSo() + 1;
		lp.setSiSo(siSo);
		
		ValidatorFactory valfac = Validation.buildDefaultValidatorFactory();
		Validator validator = valfac.getValidator();
		Set<ConstraintViolation<Lop>> violation = validator.validate(lp);
		violation.forEach(x ->{System.out.println(x.getMessage());});
		
		if(violation.size() == 0) return true;
		return false;
	}
	
	@PostMapping(value = "/hocsinh/them" , produces = MediaType.APPLICATION_JSON_VALUE)
	public void ThemHocSinh(@RequestBody String hocSinh) {
		Gson gson = new Gson();
		HocSinh hsMoi = gson.fromJson(hocSinh, HocSinh.class);
		
		ValidatorFactory valfac = Validation.buildDefaultValidatorFactory();
		Validator validator = valfac.getValidator();
		Set<ConstraintViolation<HocSinh>> violation = validator.validate(hsMoi);
		violation.forEach(x ->{System.out.println(x.getMessage());});
		
		if(violation.size() == 0) {
			if(violation.size() == 0) {
				if(KiemTra(hsMoi.getLop().getId())) {
					hocSinhRepository.save(hsMoi);
					CapNhapSiSo(hsMoi.getLop().getId());
				}
			}
		}
	}
	
	@DeleteMapping(value = "/hocsinh/xoa")
	public void XoaHocSinh(@RequestParam int hocSinhID) {
		int lopID = hocSinhRepository.findById(hocSinhID).get().getLop().getId();
		hocSinhRepository.deleteById(hocSinhID);
		CapNhapSiSo(lopID);
	}
	
	@PutMapping(value = "/hocsinh/sua")
	public void SuaHocSinh(@RequestBody String hocSinh) {
		Gson gson = new Gson();
		HocSinh hs = gson.fromJson(hocSinh, HocSinh.class);
		
		ValidatorFactory valfac = Validation.buildDefaultValidatorFactory();
		Validator validator = valfac.getValidator();
		Set<ConstraintViolation<HocSinh>> violation = validator.validate(hs);
		violation.forEach(x ->{System.out.println(x.getMessage());});
		
		if(violation.size() == 0) {
			if(KiemTra(hs.getLop().getId())) {
				HocSinh hsSua = hocSinhRepository.findById(hs.getId()).get();
				int lopID1 = hsSua.getLop().getId();
				hsSua = hs;
				hocSinhRepository.save(hsSua);
				CapNhapSiSo(hs.getLop().getId());
				CapNhapSiSo(lopID1);
			}
		}
	}
	
	@PutMapping(value = "/hocsinh/chuyenlop")
	public void ChuyenLop(@RequestParam int hocSinhID, int lopID) {
		HocSinh hs = hocSinhRepository.findById(hocSinhID).get();
		Lop lpCu = hs.getLop();
		hs.setLop(lopRepository.findById(lopID).get());
		CapNhapSiSo(lpCu.getId());
		CapNhapSiSo(lopID);
	}
}
