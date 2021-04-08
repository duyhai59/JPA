package com.example.Jpa03KhoaHoc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Jpa03KhoaHoc.model.HocVien;
import com.example.Jpa03KhoaHoc.repository.HocVienRepository;
import com.example.Jpa03KhoaHoc.repository.KhoaHocRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
public class HocVienController {

	@Autowired
	HocVienRepository hocVienRepository;
	
	@Autowired
	KhoaHocRepository khoaHocRepository;
	
	@PutMapping(value = "/hocvien/sua")
	public void SuaDuAn(@RequestBody String hocVien) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		HocVien hvMoi = gson.fromJson(hocVien, HocVien.class);
		
		ValidatorFactory valFac = Validation.buildDefaultValidatorFactory();
		Validator val = valFac.getValidator();
		Set<ConstraintViolation<HocVien>> viola = val.validate(hvMoi);
		viola.forEach(x->{
			System.out.println(x.getMessage());
		});
		
		if(viola.size() == 0) {
			HocVien hvCurrent = hocVienRepository.findById(hvMoi.getId()).get();
			hvCurrent = hvMoi;
			hocVienRepository.save(hvCurrent);
		}	
	}
	
	@GetMapping(value = "/hocvien/timkiem")
	public List<HocVien> TimKiem(@RequestParam String hoTen , int khoaHocID){
		List<HocVien> lst = new ArrayList<HocVien>();
		for(HocVien x : hocVienRepository.findAll())
			if(x.getHoTen().toLowerCase().contains(hoTen.toLowerCase()) && x.getKhoaHoc().getId() == khoaHocID)
				lst.add(x);
		return lst;
	}
}
