package com.example.Jpa04PhieuThu.controller;

import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Jpa04PhieuThu.model.LoaiNguyenLieu;
import com.example.Jpa04PhieuThu.model.NguyenLieu;
import com.example.Jpa04PhieuThu.repository.ChiTietPhieuThuRepository;
import com.example.Jpa04PhieuThu.repository.LoaiNguyenLieuRepository;
import com.example.Jpa04PhieuThu.repository.NguyenLieuRepository;
import com.google.gson.Gson;

@RestController
public class NguyenLieuController {

	@Autowired
	NguyenLieuRepository  nguyenLieuRepository;
	
	@Autowired
	LoaiNguyenLieuRepository loaiNguyenLieuRepository;
	
	@Autowired
	ChiTietPhieuThuRepository chiTietPhieuThuRepository;
	
	@PostMapping(value = "/nguyenlieu/them")
	public void ThemNguyenLieu(@RequestBody String nguyenLieu) {
		Gson gson = new Gson();
		NguyenLieu nguyenLieuMoi = gson.fromJson(nguyenLieu, NguyenLieu.class);
		 
		ValidatorFactory valFac = Validation.buildDefaultValidatorFactory();
		Validator val = valFac.getValidator();
		Set<ConstraintViolation<NguyenLieu>> viola = val.validate(nguyenLieuMoi);
		
		Optional<LoaiNguyenLieu> op = Optional.empty();
		if(viola.size() == 0 && loaiNguyenLieuRepository.findById(nguyenLieuMoi.getLoaiNguyenLieu().getId())!= op);
			nguyenLieuRepository.save(nguyenLieuMoi);
	}
}