package com.example.demoJpaBuoi1.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoJpaBuoi1.model.CauThu;
import com.example.demoJpaBuoi1.repository.CauThuRepository;
import com.google.gson.Gson;

@RestController
@RequestMapping(value="/cauthu")
public class CauThuController {
	
	@Autowired
	CauThuRepository cauthuRepository;
	
	@GetMapping(value = "/caccauthu")
	public void Create() {
		CauThu messi = new CauThu();
		messi.setTen("Lionel Messi");
		messi.setId(1);
		messi.setSoAo(10);
		messi.setViTri("CF");
		messi.setNamSinh(1987);
		messi.setChieuCao(1.70);
		cauthuRepository.save(messi);
		
		CauThu torres = new CauThu();
		torres.setId(2);
		torres.setTen("Fernando Torres");
		torres.setSoAo(9);
		torres.setViTri("CF");
		torres.setNamSinh(1984);
		torres.setChieuCao(1.86);
		cauthuRepository.save(torres);
		
		CauThu drogba = new CauThu();
		drogba.setId(3);
		drogba.setTen("Didier Drogba");
		drogba.setSoAo(11);
		drogba.setViTri("CF");
		drogba.setNamSinh(1978);
		drogba.setChieuCao(1.88);
		cauthuRepository.save(drogba);
	}
	
	@PostMapping(value = "/add" , produces = MediaType.APPLICATION_JSON_VALUE)
	public CauThu add(@RequestBody String cauthu) {
		Gson gson = new Gson();
		CauThu ronaldo = gson.fromJson(cauthu, CauThu.class);
		
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		
		Set<ConstraintViolation<CauThu>> violations = validator.validate(ronaldo);
		
		// in cac vi pham ra
		for (ConstraintViolation<CauThu> violation : violations) {
			System.out.println(violation.getMessage());
		}
		if(violations.size() == 0) {
			cauthuRepository.save(ronaldo);
		}
		return ronaldo;

	}
}
